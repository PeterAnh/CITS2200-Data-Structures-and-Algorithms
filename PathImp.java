import java.util.Arrays;
import java.util.PriorityQueue;
import CITS2200.Graph;
import CITS2200.Path;
import CITS2200.IllegalValue;

public class PathImp implements Path{
	public int getMinSpanningTree(Graph g){
		int number = g.getNumberOfVertices();
		if(number == 0){
			throw new IllegalValue(" The Graph is empty! "); 
		} else {
			int[] a = new int[number];
			int[] parent = new int[number];
			Arrays.fill(parent, -1);
			int[] distance = new int[number];
			Arrays.fill(distance, -1);
			int[][] matrix = g.getEdgeMatrix();
			PriorityQueue<Edge> b = new PriorityQueue<Edge>();
			b.add(new Edge(0,0));
			distance[0] = 0;
			while( !b.isEmpty()){
				int x = b.remove().vertex;
				if(a[x] != 0);
				a[x] = 1;
				for(int i = 0; i < number; i++){
					int j = matrix[x][i];
					if(j > 0 && a[i] < 1){
						if(distance[i] == -1 || distance[i] > j){
							distance[i] = j;
							parent[i] = x;
							b.add(new Edge(i, distance[i]));
						}
					}
				}
			}
			int k =0;
			for(int j: distance){
				if(j == -1){
					k =-1;
				}
				k+= j;
			}
			return k;
		}
	}
	
	public int[] getShortestPaths(Graph g, int starVertex){
		int number = g.getNumberOfVertices();
		if(number ==0){
			throw new IllegalValue(" The Graph is empty!");
		} else {
			int[] a = new int[number];
			int[] parent = new int[number];
			Arrays.fill(parent, -1);
			int[] distance = new int[number];
			Arrays.fill(distance, -1);
			int[][] matrix = g.getEdgeMatrix();
			PriorityQueue<Edge> b = new PriorityQueue<Edge>();
			b.add(new Edge(starVertex, 0));
			distance[starVertex] = 0;
			while(!b.isEmpty()){
				int x = b.remove().vertex;
				if(a[x] != 0);
				a[x] = 1;
				for(int i = 0; i < number; i++){
					int j = matrix[x][i];
					if(j > 0 && a[i] < 1){
						if(distance[i] == -1 || distance[i] > distance[x] + j){
							distance[i] = distance[x] + j;
							parent[i] = x;
							b.add(new Edge(i, distance[i]));
						}
					}
				}
			}
			return distance;
		}
	}
	
	private class Edge implements Comparable<Edge>{
		public int vertex;
		public int edgeWeight;
		
		public Edge(int end, int cost){
			vertex = end;
			edgeWeight = cost;
		}
		
		public int compareTo(Edge current){
			int currentWeight = current.edgeWeight;
			if(edgeWeight < currentWeight){
				return -1;
			} else if(edgeWeight > currentWeight){
				return 1;
			} else {
				return 0;
			}
		}
	}
}
