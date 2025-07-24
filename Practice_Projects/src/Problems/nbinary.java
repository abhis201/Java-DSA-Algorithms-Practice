package Problems;
import java.util.ArrayList;
import java.util.Stack;

public class nbinary {
    
    public static void printbinary(int n){
        
        int m = n;
        Stack<Integer> binary = new Stack<Integer>(); 
        if(n<=0)
        {
            System.out.println("Enter a value >0");
        }
        else{
            while(m!=1){
                binary.push(m%2);
                m = m/2;
            }
            binary.push(m);
        }
        while(binary.size()!=0)
        {
            System.out.print(binary.pop());
        }
        //System.out.println();
    }

    public static void main(String... args){

        int nbinary = 8;
        for(int i =1; i<8; i++)
        {
            //System.out.println(i);
            printbinary(i);
            System.out.print(" ,");
        }
        //printbinary(8);
        System.out.println("Another one");
        printbinary(35);

    }
}
