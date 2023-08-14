package class09;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        reverse(stack);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    public static int getLast(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }
        else {
            int last = getLast(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return ;
        }
        int last = getLast(stack);
        reverse(stack);
        stack.push(last);
    }
}
