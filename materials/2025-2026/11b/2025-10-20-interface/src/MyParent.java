public abstract class MyParent implements Comparable {
    public int var1 = 10;

    public MyParent() {
        var1 = 15;
    }

    public abstract void foo();

    @Override
    public int compareTo(Object o) {
        if(o == null) return 1;
        if(!(o instanceof  MyParent)) return 1;
        if(o == this) return 0;

        MyParent oo = (MyParent) o;
        return var1 - oo.var1;
    }
}
