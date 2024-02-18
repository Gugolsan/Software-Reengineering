public class Main {
    public static void main(String[] args) {
        // Use camelCase for variable names and meaningful names for classes
        HumanBmi humanBmi = new HumanBmi(80, 1.52F);
        System.out.println(humanBmi.calculateStatus());
    }
}

class HumanBmi {
    // Use private access modifier for fields and use getters and setters for access
    private float weight; // Weight of human in kg
    private float height; // Height of human in m
    private float bmi; // Body mass index of human

    // Use a single space for indentation and a blank line after the class declaration
    public HumanBmi(float weight, float height) {
        this.weight = weight;
        this.height = height;
        // Use parentheses for clarity and avoid magic numbers
        this.bmi = weight / (height * height);
    }

    // Use @return tag for documenting return values
    /**
     * Returns the weight of the human.
     *
     * @return the weight in kg
     */
    public double getWeight() {
        return weight;
    }

    // Use @param tag for documenting parameters
    /**
     * Sets the weight of the human and updates the body mass index.
     *
     * @param weight the new weight in kg
     */
    public void setWeight(float weight) {
        this.weight = weight;
        this.bmi = weight / (height * height);
    }

    /**
     * Returns the height of the human.
     *
     * @return the height in m
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the human and updates the body mass index.
     *
     * @param height the new height in m
     */
    public void setHeight(float height) {
        this.height = height;
        this.bmi = weight / (height * height);
    }

    // Use lowercase for constants and avoid static methods for instance fields
    /**
     * Returns the body mass index of the human.
     *
     * @return the body mass index
     */
    public double getBmi() {
        return bmi;
    }

    // Use camelCase for method names and meaningful names for variables
    /**
     * Returns the health status of the human based on the body mass index.
     *
     * @return a string indicating the health status
     */
    public String calculateStatus() {
        String status = null;
        // Use logical operators instead of bitwise operators and use braces for blocks
        if (bmi >= 18.5 && bmi < 25) {
            status = "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            status = "Overweight";
        } else if (bmi >= 30) {
            status = "Obese";
        } else if (bmi < 18.5) {
            status = "Underweight";
        }
        return status;
    }
}