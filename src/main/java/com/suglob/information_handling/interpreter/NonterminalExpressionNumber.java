package com.suglob.information_handling.interpreter;

class NonterminalExpressionNumber extends AbstractMathExpression{
    private double number;
    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }
    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
