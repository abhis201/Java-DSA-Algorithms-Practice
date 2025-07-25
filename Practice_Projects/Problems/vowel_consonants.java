package Problems;

import java.util.Scanner;

public class vowel_consonants {

    static void countvowel(String word) {
        String vowels = "aeiouy";

        String input = word.toLowerCase().trim();
        char[] array = input.toCharArray();
        int vow = 0;
        int cons = 0;
        for (char c : array) {
            if (vowels.indexOf(c) != -1) {
                vow += 1;
            } else if (c != ' ') {
                cons += 1;
            }
        }
        System.out.println("Total no of vowels is :" + vow);
        System.out.println("Total no of consonants is :" + cons);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a Sentence: ");
            String check = sc.nextLine();
            countvowel(check);
        }
    }
}
