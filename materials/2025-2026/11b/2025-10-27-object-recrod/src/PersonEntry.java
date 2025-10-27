public record PersonEntry(String name, int idNumber) {
    public PersonEntry /*(String name, int idNumber) */ {
        if(name == null || name.length() == 0)
            throw new IllegalArgumentException("Invalid name");
        if(idNumber <= 0)
            throw new IllegalArgumentException("Invalid number");

//        this.name = name;
//        this.idNumber = idNumber;
    }

    public PersonEntry(String name) {
        this(name, 1);
    }
    public PersonEntry(int idNumber) {
        this("test", idNumber);
    }
}
