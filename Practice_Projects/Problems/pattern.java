package Problems;
public class pattern {
    
    public static void printpat1()
    {
        for(int i = 11; i>=1; i--)
        {
            for(int spaces =2; spaces<=i; spaces++)
            {
                System.out.print(" ");
            }
            for(int j=15; j>=2*i; j--)
            {
                if(j%2!=0)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }/*
            for(int spaces =2; spaces<=i; spaces++)
            {
                System.out.print(" ");
            }*/
            System.out.println();
        }
    }

    public static void printpat2()
    {

        for(int i = 4; i>=1; i--)
        {
            for(int spaces=-1; spaces<=i; spaces++)
            {
                System.out.print(" ");
            }
            for(int j = 8; j>=2*i; j--)
            {
                System.out.print("*");
            }/*
            for(int spaces=1; spaces<=i; spaces++)
            {
                System.out.print(" ");
            }*/
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        printpat1();
        printpat2();
    }
}
