package inf5153.patterns.Expressions;

/**
 * Created by wflag on 2020-07-27.
 */
public class LiteralExpression implements Expression {
    private final String value;

    public LiteralExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return value;
    }
}
