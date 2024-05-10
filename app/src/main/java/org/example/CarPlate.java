package org.example;

/**
 * This my implementation of a testing class for a key in MyHashTable
 */
public class CarPlate {
    private String plate;
    private int region;

    public CarPlate(String plate, int region) {
        this.plate = plate;
        this.region = region;
    }

    public String getPlate() {
        return plate;
    }

    public int getRegion() {
        return region;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Your plate is from " + this.region + " region, the plate number: " + this.plate;
    }
}
