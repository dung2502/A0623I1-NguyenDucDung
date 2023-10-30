package abstract_class_and_interdface.Animal_Interface;

public abstract class Animal {
    public abstract String makeSound();
}
class Tiger extends Animal{

    @Override
    public String makeSound() {
        return "Gao---Gao---";
    }
}
class Chicken extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "cuctac-------cuctac";
    }

    @Override
    public String howtoEat() {
        return "Enter";
    }
}
class Orange extends Fruit{
    @Override
    public String howtoEat() {
        return "bite a lot of";
    }
}

class Apple extends Fruit{
    @Override
    public String howtoEat() {
        return "Bite a lot of to";
    }
}