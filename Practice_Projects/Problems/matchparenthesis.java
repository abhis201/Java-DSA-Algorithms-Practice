package Problems;

import java.util.Stack;

public class matchparenthesis {

    public static char getrevbrack(char c)
    {
        if(c=='}') return '{';
        else if(c==']') return '[';
        else if(c==')') return '(';
        else if(c=='>') return '<';

        return c;
    }
    
    public static boolean checkparethesis(String word)
    {

        Stack<Character> brackets = new Stack<>();

        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)=='{'||word.charAt(i)=='['||word.charAt(i)=='('||word.charAt(i)=='<')
            {
                brackets.push(word.charAt(i));
            }
            
            if(word.charAt(i)=='}'||word.charAt(i)==']'||word.charAt(i)==')'||word.charAt(i)=='>')
            {
                char rem = getrevbrack(word.charAt(i));
                if(brackets.peek()==rem){
                    brackets.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args)
    {
        String word = "<hu[ah{uahq>]";
        String word1 = "[](){<>}";
        
        
        System.out.println("Matching paranthesis: " + checkparethesis(word));
        System.out.println("Matching paranthesis: " + checkparethesis(word1));


    }
}
