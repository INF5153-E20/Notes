package inf5153.patterns.Expressions;

/**
 * Created by wflag on 2020-07-27.
 */
public interface Expression {
    void accept(ExpressionVisitor visitor);
}
