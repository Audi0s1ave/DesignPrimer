package designPatterns.abstractFactory;

public class Car extends Vehicle{
    @Override
    public Vehicle getVariant(String company){
        if(company.equals("Honda")){
            return new Honda();
        }
        return null;
    }

}
