/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null) throw new TooShortStringException();
        int start = string.indexOf("\t");
        int end = 0;
        for(int i = start+1; i < string.length(); i++){
            if(string.charAt(i) == '\t') {
                end = i;
                break;
            }
        }
        
        if (end == 0)
            throw new TooShortStringException();
            
        String result = string.substring(start+1,end);
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
