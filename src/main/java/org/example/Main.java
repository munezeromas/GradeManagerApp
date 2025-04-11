package org.example;

public class Main {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        int[] grades = {11, 95, 87, 59, 45};

        System.out.println("Original grades:");
        manager.printGrades(grades);
        try {
            grades = manager.addGrade(grades, 78);
            System.out.println("\nAfter adding grade 78:");
            manager.printGrades(grades);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
        try {
            grades = manager.addGrade(grades, -5);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nSorted grades:");
        manager.sortGrades(grades);
        manager.printGrades(grades);

        System.out.println("\nSearching for grade 59:");
        int index = manager.searchGrade(grades, 59);
        if (index != -1) {
            System.out.println("Grade 59 found at index: " + index);
        } else {
            System.out.println("Grade 59 not found.");
        }

        System.out.println("\nTrying to access index 10:");
        int gradeAtInvalidIndex = manager.getGrade(grades, 10);
        System.out.println("Result: " + gradeAtInvalidIndex);

        System.out.println("\nExtra Features:");
        System.out.println("Average grade: " + manager.calculateAverage(grades));
        System.out.println("Highest grade: " + manager.findHighestGrade(grades));
        System.out.println("Lowest grade: " + manager.findLowestGrade(grades));
    }
}
