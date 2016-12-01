package com.suglob.information_handling.calculation;

import org.apache.log4j.Logger;

import java.util.*;

public class ConvertPolishNotation {
    static final Logger logger = Logger.getLogger(ConvertPolishNotation.class);

    public static final Map<String, Integer> MAIN_MATH_OPERATIONS;
    public static final String LEFTBRACKET="(";
    public static final String RIGHTBRACKET=")";
    public static final String INCREMENT="++";
    public static final String DECREMENT="--";
    public static final String RESULT_DELIMETER=" ";
    public static final String EMPTY="";

    static {
        MAIN_MATH_OPERATIONS = new HashMap<String, Integer>();
        MAIN_MATH_OPERATIONS.put("--", 1);
        MAIN_MATH_OPERATIONS.put("++", 1);
        MAIN_MATH_OPERATIONS.put("*", 2);
        MAIN_MATH_OPERATIONS.put("/", 2);
        MAIN_MATH_OPERATIONS.put("+", 3);
        MAIN_MATH_OPERATIONS.put("-", 3);
    }

    public static String sortingStation(String expression) {
        List<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        Set<String> operationSymbols = new HashSet<String>(MAIN_MATH_OPERATIONS.keySet());
        operationSymbols.add(LEFTBRACKET);
        operationSymbols.add(RIGHTBRACKET);

        int index = 0;
        int isIncrement = 0;
        int isDecrement = 0;

        boolean findNext = true;
        while (findNext) {
            int nextOperationIndex = expression.length();
            String nextOperation = EMPTY;

            for (String operation : operationSymbols) {
                int i = expression.indexOf(operation, index);
                if (i >= 0 && i < nextOperationIndex) {
                    nextOperation = operation;
                    nextOperationIndex = i;
                }
            }

            if (nextOperationIndex == expression.length()) {
                findNext = false;
            } else {

                if (index != nextOperationIndex) {
                    if (isIncrement==1) {
                        int buf = Integer.parseInt(expression.substring(index, nextOperationIndex));
                        buf++;
                        out.add(String.valueOf(buf));
                        isIncrement=0;
                    }else if (isDecrement==1) {
                        int buf = Integer.parseInt(expression.substring(index, nextOperationIndex));
                        buf--;
                        out.add(String.valueOf(buf));
                        isDecrement=0;
                    }else{
                        out.add(expression.substring(index, nextOperationIndex));
                    }
                }

                if (nextOperation.equals(LEFTBRACKET)) {
                    stack.push(nextOperation);
                }

                else if (nextOperation.equals(RIGHTBRACKET)) {
                    while (!stack.peek().equals(LEFTBRACKET)) {
                        out.add(stack.pop());
                    }
                    stack.pop();
                }

                else {
                    isIncrement=0;
                    isDecrement=0;
                    if (nextOperation.equals(INCREMENT)){
                        isIncrement=1;
                    }
                    if (nextOperation.equals(DECREMENT)){
                        isDecrement=1;
                    }
                    while (!stack.empty() && !stack.peek().equals(LEFTBRACKET) &&
                            (MAIN_MATH_OPERATIONS.get(nextOperation) >= MAIN_MATH_OPERATIONS.get(stack.peek()))) {
                        out.add(stack.pop());
                    }
                    stack.push(nextOperation);
                }
                index = nextOperationIndex + nextOperation.length();
            }
        }

        if (index != expression.length()) {
            if (isIncrement==1) {
                int buf = Integer.parseInt(expression.substring(index));
                buf++;
                out.add(String.valueOf(buf));
                isIncrement=0;
            }else if (isDecrement==1) {
                int buf = Integer.parseInt(expression.substring(index));
                buf--;
                out.add(String.valueOf(buf));
                isDecrement=0;
            }else{
                out.add(expression.substring(index));
            }
        }

        while (!stack.empty()) {
            out.add(stack.pop());
        }
        StringBuffer result = new StringBuffer();
        if (!out.isEmpty()) {
            result.append(out.remove(0));
        }
        while (!out.isEmpty()) {
            result.append(RESULT_DELIMETER).append(out.remove(0));
        }
        logger.info("Convert to polish notation was successful");
        return result.toString();
    }
}
