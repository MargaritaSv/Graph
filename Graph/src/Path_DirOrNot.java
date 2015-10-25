import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neighbor {
    public int vertexNum;
    public Neighbor next;

    public Neighbor(int vnum, Neighbor nbr) {
        this.vertexNum = vnum;
        next = nbr;
    }
}

class Vertex {
    String name;
    Neighbor adjLIST;

    Vertex(String name, Neighbor neighbor) {
        this.name = name;
        this.adjLIST = neighbor;
    }
}

public class Path_DirOrNot {
    Vertex[] adjLists;

    public Path_DirOrNot(String fl) throws FileNotFoundException {
        Scanner read = new Scanner(new File(fl));
        String graphType = read.next();
        boolean undirected = true;

        if (graphType.equals("directed")) {
            undirected = false;
        }

        adjLists = new Vertex[read.nextInt()];

        for (int i = 0; i < adjLists.length; i++) {
            adjLists[i] = new Vertex(read.next(), null);
        }

        while (read.hasNext()) {
            int v1 = indexForName(read.next());
            int v2 = indexForName(read.next());

            adjLists[v1].adjLIST = new Neighbor(v2, adjLists[v1].adjLIST);

            if (undirected) {
                adjLists[v2].adjLIST = new Neighbor(v1, adjLists[v2].adjLIST);
            }
        }
    }

    private int indexForName(String name) {
        for (int i = 0; i < adjLists.length; i++) {
            if (adjLists[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < adjLists.length; i++) {
            System.out.print(adjLists[i].name);
            for (Neighbor nbr = adjLists[i].adjLIST; nbr != null; nbr = nbr.next) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = read.nextLine();
        Path_DirOrNot graph = new Path_DirOrNot(file);
        graph.print();
    }
}
