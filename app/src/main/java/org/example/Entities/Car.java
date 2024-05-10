
package org.example.Entities;

public class Car {
    private CarPlate plate;
    private String brand;
    private String ownerName;

    public Car(CarPlate plate, String brand, String ownerName) {
        this.plate = plate;
        this.brand = brand;
        this.ownerName = ownerName;
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
