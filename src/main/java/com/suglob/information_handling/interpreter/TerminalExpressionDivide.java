package com.suglob.information_handling.interpreter;


class TerminalExpressionDivide extends AbstractMathExpression{
    @Override
    public void interpret(Context c) {
        Double first=c.popValue();
        Double second=c.popValue();
        c.pushValue(second/first);
    }
}
