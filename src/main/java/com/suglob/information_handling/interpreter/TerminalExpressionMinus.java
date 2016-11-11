package com.suglob.information_handling.interpreter;
class TerminalExpressionMinus extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        Double first=c.popValue();
        Double second=0.0;
        if (!c.isEmpty()){
            second=c.popValue();
        }
        c.pushValue(second-first);
    }
}
