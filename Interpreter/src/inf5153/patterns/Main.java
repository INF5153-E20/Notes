package inf5153.patterns;

import inf5153.patterns.Eval.EvalVisitor;
import inf5153.patterns.Expressions.Expression;
import inf5153.patterns.Expressions.ListExpression;
import inf5153.patterns.Expressions.LiteralExpression;
import inf5153.patterns.Parser.ExpressionReader;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        ExpressionReader reader = new ExpressionReader();
        Expression expr = reader.read("(progn" +
                "(let x (list 1 2 3))" +
                "(let y (map double x))" +
                "(reduce + y))");

        EvalVisitor visitor = new EvalVisitor();
        expr.accept(visitor);

        System.out.println(visitor.getResult());
    }
}
