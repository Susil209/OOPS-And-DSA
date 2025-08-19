package com.java.TCSCodevitaQuestions;

import java.util.*;

public class Constellation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input N and then the 3xN grid.
        System.out.print("Enter the number of grid columns (N): ");
        int n = scanner.nextInt();

        // Consume the newline character left by nextInt()
        scanner.nextLine();

        String[] grid = new String[3];
        System.out.println("Enter the 3x" + n + " grid row by row:");
        for (int i = 0; i < 3; i++) {
            grid[i] = scanner.nextLine();
        }

//        System.out.println(Arrays.toString(grid));

        /*
         * For N = 18
         * grid(3 X 18)= {
         * "*.*#***#***#***.*.",
         * "*.*#*.*#.*.#*******",
         * "***#***#***#*****.*"
         * }
         */

        // Initialize an empty result string builder.
        StringBuilder result = new StringBuilder();

        // Create a map of flattened patterns to their corresponding vowels for efficient lookup.
        Map<String, Character> patterns = new HashMap<>();
        patterns.put(".*.****.*", 'A');
        patterns.put("*********", 'E');
        patterns.put("***.*.***", 'I');
        patterns.put("****.****", 'O');
        patterns.put("*.**.****", 'U');

        /*
         * Vowel Patterns (3x3 grid flattened into a 9-char string):
         * A = .*.,***,*.* -> ".*.****.*"
         * E = ***,***,*** -> "*********"
         * I = ***,.*.,*** -> "***.*.***"
         * O = ***,*.*,*** -> "****.****"
         * U = *.*,*.*,*** -> "*.**.****"
         */

        // Traverse grid columns. The index 'i' is manually incremented inside the loop.
        for (int i = 0; i < n; ) {
            // Check for and skip columns that are completely empty (all dots).
            if (grid[0].charAt(i) == '.' && grid[1].charAt(i) == '.' && grid[2].charAt(i) == '.') {
                i++;
                continue;
            }

            // If a column starts with '#', it's a delimiter.
            if (grid[0].charAt(i) == '#') {
                result.append('#');
                i++; // Move to the next column.
            } else {

                // If it's not a delimiter, it must be a 3-column wide character pattern.
                // Extract the 3x3 grid section and flatten it into a single string.
                String pattern = grid[0].substring(i, i + 3) +
                        grid[1].substring(i, i + 3) +
                        grid[2].substring(i, i + 3);

                System.out.println("Pattern: " + pattern);
                // Look up the pattern in the map and append the corresponding vowel.
                if (patterns.containsKey(pattern)) {
                    result.append(patterns.get(pattern));
                }

                i += 3; // Move past the 3 columns that form the character.
            }
        }

        System.out.println("result: " + result);

        scanner.close();
    }
}
