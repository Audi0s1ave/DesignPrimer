package designPatterns.abstractFactory;

public abstract class Vehicle {
    private static int tyres = 2;

    public static Vehicle getInstance(Integer tyre){
        if(tyre > tyres) {
            return new Car() ;
        }
        return new Bike();
    }

    public abstract Vehicle getVariant(String company);

}
