package designPatterns.abstractFactory;

public class Bike extends Vehicle{

    @Override
    public Vehicle getVariant(String company) {
        if(company.equals("RE")){
            return new RoyalEnfield();
        }
        return null;
    }
}
