import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Painting implements Comparable<Painting>{
    int time;
    int cost;
    int speed;

    Painting(int x,int y,int z) {
        time=x;
        cost=y;
        speed=z;
    }

    @Override
    public int compareTo(Painting o) {
        //return (getTime()-((Painting) o).getTime());
        int x=time-o.time;
        if(x==0) {
            x=o.speed-speed;
            if(x==0) {
                x=cost-o.cost;
            }
        }
        return x;
    }
};

class PaintingHouse {
    public static void main(String args[] ) throws Exception {
        MyScanner scan = new MyScanner();

        //Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long d=scan.nextLong();

        //Painting worker[]=new Painting[N];
        //List<Painting> worker = new ArrayList<Painting>();
        Painting worker[]=new Painting[N];

        for(int i=0;i<N;i++) {
            worker[i]=new Painting(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }

        Arrays.sort(worker);

        Painting opt=worker[0];
        long cost=opt.cost;

        for(int i=1;(i<N)&&(d>0);i++) {
            Painting curr=worker[i];
            d=d-(curr.time-opt.time)*opt.speed;

            if((curr.speed>opt.speed)&&(d>0)) {
                cost=cost+curr.cost;
                opt=curr;
            }
            opt.time=curr.time;
        }

        System.out.println(cost);
    }
};



//-----------PrintWriter for faster output---------------------------------

//-----------MyScanner class for faster input----------
class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    public long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    public int[][] nextInt2DArray(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = nextInt();
        }
        return arr;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

}

class Pair implements Comparable<Pair> {
    long u;
    long v;

    public Pair(long u, long v) {
        this.u = u;
        this.v = v;
    }


    public int hashCode() {
        int hu = (int) (u ^ (u >>> 32));
        int hv = (int) (v ^ (v >>> 32));
        return 31 * hu + hv;
    }

    public boolean equals(Object o) {
        Pair other = (Pair) o;
        return u == other.u && v == other.v;
    }

    public int compareTo(Pair other) {
        return Long.compare(u, other.u) != 0 ? Long.compare(u, other.u) : Long.compare(v, other.v);
    }

    public String toString() {
        return "[u=" + u + ", v=" + v + "]";
    }
}