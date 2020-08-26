package view;

import services.BrandModel;
import services.BrandService;
import services.CarModel;
import services.CarService;
import services.mapper.BrandMapper;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleInterface {

   private final Scanner sc = new Scanner(System.in);
   private final CarService carService= new CarService();
   private final BrandService brandService = new BrandService();

    public ConsoleInterface() {


    }


    public void displayMenu() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------------");
            System.out.println("-------Menu:------- ");
            System.out.println("1. Voir toutes les voitures");
            System.out.println("2. Voir toutes les marques");
            System.out.println("3. Trouver une voiture en fonction de l'id");
            System.out.println("4. Créer une voiture");
            System.out.println("5. Modifier une voiture");
            System.out.println("6. Supprimer une voiture");
            System.out.println("-------------------");
            System.out.println("------------------- ");

            navigate(sc.nextLine());
        }
    }


    private void navigate(String choice) {

        switch (choice) {

            case "1":
                displayAllCars();
                break;
            case "2":
                displayAllBrands();
                break;
            case "3":
                displayOne();
                break;
            case "4":
                createOneCar();
                break;
            case "5":
                updateOneCar();
                break;
            case "6":
                deleteOneCar();
                break;
        }
    }

    private void displayAllCars() {

        System.out.println("------------------- ");
        System.out.println("1. Voir toutes les voitures");
        carService.findAll().forEach(System.out::println);
        System.out.println("-------------------");
        System.out.println("------------------- ");
    }

    private void displayAllBrands() {

        System.out.println("------------------- ");
        System.out.println("2. Voir toutes les marques");
        brandService.findAll().forEach(System.out::println);
        System.out.println("-------------------");
        System.out.println("------------------- ");
    }
    private void displayOne() {

        System.out.println("------------------- ");
        System.out.println(" 3.Voir une voiture");
        System.out.println("Veuillez entrer l'id de la voiture");
        CarModel model = carService.findOneById(sc.nextLine());
        System.out.println(model);
        System.out.println("-------------------");
        System.out.println("------------------- ");
    }


    private void createOneCar() {

        String id;
        BrandModel brand;
        LocalDate purchasingDate;
        String model;
        System.out.println("------------------- ");
        System.out.println(" 3.Créer une voiture");
        System.out.println("Veuillez entrer l'id de la voiture");
        id= sc.nextLine();
        System.out.println("Veuillez entrer l'id de la marque");
        brand= brandService.findOneById(sc.nextLine());
        System.out.println("Veuillez entrer la date d'achat yy/mm/dd");
        purchasingDate=LocalDate.parse(sc.nextLine());
        System.out.println("Veuillez entrer le modèle");
        model= sc.nextLine();
        carService.createOne(new CarModel(id,brand,purchasingDate,model));
        System.out.println("-------------------");
        System.out.println("------------------- ");
    }

    private void updateOneCar() {

        //--------Celle-là n'est pas finie, ça m'a saoulé mdr-------------------------
        System.out.println("----------------------- ");
        System.out.println(" 5.Modifier une voiture");
        System.out.println("Entrez l'id de la voiture à modifier");
        String id = sc.nextLine();
        System.out.println("");


        System.out.println("-------------------");
        System.out.println("------------------- ");

    }

    private void deleteOneCar() {

        System.out.println("----------------------- ");
        System.out.println("6.Supprimer une voiture");

        System.out.println("Veuillez entrer l'id de la voiture à supprimer");
        String id = sc.nextLine();
        carService.delete(id);

        System.out.println("-------------------");
        System.out.println("------------------- ");

    }
}
