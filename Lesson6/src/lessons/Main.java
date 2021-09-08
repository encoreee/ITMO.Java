package lessons;

class Study {

    private String course;

    public Study(String course) {
        this.course = course;
    }

    public String printCourse() {
        return this.course;
    }
}

class House {

    private int floors;
    private int buildYear;
    private String name;

    public void setHouse(int floors, int buildYear, String name) {
        this.floors = floors;
        this.buildYear = buildYear;
        this.name = name;
    }

    public int getFloors() {
        return floors;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public String getName() {
        return name;
    }
}

class Tree {
    public Tree(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Tree() {
        System.out.println("Пустой конструктор без параметров сработал");
    }

    private int age;
    private boolean alive;
    private String name;

    public Tree(int age, boolean alive, String name) {
        this.age = age;
        this.alive = alive;
        this.name = name;
    }
}

class AirPlane {

    private Wing right;

    public Wing getRight() {
        return right;
    }

    public Wing getLeft() {
        return left;
    }

    private Wing left;

    public void setWeight(double right, double left) {
        this.right.setWeight(right);
        this.left.setWeight(left);
    }



    class Wing {
        private double weight;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Study study = new Study("Изучение Java - это просто!");
        System.out.println("Изучение Java - это просто!");

        House h1 = new House();
        House h2 = new House();
        h1.setHouse(4, 2000, "h1");
        h2.setHouse(2, 2001, "h2");
        System.out.println(h1.getBuildYear() + " " + h1.getFloors() + " " + h1.getName());
        System.out.println(h2.getBuildYear() + " " + h2.getFloors() + " " + h2.getName());

        Tree t1 = new Tree(100, true, "Сосна");
        Tree t2 = new Tree(20, "Дуб");
        Tree t3 = new Tree();

        AirPlane a1 = new AirPlane();
        AirPlane a2 = new AirPlane();

        a1.setWeight(10.2,10.1);
        a2.setWeight(11.4,11.2);

        System.out.println("a1 wing weight " + a1.getLeft().getWeight() + " " + a1.getRight().getWeight());
        System.out.println("a2 wing weight " + a2.getLeft().getWeight() + " " + a2.getRight().getWeight());

    }
}
