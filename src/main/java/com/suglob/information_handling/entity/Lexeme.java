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
        //log
        return null;
    }


    @Override
    public String toString() {
        return text+" ";
    }
}
