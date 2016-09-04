public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void move(){

        setSpeed(getSpeed() * Math.random());
        setDistance(getDistance() + getSpeed());
    }
    public void print(){
        long points = Math.round(getDistance());
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < points; i++){
            sb.append('.');
        }
        sb.append(getName());
        System.out.println(sb.toString());
    }
}
