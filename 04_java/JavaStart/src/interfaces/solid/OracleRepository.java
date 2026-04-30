package interfaces.solid;

public class OracleRepository implements UserRepository {

    @Override
    public void save(String data) {
        System.out.println("Oracle Save Successful: "+data);
    }
}
