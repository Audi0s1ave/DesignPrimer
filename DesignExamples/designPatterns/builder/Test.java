package designPatterns.builder;
public class Test {
    public static void main(String[] args) {
        Car c = new Car.Builder()
                .isBraked(Boolean.FALSE)
                .speed(34)
                .steer("L")
                .music("Numb")
                .build();
    }
}
