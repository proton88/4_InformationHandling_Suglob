package com.suglob.information_handling.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static final String EXPRESSION_DELIMETR="\\p{Blank}+";
    public static final char PLUS='+';
    public static final char MINUS='-';
    public static final char MULTIPLY='*';
    public static final char DIVIDE='/';
    private ArrayList<AbstractMathExpression> listExpression;

    public Client(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(EXPRESSION_DELIMETR)) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case PLUS:
                    if (lexeme.length()==2){
                        break;
                    }else {
                        listExpression.add(new TerminalExpressionPlus());
                        break;
                    }
                case MINUS:
                    if (lexeme.length()==2){
                        break;
                    }else {
                        listExpression.add(new TerminalExpressionMinus());
                        break;
                    }
                case MULTIPLY:
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case DIVIDE:
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(
                                new NonterminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    public Double calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}

