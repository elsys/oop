public enum Gender {
    MALE,
    FEMALE;

    @Override
    public String toString(){
        switch (this){
            case FEMALE: return "female";
            case MALE: return "male";
            default: return "unknown";
        }
    }
}
