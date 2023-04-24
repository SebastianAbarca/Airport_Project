package Main;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import MyGraphs.*;
import Paths.*;

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
    public static void main(String args[])
    {
        Paths p = new Paths();
        List<Edge> edges = Arrays.asList(
            new Edge(miami, madrid, 8), new Edge(miami, losAngeles, 6), new Edge(miami, buenosAires, 9),
            new Edge(losAngeles, tokyo, 12), new Edge(losAngeles, buenosAires, 14), new Edge(madrid, paris, 2),
            new Edge(madrid, cairo, 4), new Edge(paris, cairo, 4), new Edge(cairo,shanghai, 14),
            new Edge(cairo, newDehli, 8), new Edge(tokyo, newDehli, 8), new Edge(shanghai, newDehli, 10),
            new Edge(tokyo, shanghai, 3)
            );
        GraphExtended map = new GraphExtended(vertices, edges);

        System.out.println(p.findShortestPath(map, miami, tokyo));
        map.showMap();
        System.out.println(map.vertices());



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