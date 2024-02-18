# Refactoring Java Code

This project is about refactoring a Java program that calculates the body mass index and displays health status of a human based on it. The original code is poorly written and does not follow any coding standards or conventions. The refactored code is based on the Google Java Style Guide, which can be found here: https://google.github.io/styleguide/javaguide.html

## Remarks

### 1. Project Naming:

* Renamed `untitled11` name of project to `bmi-calculator` – project names should use lowercase letters and hyphens, be unique and original.

### 2. Code Comments:

* Removed unnecessary comments at the beginning of the file.
* Added appropriate comments for code.

### 3. Indentation:

* Adjusted indentation throughout the code for consistency and adherence to style guide guidelines.

### 4. Variable and Class Naming:

* Renamed `humanIMB` class to `HumanBmi`, following camel case conventions and for better understanding.
* Renamed `W` and `H` variables to `weight` and `height` respectively, following camel case conventions.
* Renamed `imb` to `bmi` for better understanding.

### 5. Access Modifiers:

* Changed access modifiers of `weight`, `height`, and `bmi` to private, encapsulating them within the class.

### 6. Data Types:

* Changed `double` to `float` data type throughout the code, because double can represent much larger numbers than a float, which is unnecessary for this program.

### 7. Constructor Parameter Naming:

* Updated constructor parameters `w` and `h` to `weight` and `height` respectively for clarity.

### 8. Parentheses: 

* Added parentheses for clarity and avoiding magic numbers in calculation `bmi` throughout the code.

### 9. Documenting:

* Added `@param` and `@return` tags throughout the code for documenting parameters and return values respectively.

### 10. Getter and Setter Methods:

* Renamed getter and setter methods for `weight` and `height` to follow JavaBeans naming conventions (`getWeight`, `setWeight`, `getHeight`, `setHeight`).

### 11. Static Methods:

* Renamed `takeImt` to `getBmi` for consistency with naming conventions.
* Avoided static methods for instance fields.

### 12. Method Naming:

* Used camelCase for method name and changed it from `Result` to `calculateStatus` for better clarity.

### 13. Logical Operators:

* Replaced bitwise AND (`&`) with logical AND (`&&`) in the `Result` method for proper boolean logic.

### 14. String Declaration:

* Changed `String string = null`; to `String status = null`; for better variable naming.

### 15. Control Flow Optimization:

* Changed individual `if` statements in the `Result` method to `if-else` statements for control flow optimization. This ensures that only one branch is executed, improving efficiency and preventing unnecessary condition checks.

### 16. Result String Refactoring:

* Refactored the Result method to provide more descriptive result strings (`"Underweight", "Normal", "Overweight", "Obese"`) instead of generic terms (`"Deficit", "Norm", "Warning!", "Fat",`). This enhances the clarity and expressiveness of the output.

### 17. Readability:

* Added appropriate spaces between operators and operands for better readability.

### 18. Class Splitting(note):

* Not applied for this program. According to the Java naming conventions, each source file should contain only one public class or interface, and the file name should match the class or interface name. For example, if we have a public class named HumanBmi, we should put it in a file named HumanBmi.java. If we have another public class named Main, we should put it in a file named Main.java.
* However, we can also have non-public classes or interfaces in the same file as the public one, as long as they are not nested inside the public one. For example, we can have a file named Main.java that contains a public class Main and a non-public class HumanBMI. The non-public class or interface can only be accessed by other classes or interfaces in the same package.  

## Original Code

The original code is given below:

```java



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        humanIMB humanIMB = new humanIMB(80,1.52);
        System.out.println(humanIMB.Result());
    }
}
class humanIMB {
    public double W; //Weight Human
    public double H; // Height Human
    private static double imb;
    public humanIMB(double w, double h) {
        W = w;
        H = h;
        imb = W / (H * H);
    }
    public double takeW() {
        return W;
    }
    public void putW(double w) {
        W = w;
        imb = W / (H * H);
    }
    public double takeH() {
        return H;
    }
    public void putH(double h) {
        H = h;
        imb = W / (H * H);
    }
    public static double takeImt() {
        return imb;
    }
    public static String Result() {
        String  string = null;
        if (imb >=18.5 & imb <25) {
            string ="Norm";
        }
        if (imb >=25 & imb <30) {
            string ="Warning! ";
        }
        if (imb >=30) {
            string ="Fat";
        }
        if (imb <18.5) {
            string ="Deficit";
        }
        return string;
    }
}
```

## Refactored Code

The refactored code is given below:

```java
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
```