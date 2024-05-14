package org.example;

import org.example.dataStructures.*;

import java.util.Scanner;

import org.example.Entities.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat do you wanna check?");

            System.out.println("\n1.Hash table.\n2.BST\n3.Exit");

            System.out.println("Your choice: ");

            if (!scan.hasNextInt()) {
                System.out.println("No input available. Exiting...");
                break;
            }

            int choice = scan.nextInt();

            if (choice == 1) {
                checkHashTable();
            } else if (choice == 2) {
                checkBST();
            } else if (choice == 3) {
                return;
            } else {
                System.out.println("I did not get you, try again.");
                continue;
            }
        }
    }

    private static void checkBST() {
        BST<Integer, String> tree = new BST<>();

        tree.put(1, "Nursultan");
        tree.put(20, "Beybarys");
        tree.put(2, "Nurbol");
        tree.put(56, "Kostya");
        tree.put(10, "Rustam");
        tree.put(8, "Arystan");
        tree.put(12, "Red bull");
        tree.put(6, "Smoking is killing us");

        for (BST.KeyValuePair elem : tree.iterator()) {
            System.out.println(elem);
        }
        System.out.println("The size of our tree: " + tree.size());

        System.out.println("\nAfter this, let's delete the element with key 6, and 2.\n");

        tree.delete(6);
        tree.delete(2);

        for (BST.KeyValuePair elem : tree.iterator()) {
            System.out.println(elem);
        }
        System.out.println("The size of our tree: " + tree.size());

        System.out.println("\nLet's get elemeents with ids 1 and 10");

        System.out.println("Value of element with id 1: " + tree.get(1));
        System.out.println("Value of element with id 10: " + tree.get(10));
    }

    private static void checkHashTable() {
        MyHashTable<CarPlate, Car> table = new MyHashTable<>();
        addRandomElements(table);
        System.out.println("Here is the number of elements in each bucket of 10000 elements: ");

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
