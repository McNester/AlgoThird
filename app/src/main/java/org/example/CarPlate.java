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
            int charOfPlate = plate.charAt(i);
            // NOTE: numberInPower is basically 31 raised to the power of n-1-i, where n-1
            // is the length
            // of a plate number -1, and i is the index of current char in this plate
            // number;
            int numberInPower = (int) Math.pow(power, plate.length() - i);

            hash = charOfPlate * numberInPower;
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Your plate is from " + this.region + " region, the plate number: " + this.plate;
    }
}
