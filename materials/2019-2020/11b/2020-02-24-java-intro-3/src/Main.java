import org.elsys.mbenov.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("HELLO");

        /*Iliana iliana = new Iliana();
        System.out.println(iliana.name + iliana.getAge());

        Iliana iliana2 = new Iliana("Elizara", 23);
        System.out.println(iliana2.name + iliana2.getAge());

        System.out.println(Iliana.gender);
        System.out.println(Iliana.getCount());*/

        //Main.strings();
        Main.boxedTypes();
    }

    static void strings() {
        String str1 = "123";
        //str1 = "asd" + "zxc " + 1234 + true;

        System.out.println(str1);
        System.out.println(str1.charAt(10));
        System.out.println(str1.compareTo("asdzxc"));
        System.out.println(str1 == "asdf");
        System.out.println(str1.contains("zxc"));
        System.out.println(str1.equals(str1));
        System.out.println(str1.equals(123));
        System.out.println(str1.equals(new Iliana()));
        System.out.println(str1.indexOf('z'));
       // str1.
    }

    static void boxedTypes() {
        //int a = new Integer(15);
        //int a = 15;
        int a = 15;
        //a.toString();
        ((Integer)a).toString();
        System.out.println("asdf " + a);
    }
}
