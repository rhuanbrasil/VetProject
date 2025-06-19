package application;

import Exceptions.MenuExceptions;
import entities.Pet;
import entities.Pets;
import enums.MenuOptions;
import enums.Sex;
import enums.Type;
import utils.RegisterInfos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RegisterInfos registerInfos = new RegisterInfos();
        Pets pets = new Pets();
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println
                (
                  "1. Cadastrar novo pet\n" +
                  "2. Alterar os dados do pet cadastrado\n" +
                  "3. Deletar um pet cadastrado\n" +
                  "4. Listar todos os pets cadastrados\n" +
                  "5. Listar pets por algum critério (idade, nome, raça)\n" +
                  "6. Sair"
                );
                String response = input.nextLine();
                int responseint = Integer.parseInt(response);
                var Option = MenuOptions.values()[responseint-1];
                if (responseint < 1 || responseint > 6 || !response.matches("^[0-9]+$")) {
                    throw new MenuExceptions("Favor informe um valor válido\n");
                }
                switch (Option) {
                    case REGISTER -> {
                       var pet = Pets.RegisterPet();
                        pets.addpet(pet);
                        createDoc(pet);
                    }
                    case UPDATE ->{
                        var pet = wichPet(pets);
                        pets.Update(pet);
                    }
                    case DELETE -> {
                        var pet = wichDelete(pets);
                        pets.removepet(pet);
                    }
                    case LISTALL -> {
                        pets.listAll();
                    }
                    case FILTERLIST -> {
                        var qnt = qntCriters();
                        if (qnt == 1){
                            System.out.println(pets.findByCriter(arg()));
                        } else {
                            var a1 = arg();
                            var a2 = arg();
                            System.out.println(pets.findByCriters(a1, a2));
                        }
                    }
                    case EXIT -> {
                        System.out.println("Saindo...");
                        exit = true;
                    }

                }
            } catch (MenuExceptions e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static String arg(){
        var sc = new Scanner(System.in);
        System.out.println("Digite o nome ou alguma característica do seu pet:");
        return sc.nextLine();
    }
    public static int qntCriters() {

            try {
                var sc = new Scanner(System.in);
                System.out.println("Quantos critérios você vai usar? (1/2)");
                var crit = sc.nextInt();
                if (crit < 1 || crit > 2) {
                    throw new MenuExceptions("Favor, informe um válor válido");
                } else{
                return crit;
                }
            } catch (MenuExceptions e) {
                System.out.println(e.getMessage());
            }
            return 0;
    }
    public static void createDoc(Pet pet){
        var now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
        var formattedDateTime = now.format(formatter);
        var path = formattedDateTime + "-" + pet.getName().replaceAll(" ", "").toUpperCase();
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path + ".txt"))){
            br.write("1." + pet.getName() +"\n");
            br.write("2." + pet.getType() +"\n");
            br.write("3." + pet.getSex() +"\n");
            br.write("4." + pet.getAddress() +"\n");
            br.write("5." + pet.getAge() +"\n");
            br.write("6." + pet.getWeight() +"\n");
            br.write("7." + pet.getRace() +"\n");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static Pet wichDelete(Pets pets) {
        var sc = new Scanner(System.in);
        pets.listAll();
        System.out.println("Qual pet você deseja deletar?");
        return pets.findByCriter(sc.nextLine());
    }
    public static Pet wichPet(Pets pets){
        var sc = new Scanner(System.in);
        pets.listAll();
        String path = "formulario.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            System.out.println("Digite o nome do pet que deseja atualizar");
            var name = sc.nextLine();
            System.out.println("Digite as novas informações:");
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
}
