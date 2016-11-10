package com.suglob.information_handling.parse;

import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.Lexeme;
import com.suglob.information_handling.entity.TypeText;


public class ParseText implements ParseInterface{
    public static final String PARAGRAPH_DELIMITER="\\r\\n";
    @Override
    public CompositeText parse(String string) {
        ParseParagraph parseParagraph=new ParseParagraph();
        CompositeText text=new CompositeText(TypeText.TEXT);
        String[] pharagraphs= string.split(PARAGRAPH_DELIMITER);
        for (String pharagraph:pharagraphs){
            text.addTextElement(parseParagraph.parse(pharagraph.trim()));
        }
        return text;
    }
}
