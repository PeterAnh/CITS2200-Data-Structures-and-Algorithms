import CITS2200.*;

public class SearchImpTest {
	public static void main(String[] args) {
		// randomGraph - (#vertices,isDirected,density)
		Graph g = Graph.randomGraph(5,true,0.7);
		System.out.println(g.toString());
		//System.out.println(g.getWeight(1,0));
		
//		boolean[] b = new boolean[2];
//		System.out.println(b[0]);
//		System.out.println(b[1]);
		// So booleans initialise to false. Perfect. :)
		
//		int[] a = new int[2];
//		System.out.println(a[0]);
		// int arrays also initialise to 0. Perfect.
		
		SearchImp sI = new SearchImp();
		int[] ss = sI.getConnectedTree(g, 4);
		System.out.println(ss[0]);
		System.out.println(ss[1]);
		System.out.println(ss[2]);
		System.out.println(ss[3]);
		System.out.println(ss[4]);
		System.out.println();
		
		int[] d = sI.getDistances(g, 4);
		System.out.println(d[0]);
		System.out.println(d[1]);
		System.out.println(d[2]);
		System.out.println(d[3]);
		System.out.println(d[4]);
	}
}
