package Data_Structures;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class graph {
    
    static Scanner sc = new Scanner(System.in);

    public static void adjacencymatrix(int nodes, char directed)
    {
        int i,j;
        int adjmatrix[][] = new int[nodes][nodes];
        int val;
        System.out.println("Enter edge weights of the graph");
        for(i=0;i<nodes;i++)
        {
            for(j=i+1;j<nodes;j++)
            {
                System.out.print("Enter edge weight between "+(i+1)+" and "+(j+1)+": ");
                val = sc.nextInt();
                adjmatrix[i][j] = val;
                if(directed == 'N' || directed == 'n'){
                    adjmatrix[j][i] = val; 
                }
            }
        }
    }

    public static void adjacencylist(int nodes){

        int i;
        int val=0;

        ArrayList<LinkedList<Integer>> adjlist = new ArrayList<LinkedList<Integer>>(nodes);

        for(i=0;i<nodes;i++)
        {
            adjlist.add(new LinkedList<Integer>());
            System.out.println("Enter edges for node "+(i+1)+": ");
            while(val!=-1){
                val = sc.nextInt();
                adjlist.get(i).add(val);
            }
            val=0;
        }
    }

    public static void minspantree(){
        //kruskal's algorithm
    }

    public static void breadfirsttravel(){}

    public static void depthfirsttravel(){}

    public static void shortestpath(){
        //dijikstra's algorithm
    }

    public static void main(String args[])
    {
        int nodes = 5;
        adjacencylist(nodes);
        adjacencymatrix(nodes, 'N');
    }
}
