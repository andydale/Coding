package Greedy;

import java.util.ArrayList;
import java.util.HashSet;


///Screwed up in creating the proper data structure to store the nodes and neighbors.
//Review it in 20 minutes and correct it.


//Since graph coloring is an NP complete problem
//We have approximate algorithmic solutions as compared to optimal solution
//One of the approaches is greedy algo, it doesn't provide optimal solution ( minimum number of colors used to color the graph)
//Rather it has an upper bound, it can color the graph in #colors <= max cardinality of a node in the graph)
public class Graphcoloring {
	public static int colorcount=0;
	public static void main(String args[]){
		Graph g1=new Graph(5);
	    g1.addEdge(0, 1);
	    g1.addEdge(0, 2);
	    g1.addEdge(1, 2);
	    g1.addEdge(1, 3);
	    g1.addEdge(2, 3);
	    g1.addEdge(3, 4);
	    System.out.println("Coloring of Graph 1 \n");
	    //Color the graph
	    greedyColoriung(g1);
	}
	
	public static void greedyColoriung(Graph g1){
		int i=0;
		for(;i<g1.size;i++){
			if(g1.color.get(i)==0){
				break;
			}
		}
		if(i==g1.size){
			System.out.println("Solution Achieved");
			printSolution(g1);
			return;
		}
		//i is the current uncolored node
		int unc=i;
		int color=0;
		//Assign color to this node, after checking it's neighbors and list of available colors
		color=getColorForThis(g1,unc);
		System.out.println("color set to "+color);
		g1.color.set(unc,color);
		greedyColoriung(g1);
	}

	private static void printSolution(Graph g1) {
		System.out.println("Max Color Count = "+colorcount);
		for(int i:g1.color){
			System.out.print(i+" ");			
		}
		System.out.println("");
	}

	//Greedy method to get the minimum color from current list.
	private static int getColorForThis(Graph g1, int unc) {
		
		ArrayList<Integer> nbors=g1.nodes.get(unc);
		HashSet<Integer> set=new HashSet<Integer>();
		for(int n:nbors) 
		{
			if(g1.color.get(n)!=0)
			{
				set.add(g1.color.get(n));
			}
		}
		

		int i=1;
		if(set.size()==colorcount){
			colorcount++;
			return colorcount;
		}else{ //we have 1ormore value that is lower than current total colorcount.
			for(;i<=colorcount;i++){
				if(!set.contains(i)){
					return i;
				}
			}
		}		
		return i;
	
	}

	public static class Graph{
		//We cannot create arrof generic type, following wouldn't work.
		//public static ArrayList<Integer>[] nodes=null;
		public static ArrayList<ArrayList<Integer>> nodes=null;
		public static ArrayList<Integer> color=null;
		public static int size=0;
		public Graph(int size){
			this.size=size;
			nodes=new ArrayList<ArrayList<Integer>>(size);			
			for(int i=0;i<size;i++){ //set all values to null
				nodes.add(null); // made mistake here, I tried running this loop, nodes.set(i,null) instead of the current statement.
			}		
			color=new ArrayList<Integer>();
			
			for(int i=0;i<size;i++){ //set all values to null
				color.add(0); 
			}
		}
		
		//Mistake , when we add and edge to an undirected graph, then we need to add edges both ways from source to target and target to source.
		public void addEdge(int source,int target){
			if( nodes.get(source)==null){
				ArrayList<Integer> nbors=new ArrayList<Integer>();
				nbors.add(target);
				nodes.add(source,nbors);
			}else{
				ArrayList<Integer> nbors=nodes.get(source);
				nbors.add(target);
				nodes.add(source,nbors);
			}
			
			if( nodes.get(target)==null){
				ArrayList<Integer> nbors=new ArrayList<Integer>();
				nbors.add(source);
				nodes.add(target,nbors);
			}else{
				ArrayList<Integer> nbors=nodes.get(target);
				nbors.add(source);
				nodes.add(target,nbors);
			}
			
		}
	}
	
}
