package lessons;

class Truck extends Car {

    int wheelsCount;
    int maxWeight;

    public void newWheels(int wheels) {
        wheelsCount = wheels;
        System.out.println("Количество колес - " + wheelsCount);
    }

    public Truck(int wheelsCount, int maxWeight, int w, String m, char c, float s) {
        super(w, m, c, s);
        this.wheelsCount = wheelsCount;
        this.maxWeight = maxWeight;
    }
}