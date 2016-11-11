package com.suglob.information_handling.parse;

import com.suglob.information_handling.calculation.ConvertPolishNotation;
import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.Lexeme;
import com.suglob.information_handling.entity.TypeText;
import com.suglob.information_handling.interpreter.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSentence implements ParseInterface {
    public static final String LEXEME_DELIMITER="\\s";
    public static final String MATH_EXPRESSION="[\\d(+-]+";
    @Override
    public CompositeText parse(String string) {
        Client interpreter=null;
        CompositeText sentence=new CompositeText(TypeText.SENTENCE);
        String[] lexemes=string.split(LEXEME_DELIMITER);
        Pattern pattern =Pattern.compile(MATH_EXPRESSION);

        for (String lexeme:lexemes){
            Matcher matcher =pattern.matcher(lexeme);
            if (matcher.lookingAt()){
                lexeme= ConvertPolishNotation.sortingStation(lexeme);
                interpreter=new Client(lexeme);
                lexeme= String.valueOf(interpreter.calculate());
            }

            sentence.addTextElement(new Lexeme(lexeme));
        }
        return sentence;
    }
}
