import java.util.*;
import java.util.List;
import java.io.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

   public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = readFile.readLine()) != null){
            sb.append(line + " ");
        }
        line = sb.toString();
        String [] splitedFile = line.split(" ");
        reader.close();
        readFile.close();
        ArrayList<String> temp = new ArrayList<>();
        for (String item: splitedFile){
            temp.add(item);
        }
        for (int i = 0; i < temp.size(); i++){
            String current = temp.get(i);
            StringBuilder currentBiulder  = new StringBuilder(current);
            for(int j = i+1; j < temp.size(); j++) {
                String search = temp.get(j);
                if (search.equals(currentBiulder.reverse().toString())) {
                    Pair newPAir = new Pair();
                    newPAir.first = current;
                    newPAir.second = search;
                        result.add(newPAir);
                    temp.remove(i);
                    temp.remove(j-1);
                    break;
                }

            }
        }
        for (Pair item: result){
            System.out.println(item);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
