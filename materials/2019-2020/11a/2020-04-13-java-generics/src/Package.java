public class Package {
    private Payload p;

    public Package() { }
    public Package(Payload p) {
        this.p = p;
    }

    public String serialize() {
        return p.serialize();
    }

    public <T> void deserialize(String data, Helper<T> helper) {
        this.p = new Payload<T>(helper.help(data));
    }
}
