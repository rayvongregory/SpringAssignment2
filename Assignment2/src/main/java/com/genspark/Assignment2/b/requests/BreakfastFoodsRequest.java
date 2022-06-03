package com.genspark.Assignment2.b.requests;

public class BreakfastFoodsRequest {

    private String name;
    private int servingSize;
    private int calories;
    private int carbs;
    private int protein;

    public BreakfastFoodsRequest() {}

    public BreakfastFoodsRequest(String name, int servingSize, int calories, int carbs, int protein) {
        this.name = name;
        this.servingSize = servingSize;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
    }

    public String getName() {
        return name;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getCalories() {
        return calories;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getProtein() {
        return protein;
    }
}
