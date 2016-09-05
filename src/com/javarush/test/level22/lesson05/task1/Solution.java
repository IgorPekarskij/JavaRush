/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) {
        String result = "";
        try {
            String[] splited = string.split(" ");
            if (splited.length < 5)
                throw new TooShortStringException();
            result = splited[1] + " " + splited[2] + " " + splited[3] + " " + splited[4];

        }catch (Exception e){
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException{
    }

    public static void main(String[] args) throws TooShortStringException{
        String check = "JavaRush - лучший сервис обучения Java.";
        System.out.println(Solution.getPartOfString(check));

    }
}
