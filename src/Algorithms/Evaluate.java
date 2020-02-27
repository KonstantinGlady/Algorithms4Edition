package Algorithms;

import java.util.Stack;

//Dijkstra's two-stack algorithm.
public class Evaluate {
    public static void main(String[] args) {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"; // ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + ) // 101.0
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String a = Character.toString(s.charAt(i));
            if (a.equals("(") || a.equals(" ")) {
            } else if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") || a.equals("sqrt")) {
                ops.push(a);
            } else if (a.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(a));
            }
        }

        System.out.println(vals.pop());
    }

}
