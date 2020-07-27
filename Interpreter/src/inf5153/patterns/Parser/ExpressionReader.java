package inf5153.patterns.Parser;

import inf5153.patterns.Expressions.Expression;
import inf5153.patterns.Expressions.ListExpression;
import inf5153.patterns.Expressions.LiteralExpression;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by wflag on 2020-07-27.
 */
public class ExpressionReader {
    private PushbackReader reader;

    public Expression read(String code) throws IOException {
        reader = new PushbackReader(new StringReader(code));

        return readExpression().get();
    }

    private Optional<Expression> readExpression() throws IOException {
        skipSpaces();

        char next = peek();
        if(next == ')') {
            read();
            return Optional.empty();
        }

        if(next == '(') {
            read();
            return Optional.of(readListExpression());
        }

        return Optional.of(readLiteralExpression());
    }

    private ListExpression readListExpression() throws IOException {
        List<Expression> expressions = new ArrayList<>();

        Optional<Expression> expression = readExpression();
        while(expression.isPresent()) {
            expressions.add(expression.get());
            expression = readExpression();
        }

        return new ListExpression(expressions);
    }

    private LiteralExpression readLiteralExpression() throws IOException {
        String expr = readUntil(Arrays.asList(' ', ')', '('));

        return new LiteralExpression(expr);
    }

    private String readUntil(List<Character> endChars) throws IOException {
        StringBuilder builder = new StringBuilder();

        char next = peek();
        if(next == (char)-1)
            throw new IllegalArgumentException();

        while(!endChars.contains(next) && next !=(char)-1) {
            builder.append(read());
            next = peek();
        }

        return builder.toString();
    }

    private void skipSpaces() throws IOException {
        while(peek() == ' ')
            read();
    }

    private char peek() throws IOException {
        char c = read();
        if(c != (char)-1)
            reader.unread((int)c);

        return c;
    }

    private char read() throws IOException {
        return (char) reader.read();
    }
}
