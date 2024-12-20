package package01.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import package01.view.*;

public class Node {

    int[] position; // [x, y] coordinates of the node
    Node parent;    // the previous node in the path
    int g;          // cost from the start node
    int h;          // heuristic cost (Manhattan distance to goal)
    int f;          // total cost (g + h)

    public Node() {
        // Default constructor
    }

    public static int[][] start(int[] start, int[] goal) {
        System.out.println("starting algorithm");      

        int[][] positionsArray = null;
        
        // Define the positions of all nodes in the graph
        int[][] nodePositions = {  
            
		  {64, 47},  //n1
    		    {64, 85},  //n1.1
    		    {64, 100},  //n1.2
    		    {64, 134}, //n2
    		    {64, 150}, //n2.1
    		    {64, 180}, //n2.2
    		    {64, 200}, //n2.3
    		    {64, 210}, //n3
    		    {64, 226}, //n3.1
    		    {100, 226}, //n3.2
    		    {131, 226}, //n4
    		    {154, 226}, //n4.1
    		    {178, 226}, //n4.2
    		    {204, 226}, //n5
    		    {225, 226}, //n5.1
    		    {252, 226}, //n6
    		    
    		    
    		    {252, 256}, //n6.1a
    		    {252, 271}, //n6.1b

    		    {252, 285}, //n6.1
    		    {252, 317}, //n7
    		    {252, 330}, //n7.1
    		    {252, 355}, //n7.2
    		    {252, 376}, //n7.3
    		    {252, 390}, //n7.4

    		    
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

    		    
    		    {160, 47},  //n22.2
    		    {192, 47},  //n22.3
    		    
    		    goal






        };

        // Create a list to hold all the nodes
        List<Node> nodeList = new ArrayList<>();
        for (int[] pos : nodePositions) {
            nodeList.add(new Node(pos, null));
        }

        // Perform A* search to find the shortest path
        List<Node> path = aStarSearch(start, goal, nodeList);

        if (path != null) {
            System.out.println("Path found:");
            int i = 0;
            positionsArray = new int[path.size()][2];
            for (Node node : path) {
                System.out.println(Arrays.toString(node.position)); 
                positionsArray[i][0] = node.position[0];  // X-coordinate
                positionsArray[i][1] = node.position[1];  // Y-coordinate
                i++;
            }
        } else {
            System.out.println("No path found.");
        }
        return positionsArray;
    } 

    // Constructor to initialize a node with its position and parent
    public Node(int[] position, Node parent) {
        this.position = position;
        this.parent = parent;
        this.g = 0;
        this.h = 0;
        this.f = 0;
    }

    // Calculate the Manhattan distance between two points
    private static double manhattanDistance(int[] start, int[] goal) {
        return Math.abs(goal[0] - start[0]) + Math.abs(goal[1] - start[1]);
    }

    // A* search algorithm implementation
    public static List<Node> aStarSearch(int[] start, int[] goal, List<Node> nodeList) {
        System.out.println("aStarSearch");

        // Priority queue to store nodes to be evaluated, sorted by f-score
        PriorityQueue<Node> openList = new PriorityQueue<>((a, b) -> a.f - b.f);
        // List to store nodes already evaluated
        List<Node> closedList = new ArrayList<>();

        // Initialize the start node
        Node startNode = new Node(start, null);
        startNode.g = 1; // Cost to reach the start node is 1
        startNode.h = (int) manhattanDistance(start, goal); // Heuristic cost to the goal
        startNode.f = startNode.g + startNode.h; // Total cost (g + h)

        openList.add(startNode);

        while (!openList.isEmpty()) {    // Process nodes in the open list
            Node current = openList.poll(); // Get the node with the lowest f-score

            // Check if the current node is the goal
            if (Arrays.equals(current.position, goal)) {
                return reconstructPath(current); // Reconstruct and return the path
            }

            closedList.add(current); // Add the current node to the closed list

            // Iterate through neighbors of the current node
            for (Node neighbor : getNeighbors(current, nodeList)) {
                if (closedList.contains(neighbor)) continue; // Skip if already evaluated

                int tentativeG = current.g + 1; // Calculate tentative g-score

                // If the neighbor is not in the open list or has a better g-score
                if (!openList.contains(neighbor) || tentativeG < neighbor.g) {
                    neighbor.g = tentativeG; // Update g-score
                    neighbor.h = (int) manhattanDistance(neighbor.position, goal); // Update h-score
                    neighbor.f = neighbor.g + neighbor.h; // Update f-score
                    neighbor.parent = current; // Set the parent to the current node

                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor); // Add neighbor to the open list
                    }
                }
            }
        }
        return null;  // No path found
    }

    // Get neighbors of the current node
    private static List<Node> getNeighbors(Node current, List<Node> nodeList) {
        List<Node> neighbors = new ArrayList<>();

        for (Node node : nodeList) {
            // Check if the node is not the current node and within a certain distance
            if (!Arrays.equals(current.position, node.position) && 
                manhattanDistance(current.position, node.position) <= 70) {

                Point currentPoint = new Point(current.position[0], current.position[1]);
                Point neighborPoint = new Point(node.position[0], node.position[1]);

                // Increase buffer zone and check for path intersection
                double bufferZone = 20.0; // Buffer zone for path checking
                boolean pathClear = true; // Flag to determine if the path is clear

                // Check for blocked roads
                for (Point blockedPoint : Settings.getBlockedRoads()) {
                    double distance = pointToLineDistance(blockedPoint, currentPoint, neighborPoint);
                    if (distance < bufferZone) {
                        pathClear = false; // Path is blocked
                        break;
                    }
                }

                if (pathClear) {
                    neighbors.add(node); // Add the neighbor if the path is clear
                }
            }
        }
        return neighbors;
    }

    // Calculate the perpendicular distance from a point to a line segment
    private static double pointToLineDistance(Point p, Point start, Point end) {
        if (start.x == end.x && start.y == end.y) {
            return p.distance(start); // If start and end are the same, return distance to start
        }

        double normalLength = Math.sqrt((end.x - start.x) * (end.x - start.x) + 
                                        (end.y - start.y) * (end.y - start.y));

        // Calculate distance using the formula for point-to-line distance
        double distance = Math.abs((p.x - start.x) * (end.y - start.y) - 
                                   (p.y - start.y) * (end.x - start.x)) / normalLength;

        // Check if the point is between start and end
        double dotProduct = ((p.x - start.x) * (end.x - start.x) + 
                             (p.y - start.y) * (end.y - start.y)) / (normalLength * normalLength);

        if (dotProduct < 0) {
            return p.distance(start); // Closest to start point
        } else if (dotProduct > 1) {
            return p.distance(end); // Closest to end point
        }

        return distance; // Perpendicular distance
    }

    // Reconstruct the path from the goal to the start
    private static List<Node> reconstructPath(Node current) {
        System.out.println("reconstructPath");
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(0, current); // Add nodes to the path in reverse order
            current = current.parent; // Move to the parent node
        }
        return path;
    }
}
