package Problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class flipmatrix {

    public static void swap(int num1, int num2){
        int x = num1;
        num1 = num2;
        num2 = x;
    }

    public static void printcol(List<List<Integer>> matrix, int colnum){
        int n = matrix.size();
        for(int i = 0; i<n; i++){
            System.out.println(matrix.get(i).get(colnum-1));
        }
    }
    
    public static void revcol(List<List<Integer>> matrix, int colnum){

        int n = matrix.size();
        printcol(matrix, colnum);
        for(int i=0,j=n-1; i<n/2&&j>=n/2; i++,j--){
            int a = matrix.get(i).get(colnum-1);
            int b = matrix.get(j).get(colnum-1);
            matrix.get(i).set(colnum-1, b);
            matrix.get(j).set(colnum-1,a);
        }
        System.out.println("Reversed Column");
        printcol(matrix, colnum);
        System.out.println("---------------");
        
    }
    
    public static void revrow(List<List<Integer>> matrix, int rownum){

        int n = matrix.size();
        int i=0,j=n-1;
        List<Integer> row = new ArrayList<>(matrix.get(rownum-1));
        row.forEach(System.out::println);
        while(i<j){
            int a = row.get(i);
            int b = row.get(j);
            row.set(j,a);
            row.set(i,b);
            ++i;--j;
        }
        matrix.set(rownum-1, row);
        List<Integer> row1 = new ArrayList<>(matrix.get(rownum-1));
        System.out.println("Reversed Row");
        row1.forEach(System.out::println);
    }

    /**
     * @param args
     */
    public static void main(String[] args){
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(112,42,83,119)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(56,125,56,49)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(15,78,101,43)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(62,98,114,108)));

        int n = matrix.size();
        int sumquad = 0;

        for(int i=0; i<n/2; i++){
            for(int j=0; j<n/2; j++){
                sumquad +=  Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(n-j-1)),
                Math.max(matrix.get(n-i-1).get(j),matrix.get(n-i-1).get(n-j-1)));
            }
        }
        System.out.println("Max sum of quadrant"+sumquad);
        System.out.println("-----------------");
        revcol(matrix, 3);
        revrow(matrix, 1);
    }
}
