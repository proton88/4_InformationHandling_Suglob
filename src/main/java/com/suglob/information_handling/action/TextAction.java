package com.suglob.information_handling.action;


import com.suglob.information_handling.entity.Component;
import com.suglob.information_handling.entity.CompositeText;

public class TextAction {
    public static void removeNextEqualsFirst(CompositeText compositeText){
        for (Component pharagraph : compositeText.getComponents()) {
            for (Component sentence : pharagraph.getComponents()) {
                for (Component lexeme : sentence.getComponents()) {
                    char firstLetter=lexeme.toString().charAt(0);
                    String newLexema="";
                    newLexema+=firstLetter;
                    for (int i=0; i<lexeme.toString().length();i++){
                        if (lexeme.toString().charAt(i)!=firstLetter){
                            newLexema+=lexeme.toString().charAt(i);
                        }
                    }
                    lexeme.setText(newLexema.trim());
                }
            }
        }
        compositeText.print();
    }

    public static void changeLexemesFirstLast(CompositeText compositeText){
        for (Component pharagraph : compositeText.getComponents()) {
            for (Component sentence : pharagraph.getComponents()) {
                Component lexeme=sentence.getComponents().get(0);
                sentence.getComponents().remove(0);
                sentence.getComponents().add(lexeme);
            }
        }
        compositeText.print();
    }
}
