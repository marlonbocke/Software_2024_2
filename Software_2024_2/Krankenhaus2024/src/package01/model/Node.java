package package01.model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import package01.view.*;


import package01.view.Settings;
public class Node {

	
    int[] position; // [x, y] coordinates of the node
    Node parent;    // the previous node in the path
    int g;          // cost from the start node
    int h;          // heuristic cost (Manhattan distance to goal)
    int f;          // total cost (g + h)
    
    
    

    
    public Node() {
		//start(null, null);
	}




 public static int[][] start(int[] start, int[] goal) {
     System.out.println("starting alogrithmus");      
		
     int[][] positionsArray = null;
    	
     int[][] nodePositions = {  
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
    		    
    		    // Neue Knoten im Bereich n6 und n7
    		    {252, 256}, //n6.1a
    		    {252, 271}, //n6.1b

    		    {252, 285}, //n6.1
    		    {252, 317}, //n7
    		    {252, 330}, //n7.1
    		    {252, 355}, //n7.2
    		    {252, 376}, //n7.3
    		    {252, 390}, //n7.4

    		    // Zusätzliche Knoten zwischen n7 und n8
    		    {270, 390}, //n7.5a
    		    {290, 390}, //n7.5b

    		    {310, 394}, //n8
    		    {360, 394}, //n9
    		    {395, 394}, //n9.1
    		    {436, 394}, //n10
    		    {436, 345}, //n10.1
    		    {436, 313}, //n11
    		    {436, 270}, //n11.1
    		    {436, 226}, //n12
    		    {440, 226}, //n12.1
    		    {450, 226}, //n12.2
    		    {460, 226}, //n12.3
    		    {486, 226}, //n12.4
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

    		    // Zusätzliche Knoten zwischen n20 und n21
    		    {275, 226}, //n20.-1
    		    {300, 226}, //n20.-1
    		    {322, 226}, //n20
    		    {340, 226}, //n20.0a
    		    {350, 226}, //n20.1
    		    {365, 226}, //n20.2
    		    {390, 226}, //n20.3
    		    {420, 226}, //n20.4
    		    {425, 226}, //n20.4
    		    
    		    {207, 134}, //n21
    		    {207, 90},  //n21.1
    		    {207, 47},  //n22
    		    {175, 47},  //n22.1
    		    {130, 47},  //n23

    		    // Zusätzliche Knoten für den Bereich von n21 und n23
    		    {160, 47},  //n22.2
    		    {192, 47},  //n22.3
    		    
    		    goal
    		};
       	      
        List<Node> nodeList = new ArrayList<>();
        for (int[] pos : nodePositions) {
            nodeList.add(new Node(pos, null));
        }
      //  System.out.println(start[1]);
        
        List<Node> path = aStarSearch(start, goal, nodeList);    //coordinates will be send to algorithmus  
        
        //List<int[]> coordinates = new ArrayList<>();
       
        if (path != null) {
			System.out.println("Pfad gefunden:");
			int i=0;
			positionsArray = new int[path.size()][2];
            for (Node node : path) {
              
               System.out.println(Arrays.toString(node.position)); 
              
               positionsArray[i][0] = node.position[0];  // X-Koordinate
               positionsArray[i][1] = node.position[1];  // Y-Koordinate
               i++;
			
                }
                                 
        } else {
            System.out.println("Kein Pfad gefunden.");
           
        }
		return positionsArray;
		
		
        
    } 
	
	
	 public Node(int[] position, Node parent) {
	        this.position = position;
	        this.parent = parent;
	        this.g = 0;
	        this.h = 0;
	        this.f = 0;
	    }
	 
    private static double manhattanDistance(int[] start, int[] goal) {       //calculate the manhattenDistance
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
        startNode.h = (int) manhattanDistance(start, goal);     //call the manhattanDistance
                
        startNode.f = startNode.g + startNode.h;

        openList.add(startNode);

        while (!openList.isEmpty()) {    //open list is not empty
        	
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
            List<Node> neighbors = new ArrayList<>();
    
            for (Node node : nodeList) {
                if (!Arrays.equals(current.position, node.position) && 
                    manhattanDistance(current.position, node.position) <= 75) {
            
                    Point currentPoint = new Point(current.position[0], current.position[1]);
                    Point neighborPoint = new Point(node.position[0], node.position[1]);
            
                    // Increase the buffer zone and check path intersection more precisely
                    double bufferZone = 20.0;
                    boolean pathClear = true;
            
                    for (Point blockedPoint : Settings.getBlockedRoads()) {
                        double distance = pointToLineDistance(blockedPoint, currentPoint, neighborPoint);
                        if (distance < bufferZone) {
                            pathClear = false;
                            break;
                        }
                    }
            
                    if (pathClear) {
                        neighbors.add(node);
                    }
                }
            }
            return neighbors;
        }

        // Add this helper method for more accurate distance calculation
        private static double pointToLineDistance(Point p, Point start, Point end) {
            if (start.x == end.x && start.y == end.y) {
                return p.distance(start);
            }
    
            double normalLength = Math.sqrt((end.x - start.x) * (end.x - start.x) + 
                                          (end.y - start.y) * (end.y - start.y));
                                  
            double distance = Math.abs((p.x - start.x) * (end.y - start.y) - 
                                     (p.y - start.y) * (end.x - start.x)) / normalLength;
                             
            // Check if point is between start and end
            double dotProduct = ((p.x - start.x) * (end.x - start.x) + 
                                (p.y - start.y) * (end.y - start.y)) / (normalLength * normalLength);
                        
            if (dotProduct < 0) {
                return p.distance(start);
            } else if (dotProduct > 1) {
                return p.distance(end);
            }
    
            return distance;
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

