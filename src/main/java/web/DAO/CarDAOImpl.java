package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAOImpl implements CarDAO {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Toyota", "Aqua", 2015));
        cars.add(new Car("Toyota", "Fortuner", 2010));
        cars.add(new Car("Toyota", "Sequoia", 2020));
        cars.add(new Car("Toyota", "Crown", 2000));
        cars.add(new Car("Toyota", "Vitz", 2017));

    }

    @Override
    public List<Car> getCar(int amount) {
        return cars.stream()
                .limit(Math.max(0, amount)) // Убеждаемся, что amount не отрицательный
                .collect(Collectors.toList());
    }
}
