package org.example;

import org.example.dataStructures.MyHashTable;
import org.example.Entities.*;

public class Main {
    public static void main(String[] args) {
        MyHashTable<CarPlate, Car> table = new MyHashTable<>();
        addRandomElements(table);
        System.out.println("Here is the number of elements in each bucket of 1000 elements: ");
        // TODO: print number of elements in each bucket (chain or linkedlist).

        for (int i = 0; i < table.getM(); i++) {
            int size = table.getBucketSize(i);
            if (size > 0) {
                System.out.println("\n" + (i + 1) + " Bucket size: " + size);
            }
        }

        System.out.println("\nOverall number of buckets: " + table.getM());

    }

    private static void addRandomElements(MyHashTable<CarPlate, Car> table) {
        int numberOfElements = 10000;
        for (int i = 0; i < numberOfElements; i++) {
            Car car = Car.createRandomCar();
            table.put(car.getPlate(), car);
        }
    }
}
