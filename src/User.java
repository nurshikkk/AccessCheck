public class User {
    private final String login;
    private final String password;
    private String email;
    private final int age;

    public User(String login, String password, String email, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getUserLogin() {
        return login;
    }

    public String getUserPassword() {
        return password;
    }

    public int getUserAge() {
        return age;
    }
}