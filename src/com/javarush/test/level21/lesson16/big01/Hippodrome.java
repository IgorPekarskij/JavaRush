import java.util.ArrayList;


public class Hippodrome {
    private String name;

    private ArrayList<Horse> horses;
    public static Hippodrome game;

    public Hippodrome() {

        horses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public ArrayList<Horse> getHorses() {
        return horses;
    }
    public Horse getWinner(){
        int horseNumber = 0;
        double maxDidtance = getHorses().get(horseNumber).getDistance();

        for(int i = 1; i <getHorses().size(); i++){
            double currentDistance = getHorses().get(i).getDistance();
            if(maxDidtance < currentDistance){
                maxDidtance = currentDistance;
                horseNumber = i;
            }

        }
        return getHorses().get(horseNumber);
    }
    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());

    }

    public void move(){
        for (Horse item: getHorses()){
            item.move();
        }
    }
    public void print(){
        for (Horse item: getHorses()){
            item.print();
            System.out.println();
            System.out.println();
        }
    }
    public void run(){
        for(int i = 1; i <= 100; i++){
            move();
            print();
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){}

        }
    }
    public static void main(String[] args) {
        game = new Hippodrome();
        Horse red = new Horse("Red",3.0, 0.0);
        Horse merin = new Horse("Merin",3.0, 0.0);
        Horse poni = new Horse("Poni",3.0, 0.0);
        game.getHorses().add(red);
        game.getHorses().add(merin);
        game.getHorses().add(poni);
        game.run();
        game.printWinner();
    }
}
