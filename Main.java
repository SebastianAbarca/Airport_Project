import MyGraphs.*;
import Tree.*;
import Path.*;
import Objects.*;
public class Main {
    public static void main(String[] args){
        Passenger p1 = new Passenger("John Smith", "ABC123", new Flight("New York", "London", 123, 6.5));
        Passenger p2 = new Passenger("Jane Doe", "DEF456", new Flight("Paris", "Tokyo", 456, 12.5));
        Passenger p3 = new Passenger("Mike Johnson", "GHI789", new Flight("Sydney", "Los Angeles", 789, 14));
        Passenger p4 = new Passenger("Anna Lee", "JKL012", new Flight("Shanghai", "San Francisco", 234, 12));
        Passenger p5 = new Passenger("Peter Parker", "MNO345", new Flight("London", "Dubai", 567, 7.5));
        
        AVLtree tree = new AVLtree();

        tree.add(p1);
        tree.add(p2);
        tree.add(p3);
        tree.add(p4);
        tree.add(p5);
       
        System.out.println("printing the tree");
       tree.printTree();

       System.out.println("\n removing from tree");

       tree.remove(p1);
       tree.remove(p2);

       System.out.println("printing tree without p1 and p2");
       tree.printTree();

       System.out.println("checking contains of p1 and p2 that should not work");
        tree.find(p1);
        tree.find(p2);

        System.out.println("checking find with p3");
        tree.find(p3);

        System.out.println("checking get passenger with p4");
        System.out.println(tree.getPassenger("Anna Lee")); 
       
    }
}
