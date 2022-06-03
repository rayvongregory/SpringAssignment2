package com.genspark.Assignment2.b.services;

import com.genspark.Assignment2.b.entity.BreakfastFoods;
import com.genspark.Assignment2.b.requests.BreakfastFoodsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BreakfastFoodsService {

    @Autowired
    private BreakfastFoodsRepository repo;

    public List<BreakfastFoods> listAll() {
        return repo.findAll();
    }

    public BreakfastFoods get(Integer id) {
        return repo.findById(id).get();
    }

    public List<BreakfastFoods> getByName(String name) {
        return  List.of(repo.findAll().stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).toArray(BreakfastFoods[]::new));
    }

    public List<BreakfastFoods> getBreakfastFoodsUnderCalories(int numCalories) {
        return  List.of(repo.findAll().stream().filter(p -> p.getCalories() <= numCalories).toArray(BreakfastFoods[]::new));
    }

    public List<BreakfastFoods> getBreakfastFoodsOverCalories(int numCalories) {
        return  List.of(repo.findAll().stream().filter(p -> p.getCalories() >= numCalories).toArray(BreakfastFoods[]::new));
    }

    public List<BreakfastFoods> getBreakfastFoodOverProteinPerServing(int gramsProtein) {
        return  List.of(repo.findAll().stream().filter(p -> p.getProtein() >= gramsProtein).toArray(BreakfastFoods[]::new));
    }

    public List<BreakfastFoods> getBreakfastFoodUnderCarbsPerServing(int gramsCarbs) {
        return  List.of(repo.findAll().stream().filter(p -> p.getCarbs() <= gramsCarbs).toArray(BreakfastFoods[]::new));
    }

    public List<BreakfastFoods> getBreakfastFoodOverCarbsPerServing(int gramsCarbs) {
        return  List.of(repo.findAll().stream().filter(p -> p.getCarbs() >= gramsCarbs).toArray(BreakfastFoods[]::new));
    }

    public BreakfastFoods editName(BreakfastFoodsRequest breakfastFoodsRequest, int id) {
        BreakfastFoods b = repo.findById(id).get();
        b.setName(breakfastFoodsRequest.getName());
        return repo.save(b);
    }

    public BreakfastFoods editServingSize(BreakfastFoodsRequest breakfastFoodsRequest, int id) {
        BreakfastFoods b = repo.findById(id).get();
        b.setServingSize(breakfastFoodsRequest.getServingSize());
        return repo.save(b);
    }

    public BreakfastFoods editCalories(BreakfastFoodsRequest breakfastFoodsRequest, int id) {
        BreakfastFoods b = repo.findById(id).get();
        b.setCalories(breakfastFoodsRequest.getCalories());
        return repo.save(b);
    }

    public BreakfastFoods editCarbs(BreakfastFoodsRequest breakfastFoodsRequest, int id) {
        BreakfastFoods b = repo.findById(id).get();
        b.setCarbs(breakfastFoodsRequest.getCarbs());
        return repo.save(b);
    }

    public BreakfastFoods editProtein(BreakfastFoodsRequest breakfastFoodsRequest, int id) {
        BreakfastFoods b = repo.findById(id).get();
        b.setProtein(breakfastFoodsRequest.getProtein());
        return repo.save(b);
    }

    public BreakfastFoods addNewBreakfastFood(BreakfastFoodsRequest breakfastFoodsRequest) {
        BreakfastFoods p = new BreakfastFoods();
        p.setName(breakfastFoodsRequest.getName());
        p.setServingSize(breakfastFoodsRequest.getServingSize());
        p.setCalories(breakfastFoodsRequest.getCalories());
        p.setCarbs(breakfastFoodsRequest.getCarbs());
        p.setProtein(breakfastFoodsRequest.getProtein());
        return repo.save(p);
    }

    public void deleteBreakfastFood(int id) {
        repo.deleteById(id);
    }
}
