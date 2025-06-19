package entities;

import Exceptions.MenuExceptions;
import enums.Sex;
import enums.Type;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pets {
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }
    public static Pet RegisterPet() {
        Scanner sc = new Scanner(System.in);
        String path = "formulario.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println(br.readLine());
            var name = sc.nextLine();
            if (name.split(" ").length < 2) {
                throw new MenuExceptions("Por favor, cadastre nome e sobrenome");
            } else if (!name.matches("[a-zA-Z ]+")) {
                throw new MenuExceptions("Por favor, sem caracteres especiais");
            }
            System.out.println(br.readLine());
            var type = Type.valueOf(sc.nextLine().toUpperCase().trim());
            System.out.println(br.readLine());
            var sex = Sex.valueOf(sc.nextLine().toUpperCase().trim());
            System.out.println(br.readLine());
            var address = sc.nextLine();
            System.out.println(br.readLine());
            var age = sc.nextInt();
            System.out.println(br.readLine());
            var weight = sc.nextDouble();
            sc.nextLine();
            System.out.println(br.readLine());
            var race = sc.nextLine();
            return new Pet(
                    name,
                    address,
                    race,
                    age,
                    weight,
                    type,
                    sex
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Pet findByCriters(String arg, String arg2){
        return pets.stream()
                .filter(pet -> {
                    boolean matchesArg =
                            pet.getAddress().equals(arg) ||
                            pet.getName().toLowerCase().contains(arg.toLowerCase()) ||
                            (isValidInt(arg) && pet.getAge() == Integer.parseInt(arg)) ||
                            (isValidDouble(arg) && pet.getWeight() == Double.parseDouble(arg)) ||
                            pet.getRace().equalsIgnoreCase(arg) ||
                            pet.getSex().name().equals(arg.toUpperCase().trim());
                    boolean matchesArg2 =
                            pet.getAddress().equals(arg2) ||
                            pet.getName().contains(arg2) ||
                            (isValidInt(arg2) && pet.getAge() == Integer.parseInt(arg2)) ||
                            (isValidDouble(arg2) && pet.getWeight() == Double.parseDouble(arg2)) ||
                            pet.getRace().equals(arg2);

                    return matchesArg && matchesArg2;

                })
                .findFirst()
                .orElseThrow(() -> new MenuExceptions("Por favor, informe critérios presentes em algum pet cadastrado"));

    }
    private static boolean isValidInt(String str) {
        if (str == null){
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
        return false;
        }
    }

    private static boolean isValidDouble(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Pet findByCriter(String arg){
        return pets.stream()
                .filter(pet -> pet.getAddress().equals(arg)
                        || pet.getName().contains(arg)
                        || (isValidInt(arg) && pet.getAge() == Integer.parseInt(arg))
                        || (isValidDouble(arg) && pet.getWeight() == Double.parseDouble(arg))
                        || pet.getRace().equals(arg)
                        || pet.getSex().name().equals(arg.toUpperCase().trim()))
                .findFirst()
                .orElseThrow(() -> new MenuExceptions("Por favor, informe critérios presentes em algum pet cadastrado"));

    }
    public Pet Update(Pet pet){
        var toUp = findByCriters(pet.getName(), pet.getRace());
        pets.remove(toUp);
        pets.add(pet);
        return pet;
    }
    public void listAll(){
         pets.forEach(System.out::println);
    }
    public void addpet(Pet pet) {
        pets.add(pet);
    }
    public void removepet(Pet pet) {
        var toDelete = findByCriters(pet.getName(), pet.getRace());
        pets.remove(toDelete);
    }
}
