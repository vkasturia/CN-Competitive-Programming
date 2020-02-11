import java.io.*;
class VasyaRhezo {
    public static void main(String[] args)throws IOException {
        Reader sc=new Reader();
        int n=sc.nextInt();
        long a1[]=new long[n];
        long b1[]=new long[n];
        for(int i=0;i<n;i++)
        {
            a1[i]=sc.nextLong();
        }
        for(int i=0;i<n;i++)
        {
            b1[i]=sc.nextLong();
        }
        Triplet tree[]=new Triplet[4*n];
        for(int i=0;i<4*n;i++)
        {
            tree[i]=new Triplet(0,0,-1);
        }
        buildTree(a1,b1,tree,0,n-1,1);
        // for(int i=0;i<4*n;i++)
        // {
        // 	System.out.println(tree[i]);
        // }
        int q=sc.nextInt();
        while(q-->0)
        {
            int l=sc.nextInt();
            int r=sc.nextInt();
            Triplet ans=query(tree,0,n-1,1,l-1,r-1);
            System.out.println(ans.i+1);
        }

    }
    public static Triplet query(Triplet tree[],int start,int end,int treeNode,int left,int right)
    {
        //completely outside
        if(start>right || end<left)
        {
            return new Triplet (0,0,-1);
        }
        else if(start>=left && end<=right)
        {
            return tree[treeNode];
        }
        int mid=(start+end)/2;
        Triplet ans1=query(tree,start,mid,2*treeNode,left,right);
        Triplet ans2 =query(tree,mid+1,end,2*treeNode+1,left,right);
        long a1=ans1.a;
        long a2=ans2.a;
        long b1=ans1.b;
        long b2=ans2.b;
        int index1=ans1.i;
        int index2=ans2.i;
        Triplet t=new Triplet(0,0,-1);
        if(a1>a2)
        {
            t=new Triplet(a1,b1,index1);

        }
        else if(a1<a2)
        {
            t=new Triplet(a2,b2,index2);

        }
        else if(a1==a2)
        {
            if(b1<b2)
            {
                t=new Triplet(a1,b1,index1);

            }
            else if(b1>b2)
            {
                t=new Triplet(a2,b2,index2);

            }
            else if(b1==b2)
            {
                if(index1<index2)
                {
                    t=new Triplet(a1,b1,index1);

                }
                else
                {
                    t=new Triplet(a2,b2,index2);

                }
            }
        }
        return  t;


    }
    public static void buildTree(long a[],long b[],Triplet tree[],int start,int end,int treeNode)
    {
        if(start==end)
        {
            tree[treeNode]=new Triplet(a[start],b[start],start);
            return;
        }
        int mid=(start+end)/2;
        buildTree(a,b,tree,start,mid,2*treeNode);
        buildTree(a,b,tree,mid+1,end,2*treeNode+1);
        long a1=tree[2*treeNode].a;
        long a2=tree[2*treeNode+1].a;
        long b1=tree[2*treeNode].b;
        long b2=tree[2*treeNode+1].b;
        int index1=tree[2*treeNode].i;
        int index2=tree[2*treeNode+1].i;
        if(a1>a2)
        {
            Triplet t=new Triplet(a1,b1,index1);
            tree[treeNode]=t;
        }
        else if(a1<a2)
        {
            Triplet t=new Triplet(a2,b2,index2);
            tree[treeNode]=t;
        }
        else if(a1==a2)
        {
            if(b1<b2)
            {
                Triplet t=new Triplet(a1,b1,index1);
                tree[treeNode]=t;
            }
            else if(b1>b2)
            {
                Triplet t=new Triplet(a2,b2,index2);
                tree[treeNode]=t;
            }
            else if(b1==b2)
            {
                if(index1<index2)
                {
                    Triplet t=new Triplet(a1,b1,index1);
                    tree[treeNode]=t;
                }
                else
                {
                    Triplet t=new Triplet(a2,b2,index2);
                    tree[treeNode]=t;
                }
            }
        }



    }
}
class Triplet
{
    long a, b; int i;
    public Triplet(long a,long b,int i)
    {
        this.a=a;
        this.b=b;
        this.i=i;
    }
    public String toString()
    {
        return this.a+" "+this.b+" "+this.i;
    }

}
class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
    public Reader(){
        din=new DataInputStream(System.in);
        buffer=new byte[BUFFER_SIZE];
        bufferPointer=bytesRead=0;
    }

    public Reader(String file_name) throws IOException{
        din=new DataInputStream(new FileInputStream(file_name));
        buffer=new byte[BUFFER_SIZE];
        bufferPointer=bytesRead=0;
    }

    public String readLine() throws IOException{
        byte[] buf=new byte[64]; // line length
        int cnt=0,c;
        while((c=read())!=-1){
            if(c=='\n')break;
            buf[cnt++]=(byte)c;
        }
        return new String(buf,0,cnt);
    }

    public int nextInt() throws IOException{
        int ret=0;byte c=read();
        while(c<=' ')c=read();
        boolean neg=(c=='-');
        if(neg)c=read();
        do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(neg)return -ret;
        return ret;
    }

    public long nextLong() throws IOException{
        long ret=0;byte c=read();
        while(c<=' ')c=read();
        boolean neg=(c=='-');
        if(neg)c=read();
        do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(neg)return -ret;
        return ret;
    }

    public double nextDouble() throws IOException{
        double ret=0,div=1;byte c=read();
        while(c<=' ')c=read();
        boolean neg=(c=='-');
        if(neg)c = read();
        do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(c=='.')while((c=read())>='0'&&c<='9')
            ret+=(c-'0')/(div*=10);
        if(neg)return -ret;
        return ret;
    }

    public char nextChar() throws IOException{
        byte c=read();
        while(c<=' ')c=read();
        return (char)c;
    }

    private void fillBuffer() throws IOException{
        bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
        if(bytesRead==-1)buffer[0]=-1;
    }

    private byte read() throws IOException{
        if(bufferPointer==bytesRead)fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException{
        if(din==null) return;
        din.close();
    }
}