package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerNum = new Scanner(System.in).useLocale(Locale.US);
    static GestorCoche gc = new GestorCoche();
    public static void main(String[] args) {
        int opcion;
        System.out.println("crud de coches");
        boolean salir = false;
        do {
            menu();
            opcion = scannerNum.nextInt();
            switch (opcion) {
                case 1:
                    ingresarCoche();
                    break;
                case 2:
                    mostrarCoches();
                    break;
                case 9:
                    mocearCoches();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while (!salir);
        System.out.println("Adios!");
    }
    private static void menu() {
        System.out.println("Menu de Opciones");
        System.out.println("================");
        System.out.println("1. Ingresar Coche");
        System.out.println("2. Listar Coches");
        System.out.println("9. Agredar Coches EN MASA");
        System.out.println("0. Salir");
        System.out.println();
        System.out.print("Ingrese una opcion: ");
    }
    private static void ingresarCoche() {
        String marca;
        String modelo;
        int anio;
        String color;
        System.out.println("Formulario de ingreso de Coche");
        System.out.println("==============================");
        System.out.println();
        System.out.print("Marca: ");
        marca = scannerStr.nextLine();
        System.out.print("Modelo: ");
        modelo = scannerStr.nextLine();
        System.out.print("Año: ");
        anio = scannerNum.nextInt();
        System.out.print("Color: ");
        color = scannerStr.nextLine();
        gc.agregarCoche(new Coche( marca, modelo, anio, color));
    }
    private static void mostrarCoches() {
        System.out.println("Listado de Coches");
        System.out.println("=================");
        System.out.println();
        for (Coche c : gc.listarCoches()) {
            System.out.println(c.getId() + " - " + c.getMarca() + " - " + c.getModelo() + " - " + c.getAnio() + " - " + c.getColor());
        }
    }
    private static void  mocearCoches() {
        gc.agregarCoche(new Coche("Toyota", "Corolla", 2018, "Azul"));
        gc.agregarCoche(new Coche("Honda", "Civic", 2019, "Negro"));
        gc.agregarCoche(new Coche("Chevrolet", "Camaro", 2020, "Amarillo"));
        gc.agregarCoche(new Coche("Nissan", "Sentra", 2021, "Blanco"));
        gc.agregarCoche(new Coche("Volkswagen", "Golf", 2017, "Verde"));
        gc.agregarCoche(new Coche("BMW", "Serie 3", 2022, "Gris"));
        gc.agregarCoche(new Coche("Audi", "A4", 2016, "Plata"));
        gc.agregarCoche(new Coche("Mercedes-Benz", "Clase C", 2023, "Negro"));
        gc.agregarCoche(new Coche("Subaru", "Impreza", 2015, "Rojo"));
        gc.agregarCoche(new Coche("Mazda", "3", 2014, "Azul"));
    }
}