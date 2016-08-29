package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        String file = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        do{
            String temp = reader.readLine();
            if(temp == null)
                break;
            PEOPLE.add(parseFileString(temp));
        }while (true);
        reader.close();
    }
    public static Person parseFileString(String line){
        String [] splitedLine = line.split(" ");
        String name = "";
        Calendar calendar = new GregorianCalendar(Integer.parseInt(splitedLine[splitedLine.length-1]), Integer.parseInt(splitedLine[splitedLine.length-2])-1,
                Integer.parseInt(splitedLine[splitedLine.length-3]));

        for (int i =0; i < splitedLine.length-3; i++){
            name += splitedLine[i] + " ";
        }
        return new Person(name.trim(), calendar.getTime());
    }
}
