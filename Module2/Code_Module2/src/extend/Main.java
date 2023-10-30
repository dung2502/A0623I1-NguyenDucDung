package extend;

 class test extends father_Test {
     protected void method(){}
     void method1(){}
     public void me(){}
     public void speak(){
        System.out.println("speak");
        super.speak();
    }
    public void train(){
        this.speak();
    }
}
 class father_Test{
     public void me(){}
    public  void speak(){
        System.out.println("speak son");
    }
     public father_Test() {
         System.out.println("Here");
     }
 }
 class test2 extends father_Test{}
 public class Main{
     public static void main(String[] args) {
         father_Test b = new test2();
         father_Test[] c = new father_Test[5];
        test a = new test();
        a.speak();
        a.train();
     }
 }
