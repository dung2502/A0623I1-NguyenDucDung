package class_in_java;

public class Test_Circle {
    public static void main(String[] args) {
        Simple_Circle c1 = new Simple_Circle();
        Simple_Circle c2 = new Simple_Circle(25);
        Simple_Circle c3 = new Simple_Circle(125);

        System.out.println("Area 1: " + c1.getArea());
        System.out.println("Area 1: " + c2.getArea());
        System.out.println("Area 1: " + c3.getArea());

        System.out.println("Parameter 1: " + c1.getPerimeter());
        System.out.println("Parameter 1: " + c2.getPerimeter());
        System.out.println("Parameter 1: " + c3.getPerimeter());

        c2.setRadius(100);
        System.out.println("Chance radius 2 = 100 : " +  c2);
    }
}
 class Simple_Circle{
    double radius;
    Simple_Circle(){
        this.radius = 1;
    }
    Simple_Circle(double a){
        this.radius = a;
    }
    double getArea(){
        return radius * radius * Math.PI;
    }
    double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    void setRadius(double newRadius){
        radius = newRadius;
    }


 }
