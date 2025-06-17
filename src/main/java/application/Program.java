package application;

import Exceptions.MenuExceptions;
import entities.Pet;
import entities.Pets;
import utils.RegisterInfos;

import java.util.InputMismatchException;
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
                if (responseint < 1 || responseint > 6 || !response.matches("^[0-9]+$")) {
                    throw new MenuExceptions("Favor informe um valor válido\n");
                }
                switch (responseint) {
                    case 1:
                        registerInfos.RegisterMenu();
                        Pet pet = new Pet(
                                registerInfos.getName(),
                                registerInfos.getAddress(),
                                registerInfos.getRace(),
                                registerInfos.getAge(),
                                registerInfos.getWeight(),
                                registerInfos.getType(),
                                registerInfos.getSex()
                        );
                        pets.addpet(pet);
                        exit = true;
                    case 2:

                }
            } catch (MenuExceptions e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
