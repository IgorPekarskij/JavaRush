import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File myFile = new File("/home/igor/java/JavaRushHomeWork/file.txt");
        try{
        
        oos = new ObjectOutputStream(new FileOutputStream(myFile));
        Solution savedObject = new Solution(25);
        System.out.println("Object before saving : " +  savedObject);
        oos.writeObject(savedObject);
        }catch(IOException e){}
        finally{
            try{
                if(oos != null){
                    oos.flush();
                    oos.close();
                }
            }catch (IOException ignore){/*NOP*/}
        }
        try{
        ois = new ObjectInputStream(new FileInputStream(myFile));
        Solution loadedObject = (Solution) ois.readObject();
        System.out.println("Object after loading : " + loadedObject);
        }catch (IOException e){}
        catch(ClassNotFoundException e){}
        finally{
            try{
                if (ois != null)
                    ois.close();    
            }catch(IOException ignore){/*NOP*/}
        }
       
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;
   
    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
    
    @Override
    public String toString() {
        return this.string;
    }
}