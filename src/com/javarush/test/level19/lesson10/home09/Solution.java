package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original = System.out;
        String advertisement = "JavaRush - курсы Java онлайн";

        ByteArrayOutputStream incomingData = new ByteArrayOutputStream();
        PrintStream swappedPrintStream = new PrintStream(incomingData);
        System.setOut(swappedPrintStream);

        testString.printSomething();

        String incomingString = incomingData.toString();
        String[] splitedIncomingString = incomingString.split("\\n");
        System.setOut(original);

        int count = 0;
        for (int i = 0; i < splitedIncomingString.length; i++){
            if (count == 2){
                System.out.println(advertisement);
                count =0;
            }
            System.out.println(splitedIncomingString[i]);
            count++;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
