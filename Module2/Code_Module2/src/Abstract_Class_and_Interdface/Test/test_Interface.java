package Abstract_Class_and_Interdface.Test;

import Abstract_Class_and_Interdface.Test.Fly;

public abstract class test_Interface {
    private String name;

    public void Geometric(String Name){
    }
    public String getName(){
        return name;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class bird implements Fly {

    @Override
    public String fly() {
        return "null";
    }

    @Override
    public String method_Fly() {
        return "coco";
    }
}