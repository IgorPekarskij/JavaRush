import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException{

        Object read = objectStream.readObject();
        if(read instanceof B){
            return (B) read;
        }else if(read instanceof A){
            return (A) read;
        }

        return null;
    }

    public class A implements Serializable {
        private static final long serialVersionUID = 3L;
    }

    public class B extends A {
        private static final long serialVersionUID = 4L;
        public B() {
            System.out.println("inside B");
        }
    }
}
