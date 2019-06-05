import java.util.*;

public class B1026 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];

        for(int i = 0 ; i < N ; i++)
            A[i] = sc.nextInt();
        for(int i = 0 ; i < N ; i++) {
            B[i] = sc.nextInt();
            C[i] = B[i];
        }


        Arrays.sort(A);
        int[] result = new int[N];
        for (int i = 0 ; i < A.length ; i++){
            int max = C[0];
            int index = 0;
            for (int j = 1; j < B.length; j++) {
                if (C[j] > max) {
                    max = C[j];
                    index = j;
                }
            }
            result[index] = A[i];
            C[index] = -1;
        }

        int sum = 0;

        for(int i = 0 ; i < N ; i++){
            sum += result[i] * B[i];
        }

        System.out.println(sum);

    }
}
