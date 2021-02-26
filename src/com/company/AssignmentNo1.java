package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class AssignmentNo1 {

    public static void main(String[] args) {

        ArrayList<String> myArrayList = new ArrayList<>();
        myArrayList.add("Computer");
        myArrayList.add("Plate");
        myArrayList.add("Chair");
        myArrayList.add("Girl");
        myArrayList.add("Boy");
        myArrayList.add("Cat");
        myArrayList.add("Dog");
        myArrayList.add("Shirt");
        myArrayList.add("Determination");

        long countStartsWith = myArrayList.stream().filter(w -> w.startsWith("C")).count();
        System.out.println("\nWord(s) starting with 'C': " + countStartsWith);

        long countEndsWith = myArrayList.stream().filter(w -> w.endsWith("e")).count();
        System.out.println("Word(s) ending with 'e': " + countEndsWith);

        long countLength = myArrayList.stream().filter(w -> w.length() == 5).count();
        System.out.println("Word(s) with length '5': " + countLength);

        long countContain = myArrayList.stream().filter(w -> w.contains("e")).count();
        System.out.println("Word(s) consist of 'e': " + countContain);

        boolean isExist = myArrayList.stream().anyMatch(element -> element.contains("te"));
        System.out.println("There are word(s) with substring 'te': " + isExist + "\n");

        histogram(myArrayList);
        sortingArray(myArrayList);
    }

    public static void histogram(ArrayList<String> myArrayList) {
        int[] newArray = new int[14];
        for (int i = 0; i < newArray.length; i++) {
            int counter = 0;
            for (String s : myArrayList) {
                if (i == s.length()) {
                    counter++;
                }
            }
            newArray[i] = counter;
            if (counter != 0 && counter < 2) {
                System.out.println(newArray[i] + " word is with length " + i);
            }
            if (counter > 1) {
                System.out.println(newArray[i] + " words are with length " + i);
            }
        }
    }

    public static void sortingArray(ArrayList<String> myArrayList) {
        //1.Sorting by Collections.sort()
        System.out.println("\nMy Array List before sorting: " + myArrayList);
        Collections.sort(myArrayList);
        System.out.println("My Array List after sorting: " + myArrayList);

        //2.Sorting by Stream.sorted()
        System.out.println("\nMy Array List sorted: ");
        myArrayList.stream().sorted().map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
