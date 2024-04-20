package designPatterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Car> c = new ArrayList<>();
        c.add(new Honda());
        c.add(new SuzukiAdapter(new Suzuki())); // adapter design pattern to plug the incompatible Suzuki typ
    }
}
