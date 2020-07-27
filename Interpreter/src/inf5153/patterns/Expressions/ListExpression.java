package inf5153.patterns.Expressions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wflag on 2020-07-27.
 */
public class ListExpression implements Expression {
    private final List<Expression> expressions;

    public ListExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');

        builder.append(expressions.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(" ")));

        builder.append(')');

        return builder.toString();
    }
}
