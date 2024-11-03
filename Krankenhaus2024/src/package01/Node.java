package package01;

import java.lang.classfile.components.ClassPrinter.LeafNode;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;
import java.util.PriorityQueue;



public class Node {

	
	int[] position; // [x, y] coordinates of the node
    Node parent;    // the previous node in the path
   int g;          // cost from the start node
   int h;          // heuristic cost (Manhattan distance to goal)
   int f;          // total cost (g + h)

   
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		  int[][] nodes = {
//
//		           {64, 47}, {64, 226}, {204, 47}, {204, 226}, {252, 226},
//		           {252, 395}, {436, 395}, {436, 226}, {573, 226}, {573, 52}, {441, 52}
//		       };
		
		
		int[] position = {0, 0}; // Beispiel-Koordinaten
	    Node node = new Node(position, null); // Eltern-Knoten als null gesetzt
	    
	

	}   
   
   
	
	
   public Node(int[] position, Node parent) {
   	System.out.println("Node2");
   	
       this.position = position;
       this.parent = parent;
       this.g = 0;
       this.h = 0;
       this.f = 0;
       calulate();
   }

   public void calulate() {
       System.out.println("calulate");
                            // example coordinates            
    int[] startNode = {100, 200};  // coordinates of the start node (point)
    int[] goalNode = {500, 400};   // coordinates of the destination node (point)
 	
    double distance = manhattanDistance(startNode, goalNode);

    
    System.out.println("The distance value are : " + distance );
    

	  int[][] nodes = {

	           {64, 47}, {64, 226}, {204, 47}, {204, 226}, {252, 226},
	           {252, 395}, {436, 395}, {436, 226}, {573, 226}, {573, 52}, {441, 52}
	       };
	
    
    distance(nodes);
  }

   private static double manhattanDistance(int[] startNode, int[] goalNode) {
		
		
		int x12 = startNode[0];
       int y12 = startNode[1];
       int x13 = goalNode[0];
       int y13 = goalNode[1];


       int result=(int) Math.sqrt(Math.pow(x13 - x12, 2) + Math.pow(y13 - y12, 2));
       return result;   
		
	}
    
   
   public void distance(int nodes[][]) {
	   System.out.println("distance");
       // Array of node coordinates
      


 double totalDistance = 0.0;

       // Calculate the total distance for the path
       for (int i = 0; i < nodes.length - 1; i++) {
           totalDistance +=manhattanDistance(nodes[i], nodes[i + 1]);
       }

       System.out.println("Total distance for the path: " + totalDistance);
   }

   
   
   
   
   
   
   
 
   
   
   
   
   

}
