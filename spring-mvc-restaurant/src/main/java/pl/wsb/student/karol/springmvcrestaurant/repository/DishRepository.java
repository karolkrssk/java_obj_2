package pl.wsb.student.karol.springmvcrestaurant.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.wsb.student.karol.springmvcrestaurant.model.Dish;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query("Select e from Dish e WHERE e.price >=10")
    public Iterable<Dish> listPriceBiggerThan10();

    @Query("Select e from Dish e WHERE e.productType  = 'jedzenie'")
    public Iterable<Dish> listOnlyFood();

    @Query("Select e from Dish e WHERE e.productType  = 'napoj'")
    public Iterable<Dish> listOnlyDrink();
}
