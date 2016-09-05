
import java.util.ArrayList;
import java.util.StringTokenizer;
/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
            StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
            ArrayList<String> tokens = new ArrayList<>();
            while (tokenizer.hasMoreElements()) {
                tokens.add(tokenizer.nextToken());
            }
            String [] result = null;
            result = tokens.toArray(new String[tokens.size()]);
            return result;
        }
}
