package designPatterns.singleton;

public class Car {

    public static final Car c;

    static {
        c = new Car();
    }
    private Car(){

    }
    public static Car getInstance(){
        return c;
    }

}
