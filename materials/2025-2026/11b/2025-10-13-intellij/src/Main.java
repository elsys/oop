import java.util.Objects;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int var1;
    private String var2;

    public Main(int var1, String var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    @Override
    public String toString() {
        return "Main{" +
                "var1=" + var1 +
                ", var2='" + var2 + '\'' +
                '}';
    }

    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return var1 == main.var1 && Objects.equals(var2, main.var2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(var1, var2);
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        List<Integer> l1;
        Map<String, String> m1;
        Queue<Integer> q1;
    }
}