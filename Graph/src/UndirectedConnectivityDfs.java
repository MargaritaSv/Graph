import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Margarita on 20-Oct-15.
 * the source code of the Java program to check
 * the connectivity of a undirected graph.
 * The Java program is successfully compiled and run on a Linux system. DFS
 */
public class UndirectedConnectivityDfs {
    public static void main(String[] args) {
        int numOfNodes, source;

        Scanner read = null;

        try {
            System.out.println("Enter the number of nodes in graph :");
            read = new Scanner(System.in);
            numOfNodes = read.nextInt();

            int[][] adjacency_matrix = new int[numOfNodes + 1][numOfNodes + 1];
            System.out.println("Enter the adjency matrix:");


            for (int i = 0; i < numOfNodes; i++) {
                for (int j = 0; j < numOfNodes; j++) {
                    adjacency_matrix[i][j] = read.nextInt();
                }
            }

            for (int i = 0; i < numOfNodes; i++) {
                for (int j = 0; j < numOfNodes; j++) {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0) {
                        adjacency_matrix[j][i] = 1;
                    }
                }
            }

            for (int i = 0; i < adjacency_matrix.length; i++) {
                for (int j = 0; j < adjacency_matrix.length; j++) {
                    System.out.print(adjacency_matrix[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println("Enter the source for the graph");

            source = read.nextInt();

            UndirectedConnectivityDfs undConn = new UndirectedConnectivityDfs();
            undConn.dfs(adjacency_matrix, source);

        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong input format");
        }

        read.close();
    }

    private void dfs(int[][] adjacency_matrix, int source) {

        int nodes = adjacency_matrix[source].length - 1;
        int visited[] = new int[nodes + 1];
        int el = source;
        int i = source;

        visited[source] = 1;
        stack.push(source);

        while (!stack.isEmpty()) {
            el = stack.peek();
            i = el;

            while (i <= nodes) {
                if (adjacency_matrix[el][i] == 1 && visited[i] == 0) {
                    stack.peek();
                    visited[i] = 1;
                    el = i;
                    i = 1;
                    continue;
                }
                i++;
            }
            stack.pop();
        }

        boolean connected = false;

        for (int j = 1; j <= nodes; j++) {
            if (visited[nodes] == 1) {
                connected = true;
            } else {
                connected = false;
                break;
            }
        }

        if (connected) {
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is disconnected");
        }
    }

    private Stack<Integer> stack;

    public UndirectedConnectivityDfs() {
        stack = new Stack<Integer>();
    }
}
/*Enter the number of nodes in graph :
2
Enter the adjency matrix:
000010
000110
000001
00000
Enter the source for the graph
2
The graph is connected

-------------------------------

Enter the number of nodes in the graph
5
Enter the adjacency matrix
0 1 0 1 0
0 0 1 0 0
0 0 0 0 0
0 1 0 0 0
0 0 0 0 0
Enter the source for the graph
1
The graph is disconnected
*/
