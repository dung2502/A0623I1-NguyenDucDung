package extend.Circlefamily;


class Circle{
    private double radius;
    private String color;

    public Circle() {
        color = "blue";
        radius = 2.0;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }
    public  double getPerimeter(){
        return  2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}

class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double volume(){
        return Math.PI*Math.pow(getRadius(),2)*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height= " + height + "radius= "+ getRadius() + "color= "+ getColor()+
                '}';
    }
}

public class Circle_family {
    public static void main(String[] args) {
        Circle a = new Circle();
        Cylinder b = new Cylinder(4);
        Circle c = new Cylinder(1);
        Circle d = new Circle(4.0, "red");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
}

