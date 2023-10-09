package Abstract_Class_and_Interdface.interface_Resizeable;

public class Test_Resizeable {
    public static void main(String[] args) {
        Shape[] shapeArr = new Shape[3];
        shapeArr[0] = new Circle(3.6);
        shapeArr[1] = new Rectangle(7, 5);
        shapeArr[2] = new Circle();

        System.out.println("Before resize: ");
        for (Shape item : shapeArr) {
            System.out.println(item);
        }
        for (Shape item : shapeArr) {
            item.resize((Math.random() * 100 - 1) / 100);
        }
        System.out.println("\n" + "After resize");
        for (Shape item : shapeArr) {
            System.out.println(item);
        }
    }
}
