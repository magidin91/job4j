package ru.job4j.other.lyambda;

/**
 * Использование лямбда, как параметр метода
 */
interface StringFunc {
    String func(String n);
}

class LambdasAsArgumentsDemo {

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;
        System.out.println("Этo исходная строка:" + inStr);

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Этo строка прописными буквами:"
                + outStr);

        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for (i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            return result;
        }, inStr);
        System.out.println("Этo строка с удаленными пробелами:" + outStr);
    }
}