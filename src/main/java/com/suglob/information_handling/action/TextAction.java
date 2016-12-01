package com.suglob.information_handling.action;


import com.suglob.information_handling.entity.Component;
import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.Lexeme;
import org.apache.log4j.Logger;

public class TextAction {
    static Logger logger = Logger.getLogger(TextAction.class);

    public static CompositeText removeNextEqualsFirst(CompositeText compositeText){
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
        logger.info("To delete all subsequent occurrences of the first token letter fulfilled.");
        return newCompositeText;
    }

    public static CompositeText changeLexemesFirstLast(CompositeText compositeText){
        CompositeText newCompositeText=new CompositeText(compositeText);
        Component text=newCompositeText.getComponents().get(0);
        for (Component pharagraph : text.getComponents()) {
            for (Component sentence : pharagraph.getComponents()) {
                Component firstLexeme=sentence.getComponents().get(0);
                int lastIndex=sentence.getComponents().size();
                Component lastLexeme=sentence.getComponents().get(lastIndex-1);
                sentence.getComponents().remove(0);
                sentence.getComponents().add(0,lastLexeme);
                sentence.getComponents().remove(lastIndex-1);
                sentence.getComponents().add(firstLexeme);
            }
        }
        logger.info("Change first and last lexemes in sentences was executed");
        return newCompositeText;
    }

    public static CompositeText removeLexemes(CompositeText compositeText, int length, char symbol){
        CompositeText newCompositeText=new CompositeText(compositeText);
        Component text=newCompositeText.getComponents().get(0);
        for (Component pharagraph : text.getComponents()) {
            for (int i=0; i<pharagraph.getComponents().size();i++){
                Component sentence=pharagraph.getComponents().get(i);
                for (int j=0; j<sentence.getComponents().size();j++){
                    Component lexeme=sentence.getComponents().get(j);
                    if (lexeme.toString().charAt(0)==symbol && lexeme.toString().trim().length()==length){
                        if (sentence instanceof CompositeText) {
                            ((CompositeText) sentence).removeTextElement(lexeme);
                        }
                        j--;
                    }
                }
            }
        }
        logger.info("Remove all lexemes by symbol: "+symbol+ " and length: "+length+ " was executed");
        return newCompositeText;
    }
}
