package MyGraphs;

public class Edge 
{
    Vertex departure, dest;
    int time;

    public Edge(Vertex departure, Vertex dest, int weight)
    {
        this.departure = departure;
        this.dest = dest;
        this.time = weight;
    }

    public String getDeparture() {
        return departure.getCity();
    }

    public void setDeparture(Vertex departure) {
        this.departure = departure;
    }

    public String getDest() {
        return dest.getCity();
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String ToString()
    {
        return "(Departure: " + departure.getCity() + " ; Arrival: " + dest.getCity()
            + " ; Time: " + time;
    }
    
}
