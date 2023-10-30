package inheritance;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        circle.setFilled("black");
        System.out.println("A circle : " + circle.toString());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());
        System.out.println();
        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println("A rectangle : " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());
        System.out.println();
    }
}


class Geometric{
    private String color = "white";
    private String filled = null;

    public Geometric() {
    }

    public Geometric(String color, String filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public String getFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(String filled) {
        this.filled = filled;
    }
    public String toString() {
        return "created with \"" + color + "\" color and " +
                (filled == null ? "no fill" : "filled with \"" + filled + "\" color");
    }
}
class Circle extends Geometric{
    private double radius;
    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;

    }

    public Circle(String color, String filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*this.radius*this.radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*this.radius;
    }
    public double getDiameter(){
        return 2*this.radius;
    }
    public void printCircle(){

    }
}
class Rectangle extends Geometric{
    private double width;
    private double heigth;

    public Rectangle(){

    }
    public Rectangle(double width, double heigth){
        this.width =width;
        this.heigth =heigth;
    }

    public Rectangle(String color, String filled, double width, double heigth) {
        super(color, filled);
        this.width = width;
        this.heigth = heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }
    public double getArea(){
        return this.width*this.heigth;
    }
    public double getPerimeter(){
        return 2*(this.heigth + this.width);
    }
}