package lessons;

public class Employeer extends Human {

    String bankName;

    public Employeer(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public void print() {
        System.out.println("Realisation of printing Employeer");
    }
}
