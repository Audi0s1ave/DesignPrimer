package designPatterns.factory;

public class Test {
    public static Car testFactory(String type){
        Car c;
        if(type.equals("Honda")){
            c = new Honda();
        }
        else{
            c = new Suzuki();
        }
        return c;
    }
}
