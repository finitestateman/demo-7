package com.pokemon.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class PokemonDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private int hp;
    private boolean legendary;
    private double height;
    private float weight;
    private String captureDate;
    private int stardustCost;

    public PokemonDto() {
    }

    public PokemonDto(Long id, String name, String type, int hp, boolean legendary, double height, float weight, String captureDate, int stardustCost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.legendary = legendary;
        this.height = height;
        this.weight = weight;
        this.captureDate = captureDate;
        this.stardustCost = stardustCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
    }

    public int getStardustCost() {
        return stardustCost;
    }

    public void setStardustCost(int stardustCost) {
        this.stardustCost = stardustCost;
    }
}
