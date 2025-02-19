public final class UserAuth {
    private String token;

    public String getToken() {
        return token;
    }

    public void authenticate() {
        token = "abc";
    }

    private UserAuth() {}

    private static UserAuth auth;

    public static UserAuth getAuth() {
        return auth;
    }

    public static void init() {
        auth = new UserAuth();
    }
}
