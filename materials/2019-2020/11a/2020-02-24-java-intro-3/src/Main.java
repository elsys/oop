import org.elsys.mbenov.Rapper;

public class Main {
    public static void main(String[] args) {
        /*Rapper drake = new Rapper();
        System.out.println(drake.name + drake.getEarnings());

        Rapper drake2 = new Rapper("Drake", 1000);
        System.out.println(drake2.name + drake2.getEarnings());

        System.out.println(Rapper.getCount());
        */
        //Main.strings();
        Main.boxedTypes();
    }

    static void strings() {
        String str1 = "asdf";
        //String str2 = "qwer";
        String str2 = "asd" + "xcv" + 123 + true;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));

        System.out.println(str2.contains("d"));
        System.out.println(str2.indexOf('c'));
        System.out.println(str2.hashCode());
        System.out.println(str2.length());
    }

    static void boxedTypes() {
        int a = new Integer(15);
        System.out.println(a);
        System.out.println(((Integer)a).toString());
    }
}
