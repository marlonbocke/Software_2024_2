package package01;
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
        int[] start = {64, 47};  
        int[] goal = {436, 395};   

   
    
        
        int[][] nodePositions ={
                {64, 47}, {64, 226}, {204, 47}, {204, 226}, {252, 226},
                {252, 395}, {436, 395}, {436, 226}, {573, 226}, {573, 52}, {441, 52}
            };
        
        
        
        List<Node> nodeList = new ArrayList<>();
        for (int[] pos : nodePositions) {
            nodeList.add(new Node(pos, null));
        }
      //  System.out.println(start[1]);
        
        
        
        List<Node> path = aStarSearch(start, goal, nodeList);
        
        if (path != null) {
            System.out.println("Pfad gefunden:");
            for (Node node : path) {
                System.out.println(Arrays.toString(node.position));
            }
        } else {
            System.out.println("Kein Pfad gefunden.");
           
        }
        
        
    }
 
    public Node(int[] position, Node parent) {
        this.position = position;
        this.parent = parent;
        this.g = 0;
        this.h = 0;
        this.f = 0;
    }
 
    private static double manhattanDistance(int[] start, int[] goal) {
        return Math.abs(goal[0] - start[0]) + Math.abs(goal[1] - start[1]);
    }
 
    public static List<Node> aStarSearch(int[] start, int[] goal, List<Node> nodeList) {
        System.out.println("aStarSearch");
        
        int i=0;
        int f=0;
       // System.out.println(start[0],start[1]);
        
        PriorityQueue<Node> openList = new PriorityQueue<>((a, b) -> a.f - b.f);
        List<Node> closedList = new ArrayList<>();

        Node startNode = new Node(start, null);
        
        
        startNode.g = 1;
        startNode.h = (int) manhattanDistance(start, goal);
        
        
        startNode.f = startNode.g + startNode.h;

        openList.add(startNode);

        while (!openList.isEmpty()) {    //open list is empty
        	
        	 i=i+1;
             System.out.println("openlist is empty="+i);
        	
            Node current = openList.poll();

            if (Arrays.equals(current.position, goal)) {   //if current position is same with the destination
                return reconstructPath(current);
            }

            closedList.add(current);

            for (Node neighbor : getNeighbors(current, nodeList)) {
            	
            	f=f+1;
                System.out.println("A2="+f);
            	
            	
                if (closedList.contains(neighbor)) continue;

                int tentativeG = current.g + 1;

                if (!openList.contains(neighbor) || tentativeG < neighbor.g) {
                	System.out.println("1. true");
                    neighbor.g = tentativeG;
                    System.out.println("tentativeG="+tentativeG);
                    
                    neighbor.h = (int) manhattanDistance(neighbor.position, goal);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;

                    if (!openList.contains(neighbor)) {
                    	System.out.println("2. true");
                        openList.add(neighbor);
                    }
                    System.out.println("2. false");
                    
                }
                
               
                System.out.println("1. false");
            }
        }
        return null;  
    }

    private static List<Node> getNeighbors(Node current, List<Node> nodeList) {
    	System.out.println("getNeighnors");
    	int i =0;
        List<Node> neighbors = new ArrayList<>();

        for (Node node : nodeList) {
            if (!Arrays.equals(current.position, node.position) && manhattanDistance(current.position, node.position) <= 300) {
              //if (current.position <= node.position) {	
                neighbors.add(node);
                System.out.println("getNeigbors=true");
            }
            System.out.println("current_position"+Arrays.toString(current.position));
            System.out.println("node_position"+Arrays.toString(node.position));
            i=i+1;
            System.out.println(i);   
        }
        return neighbors;
    }

    private static List<Node> reconstructPath(Node current) {
    	System.out.println("reconstructPath");
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(0, current);
            current = current.parent;
        }
        
        return path;
    }
}