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
           
    	  int[] start = {20, 20};  
          int[] goal = {50, 70};   
        
    	
    	
        int[][] nodePositions ={		//x,y      //have to insert more node coordinates
      
        				
                {64, 47},  //n1
                {64, 85},  //n1.1
                {64, 134}, //n2
                {64, 180}, //n2.1
                {64, 226}, //n3
                {100, 226}, //n3.1       
                {131, 226}, //n4
                {154, 226}, //n4.1                
                {204, 226}, //n5
                {225, 226}, //n5.1
                {252, 226}, //n6
                {252, 285}, //n6.1
                {252, 317}, //n7
                {252, 355}, //n7.1
                {252, 394}, //n8
                {310, 394}, //n8.1
                {360, 394}, //n9
                {395, 394}, //n9.1
                {436, 394}, //n10
                {436, 345}, //n10.1
                {436, 313}, //n11
                {436, 270}, //n11.1
                {436, 226}, //n12
                {486, 226}, //n12.1
                {524, 226}, //n13
                {550, 226}, //n13.1
                {571, 226}, //n14
                {571, 180}, //n14.1
                {571, 134}, //n15
                {571, 85}, //n15.1
                {571, 47}, //n16
                {532, 47}, //n16.1
                {499, 47}, //n17
                {450, 47}, //n17.1
                {436, 47}, //n18
                {436, 85}, //n18.1
                {436, 134}, //n19
                {436, 180}, //n19.1
                {322, 226}, //n20
                
                {207, 134}, //n21
                {207, 90}, //n21.1
                {207, 47}, //n22
                {175, 47}, //n22.1
                {130, 47}, //n23
                goal
             
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
            if (!Arrays.equals(current.position, node.position) && manhattanDistance(current.position, node.position) <= 100) {
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

//currentProblem: goal point will not insert in node and that's why the algorithms didn't work if you enter a none node point. 