package abstract_class_and_interdface.interface_Colorable;

public class Main_test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(4.7);
        shapes[1] = new Rectangle(3.5, 7);
        shapes[2] = new Circle();
        for (Shape item: shapes){
            System.out.println(item);
            if(item instanceof Colorable){
                ((Colorable) item).howToColor();
            }
        }
    }
}
