package com.suglob.information_handling.entity;

import java.util.ArrayList;

public class Lexeme implements Component {
    private String text;

    public Lexeme(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public ArrayList<Component> getComponents() {
        return null;
    }

    @Override
    public void addTextElement(Component element) {

    }

    @Override
    public void removeTextElement(Component element) {

    }

    @Override
    public void print() {
        System.out.print(text+" ");
    }

    @Override
    public String toString() {
        return text+" ";
    }
}
