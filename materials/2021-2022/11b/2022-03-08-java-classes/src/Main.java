public class Main {
    public static void main(String[] args) {
        String str1 = "str1";
        String str2 = "str1";
        str2 = "str2";
        String str3 = str1 + str2 + "str1";
        str2 = str2.replace('2', '3');

        System.out.println(str2);
        System.out.println(str3);

        String str4 = new String("str4");
        StringBuilder str5 = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            str5.append(i);
            str5.append(" ");
        }
        System.out.println(str5);
        String str6 = str5.toString();
        System.out.println(str6);

        int a = 5;
        Integer b = 7;
        int c = Integer.getInteger("56");




    }
}
