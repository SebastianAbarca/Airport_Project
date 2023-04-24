import MyGraphs.*;
import Tree.*;
import Paths.*;
import Objects.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Main
{
    final static Vertex miami = new Vertex("Miami");
    final static Vertex tokyo = new Vertex("Tokyo");
    final static Vertex losAngeles = new Vertex("Los Angeles");
    final static Vertex buenosAires = new Vertex("Buenos Aires");
    final static Vertex madrid = new Vertex("Madrid");
    final static Vertex cairo = new Vertex("Cairo");
    final static Vertex paris = new Vertex("Paris");
    final static Vertex shanghai = new Vertex("Shanghai");
    final static Vertex newDehli = new Vertex("New Dehli");

    final static List<Vertex> vertices = Arrays.asList(
            miami, tokyo, losAngeles, buenosAires, madrid, cairo, paris, shanghai, newDehli);

    final static List<Edge> edges = Arrays.asList(
    new Edge(miami, madrid, 8), new Edge(miami, losAngeles, 6), new Edge(miami, buenosAires, 9),
    new Edge(losAngeles, tokyo, 12), new Edge(losAngeles, buenosAires, 14), new Edge(madrid, paris, 2),
    new Edge(madrid, cairo, 4), new Edge(paris, cairo, 4), new Edge(cairo,shanghai, 14),
    new Edge(cairo, newDehli, 8), new Edge(tokyo, newDehli, 8), new Edge(shanghai, newDehli, 10),
    new Edge(tokyo, shanghai, 3)
            );

    public static void main(String[] args)
    {
        GraphExtended map = new GraphExtended(vertices, edges);
        Paths p = new Paths();
        AVLtree tree = new AVLtree();
        menu(map,tree,p);

        
    } 

    public static void menu(GraphExtended map,AVLtree tree, Paths p){
        Scanner scnr = new Scanner(System.in);
        boolean flag = false;
        int input = 0;
    do{
        try{
            System.out.println("1.Show map");
            System.out.println("2.Print passenger list");
            System.out.println("3.Print shortest path");
            System.out.println("4.add passenger");
            System.out.println("5.remove passenger");
            System.out.println("6.find passenger");
            System.out.println("7.add flight");
            System.out.println("8.remove flight");
            System.out.println("9.find flight");
            input = scnr.nextInt();
            flag = true;

        }catch(InputMismatchException e){
            System.out.println("please try again using numbers 1 through 9");
            flag = false;
            scnr.next();
        }
    }while(flag == false);

    switch(input){
        case 1:
            map.showMap();
            break;
        case 2:
            tree.printTree();
            break;
        case 3: // find shortest path between 2 cities
            Vertex v1;
            Vertex v2;
            String departure;
            String destination;

            System.out.println("Please select a where you will be departing from: ");
            System.out.println(map.vertices());
            departure = scnr.nextLine();
            System.out.println("Please select a destination: ");
            System.out.println(map.vertices());
            destination = scnr.nextLine();
            v1 = findVertex(destination, map);
            v2 = findVertex(departure, map);

            System.out.println(p.findShortestPath(map, v1, v2));

            break;
        case 4:
        /*
         * print the availabe passenger
         * get input from user 
         * place that passenger on a variable
         * pass variable to tree.add()
         */
            Passenger.createPassengers();
            tree.add(null);
            break;
        case 5:
        /*
         * print removable passengers
         * get input
         * place passenger on variable 
         * pass it to remove
         */
            tree.remove(null);
            break;
        case 6:
        /*
         * print findable passengers
         * get input
         * place passenger on variable 
         * pass it to find
         */
            tree.find(null);
            break;
        case 7:
            map.addFlight();
            break;
        case 8:
            map.removeFlight();
            break;
        case 9:
            map.findFlight();
            break;
        
    }
    }

    public static Vertex findVertex(String string, GraphExtended g)
    {
        Vertex v;
        List<Vertex> verticies = g.vertices();
        for(int i = 0; i < verticies.size(); i++)
        {
            if(string.equalsIgnoreCase(verticies.get(i).getCity()))
            {
                return verticies.get(i);
            }
        }
        return null;
    }
   
}
