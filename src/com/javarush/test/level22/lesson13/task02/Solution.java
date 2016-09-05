
import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset windows = Charset.forName("Windows-1251");
        String sourceFile = args[0];
        String destFile = args[1];

        BufferedReader in = new BufferedReader(new FileReader(sourceFile));
        PrintWriter out = new PrintWriter(new FileWriter(destFile));

        ArrayList<String > source = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null){
            source.add(line);
        }
        ArrayList<String> decod = new ArrayList<>();

        for (String current: source){
            decod.add(new String(current.getBytes(windows)));
        }
        for(String item: decod){
            out.println(item);
        }
        in.close();
        out.close();
    }
}
