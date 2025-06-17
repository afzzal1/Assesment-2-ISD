
public class Main {
    public static void main(String[] args) {
        itinerary graph = new itinerary(9);

        graph.addKota("Paris");
        graph.addKota("Brussels");
        graph.addKota("Zurich");
        graph.addKota("Amsterdam");
        graph.addKota("Vienna");
        graph.addKota("Prague");
        graph.addKota("Hamburg");
        graph.addKota("warsaw");
        graph.addKota("Budapest");

        graph.addEdge("Paris", "France");
        graph.addEdge("Brussels", "Belgium");
        graph.addEdge("Zurich", "Switzerland");
        graph.addEdge("Amsterdam", "Netherlands");
        graph.addEdge("Vienna", "Austria");
        graph.addEdge("Prague", "Czechia/Republik Ceko");
        graph.addEdge("Hamburg", "Jerman");
        graph.addEdge("Warsaw", "Poland");
        graph.addEdge("Budapest", "Hungary");

        System.out.println();
        graph.bfs("France");

        System.out.println();
        graph.dfs("France");
    }
}