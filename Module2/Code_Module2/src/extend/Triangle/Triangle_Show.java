package extend.Triangle;
import java.util.Scanner;
class Shape{
    private String color;

    public Shape() {
        this.color = "blue";
    }
    public Shape(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return"A Shape with color of " + this.color ;
    }
}
class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1 =1.0;
        this.side3 =1.0;
        this.side2 =1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "Color=" + super.getColor() +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() +
                '}';
    }
}

public class Triangle_Show {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Triangle b = new Triangle("blue", 3,4,5);
        Triangle a = new Triangle();
        System.out.println("Enter color:");
        String color = sc.nextLine();
        a.setColor(color);
        System.out.println("Total 2 side greater the other side!!");
        System.out.println("Enter side 1:");
        double side1 = sc.nextDouble();
        a.setSide1(side1);
        System.out.println("Enter side 2:");
        double side2 = sc.nextDouble();
        a.setSide2(side2);
        System.out.println("Enter side 3:");
        double side3 = sc.nextDouble();
        a.setSide3(side3);
        System.out.println(a);
        System.out.println(b);
    }
}
