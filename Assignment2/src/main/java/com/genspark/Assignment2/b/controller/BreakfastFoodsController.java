package com.genspark.Assignment2.b.controller;

import com.genspark.Assignment2.b.entity.BreakfastFoods;
import com.genspark.Assignment2.b.requests.BreakfastFoodsRequest;
import com.genspark.Assignment2.b.services.BreakfastFoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/breakfast-foods")
@RestController
public class BreakfastFoodsController {

    @Autowired
    private BreakfastFoodsService service;

    @GetMapping("/")
    public List<BreakfastFoods> getAllBreakfastFoods() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public BreakfastFoods getBreakfastFoodById(@PathVariable(value = "id") int id) {
        return service.get(id);
    }

    @GetMapping("/name/{name}")
    public List<BreakfastFoods> getBreakfastFoodByName(@PathVariable(value = "name") String name) {
        return service.getByName(name);
    }

    @GetMapping("/calories/lt/{num-calories}")
    public List<BreakfastFoods> getBreakfastFoodsUnderCalories(@PathVariable(value = "num-calories") int numCalories) {
        return service.getBreakfastFoodsUnderCalories(numCalories);
    }

    @GetMapping("/calories/gt/{num-calories}")
    public List<BreakfastFoods> getBreakfastFoodsOverCalories(@PathVariable(value = "num-calories") int numCalories) {
        return service.getBreakfastFoodsOverCalories(numCalories);
    }

    @GetMapping("/protein/{grams-protein}")
    public List<BreakfastFoods> getBreakfastFoodsOverProteinPerServing(@PathVariable(value = "grams-protein") int gramsProtein) {
        return service.getBreakfastFoodOverProteinPerServing(gramsProtein);
    }

    @GetMapping("/carbs/lt/{grams-carbs}")
    public List<BreakfastFoods> getBreakfastFoodsUnderCarbsPerServing(@PathVariable(value = "grams-carbs") int gramsCarbs) {
        return service.getBreakfastFoodUnderCarbsPerServing(gramsCarbs);
    }

    @GetMapping("/carbs/gt/{grams-carbs}")
    public List<BreakfastFoods> getBreakfastFoodsOverCarbsPerServing(@PathVariable(value = "grams-carbs") int gramsCarbs) {
        return service.getBreakfastFoodOverCarbsPerServing(gramsCarbs);
    }

    @PutMapping("/edit-name/{id}")
    public String editBreakfastFoodsNameById(@RequestBody BreakfastFoodsRequest breakfastFoodsRequest, @PathVariable(value = "id") int id) {
        try {
            service.editName(breakfastFoodsRequest, id);
            return "Name of breakfast food with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Breakfast food with id: " + id + " was not found.";
        }
    }

    @PutMapping("/edit-serving-size/{id}")
    public String editBreakfastFoodsServingSizeById(@RequestBody BreakfastFoodsRequest breakfastFoodsRequest, @PathVariable(value = "id") int id) {
        try {
            service.editServingSize(breakfastFoodsRequest, id);
            return "Serving size of breakfast food with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Breakfast food with id: " + id + " was not found.";
        }
    }

    @PutMapping("/edit-calories/{id}")
    public String editBreakfastFoodsCaloriesById(@RequestBody BreakfastFoodsRequest breakfastFoodsRequest, @PathVariable(value = "id") int id) {
        try {
            service.editCalories(breakfastFoodsRequest, id);
            return "Calories of breakfast food with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Breakfast food with id: " + id + " was not found.";
        }
    }

    @PutMapping("/edit-carbs/{id}")
    public String editBreakfastFoodsCarbsById(@RequestBody BreakfastFoodsRequest breakfastFoodsRequest, @PathVariable(value = "id") int id) {
        try {
            service.editCarbs(breakfastFoodsRequest, id);
            return "Carbs per serving of breakfast food with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Breakfast food with id: " + id + " was not found.";
        }
    }

    @PutMapping("/edit-protein/{id}")
    public String editBreakfastFoodsProteinById(@RequestBody BreakfastFoodsRequest breakfastFoodsRequest, @PathVariable(value = "id") int id) {
        try {
            service.editProtein(breakfastFoodsRequest, id);
            return "Protein per serving of breakfast food with id: " + id + " has been updated";
        } catch (NoSuchElementException e) {
            return "Breakfast food with id: " + id + " was not found.";
        }
    }

    @PostMapping("/new")
    public BreakfastFoods addNewBreakfastFood(@RequestBody BreakfastFoodsRequest breakfastFoodsRequest) {
        return service.addNewBreakfastFood(breakfastFoodsRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBreakfastFoodById(@PathVariable(value = "id") int id) {
        try {
            String name = service.get(id).getName();
            service.deleteBreakfastFood(id);
            return name + " has been removed from the database";
        } catch (NoSuchElementException e) {
            return "Breakfast food with id: " + id + " was not found.";
        }
    }
}
