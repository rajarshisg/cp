import java.io.*;
import java.util.*;
 
public class Solution {
 
    // Main function to choose between file or terminal input/output
    public static void main(String[] args) throws IOException {
        // BufferedReader to read from terminal input (console)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        long x = Integer.parseInt(st.nextToken());
        long count = 0, sum = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            long num = Long.parseLong(st.nextToken());
            sum += num;
 
            if (map.containsKey(sum - x)) {
                count += map.get(sum - x);
            }
 
            map.put(sum, map.getOrDefault(sum, 0L) + 1L);
        }
 
        System.out.println(count);

        // Close resources
        br.close();
    }
}
 