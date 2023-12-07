//steg3
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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


public class NetworkFlow2 {
    int s, t, maxflow, v, x, y, e;
    public static int r = 1; 
    LinkedList2[] kanter; 
    Kattio io;

    public NetworkFlow() throws Exception {
        io = new Kattio(System.in, System.out);
        read();
        findMaxFlow();
        write();
        io.close();
    }

    private void read() {
        x = io.getInt();
        y = io.getInt();
        e = io.getInt();
        s = x + y + 1;
        t = s + 1;
        v = t;
        kanter = new LinkedList2[v + 1];
        for (int i = 0; i <= v; i++)
            kanter[i] = new LinkedList2();
        for (int i = 0; i < e; ++i) {
            int a = io.getInt();
            int b = io.getInt();
            addkant(a, b);
        }
        for (int i = 0; i < x; i++) {
            addkant(s, (i + 1));
        }
        for (int i = 0; i < y; i++) {
            addkant(x + 1 + i, t);
        }

    }

    private void addkant(int a, int b) {
        Kant x = new Kant(a, b, 1, 0);
        Kant y = new Kant(b, a, 0, 0);
        if (kanter[a].contains(x)) {
            Kant y2 = null;
            Kant le = kanter[a].first;
            while (le != null) {
                if (le.equals(x)) {
                    y2 = le.invers;
                    break;
                }
                le = le.next;
            }
            kanter[a].remove(x);
            kanter[a].add(x);
            x.invers = y2;
            y2.invers = x;
        }
        else {
            kanter[a].add(x);
            kanter[b].add(y);
            x.invers = y;
            y.invers = x;
        }
    }

    private void write() {
        io.println(x + " " + y);
        io.println(maxflow);
        for (int i = 1; i < kanter.length - 2; i++) {
            Kant le = kanter[i].first;
            while (le != null) {
                if (le.to != t && le.flow > 0) {
                    io.println(i + " " + le.to);
                }
                le = le.next;
            }
        }
        io.flush(); 
    }

    private void findMaxFlow() throws Exception {
        Kant x;
        maxflow = 0;
        while ((x = BFS()) != null) {
            while (x != null) {
                x.flow += r;
                x.invers.flow = -x.flow;
                x = x.father; 
            }
            maxflow += r;
        }
    }
    private Kant BFS() throws Exception {
    boolean[] visited = new boolean[v + 1];
    LinkedList<Kant> q = new LinkedList<>();  
    Kant le = kanter[s].first;
    while (le != null) {
        if ((le.cap - le.flow) > 0) {
            q.add(le); 
            le.father = null;
        }
        le = le.next;
    }
    visited[s] = true;
    while (!q.isEmpty()) {  
        Kant at = q.poll();  
        if (!visited[at.to]) {
            visited[at.to] = true;
            if (at.to == t) {
                return at;
            }
            le = kanter[at.to].first;
            while (le != null) {
                if (!visited[le.to] && (le.cap - le.flow) > 0) {
                    le.father = at;
                    q.add(le);  
                }
                le = le.next;
            }
        }
    }
    return null;
}

    public static void main(String[] args) throws Exception {
        new NetworkFlow2();
    }

    public class LinkedList2 {
        public Kant first;
        public Kant last;

        public LinkedList2() {

        }

        public void add(Kant ge) {
            if (first == null) {
                first = ge;
                last = ge;
            } else {
                last.next = ge;
                last = ge;
            }
        }

        public void clear() {
            first = null;
            last = null;
        }

        public boolean contains(Kant ge) {
            Kant g = first;
            while (g != null) {
                if (g == ge)
                    return true;
                g = g.next;
            }
            return false;
        }

        public void remove(Kant ge) {
            Kant prev = null;
            Kant g = first;
            while (g != null) {
                if (g == ge) {
                    if (prev == null) {
                        first = g.next;
                    } else {
                        prev.next = g.next;
                    }
                    return;
                }
                prev = g;
                g = g.next;
            }
        }

    }

    public class Kant {
        public int to;
        public int from;
        public int flow;
        public int cap;
        public Kant invers; 
        public Kant father; 
        public Kant next; 

        public Kant(int from, int to, int cap, int flow) {
            this.from = from;
            this.to = to;
            this.cap = cap;
            this.flow = flow;
        }

        @Override
        public boolean equals(Object o) {
            Kant t = (Kant) o;
            if (this.to == t.to)
                return true;
            return false;
        }
    }
}
