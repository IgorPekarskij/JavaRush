import java.util.LinkedHashMap;
import java.util.Map;


/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone =  solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public User clone() throws CloneNotSupportedException{
            User newUser = (User) super.clone();
            return newUser;
        }
    }
    public Solution clone() throws CloneNotSupportedException{
        Solution newSolution = new Solution();
        Map<String, User> users = new LinkedHashMap();
        for (Map.Entry<String, User> entry: this.users.entrySet()){
            User newUser = entry.getValue().clone();
             newSolution.users.put(newUser.name, newUser);
        }
        return newSolution;
    }

}
