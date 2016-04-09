import java.util.*;
class node {
    String nodename;
    int distance;

     node(String nodename,int distance) {
        this.nodename = nodename;
        this.distance = distance;
     }
}

public class All {
    public static void main(String[] args) {
        int i = 0;
        node[] nodes;
        int[][] adjacencymatrix;
        int nofvertices;
        String source;
        
        Scanner s=new Scanner(System.in);
        nofvertices=Integer.parseInt(s.nextLine());
        PriorityQueue<node> q= new PriorityQueue(nofvertices,checkDistance);
        parent=new String[nofvertices];
        nodes=new node[nofvertices];
        String vertices=s.nextLine();
        StringTokenizer st = new StringTokenizer(vertices,"(),");
        String[] array = new String[nofvertices];
        String name;
        while(st.hasMoreTokens()) {
            name=st.nextToken();
            node n=new node(name,999);
            nodes[i]=n;
            i++;
        }
        adjacencymatrix=new int[nofvertices][nofvertices];
        for( i=0;i<nofvertices;i++) {
            String input=s.nextLine();
            String[] arr=input.split(",");
            for(int j=0;j<nofvertices;j++)
                adjacencymatrix[i][j]=Integer.parseInt(arr[j]);
        }
        for(int sourcePosition = 0; sourcePosition < nofvertices; sourcePosition++) {
           for(int nodePosition = 0; nodePosition < nofvertices; nodePosition ++) {
                if(nodes[nodePosition].nodename.equals(nodes[sourcePosition].nodename))
                    nodes[nodePosition].distance = 0;
                else
                    nodes[nodePosition].distance = 999;
            }
            q.add(nodes[sourcePosition]);

            while(!q.isEmpty())
            {
                node top=q.poll();
                for(int k=0;k<nofvertices;k++)
                {
                    if(nodes[k].nodename.equals(top.nodename))
                    {
                        for(int z=0;z<nofvertices;z++)
                        {
                            if(top.distance + adjacencymatrix[k][z]<nodes[z].distance){
                                nodes[z].distance = top.distance+adjacencymatrix[k][z];
                                q.add(nodes[z]);
                            }
                        }
                    }
                }    
            }
            
            for(i = 0; i < nofvertices; i++)
                if(i == nofvertices - 1)
                    System.out.print(nodes[i].distance);
                else
                    System.out.print(nodes[i].distance + ",");
            System.out.println("");
        }
        
    }

    public static Comparator<node> checkDistance = new Comparator<node>() {
        @Override
        public int compare(node node1, node node2){
            return node1.distance - node2.distance;
        }
    };

}