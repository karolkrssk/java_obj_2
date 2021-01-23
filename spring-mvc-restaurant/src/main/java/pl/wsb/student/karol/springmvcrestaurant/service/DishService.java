package pl.wsb.student.karol.springmvcrestaurant.service;

import org.springframework.stereotype.Service;
import pl.wsb.student.karol.springmvcrestaurant.model.Dish;
import pl.wsb.student.karol.springmvcrestaurant.repository.DishRepository;

import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Iterable<Dish> listAll() {
        return dishRepository.findAll();
    }

    public Iterable<Dish> listFood() {
        return dishRepository.listOnlyFood();
    }

    public Iterable<Dish> listDrink() {
        return dishRepository.listOnlyDrink();
    }

    public Iterable<Dish> listPriceBiggerThan() {
        return dishRepository.listPriceBiggerThan10();
    }

    public void save(Dish dish) {
        if (dish.getModified() == null) {
            dish.setModified(new Date());
        }   //if
        dishRepository.save(dish);
    }

    public Dish find(Integer id) {
        return dishRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        dishRepository.deleteById(id);
    }
}