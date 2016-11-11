package com.suglob.information_handling.entity;

import java.util.ArrayList;

public interface Component {
    public ArrayList<Component> getComponents();
    public void addTextElement(Component element);
    public void removeTextElement(Component element);
    void print();
}
