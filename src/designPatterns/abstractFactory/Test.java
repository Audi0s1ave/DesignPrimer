package designPatterns.abstractFactory;

public class Test {
    public static void main(String[] args) {
        int tyre = 2;
        Vehicle vehicle = Vehicle.getInstance(tyre);
        vehicle = vehicle.getVariant("RE");
        System.out.println(vehicle.getClass());
    }
}
