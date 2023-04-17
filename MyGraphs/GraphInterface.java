package MyGraphs;
import java.util.List;

public interface GraphInterface {
    public List<Vertex> vertices();

    public List<Edge> edges();

    public List incidentEdges(Vertex v);
}
