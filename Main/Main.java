package Main;
import MyGraphs.*;
import Tree.*;
import Paths.*;
import Objects.*;

import java.util.*;

/*
 * Group member:
 * Juan Zaragoza, Sebastian Abarca, Eros Lorenzo
 * 
 * Contribution:
 * Juan Zaragoza
 *      AVL tree, Passenger, and Main classes
 * 
 * Sebastian Abarca
 *     Graph, Paths, and Main class
 * 
 * Eros Lorenzo
 *      HashMap
 */


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
    static HashMap<String, Flight> flyFo = new HashMap<String, Flight>();
    static Flight nakondaAirlines = new Flight("Miami", "Madrid", 3476, 8.35);
    static Flight aMerryCano = new Flight("Miami", "Los Angeles", 537, 6.06);
    static Flight sebby = new Flight("Miami", "Buenos Aires", 843, 8.50);
    static Flight juanNa = new Flight("Los Angeles", "Tokyo", 7834, 11.50);
    static Flight birdie = new Flight("Los Angeles", "Buenos Aires", 9433, 14.30);
    static Flight eronda = new Flight("Madrid", "Paris", 4362, 2.00);
    static Flight ilmarAirlines = new Flight("Madrid", "Cairo", 3623, 4.35);
    static Flight USAirAir = new Flight("Paris", "Cairo", 4284, 4.20);
    static Flight TDFly = new Flight("Cairo", "Shanghai", 8532, 15.40);
    static Flight KFlights = new Flight("Cairo", "New Delhi", 9434, 8.20);
    static Flight JPAir = new Flight("Tokyo", "New Delhi", 1462, 7.50);
    static Flight TokyoFlights = new Flight("Tokyo", "Shanghai", 3452, 2.55);
    static Flight ShangHeight = new Flight("Shanghai", "New Delhi", 4831, 9.35);
    static Flight[] allFlights = {nakondaAirlines, aMerryCano, sebby,juanNa,birdie,eronda,ilmarAirlines,USAirAir
            ,TDFly,KFlights,JPAir,TokyoFlights,ShangHeight};

    public static void main(String[] args)
    {
        for(int i = 0;i< allFlights.length;i++)
        {
            flyFo.put(allFlights[i].getDeparture(), allFlights[i]);
        }
        GraphExtended map = new GraphExtended(vertices, edges);
        Paths p = new Paths();
        AVLtree tree = new AVLtree();
        menu(map,tree,p);
    } 

    public static void menu(GraphExtended map,AVLtree tree, Paths p){
        Scanner scnr = new Scanner(System.in);
        boolean flag = false;
        int input = -1;
    do{
        try{
            System.out.println("1.Show map");
            System.out.println("2.add passenger");
            System.out.println("3.Print shortest path");
            System.out.println("4.print passenger list");
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
            int a;

            System.out.println("Here are the passenger that are available to be added please select one.");

            ArrayList<Passenger> myList = Passenger.createPassengers();

            for(int i = 0; i < myList.size();i++){
                System.out.println(i+1 + ". " + myList.get(i));
            }
            a = scnr.nextInt();

            tree.add(myList.get(a));

            break;
        case 3: // find shortest path between 2 cities
        Vertex v1 = null;
        Vertex v2 = null;
        String departure;
        String destination;
        do{
            System.out.println("Please select a where you will be departing from: ");
            System.out.println(map.vertices());
            departure = scnr.nextLine();
            System.out.println("Please select a destination: ");
            System.out.println(map.vertices());
            destination = scnr.nextLine();
        
        v1 = findVertex(destination, map);
        v2 = findVertex(departure, map);
        }while(v1 == null && v2 == null);

        System.out.println(p.findShortestPath(map, v1, v2));

            break;
        case 4: // add passenger
            tree.printTree();
            break;
        case 5: // remove passenger
            int b;

            System.out.println("Here are the passenger that are available to be removed please select one.");

            ArrayList<Passenger> myList2 = Passenger.createPassengers();

            for(int i = 0; i < myList2.size();i++){
                System.out.println(i+1 + ". " + myList2.get(i));
            }

            b = scnr.nextInt();

            tree.remove(myList2.get(b));

            break;
        case 6: // find passenger
            int c;

            System.out.println("Here are the passenger that are available to be removed please select one.");

            ArrayList<Passenger> myList3 = Passenger.createPassengers();

            for(int i = 0; i < myList3.size();i++){
                System.out.println(i+1 + ". " + myList3.get(i));
            }

            c = scnr.nextInt();

            tree.find(myList3.get(c));

            break;
        case 7:
        
           // map.addFlight();
            break;
        case 8:
         
           // map.removeFlight();
            break;
        case 9:
         
           // map.findFlight();
            break;
        
    }

    }


    public static void addVertexEdge(GraphExtended g)
    {
        Scanner kybrd = new Scanner(System.in);
        String v1;
        String v2;
        Vertex cityNew;
        Vertex citySelect;
        int time = 0;
        int count = 0;
        boolean tryCatch = false;
        boolean tryCatch2 = false;
        int timeNew = 0;
        System.out.println("Which airport would you like to add");
        v1 = kybrd.nextLine();
        do{
            try{
                System.out.println("How many airports does it connect to?");
                count = kybrd.nextInt();
                tryCatch = true;
            }catch(InputMismatchException e)
            {
                System.out.println("Sorry please enter a number.");
                tryCatch = false;
            }
        }while(!tryCatch);

        cityNew = new Vertex(v1);
        for(int i = 0; i < count; i++)
        {
            g.vertices();
            System.out.println("Please select its connections: ");
            v2 = kybrd.nextLine();

            do{
                try{
                    System.out.println("How long is the flight?");
                    time = kybrd.nextInt();
                    tryCatch2 = true;
                }catch(InputMismatchException e)
                {
                    System.out.println("Sorry please enter a number.");
                    tryCatch2 = false;
                }
            }while(!tryCatch2);
            citySelect = findVertex(v2, g);
            Edge edgeNew = new Edge(cityNew, citySelect, time);
            edges.add(edgeNew);
            
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
