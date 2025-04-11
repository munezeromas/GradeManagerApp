public class Main {
    public static void main(String[] args) {
        // Initialize GradeManager with capacity of 5
        GradeManager manager = new GradeManager(5);

        // Test adding valid grades
        try {
            manager.addGrade(85);
            manager.addGrade(90);
            manager.addGrade(78);
            manager.addGrade(92);
            manager.addGrade(88); // Fills initial capacity
            manager.addGrade(95); // Tests array resizing
            System.out.println("Grades added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding grades: " + e.getMessage());
        }

        // Display current grades
        System.out.println("Current grades: " + Arrays.toString(manager.getGrades()));

        // Test sorting
        try {
            manager.sortGrades();
            System.out.println("Sorted grades: " + Arrays.toString(manager.getGrades()));
        } catch (Exception e) {
            System.out.println("Error sorting grades: " + e.getMessage());
        }

        // Test grade search
        try {
            int searchTarget = 90;
            int index = manager.searchGrade(searchTarget);
            if (index != -1) {
                System.out.println("Grade " + searchTarget + " found at index: " + index);
            } else {
                System.out.println("Grade " + searchTarget + " not found");
            }
        } catch (Exception e) {
            System.out.println("Error searching for grade: " + e.getMessage());
        }

        // Test average calculation
        try {
            double average = manager.calculateAverage();
            System.out.printf("Average grade: %.2f\n", average);
        } catch (IllegalStateException e) {
            System.out.println("Error calculating average: " + e.getMessage());
        }

        // Test highest grade
        try {
            System.out.println("Highest grade: " + manager.findHighestGrade());
        } catch (IllegalStateException e) {
            System.out.println("Error finding highest grade: " + e.getMessage());
        }

        // Test lowest grade
        try {
            System.out.println("Lowest grade: " + manager.findLowestGrade());
        } catch (IllegalStateException e) {
            System.out.println("Error finding lowest grade: " + e.getMessage());
        }

        // Test invalid grade input
        try {
            manager.addGrade(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error for invalid grade: " + e.getMessage());
        }

        // Test operations on empty manager
        GradeManager emptyManager = new GradeManager(5);
        try {
            emptyManager.calculateAverage();
        } catch (IllegalStateException e) {
            System.out.println("Expected error for empty manager: " + e.getMessage());
        }
    }
}
