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

    // TODO: optimize the hashcode method
    @Override
    public int hashCode() {
        if (plate.isBlank()) {
            return 0;
        }
        int hash = Integer.MAX_VALUE;
        double power = 31;
        for (int i = 0; i < plate.length(); i++) {
            hash = (int) plate.charAt(i) * (int) Math.pow(power, plate.length() - i);
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Your plate is from " + this.region + " region, the plate number: " + this.plate;
    }
}
