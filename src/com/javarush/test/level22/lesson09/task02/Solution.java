import java.util.*;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

   public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params == null || params.size() == 0)
            return sb;
        for(Map.Entry<String, String > pair : params.entrySet()){
            if(pair.getKey() != null && pair.getValue() != null){
                sb.append(pair.getKey() + " = " ).append("'" + pair.getValue()+"'");
                sb.append(" and ");
            }
        }
        sb.delete(sb.length()-5, sb.length());
        return sb;
    }

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put(null, "Kiev");
        map.put("age", null);
        String result = getCondition(map).toString();

        System.out.println(result);
    }
}
