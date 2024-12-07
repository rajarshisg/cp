# Sublime Text Setup Guide for Competitive Programming with Java (MacOS)

This guide will walk you through the process of setting up Sublime Text for competitive programming in Java. We will configure Sublime Text for efficient coding, including automatic compilation and execution of Java code, using custom snippets and build systems.

## Prerequisites

Before you start, ensure you have:

- **Sublime Text** installed on your machine (download from [here](https://www.sublimetext.com/)).
- **Java Development Kit (JDK)** installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

Make sure `java` and `javac` are in your system's `PATH` by running `javac --version` and `java --version`.

## Step 1: Install Java Build System in Sublime Text

Sublime Text does not have a built-in Java build system, but you can easily set one up.

1. Open **Sublime Text**.
2. Go to **Tools > Build System > New Build System**.
3. Replace the content with the following:

   ```json
   {
     "shell_cmd": "javac $file && java $file_base_name"
   }
   ```

   This build system tells Sublime Text to compile the Java file using `javac`, and then run it using `java`.

4. Save the build system file as `Java.sublime-build`.

## Step 2: Create Java Snippets for Competitive Programming

Snippets in Sublime Text allow you to quickly insert commonly used code patterns.

1. Go to **Tools > Developer > New Snippet**.
2. Replace the content of the snippet file with the following code for a typical Java template:

   ```xml
   <snippet>
       <content><![CDATA[
   import java.io.*;
   import java.util.*;

   public class ${1:Solution} {  <!-- Placeholder for the class name -->

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
               out.write(Integer.toString(a + b));  // Convert the sum to a string
               out.newLine();  // Move to the next line in the file
           }

           out.flush();  // Ensure that everything is written to the file

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
   ]]></content>
       <tabTrigger>cpjava</tabTrigger>
       <scope>source.java</scope>
   </snippet>
   ```

3. Save this snippet as `cpjava.sublime-snippet` in your Sublime Text packages folder (navigate to **Preferences > Browse Packages** and save it under the `User` folder).

## Step 3: Create a Sublime Workspace

1. Open a new folder in Sublime.
2. Create three files under this folder `Solution.java`, `input.txt` and `output.txt`.
3. Inside `Solution.java` type `cpjava + Tab`, this will load the boilerplate code we saved earlier in `cpjava.sublime-snippet`.
4. To set-up the three files in a grid layout do `View > Layout > Columns 3` and `View > Groups > Max Columns: 2`.
5. Adjust the grid sizes and place the files as per your convenience.
6. Save this folder as a sublime project `Project > Save Project As...`
7. Open this project anytime using `Project > Open Project...` and navigating to the folder we created and selecting the `*.sublime-workspace` file

## Step 4: Executing code

1. Enter the input in `input.txt` and write your code in `Solution.java`.
2. Setup the default build system by navigating to `Tools > Build System` and select `Java` as the default build system (needs to be done only for first time).
3. Finally press `CMD + B` and you should see the output in the `output.txt` file.
