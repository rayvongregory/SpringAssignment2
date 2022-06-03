package com.genspark.Assignment2.b.entity;

import javax.persistence.*;

@Entity
@Table(name = "breakfast_foods")
public class BreakfastFoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "serving_size_in_grams")
    private int servingSize;

    @Column(name = "calories")
    private int calories;

    @Column(name = "carbs")
    private int carbs;

    @Column(name = "protein")
    private int protein;

    public BreakfastFoods() {
    }

    public BreakfastFoods(String name, int servingSize, int calories, int carbs, int protein) {
        this.name = name;
        this.servingSize = servingSize;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "BreakfastFoods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", servingSize=" + servingSize +
                ", calories=" + calories +
                ", carbs=" + carbs +
                ", protein=" + protein +
                '}';
    }
}
