package inf5153.patterns.Eval;

import inf5153.patterns.Expressions.Expression;
import inf5153.patterns.Expressions.ListExpression;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by wflag on 2020-07-27.
 */
public class EvalChain {
    private final List<EvalChainHandler> handlers;

    public EvalChain(List<EvalChainHandler> handlers) {
        this.handlers = Arrays.asList(
               // Create new handlers.
                //new PrognHandler(),
                //new LetHandler()
                //...
        );
    }

    public Expression eval(ListExpression expr) {
        String fn = expr.getExpressions().get(0).toString();

        for(EvalChainHandler handler : handlers) {
            Optional<Expression> result = handler.handle(fn, expr);
            if(result.isPresent())
                return result.get();
        }

        throw new IllegalArgumentException();
    }
}
