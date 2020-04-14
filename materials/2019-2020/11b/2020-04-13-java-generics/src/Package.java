public class Package {
    private Payload p;

    public Package() { }
    public Package(Payload p) {
        this.p = p;
    }

    public String serialize() {
        return p.serialize();
    }

    public <T> void deserialize(String data, Builder<? extends T> builder) { // "15.15"
        //Payload<T> pp = new Payload<T>(new T(data));
        //Payload<T> pp = new Payload<T>(T.<T>fromString(data));
        //this.p = ???;
        this.p = new Payload<T>(builder.build(data));
    }
}
