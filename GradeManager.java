class GradeManager {
    private int[] grades;
    private int size;

    public GradeManager(int initialCapacity) {
        grades = new int[initialCapacity];
        size = 0;
    }

    // Adds a grade to the array with resizing if needed
    public void addGrade(int grade) throws IllegalArgumentException {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Invalid grade: Grade must be between 0 and 100");
        }

        if (size == grades.length) {
            resizeArray();
        }

        grades[size++] = grade;
    }

    // Helper method to resize the array when full
    private void resizeArray() {
        int[] newArray = new int[grades.length * 2];
        System.arraycopy(grades, 0, newArray, 0, grades.length);
        grades = newArray;
    }

    // Sorts grades in ascending order
    public void sortGrades() {
        Arrays.sort(grades, 0, size);
    }

    // Searches for a specific grade and returns its index
    public int searchGrade(int target) {
        for (int i = 0; i < size; i++) {
            if (grades[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Calculates the average grade
    public double calculateAverage() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("No grades available to calculate average");
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += grades[i];
        }
        return (double) sum / size;
    }

    // Finds the highest grade
    public int findHighestGrade() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("No grades available");
        }

        int highest = grades[0];
        for (int i = 1; i < size; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    // Finds the lowest grade
    public int findLowestGrade() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("No grades available");
        }

        int lowest = grades[0];
        for (int i = 1; i < size; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }

    // Returns a copy of the grades array (only the filled portion)
    public int[] getGrades() {
        return Arrays.copyOf(grades, size);
    }
}
