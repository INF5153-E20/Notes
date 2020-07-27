package inf5153.patterns.Eval;

import inf5153.patterns.Expressions.Expression;
import inf5153.patterns.Expressions.ExpressionVisitor;
import inf5153.patterns.Expressions.ListExpression;
import inf5153.patterns.Expressions.LiteralExpression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wflag on 2020-07-27.
 */
public class EvalVisitor implements ExpressionVisitor {
    private Expression result;
    private Map<String, Expression> bindings;

    public EvalVisitor() {
        this.bindings = new HashMap<>();
    }

    @Override
    public void visit(ListExpression expr) {
        result = eval(expr);
    }

    @Override
    public void visit(LiteralExpression expr) {
        result = expr;
    }

    public Expression getResult() {
        return result;
    }

    private Expression eval(ListExpression expr) {
        String fn = expr.getExpressions().get(0).toString();

        switch(fn) {
            case "progn":
                return expr.getExpressions().stream()
                        .reduce(null, (l, r) -> evalAsExpr(r));
            case "let":
                String binding = expr.getExpressions().get(1).toString();
                Expression letarg = expr.getExpressions().get(2);
                return evalLet(binding, letarg);
            case "list":
                return new ListExpression(expr.getExpressions().stream()
                    .skip(1).collect(Collectors.toList()));
            case "inc":
            case "dec":
            case "double":
            case "square":
                return evalUnary(fn, expr);
            case "+":
            case "-":
            case "*":
            case "/":
            case "map":
            case "reduce":
                return evalBinary(fn, expr);
            default: throw new IllegalArgumentException();
        }
    }

    private Expression evalUnary(String fn, ListExpression expr) {
        Expression arg = expr.getExpressions().get(1);
        switch(fn) {
            case "inc":
                return evalInc(arg);
            case "dec":
                return evalDec(arg);
            case "double":
                return evalDouble(arg);
            case "square":
                return evalSquare(arg);
            default: throw new IllegalArgumentException();
        }
    }

    private LiteralExpression evalInc(Expression arg) {
        return integerExpr(evalAsNumber(arg) + 1);
    }

    private LiteralExpression evalDec(Expression arg) {
        return integerExpr(evalAsNumber(arg) - 1);
    }

    private LiteralExpression evalDouble(Expression arg) {
        return integerExpr(evalAsNumber(arg) * 2);
    }

    private LiteralExpression evalSquare(Expression arg) {
        int n = evalAsNumber(arg);
        return integerExpr(n * n);
    }

    private Expression evalBinary(String fn, ListExpression expr) {
        Expression left = expr.getExpressions().get(1);
        Expression right = expr.getExpressions().get(2);
        switch(fn) {
            case "+":
                return evalAdd(left, right);
            case "-":
                return evalSubtract(left, right);
            case "*":
                return evalMultiply(left, right);
            case "/":
                return evalDivide(left, right);
            case "map":
                return evalMap(left, right);
            case "reduce":
                return evalReduce(left, right);
            default: throw new IllegalArgumentException();
        }
    }

    private LiteralExpression evalAdd(Expression left, Expression right) {
        return integerExpr(evalAsNumber(left) + evalAsNumber(right));
    }

    private LiteralExpression evalSubtract(Expression left, Expression right) {
        return integerExpr(evalAsNumber(left) - evalAsNumber(right));
    }

    private LiteralExpression evalMultiply(Expression left, Expression right) {
        return integerExpr(evalAsNumber(left) * evalAsNumber(right));
    }

    private LiteralExpression evalDivide(Expression left, Expression right) {
        return integerExpr(evalAsNumber(left) / evalAsNumber(right));
    }

    private ListExpression evalMap(Expression function, Expression arg) {
        List<Expression> expressions = evalAsList(arg);
        List<Expression> results = expressions.stream()
                .map(e -> evalAsExpr(new ListExpression(
                        Arrays.asList(function, e))))
                .collect(Collectors.toList());

        return new ListExpression(results);
    }

    private Expression evalReduce(Expression function, Expression arg) {
        List<Expression> expressions = evalAsList(arg);
        return expressions.stream()
                .skip(1)
                .reduce(expressions.get(0), (l, r) -> evalAsExpr(
                        new ListExpression(Arrays.asList(function, l, r))));
    }

    private Expression evalLet(String binding, Expression arg) {
        Expression expr = evalAsExpr(arg);
        bindings.put(binding, expr);

        return expr;
    }

    private Expression evalAsExpr(Expression e) {
        String literal = e.toString();
        if(bindings.containsKey(literal))
            return bindings.get(literal);

        e.accept(this);

        return result;
    }

    private List<Expression> evalAsList(Expression e) {
        return ((ListExpression)evalAsExpr(e)).getExpressions();
    }

    private int evalAsNumber(Expression e) {
        return Integer.parseInt(evalAsExpr(e).toString());
    }

    private LiteralExpression integerExpr(int i) {
        return new LiteralExpression(String.format("%d", i));
    }
}
