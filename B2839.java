import java.util.*;

public class B2839 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int x, y;

        y = N / 5;
        while(y >= 0){
            x = (N - y * 5) / 3;
            if(x * 3 + y * 5 == N){
                System.out.println(x + y);
                return;
            }
            else{
                y--;
            }
        }
        System.out.println("-1");
    }
}
