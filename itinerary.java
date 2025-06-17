
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class itinerary {
    int n;
    HashMap<String, Integer> namaToIndex = new HashMap<>();
    LinkedList<Integer>[] adjListArray;
    int index = 0;

    public itinerary(int n) {
        this.n = n;
        adjListArray = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addKota(String nama) {
        if (!namaToIndex.containsKey(nama)) {
            namaToIndex.put(nama, index);
            index++;
        }
    }

    public void addEdge(String src, String dst) {
        int from = namaToIndex.get(src);
        int idst = namaToIndex.get(dst);

        adjListArray[from].add(idst);
        adjListArray[idst].add(from);
    }

    public String getNamaFromIndex(int index) {
        for (Map.Entry<String, Integer> entry : namaToIndex.entrySet()) {
            if (entry.getValue() == index) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void bfs(String sourceCity) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int start = namaToIndex.get(sourceCity);

        visited[start] = true;
        queue.add(start);

        System.out.println("Urutan kunjungan (berdekatan dulu / BFS):");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(getNamaFromIndex(node) + " ");

            for (int neighbor : adjListArray[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(String sourceCity) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int start = namaToIndex.get(sourceCity);

        stack.push(start);
        System.out.println("\nUrutan kunjungan ( / DFS):");

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(getNamaFromIndex(node) + " ");

                for (int neighbor : adjListArray[node]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}