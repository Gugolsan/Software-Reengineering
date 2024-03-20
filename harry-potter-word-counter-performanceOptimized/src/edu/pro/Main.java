package edu.pro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class for processing a text file and displaying word frequencies.
 *
 * @author Volodymyr Voroniuk
 * @project harry-potter-word-counter
 * @class Main
 * @version 1.0.2
 * @since 11.03.24 - 11.10
 */
public class Main {

    // Constant for the file path to make it easy to change the file location if necessary
    public static final String FILE_PATH = "src/edu/pro/txt/harry.txt";

    public static void main(String[] args) throws IOException {

        // Record the start time for performance measurement
        LocalDateTime start = LocalDateTime.now();

        // Define the pattern to match words using a regular expression
        Pattern wordPattern = Pattern.compile("[A-Za-z]+");

        // Create a map to store word frequencies
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Open a BufferedReader to read the file line by line for efficiency
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // Read each line from the file
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // Use Matcher to find words in the currentLine
                Matcher matcher = wordPattern.matcher(currentLine.toLowerCase());

                // Find each word and count its frequency
                while (matcher.find()) {
                    String word = matcher.group();
                    // Update the frequency count for each word in the map
                    wordFrequencies.merge(word, 1, Integer::sum);
                }
            }
        }

        // Print the top 30 most frequent words
        System.out.println("Words and their frequency:\n");
        // Convert the map entries to Word objects and sort by frequency
        wordFrequencies.entrySet().parallelStream()
                .map(entry -> new Word(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(Word::getFrequency).reversed())
                .limit(30) // Limit the sorted stream to the top 30 words
                .forEach(System.out::println);

        // Record the finish time for performance measurement
        LocalDateTime finish = LocalDateTime.now();

        // Print the time taken to process
        System.out.println("------");
        // Calculating the duration of the execution in milliseconds
        System.out.println("Execution duration of app is " + ChronoUnit.MILLIS.between(start, finish) + " milliseconds");
    }
}
