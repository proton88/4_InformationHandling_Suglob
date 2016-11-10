package com.suglob.information_handling.calculation;


import java.util.*;

public class PolishNotation {
    public static final Map<String, Integer> MAIN_MATH_OPERATIONS;
    public static final String LEFTBRACKET="(";
    public static final String RIGHTBRACKET=")";

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
        if (expression == null || expression.length() == 0)
            throw new IllegalStateException("Expression isn't specified.");
        if (MAIN_MATH_OPERATIONS == null || MAIN_MATH_OPERATIONS.isEmpty())
            throw new IllegalStateException("Operations aren't specified.");
        // Выходная строка, разбитая на "символы" - операции и операнды..
        List<String> out = new ArrayList<String>();
        // Стек операций.
        Stack<String> stack = new Stack<String>();

        // Удаление пробелов из выражения.
        expression = expression.replace(" ", "");

        // Множество "символов", не являющихся операндами (операции и скобки).
        Set<String> operationSymbols = new HashSet<String>(MAIN_MATH_OPERATIONS.keySet());
        operationSymbols.add(LEFTBRACKET);
        operationSymbols.add(RIGHTBRACKET);

        // Индекс, на котором закончился разбор строки на прошлой итерации.
        int index = 0;
        int isIncrement = 0;
        int isDecrement = 0;
        // Признак необходимости поиска следующего элемента.
        boolean findNext = true;
        while (findNext) {
            int nextOperationIndex = expression.length();
            String nextOperation = "";
            // Поиск следующего оператора или скобки.
            for (String operation : operationSymbols) {
                int i = expression.indexOf(operation, index);
                if (i >= 0 && i < nextOperationIndex) {
                    nextOperation = operation;
                    nextOperationIndex = i;
                }
            }
            // Оператор не найден.
            if (nextOperationIndex == expression.length()) {
                findNext = false;
            } else {
                // Если оператору или скобке предшествует операнд, добавляем его в выходную строку.
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


                    //out.add(expression.substring(index, nextOperationIndex));
                }
                // Обработка операторов и скобок.
                // Открывающая скобка.
                if (nextOperation.equals(LEFTBRACKET)) {
                    stack.push(nextOperation);
                }
                // Закрывающая скобка.
                else if (nextOperation.equals(RIGHTBRACKET)) {
                    while (!stack.peek().equals(LEFTBRACKET)) {
                        out.add(stack.pop());
                        if (stack.empty()) {
                            throw new IllegalArgumentException("Unmatched brackets");
                        }
                    }
                    stack.pop();
                }
                // Операция.
                else {
                    isIncrement=0;
                    isDecrement=0;
                    if (nextOperation.equals("++")){
                        isIncrement=1;
                    }
                    if (nextOperation.equals("--")){
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
        // Добавление в выходную строку операндов после последнего операнда.
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
        // Пробразование выходного списка к выходной строке.
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        StringBuffer result = new StringBuffer();
        if (!out.isEmpty())
            result.append(out.remove(0));
        while (!out.isEmpty())
            result.append(" ").append(out.remove(0));

        return result.toString();
    }
}
