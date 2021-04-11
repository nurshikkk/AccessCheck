import java.util.Scanner;

public class Main {
    public static User[] getUsers() {
        User user1 = new User("admin", "12345", "admin@mail.ru", 23);
        User user2 = new User("user", "12345", "user@mail.ru", 20);
        User user3 = new User("user2", "12345", "user2@mail.ru", 15);
        return new User[] {user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equalsIgnoreCase(user.getUserLogin()) && password.equals(user.getUserPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getUserAge() < 18) {
            throw new AccessDeniedException("Ваш возраст меньше 18");
        }
    }

    public static void main(String[] args) throws AccessDeniedException, UserNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));

        System.out.println("Доступ предоставлен");
    }
}