package com.example.a16022895.firebaseinventoryapp;

import java.io.Serializable;

public class Item implements Serializable{

    private String name;
    private double unitCost;
    private String id;

    public String getId() {
        return id;
    }

    public Item() {

    }

    public Item(String name, double unitCost) {
        this.name = name;
        this.unitCost = unitCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
