package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader readerFaileName = new BufferedReader(new InputStreamReader(System.in));
        String courceFile = readerFaileName.readLine();

        BufferedReader sourceReader = new BufferedReader(new InputStreamReader(new FileInputStream(courceFile)));

        do{
            String temp = sourceReader.readLine();
            if(temp == null)
                break;
            StringBuilder sb = new StringBuilder(temp);
            String result = sb.reverse().toString();
            System.out.println(result);
        }while (true);
        readerFaileName.close();
        sourceReader.close();
    }
}
