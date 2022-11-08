public class Main {
    public static void main (String[]args){
//        FootballPlayer p = new FootballPlayer("Ivan", 25, "BG", 100, 10, 1, "goalkeeper");
//        System.out.println(p);

        TennisTeam t = new TennisTeam();
        try {
            t.addPlayer(new TennisPLayer());
            t.addPlayer(new TennisPLayer());
        } catch (IllegalArgumentException ex) {
            System.out.println("Cannot add player");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Generic exception");
            ex.printStackTrace();
            throw ex;
        }
    }
}
