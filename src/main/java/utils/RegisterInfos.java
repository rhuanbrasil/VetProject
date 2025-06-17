package utils;

import Exceptions.MenuExceptions;
import enums.Sex;
import enums.Type;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RegisterInfos {
    private String name, address, race;
    private int age;
    private double weight;
    private Type type;
    private Sex sex;

    public String getName() {
        return name;
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

    public void RegisterMenu() {
        Scanner sc = new Scanner(System.in);
        String path = "formulario.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            System.out.println(br.readLine());
            name = sc.nextLine();
            if (name.split(" ").length < 2) {
                throw new MenuExceptions("Por favor, cadastre nome e sobrenome");
            } else if (!name.matches("[a-zA-Z ]+")) {
                throw new MenuExceptions("Por favor, sem caracteres especiais");
            }
            System.out.println(br.readLine());
            type = Type.valueOf(sc.nextLine().toUpperCase().trim());
            System.out.println(br.readLine());
            sex = Sex.valueOf(sc.nextLine().toUpperCase().trim());
            System.out.println(br.readLine());
            address = sc.nextLine();
            System.out.println(br.readLine());
            age = sc.nextInt();
            System.out.println(br.readLine());
            weight = sc.nextDouble();
            sc.nextLine();
            System.out.println(br.readLine());
            race = sc.nextLine();
            }
        catch(IOException e){
            throw new MenuExceptions("Erro ao ler o arquivo");
        }
    }

}
