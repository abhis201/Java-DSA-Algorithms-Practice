import java.util.HashMap;

public class first {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(1,3);
        mp.put(2,2);
        mp.forEach((k,v)->{System.out.println(k+","+v);});
        int a = 5;
        for (int i = 0; i < a; i++) {
            System.out.print("x");
        }
    }
}