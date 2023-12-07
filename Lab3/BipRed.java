import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class BipRed {
    Kattio io;
    ArrayList<LinkedList<Integer>> graph;
    ArrayList<LinkedList<Integer>> flowSolution;
    int x, y, e, edgeSol;

    BipRed() {
        io = new Kattio(System.in, System.out);
        readBipartiteGraph();
        writeFlowGraph();
        readMaxFlowSolution();
        writeBipMatchSolution();
        io.close();
    }

    void readBipartiteGraph() {
        x = io.getInt();
        y = io.getInt();
        e = io.getInt();
        graph = new ArrayList<>(x + y + 2);

        for (int i = 0; i < x + y + 2; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 1; i <= x; i++) {
            graph.get(0).add(i);
        }

        for (int i = 0; i < e; i++) {
            int a = io.getInt();
            int b = io.getInt();
            graph.get(a).add(b);
        }

        for (int i = x + 1; i <= x + y; i++) {
            graph.add(new LinkedList<>());
            graph.get(i).add(x + y + 1);
        }
    }

    void writeFlowGraph() {
        io.println(x + y + 2);
        io.println(1 + " " + (x + y + 2));
        io.println(x + y + e);

        for (int i = 0; i < graph.size(); i++) {
            int a = i + 1;
            for (Integer b : graph.get(i)) {
                b += 1;
                io.println(a + " " + b + " " + 1);
            }
        }

        io.flush();
    }

    void readMaxFlowSolution() {
        int v = io.getInt();
        int s = io.getInt();
        int t = io.getInt();
        int totFlow = io.getInt();
        edgeSol = io.getInt();
        flowSolution = new ArrayList<>();

        for (int i = 0; i < edgeSol; i++) {
            int a = io.getInt();
            int b = io.getInt();
            int f = io.getInt();

            if (a != s && b != t) {
                flowSolution.add(new LinkedList<>());
                flowSolution.get(flowSolution.size() - 1).add(a);
                flowSolution.get(flowSolution.size() - 1).add(b);
                flowSolution.get(flowSolution.size() - 1).add(f);
            }
        }
    }

    void writeBipMatchSolution() {
        io.println(x + " " + y);
        io.println(flowSolution.size());

        for (int i = 0; i < flowSolution.size(); i++) {
            int a = flowSolution.get(i).get(0);
            int b = flowSolution.get(i).get(1);
            io.println((a - 1) + " " + (b - 1));
        }
    }

    public static void main(String args[]) {
        new BipRed();
    }
}
