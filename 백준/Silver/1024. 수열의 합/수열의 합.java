import java.io.*;
import java.util.*;
 
public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        
        int x = -1;
        int t = -1;
        int len = -1;
        
        for (int i = L; i <= 100; i++)
        {
            t = (i - 1) * i / 2;
            if ((N - t) % i == 0)
            {
                x = (N - t) / i;
                len = i;
                break;
            }
        }
        
        int res = 0;
        if (x < 0)
        {
            System.out.println(-1);
        } else
        {
            for (int i = 0; i < len; i++)
            {
                System.out.print(x + i + " ");
            }
        }
    }
}