package entities;

import enums.Sex;
import enums.Type;

public class Pet {
    private String name, address, race;
    private int age;
    private double weight;
    private Type type;
    private Sex sex;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "Pet Details:\n" +
                "  Name: %s\n" +
                "  Address: %s\n" +
                "  Race: %s\n" +
                "  Age: %d years\n" +
                "  Weight: %.2f kg\n" +
                "  Type: %s\n" +
                "  Sex: %s",
                name, address, race, age, weight, type, sex);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

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
