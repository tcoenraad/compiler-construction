// Generated from C:/Users/Jip/Documents/compiler-construction/block-5/pp/block5/cc/antlr\Building.g4 by ANTLR 4.5
package pp.block5.cc.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BuildingParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BuildingVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BuildingParser#building}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilding(@NotNull BuildingParser.BuildingContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#floor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloor(@NotNull BuildingParser.FloorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildingParser#room}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoom(@NotNull BuildingParser.RoomContext ctx);
}