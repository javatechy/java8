package graph;

import java.util.LinkedList;
import java.util.Queue;

import utils.Common;

public class GraphSearch {

	public static void main(String arp[]) {
		NodeG root = init();
		bfs(root);
		root = init();
		dfs(root);
	}

	private static NodeG init() {
		NodeG root = new NodeG(1, 3, 4, 5, 6);
		NodeG node4 = root.getNode(root, 4);
		node4.addChildren(30, 6, 7);
		return root;
	}

	/**
	 * It is done using recursion.
	 */
	public static void bfs(NodeG root) {
		if (root == null)
			return;
		Common.print(" " + root.data);
		root.isVisited = true;
		if (root.children != null) {
			for (NodeG child : root.children) {
				bfs(child);
			}
		}
	}

	/**
	 * It is done using queue implementation.
	 */
	public static void dfs(NodeG root) {
		Common.println();
		Queue<NodeG> queue = new LinkedList<>();
		queue.add(root);
		Common.print(root.data);
		root.isVisited = true;
		while (!queue.isEmpty()) {
			NodeG node = queue.remove();
			for (NodeG child : node.children) {
				if (child.isVisited == false) {
					Common.print(child.data);
					child.isVisited = true;
					queue.add(child);
				}

			}
		}
	}

}
