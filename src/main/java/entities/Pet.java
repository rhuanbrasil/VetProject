package entities;

import enums.Sex;
import enums.Type;

public class Pet {
    private String name, address, race;
    private int age;
    private double weight;
    private Type type;
    private Sex sex;

    public Pet(String name, String address, String race, int age, double weight, Type type, Sex sex) {
        this.name = name;
        this.address = address;
        this.race = race;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.sex = sex;
    }
}
