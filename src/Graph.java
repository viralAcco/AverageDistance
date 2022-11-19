import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Graph{
    int V;
    LinkedList<Edge>[] adjL;
    int total;
    int paths;
    Graph(int V){
        adjL = new LinkedList[V];

        for (int i = 0; i <V; i++){
            adjL[i] = new LinkedList<>();
        }
    }
    void addEdge(int src, int dst, int wt) {
        Edge e1 = new Edge(src, dst, wt);
        adjL[src].add(e1);

        Edge e2 = new Edge(dst, src, wt);
        adjL[dst].add(e2);
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 12);
        graph.addEdge(0, 2, 13);
        graph.addEdge(0, 3, 11);
        graph.addEdge(0, 4, 8);
        graph.addEdge(1, 2, 3);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 2, 4);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Source (A, B, C, D or E): ");
        String x = sc.nextLine();
        System.out.print("Enter Destination (A, B, C, D or E): ");
        String y = sc.nextLine();
        System.out.println("Average distance From "+ x +" to "+ y +" is "+  graph.calculateAveragedistBetweenTwoPoints(x, y) + "!");
    }
    public double calculateAveragedistBetweenTwoPoints(String x, String y)
    {
        int s = x.equals("A") ? 0 : (x.equals("B") ? 1 : (x.equals("C") ? 2 : (x.equals("D") ? 3 : 4)));
        int d = y.equals("A") ? 0 : (y.equals("B") ? 1 : (y.equals("C") ? 2 : (y.equals("D") ? 3 : 4)));
//        System.out.println(s);
//        System.out.println(d);
        boolean[] visited =new boolean[5];
        Arrays.fill(visited, false);
        paths=0;
        total=0;
        visited[s]=true;
        DFS(s,d,visited,0);

        return ((double) total / (double) paths);
    }

    private void DFS(int s, int d, boolean[] visited, int dist){
        if(s==d){
            paths++;
            total += dist;
            return;
        }
        for(Edge e : adjL[s]){

            int t = e.dst;
            if(!visited[t]){
                visited[t] = true;
                DFS(t, d, visited, dist+e.wt);
                visited[t] = false;
            }
        }
    }
}
