package interfaces.solid;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository=repository;
    }

    public void register(String name) {
        repository.save(name);
    }

    public static void main(String[] args) {
        new UserService(new OracleRepository());

    }
}