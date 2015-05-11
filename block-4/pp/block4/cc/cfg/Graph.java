package pp.block4.cc.cfg;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Graph class, used for CFGs.
 * @author Arend Rensink
 */
public class Graph implements Iterable<Node> {
	/** Set of nodes in this graph. */
	private final Set<Node> nodes;

	/** Constructs an initially empty graph. */
	public Graph() {
		this.nodes = new LinkedHashSet<>();
	}

	/** Adds a new node to this graph and returns it.
	 * The new node number equals the number of nodes at the
	 * time of invocation.
	 */
	public Node addNode() {
		Node result = new Node(this.nodes.size());
		this.nodes.add(result);
		return result;
	}

	/** Adds a new node to this graph with a given ID and returns it.
	 * The new node number equals the number of nodes at the
	 * time of invocation.
	 */
	public Node addNode(String id) {
		Node result = new Node(this.nodes.size(), id);
		this.nodes.add(result);
		return result;
	}

	/** Returns the set of nodes in this graph. */
	public Set<Node> getNodes() {
		return this.nodes;
	}

	/** Returns an iterator over the nodes in this graph. */
	@Override
	public Iterator<Node> iterator() {
		return this.nodes.iterator();
	}

	/** Returns the number of nodes in this graph. */
	public int size() {
		return this.nodes.size();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Graph with %d nodes%n", size()));
		for (Node node : this) {
			result.append(node.toString());
			result.append('\n');
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		return this.nodes.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Graph)) {
			return false;
		}
		Graph other = (Graph) obj;
		if (!this.nodes.equals(other.nodes)) {
			return false;
		}
		return true;
	}

	/** Builds a simple CFG and prints it out. */
	public static void main(String[] args) {
		Graph g = new Graph();
		Node n0 = g.addNode("First");
		Node n1 = g.addNode();
		Node n2 = g.addNode("Last");
		n0.addEdge(n1);
		n1.addEdge(n2);
		n2.addEdge(n0);
		n2.addEdge(n2);
		System.out.println(g);
	}
}
