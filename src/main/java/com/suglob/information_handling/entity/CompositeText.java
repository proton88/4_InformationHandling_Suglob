package com.suglob.information_handling.entity;

import java.util.ArrayList;

public class CompositeText implements Component {
    private ArrayList<Component> components;
    private TypeText typeText;

    public CompositeText(TypeText typeText) {
        components =new ArrayList<>();
        this.typeText=typeText;
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
    public void print() {
        for (Component element: components){
            element.print();
            if (typeText==TypeText.TEXT){
                System.out.println();
            }
        }
    }

}
