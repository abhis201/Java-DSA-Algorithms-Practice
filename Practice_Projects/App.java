public class App {

    static int gcd(int a, int b){
        if(b>a)return gcd(b,a);

        int remainder,dividend=a,divisor=b;

        while(divisor!=0){
            remainder = dividend%divisor;
            dividend = divisor;
            divisor = remainder;
        }
        
        return dividend;
    }

    static int lcm(int a, int b)
    {
        int n1=a,i=2;
        while(n1%b!=0)
        {
            n1 = a*i;
            i++;
        }
        return n1;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        for (int i = 5; i > 0; i--) {
           /* for (int j = 0; j < i; j++) {
                System.out.print("*");
            }*/
            System.out.print("*".repeat(i));
            System.out.println();
        }
        System.out.println(gcd(35, 49));
        System.out.println(lcm(10,22));
    }
}
