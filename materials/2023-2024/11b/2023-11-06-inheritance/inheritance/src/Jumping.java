public interface Jumping {
    default void jump() throws NotImplementedException {
        //System.out.println("???");
        throw new NotImplementedException();
    };
}
