package backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphColoringProblem {
//	public static enum color {red,green,blue};
	public static HashMap<Integer,String> color=new HashMap<Integer,String>();
	public static ArrayList<Integer> q=new ArrayList<Integer>();
	public static int nodes[]=null;
	public static void main(String args[]){
		 /* Create following graph and test whether it is 3 colorable
	      (3)---(2)
	       |   / |
	       |  /  |
	       | /   |
	      (0)---(1)
	    */
	    int graph[][] =
	    	{
	    	{0, 1, 1, 1},
	        {1, 0, 1, 0},
	        {1, 1, 0, 1},
	        {1, 0, 1, 0}
	    	};
	    nodes=new int[graph.length]; // 2d array .length returns #rows
	    int m = 3; // Number of colors
	    color.put(1, "R");
	    color.put(2, "B");
	    color.put(3, "G");
	    graphColoring(graph, m);	    
	}
	
	private static void graphColoring(int[][] graph, int m) {
		//Stopping condition check
		int i=0;
		for(int c:nodes){
			if(c==0)			
				break;
			i++;
		}
		if(i==nodes.length){
			System.out.println("Solution Achieved");
			printSolution(nodes);
			return;
		}
		int unc=i;
		//check all neighbors of this node, if they 
		for(i=1;i<=m;i++){// try all colors at this node.
			if(isUsableColor(graph,unc,i)){
				nodes[unc]=i; //color coding starts from 1,2..,m-1,m
				graphColoring(graph, m);
				nodes[unc]=0;	
			}			
		}	
	}
	

	
	private static void printSolution(int[] nodes2) {
		System.out.print("\t");
		for(int i=0;i<nodes2.length;i++){
			System.out.print(nodes2[i]+" ");
//			System.out.print(color.get(nodes2[i])+" ");			
		}
		System.out.println("");
	}

	private static boolean isUsableColor(int[][] graph,int id, int color) {
		for(int j=0;j<nodes.length;j++){
			if(graph[id][j]==1){//for all neighbor
				if(nodes[j]==color){//color matches with this neighbor
					return false;
				}
			}			
		}		
		return true;
	}

	//Assuming colored cells have value 1+, indicating the color.
	private static void getFirUncoloredNode(int[][] graph) {
	}

	/* A utility function to print solution */
	void printSolution(int color[],int V)
	{
	    System.out.println("Solution Exists:Following are the assigned colors \n");
	    for (int i = 0; i < V; i++)
	      System.out.println(" %d "+color[i]);	    
	    System.out.println("\n");
	}	 
}
