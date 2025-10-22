public class MyChild extends MyParent implements IExample {
    @Override
    public void foo() {
        System.out.println("MyChild::foo called");
    }

    @Override
    public void bar() {
        System.out.println("MyChild::bar called");
    }


}
