import java.io.*;
import java.util.*;

public class Solution {

    // This method handles file input/output (for localhost)
    private static void fileMain() throws IOException {
        // BufferedReader to read input from file
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
        // BufferedWriter to write output to file
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        int tc = Integer.parseInt(br.readLine()); // Read number of test cases

        // Process each test case
        while (tc-- > 0) {
            String delimeter = " ";
            StringTokenizer st = new StringTokenizer(br.readLine(), delimeter);
            
            int a = Integer.parseInt(st.nextToken());  // Read first integer
            int b = Integer.parseInt(st.nextToken());  // Read second integer
            
            // Output result to file
            out.write(Integer.toString(a + b));  // Convert the sum to a string
            out.newLine();  // Move to the next line in the file
        }
        
        // Ensure that everything is written to the file
        out.flush();
        
        // Close resources
        br.close();
        out.close();
    }

    // This method handles terminal input/output (for online judges)
    private static void terminalMain() throws IOException {
        // BufferedReader to read from terminal input (console)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // PrintWriter to write to terminal output (console)
        PrintWriter out = new PrintWriter(System.out);
        
        int tc = Integer.parseInt(br.readLine()); // Read number of test cases
        
        // Process each test case
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());  // Read first integer
            int b = Integer.parseInt(st.nextToken());  // Read second integer
            
            // Output result to terminal
            out.println(a + b);  // You can also use out.print for no newline
        }
        
        // Close resources
        br.close();
        out.close();
    }

    // Main function to choose between file or terminal input/output
    public static void main(String[] args) throws IOException {
        // Choose the appropriate method based on the input/output requirement
        fileMain(); // Use this for file-based input/output
        // terminalMain(); // Use this for terminal-based input/output
    }
}
    