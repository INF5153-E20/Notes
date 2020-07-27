package inf5153.patterns.Eval;

import inf5153.patterns.Expressions.Expression;
import inf5153.patterns.Expressions.ListExpression;

import java.util.Optional;

/**
 * Created by wflag on 2020-07-27.
 */
public interface EvalChainHandler {
    Optional<Expression> handle(String fn, ListExpression expr);
}
