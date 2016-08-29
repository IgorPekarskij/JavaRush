package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        String sourceFile = args[0];
        String destinationFile = args[1];
        BufferedReader readFromSourceFile = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
        BufferedWriter writeToDestFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFile)));
        ArrayList<String> wordsToBeWrite = new ArrayList<>();
        do {
            String temp = readFromSourceFile.readLine();
            if (temp == null)
                break;
            String [] splittedString = temp.split(" ");
            for(String oneWord: splittedString){
                if(oneWord.length() > 6){
                    wordsToBeWrite.add(oneWord);
                }
            }
        }while (true);
        for(int i = 0; i < wordsToBeWrite.size(); i++){
            if(i == wordsToBeWrite.size()-1){
                writeToDestFile.write(wordsToBeWrite.get(i));
            }else{
                writeToDestFile.write(wordsToBeWrite.get(i) + ",");
            }
        }
        readFromSourceFile.close();
        writeToDestFile.close();
    }
}
