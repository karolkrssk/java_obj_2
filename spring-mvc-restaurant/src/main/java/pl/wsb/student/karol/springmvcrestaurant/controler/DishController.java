package pl.wsb.student.karol.springmvcrestaurant.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.student.karol.springmvcrestaurant.model.Dish;
import pl.wsb.student.karol.springmvcrestaurant.service.DishService;

@Controller
@RequestMapping("")
class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listDishes", dishService.listAll());

        return "dish/index";
    }

    @GetMapping("/drinks")
    public String drinks(Model model) {
        model.addAttribute("drinks", dishService.listDrink());
        return "dish/drinks";
    }

    @GetMapping("/main_dishes")
    public String main_dishes(Model model) {
        model.addAttribute("food", dishService.listFood());
        return "dish/main_dishes";
    }

    @GetMapping("/suggested")
    public String suggested(Model model) {
        model.addAttribute("expensiveDishes", dishService.listPriceBiggerThan());
        return "dish/suggested";
    }

    @RequestMapping("/new_food")
    public String createFood(Model model) {
        Dish dish = new Dish();
        model.addAttribute("dish", dish);
        return "/new_food";
    }


    @RequestMapping("/new_drink")
    public String createDrink(Model model) {
        Dish dish = new Dish();
        model.addAttribute("dish", dish);
        return "/new_drink";
    }


    @PostMapping("/save_drink")
    public String saveDrink(@ModelAttribute("dish") Dish dish) {
        dish.setProductType("napoj");
        dishService.save(dish);
        return "redirect:/";
    }

    @PostMapping("/save_food")
    public String saveFood(@ModelAttribute("dish") Dish dish) {
        dish.setProductType("jedzenie");
        dishService.save(dish);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("dish", dishService.find(id));
        return modelAndView;
    }


    @RequestMapping("/delete/{id}")
    public String deleteDish(@PathVariable(name = "id") int id) {
        try {
            dishService.delete(id);
            return "redirect:/";
        } catch (Throwable ex) {
            return "/error";
        }
    }

}