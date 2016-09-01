import java.io.*;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/

public class Solution implements Externalizable{


    public static String greeting = "Hello world";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(greeting);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        greeting = (String) in.readObject();
    }

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console by character.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        transient private int i = 8;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int ii) {
            this.i = ii;
        }

        public OutputToConsole() {
        }

        /**
         * Outputs to the console a static field of Solution class [greeting].
         * Has to use [charAt] method of String class
         */
        public void outputToConsole(int ii) {
            for (int i = 0; i < greeting.length(); i++) {
                System.out.print(greeting.charAt(i));
            }
        }
    }
  }
