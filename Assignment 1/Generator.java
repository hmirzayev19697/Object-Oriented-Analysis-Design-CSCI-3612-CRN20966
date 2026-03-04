/*
Full Name: Huseyn Mirzayev
Project Name: Random Numbers Generation and their Statistical Analysis
Class: Object Oriented Analysis & Design (CRN - 20966)
Date: February 9, 2026
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


// Class definition example
public class Generator {
    
    // Class attributes example (and accessibility example - "private")
    private int[] selectedValuesN = {12, 254, 10000}; // selected values of n
    private int[] generatorTypes = {1, 2, 3};
    private Random random;
    
    // Accessibility example - public (constructor)
    public Generator() {
        this.random = new Random();
    }
    
    /*
    Populate Method Definition 
    Generates and returns an ArrayList of n random double values in [0, 1) using specified generator.
    
    Parameters: 
    n - number of random values to generate
    randNumGen - generator type: 1 = Random, 2 = Math.random(), 3 = ThreadLocalRandom
    */
    public ArrayList<Double> populate(int n, int randNumGen) {
        // Object Instantiation Example - instantiating an ArrayList
        ArrayList<Double> randomValues = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            double value = 0.0;
            
            switch (randNumGen) {
                case 1:
                    value = random.nextDouble();
                    break;
                case 2:
                    value = Math.random();
                    break;
                case 3:
                    value = ThreadLocalRandom.current().nextDouble();
                    break;
                default:
                    System.out.println("This wasn't supposed to happen!!!! Invalid generator type: " + randNumGen);
                    return randomValues;
            }
            
            randomValues.add(value);
        }
        
        return randomValues;
    }
    
    /*
    Calculates descriptive statistics for the random values.
    Parameter: This method takes as an input randomValues - ArrayList of random doubles.
    Eventually returns an ArrayList containing [n, mean, stddev, min, max].
    */
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        ArrayList<Double> results = new ArrayList<>();
        
        int n = randomValues.size();
        
        // Calculate min and max
        double sum = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        for (double value : randomValues) {
            sum += value;
            if (value < min) min = value;
            if (value > max) max = value;
        }
        
        // calculates mean
        double mean = sum / n;
        
        // Calculates sample standard deviation using formula: sqrt(sum((x_i - mean)^2) / (n - 1))
        double sumSquaredDifferences = 0.0;
        for (double value : randomValues) {
            double difference = value - mean;
            sumSquaredDifferences += difference * difference;
        }
        
        double stddev = Math.sqrt(sumSquaredDifferences / (n - 1));
        
        // Returns results in order: [n, mean, stddev, min, max]
        results.add((double) n);
        results.add(mean);
        results.add(stddev);
        results.add(min);
        results.add(max);
        
        return results;
    }
    
    /*
    Accessibility example - public.
    Displays statistical results in tabular format.
    results - ArrayList containing [n, mean, stddev, min, max]
    headerOn - true to display column headers
    */
    public void display(ArrayList<Double> results, boolean headerOn) {
        if (headerOn) {
            System.out.println("========================================================================");
            System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", 
                            "n", "Mean", "Std Dev", "Min", "Max");
            System.out.println("========================================================================");
        }
        
        if (results == null || results.size() != 5) {
            System.out.println("Error: Oh no, something is wrong with my results(((");
            return;
        }
        
        int n = results.get(0).intValue();
        double mean = results.get(1);
        double stddev = results.get(2);
        double min = results.get(3);
        double max = results.get(4);
        
        System.out.printf("%-15d %-15.6f %-15.6f %-15.6f %-15.6f%n", 
                        n, mean, stddev, min, max);
    }
    
    /*
    Executes the complete analysis for all combinations of selected sizes
    and random number generators (9 total results at the end).
    */
    public void execute() {
        System.out.println("\nRandom Number Generator Statistical Analysis");
        System.out.println("=====================================================");
        
        int resultNumber = 0;
        
        // Executes each random number generator
        for (int genType : generatorTypes) {
            String generatorName = getGeneratorName(genType);
            System.out.println("\nGenerator: " + generatorName);
            
            boolean firstResult = true;
            
            // Executes each selected sample size
            for (int n : selectedValuesN) {
                ArrayList<Double> randomValues = populate(n, genType);
                ArrayList<Double> stats = statistics(randomValues);
                display(stats, firstResult);
                firstResult = false;
                resultNumber++;
            }
        }
        
        System.out.println("\n========================================================================");
        System.out.println("Analysis complete. Total results: " + resultNumber);
        System.out.println("========================================================================\n");
    }
    
    // Accessibility example - private method to get Generators' Name (only used internally, hence private)
    private String getGeneratorName(int genType) {
        switch (genType) {
            case 1:
                return "java.util.Random";
            case 2:
                return "Math.random()";
            case 3:
                return "java.util.concurrent.ThreadLocalRandom";
            default:
                return "Unknown Generator :)";
        }
    }
    
    /*
    Main method that starts our program.
    Accessibility example: Here it is public static, which is required for JVM to run the program
    */
    public static void main(String[] args) {
        // Object Instantiation Example
        Generator g = new Generator();
        g.execute();
    }
}
