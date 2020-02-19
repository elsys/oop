import org.elsys.mbenov.Rapper;

public class Main {
    public static void main(String[] args) {
        Rapper drake = new Rapper();
        System.out.println(drake.name + drake.getEarnings());

        Rapper drake2 = new Rapper("Drake", 1000);
        System.out.println(drake2.name + drake2.getEarnings());

        System.out.println(Rapper.getCount());
    }
}
