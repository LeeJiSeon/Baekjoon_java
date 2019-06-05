import java.util.*;

public class B10815 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrN = new int[N];
        for(int i = 0 ; i < N ; i++)
            arrN[i] = sc.nextInt();

        int M =  sc.nextInt();
        int[] arrM = new int[M];
        for(int i = 0 ; i < M ; i++)
            arrM[i] = sc.nextInt();

        Arrays.sort(arrN);

        int low;
        int high;
        int mid;

        boolean isSearch;

        for(int i = 0 ; i < M ; i++) {
            isSearch = false;
            low = 0;
            high = N - 1;
            while (low <= high) {
                mid = (low + high) / 2;

                if (arrN[mid] == arrM[i]) {
                    isSearch = true;
                    break;
                } else {
                    if (arrN[mid] < arrM[i]) {
                        low = mid + 1;
                    } else if (arrN[mid] > arrM[i]) {
                        high = mid - 1;
                    }
                }
            }
            if (isSearch)
                arrM[i] = 1;
            else
                arrM[i] = 0;
            System.out.print(arrM[i] + " ");
        }
    }
}
