public enum Gender {
    MALE,
    FEMALE;

    @Override
    public String toString(){
        switch (this){
            case MALE: return "male";
            case FEMALE: return "female";
            default: return "unknown";
        }
    }
}