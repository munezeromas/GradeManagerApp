package org.example;

import java.util.Arrays;

public class GradeManager {
    public void printGrades(int[] grades) {
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    public int[] addGrade(int[] grades, int grade) throws InvalidGradeException {
        if (grade < 0) {
            throw new InvalidGradeException("Error: Grade cannot be negative.");
        }

        int[] newGrades = Arrays.copyOf(grades, grades.length + 1);
        newGrades[newGrades.length - 1] = grade;

        return newGrades;
    }

    public void sortGrades(int[] grades) {
        Arrays.sort(grades);
    }

    public int searchGrade(int[] grades, int target) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int getGrade(int[] grades, int index) {
        try {
            return grades[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index!");
            return -1;
        } finally {
            System.out.println("Operation logged.");
        }
    }

    public double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public int findHighestGrade(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public int findLowestGrade(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
