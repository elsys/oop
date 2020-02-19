import org.elsys.mbenov.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("HELLO");

        Iliana iliana = new Iliana();
        System.out.println(iliana.name + iliana.getAge());

        Iliana iliana2 = new Iliana("Elizara", 23);
        System.out.println(iliana2.name + iliana2.getAge());

        System.out.println(Iliana.gender);
        System.out.println(Iliana.getCount());
    }
}
