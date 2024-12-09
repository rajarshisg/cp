/**
 * Problem Link - Problem Link - https://cses.fi/problemset/task/1652
 */
import java.io.*;
import java.util.*;

public class Solution {

    private static long forestQueries(long[][] prefix, int l1, int r1, int l2, int r2) {
        long trees = prefix[l2][r2];
        trees -= (l1 > 0) ? prefix[l1 - 1][r2] : 0;
        trees -= (r1 > 0) ? prefix[l2][r1 - 1] : 0;
        trees += (l1 > 0 && r1 > 0) ? prefix[l1 - 1][r1 - 1] : 0;
        return trees;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader to read from terminal input (console)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // PrintWriter to write to terminal output (console)
        PrintWriter out = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[][] prefix = new long[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int j = 0;
            for (char c : line.toCharArray()) {
                prefix[i][j] = c == '.' ? 0 : 1;
                prefix[i][j] += (i > 0) ? prefix[i - 1][j] : 0;
                prefix[i][j] += (j > 0) ? prefix[i][j - 1] : 0;
                prefix[i][j] -= (i > 0 && j > 0) ? prefix[i - 1][j - 1] : 0;
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();

        // Process each queries
        while (q-- > 0) {
            String delimeter = " ";
            st = new StringTokenizer(br.readLine(), delimeter);
            
            int l1 = Integer.parseInt(st.nextToken()) - 1; 
            int r1 = Integer.parseInt(st.nextToken()) - 1;  
            int l2 = Integer.parseInt(st.nextToken()) - 1; 
            int r2 = Integer.parseInt(st.nextToken()) - 1;  
            
            sb.append(Long.toString(forestQueries(prefix, l1, r1, l2, r2)));
            sb.append("\n");
        }
        
        out.print(sb.toString());
        
        // Close resources
        br.close();
        out.close();
    }
}
    