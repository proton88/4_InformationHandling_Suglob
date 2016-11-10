package com.suglob.information_handling.parse;


import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.TypeText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseParagraph implements ParseInterface {
    public static final String SENTENCE_DELIMITER="([^.!?\\u2026]+[.!?\\u2026])";
    @Override
    public CompositeText parse(String string) {
        ParseSentence parseSentence=new ParseSentence();
        CompositeText pharagraph=new CompositeText(TypeText.PHARAGRAPH);
        Pattern pattern =Pattern.compile(SENTENCE_DELIMITER);
        Matcher matcher =pattern.matcher(string);
        while (matcher.find()){
            pharagraph.addTextElement(parseSentence.parse(matcher.group().trim()));
        }
        return pharagraph;
    }
}
