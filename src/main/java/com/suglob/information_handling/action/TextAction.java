package com.suglob.information_handling.action;


import com.suglob.information_handling.entity.Component;
import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.Lexeme;

public class TextAction {
    public static void removeNextEqualsFirst(CompositeText compositeText){
        CompositeText newCompositeText=new CompositeText(compositeText);
        Component text=newCompositeText.getComponents().get(0);
        for (Component pharagraph : text.getComponents()) {
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
                    if (lexeme instanceof Lexeme) {
                        Lexeme lex = (Lexeme) lexeme;
                        lex.setText(newLexema.trim());
                    }

                }
            }
        }
        System.out.println(newCompositeText);
    }

    public static void changeLexemesFirstLast(CompositeText compositeText){
        CompositeText newCompositeText=new CompositeText(compositeText);
        Component text=newCompositeText.getComponents().get(0);
        for (Component pharagraph : text.getComponents()) {
            for (Component sentence : pharagraph.getComponents()) {
                Component lexeme=sentence.getComponents().get(0);
                sentence.getComponents().remove(0);
                sentence.getComponents().add(lexeme);
            }
        }
        System.out.println(newCompositeText);
    }

    public static void removeLexemes(CompositeText compositeText, int length, char symbol){
        CompositeText newCompositeText=new CompositeText(compositeText);
        Component text=newCompositeText.getComponents().get(0);
        for (Component pharagraph : text.getComponents()) {
            for (int i=0; i<pharagraph.getComponents().size();i++){
            //for (Component sentence : pharagraph.getComponents()) {
                Component sentence=pharagraph.getComponents().get(i);
                //for (Component lexeme : sentence.getComponents()) {
                for (int j=0; j<sentence.getComponents().size();j++){
                    Component lexeme=sentence.getComponents().get(j);
                    if (lexeme.toString().charAt(0)==symbol && lexeme.toString().trim().length()==length){
                        ((CompositeText)sentence).removeTextElement(lexeme);
                        j--;
                    }
                }
            }
        }
        System.out.println(newCompositeText);
    }
}
