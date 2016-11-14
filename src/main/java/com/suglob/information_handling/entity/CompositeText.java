package com.suglob.information_handling.entity;

import java.util.ArrayList;

public class CompositeText implements Component {
    private ArrayList<Component> components;
    private TypeText typeText;

    public CompositeText(TypeText typeText) {
        components =new ArrayList<>();
        this.typeText=typeText;
    }

    public CompositeText(CompositeText text){
        components =new ArrayList<>();
        CompositeText newText=new CompositeText(TypeText.TEXT);
        for (Component pharagraph : text.getComponents()) {
            CompositeText newPharagraph=new CompositeText(TypeText.PHARAGRAPH);
            for (Component sentence : pharagraph.getComponents()) {
                CompositeText newSentence=new CompositeText(TypeText.SENTENCE);
                for (Component lexeme : sentence.getComponents()) {
                    Component newLexeme=new Lexeme(lexeme.toString().trim());
                    newSentence.addTextElement(newLexeme);
                }
                newPharagraph.addTextElement(newSentence);
            }
            newText.addTextElement(newPharagraph);
        }
        components.add(newText);
    }

    public CompositeText() {
        components =new ArrayList<>();
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public TypeText getTypeText() {
        return typeText;
    }

    public void addTextElement(Component element){
        components.add(element);
    }

    public void removeTextElement(Component element){
        components.remove(element);
    }


    @Override
    public String toString() {
        StringBuilder text=new StringBuilder("");
        for (Component element: components){
            text.append(element);
            if (typeText==TypeText.TEXT){
                text.append("\n");
            }
        }

        return text.toString();
    }
}
