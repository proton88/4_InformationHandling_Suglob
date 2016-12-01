package com.suglob.information_handling.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Lexeme implements Component {
    static Logger logger = Logger.getLogger(Lexeme.class);

    private String text;

    public Lexeme(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public ArrayList<Component> getComponents() {
        logger.error("Attempting to call getComponents from Lexeme");
        return null;
    }


    @Override
    public String toString() {
        return text+" ";
    }
}
