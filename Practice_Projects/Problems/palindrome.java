package Problems;
import java.util.Scanner;
import java.util.stream.IntStream;


public class palindrome {

    static void check_palindrome(String pali){
        int len = pali.length();
        // char[] palin = pali.toCharArray();
        StringBuilder rev = new StringBuilder();
        String forward = pali.toLowerCase();

        String reverse = new StringBuilder(forward).reverse().toString();
        Boolean check = IntStream.range(0,len/2).allMatch(i -> forward.charAt(i) == forward.charAt(len - i-1));
        System.out.println(check);

        for(int i = len-1; i>=0; i--)
        {
            rev.append(pali.charAt(i));
        }
        // String reverse = rev.toString();
        System.out.println(reverse);

        reverse = reverse.toLowerCase();

        if (forward.equals(reverse)) {
            System.out.println("This word is a Palindrome");
        } else {
            System.out.println("This word is not a palindrome");
        }
    }
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a word : ");
            String pal = sc.nextLine();
            check_palindrome(pal);
        }
        
    }
}
