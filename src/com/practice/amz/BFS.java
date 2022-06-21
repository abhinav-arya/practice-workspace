// BFS Algorithm 
package com.practice.amz;
import java.io.*;
import java.util.*;
import java.util.LinkedList;

class BFSGraph {

	private int V;
	private LinkedList<Integer> adj[];
	
	BFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
}

public class BFS {

	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.print("BFS traversal started at 2 :: ");
		g.BFS(2);
	}
}
