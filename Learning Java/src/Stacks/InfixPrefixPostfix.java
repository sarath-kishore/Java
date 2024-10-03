package Stacks;
import java.util.*;
public class InfixPrefixPostfix {
    public static void main(String[] args) {
        String infExp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix: " + infExp);
        System.out.println("Postfix: " + infixToPostfix(infExp));
        System.out.println("Prefix: " + infixToPrefix(infExp));
    }

    static String infixToPrefix(String exp){
        String temp = infixReverse(exp);

//        System.out.println("reverse: " + temp);
//        System.out.println("postfix: " + prefixPostfix(temp));
        StringBuilder ans = new StringBuilder(prefixPostfix(temp));
        return ans.reverse().toString();
    }

    public static String prefixPostfix(String exp) {
        // nearly postfix used for prefix conversion
        String ans = new String();
        Stack<Character> st = new Stack<>();

        int i=0;
        while(i<exp.length()){
            char ch = exp.charAt(i);
            if(isOperand(ch))
                ans += ch;
            else if(ch == '(')
                st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();
                }
                if(!st.isEmpty())
                    st.pop(); // pop off the opening bracket '('
            }else{
                // operator
                while(!st.isEmpty() && priority(ch) < priority(st.peek())){
            // in infix to postfix, ch <= st.peek will be popped
                    ans += st.pop();
                }
                st.push(ch);
            }

            i++;
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }

        return ans;
    }

    static String infixReverse(String exp){
        char[] str = exp.toCharArray();
        int i=0;
        int j = str.length-1;
        while(i<=j){
            char ch = str[i];
            str[i] = str[j];
            if(str[i] == '(')
                str[i] = ')';
            else if(str[i] == ')')
                str[i] = '(';
            str[j] = ch;
            if(str[j] == '(')
                str[j] = ')';
            else if(str[j] == ')')
                str[j] = '(';
            i++;
            j--;
        }
        return new String(str);
    }

    public static String infixToPostfix(String exp) {
        // Your code here
        String ans = new String();
        Stack<Character> st = new Stack<>();

        int i=0;
        while(i<exp.length()){
            char ch = exp.charAt(i);
            if(isOperand(ch))
                ans += ch;
            else if(ch == '(')
                st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();
                }
                if(!st.isEmpty())
                    st.pop(); // pop off the opening bracket '('
            }else{
                // // operator
                while(!st.isEmpty() && priority(ch) <= priority(st.peek())){
                    ans += st.pop();
                }
                st.push(ch);
            }

            i++;
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }

        return ans;
    }

    static boolean isOperand(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >='A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }

    static int priority(char ch){
        if(ch == '^')
            return 3;
        else if(ch == '*' || ch == '/')
            return 2;
        else if(ch == '+' || ch == '-')
            return 1;
        else
            return -1;
    }
}

