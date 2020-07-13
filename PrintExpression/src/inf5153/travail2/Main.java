package inf5153.travail2;

import java.util.Stack;

public class Main {
    private interface PrintExpression {
        String printAsLeft();
        String printAsRight();
    }

    public static class PrintValue implements PrintExpression {
        private int value;

        public PrintValue(int value) {
            this.value = value;
        }

        @Override
        public String printAsLeft() {
            return String.format("%d", value);
        }

        @Override
        public String printAsRight() {
            return String.format("%d", value);
        }
    }

    public static class PrintOperation implements PrintExpression {
        private String expression;

        public PrintOperation(PrintExpression left, PrintExpression right, String operator) {
            expression = String.format("%s %s %s",
                    left.printAsLeft(),
                    operator,
                    right.printAsRight());
        }

        @Override
        public String printAsLeft() {
            return expression;
        }

        @Override
        public String printAsRight() {
            return String.format("(%s)", expression);
        }
    }

    public static void main(String[] args) {
	    // 2 + 3 infix
        // +(2, 3) prefix
        // 2 3 + postfix

        // 2 * 4 + 3 - 15 / 2 infix
        // 2 4 * 3 + 15 - 2 / postfix
        // 2 4 * -> 8
        // 8 3 + -> 11
        // 11 15 - -> -4
        // -4 2 / -> -2
        // -2

        // 2 - (5 - 3) / (16 / 4) infix
        // 2 5 3 - - 16 4 / / postfix

        String postfix = "2 5 3 - - 16 4 / /";
        String[] elements = postfix.split(" ");

        Stack<PrintExpression> stack = new Stack<>();

        for(String element : elements) {
            try {
                int n = Integer.parseInt(element);
                stack.push(new PrintValue(n));
            } catch(NumberFormatException ex) {
                PrintExpression right = stack.pop();
                PrintExpression left = stack.pop();

                stack.push(new PrintOperation(left, right, element));
            }
        }

        System.out.println(stack.peek().printAsLeft());
    }
}
