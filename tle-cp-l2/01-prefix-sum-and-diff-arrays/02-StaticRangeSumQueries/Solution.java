/**
 * Problem Link - https://cses.fi/problemset/task/1646/
 */
import java.io.*;
import java.util.*;
 
public class Solution {
 
    // Main function to choose between file or terminal input/output
    public static void main(String[] args) throws IOException {
        // BufferedReader to read from terminal input (console)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
 
        long[] prefix = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < prefix.length; i++) {
            if (i == 0) prefix[i] = Long.parseLong(st.nextToken());
            else prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
        }
 
        StringBuilder sb = new StringBuilder();
 
        // Process each test case
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int l = Integer.parseInt(st.nextToken()) - 1;  // Read first integer
            int r = Integer.parseInt(st.nextToken()) - 1;  // Read second integer
            
            sb.append(Long.toString(prefix[r] - ((l - 1) >= 0 ? prefix[l - 1] : 0)));
            sb.append("\n");
        }
 
        System.out.println(sb.toString());
        
        // Close resources
        br.close();
    }
}