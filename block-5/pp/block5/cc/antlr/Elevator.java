package pp.block5.cc.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import pp.block5.cc.ErrorListener;
import pp.block5.cc.ParseException;
import pp.block5.cc.antlr.BuildingParser.BuildingContext;
import pp.block5.cc.antlr.BuildingParser.FloorContext;

/** Prettyprints a (number, word)-sentence and adds the numbers. */
public class Elevator extends BuildingBaseVisitor<Integer> {
	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		if (args.length == 0) {
			process(elevator, "Zilverling: f1[r1 r2] f2[r3] f3");
		} else {
			for (String text : args) {
				process(elevator, text);
			}
		}
	}

	private static void process(Elevator elevator, String text) {
		try {
			System.out.printf("Processing '%s':%n", text);
			int result = elevator.traverse(text);
			System.out.println("Room count: " + result);
		} catch (ParseException exc) {
			exc.print();
		}
	}

	/** Groups a given sentence and prints it to stdout.
	 * Returns the sum of the numbers in the sentence.
	 */
	public int traverse(String text) throws ParseException {
		CharStream chars = new ANTLRInputStream(text);
		ErrorListener listener = new ErrorListener();
		Lexer lexer = new BuildingLexer(chars);
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		TokenStream tokens = new CommonTokenStream(lexer);
		BuildingParser parser = new BuildingParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTree tree = parser.building();
		listener.throwException();
		return visit(tree);
	}

	// The visit methods follow below
	@Override
	public Integer visitBuilding(BuildingContext ctx) {
		int result = 0;
		System.out.printf("--> Visiting the %s!%n", ctx.ID().getText());
		// do stuff in between the visit calls for the floors
		System.out.println("Start the elevator");
		int floorCount = ctx.floor().size();
		for (int i = 0; i < floorCount - 1; i++) {
			result += visit(ctx.floor(i));
			System.out.println("Up one floor");
		}
		System.out.println("Arrived at the top floor");
		result += visit(ctx.floor(floorCount - 1));
		return result;
	}

	@Override
	public Integer visitFloor(FloorContext ctx) {
		System.out.printf("--> Visiting %s", ctx.FLOOR().getText());
		int result = ctx.room() == null ? 0 : ctx.room().size();
		// the rooms are not visited individually
		System.out.printf(" (%d rooms)%n", result);
		return result;
	}
}
