package Problems;

public class maxprod {
    
    public static void main(String[] args){

        int[] number = {-9,-8,3,-4,5,6,8};
        //Arrays.sort(number);
        int max = -9999;
        int secmax = -999;
        int min = 9999;
        int nextmin = 999;
        for(int i =0; i<number.length;i++)
        {
            if(max<number[i])
            {
                secmax = max;
                max = number[i];
            }
            else if(secmax<number[i])
            {
                secmax = number[i];
            }

            if(min>number[i])
            {
                nextmin = min;
                min = number[i];
            }
            else if(nextmin>number[i])
            {
                nextmin = number[i];
            }
        }
        int maxprod = max*secmax;
        int highprod = min*nextmin;
        if(maxprod>highprod)
        System.out.println(""+max+"x"+secmax+" = " +maxprod);
        else
        System.out.println(min+"x"+nextmin+" = "+ highprod);
    }
}
