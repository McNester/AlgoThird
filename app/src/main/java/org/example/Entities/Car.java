
package org.example.Entities;

import java.util.Random;

import org.example.Utils;

public class Car {
    private CarPlate plate;
    private String brand;
    private String ownerName;

    public Car(CarPlate plate, String brand, String ownerName) {
        this.plate = plate;
        this.brand = brand;
        this.ownerName = ownerName;
    }

    public static Car createRandomCar() {
        Random rand = new Random();

        CarPlate randPlate = new CarPlate(Utils.generateRandomString(6), rand.nextInt(20));

        String[] listOfBrands = { "BMW", "Mercedes", "Volvo", "Toyota" };

        String randBrand = listOfBrands[rand.nextInt(listOfBrands.length)];

        String randName = Utils.generateRandomString(7);

        return new Car(randPlate, randBrand, randName);

    }

    public CarPlate getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setPlate(CarPlate plate) {
        this.plate = plate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
