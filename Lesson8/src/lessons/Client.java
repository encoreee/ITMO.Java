package lessons;

public class Client extends Human {

    String bankName;

    public Client(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public void print() {
        System.out.println("Realisation of printing Client");
    }
}

