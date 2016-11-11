package com.suglob.information_handling.interpreter;

import java.util.ArrayDeque;

class Context {
    private ArrayDeque<Double> contextValues = new ArrayDeque<>();
    public Double popValue() {
        return contextValues.pop();
    }
    public void pushValue(Double value) {
        this.contextValues.push(value);
    }
    public boolean isEmpty(){
        return contextValues.isEmpty();
    }
}
