package org.example;

import java.util.Arrays;

public class GradeManager {
    public void printGrades(int[] grades) {
        for (int g : grades) {
            System.out.print(g + " ");
        }
        System.out.println();
    }

    public int[] addGrade(int[] grades, int grade) throws InvalidGradeException {
        if (grade < 0) {
            throw new InvalidGradeException("Grade can't be negative.");
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
            System.out.println("Invalid index.");
            return -1;
        } finally {
            System.out.println("Done.");
        }
    }

    public double calculateAverage(int[] grades) {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.length;
    }

    public int findHighestGrade(int[] grades) {
        int max = grades[0];
        for (int g : grades) {
            if (g > max) {
                max = g;
            }
        }
        return max;
    }

    public int findLowestGrade(int[] grades) {
        int min = grades[0];
        for (int g : grades) {
            if (g < min) {
                min = g;
            }
        }
        return min;
    }
}
