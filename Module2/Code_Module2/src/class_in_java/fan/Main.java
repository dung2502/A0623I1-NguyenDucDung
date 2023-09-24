package class_in_java.fan;

public class Main {
    public static void main(String[] args) {
        Fan sony = new Fan();
        sony.setOn(true);
        sony.setSpeed(Fan.FAST);
        sony.setRadius(10);
        sony.setColor("yellow");

        Fan toyota = new Fan();
        toyota.setOn(true);
        toyota.setSpeed(Fan.MEDIUM);
        toyota.setRadius(5);
        toyota.setColor("blue");

        System.out.println("Information of sony Fan: " + sony);
        System.out.println("Information of toyota Fan: " + toyota);
    }
}
