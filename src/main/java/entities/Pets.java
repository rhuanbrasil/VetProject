package entities;

import java.util.List;

public class Pets {
    private List<Pet> pets;

    public void addpet(Pet pet) {
        pets.add(pet);
    }
    public void removepet(Pet pet) {
        pets.remove(pet);
    }
}
