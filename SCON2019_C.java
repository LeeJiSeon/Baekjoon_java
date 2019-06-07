import java.util.*;

public class SCON2019_C {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int T = sc.nextInt();

        int[][] time = new int[M][2];
        for(int i = 0 ; i < M ; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }


        int partytime = 0;
        int arrN[] = new int[N];

        for(int i = 0 ; i < N ; i++)
            arrN[i] = 0;

        for(int i = 1 ; i < N + 1 ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(i >= time[j][0] && i < time[j][1])
                    arrN[i - 1] += 1;
            }
        }

        int count = 0;
        ArrayList<ArrayList<Integer>> arrK = new ArrayList<ArrayList<Integer>>();

        while(count < N) {
            if(arrN[count] < T) {
                if(arrN[count] + K >= T) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    int b = arrN[count];
                    while(arrN[count] >= b && arrN[count] != T) {
                        tmp.add(K - arrN[count]);
                        count++;
                        if(count >= N)
                            break;
                    }
                    arrK.add(tmp);
                }
                else
                    count++;
            }
            else {
                count++;
                partytime++;
            }
        }

        ArrayList<ArrayList<Integer>> timeK = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i < arrK.size() ; i++) {
            int max = arrK.get(i).get(0);
            for(int j = 1 ; j < arrK.get(i).size() ; j++) {
                if(arrK.get(i).get(j) > max)
                    max = arrK.get(i).get(j);
            }
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(max + 1);
            tmp.add(arrK.get(i).size());
            timeK.add(tmp);
        }


        for(int i = 0 ; i < timeK.size() ; i++) {
            System.out.println(timeK.get(i).get(0));
            System.out.println(timeK.get(i).get(1));
        }

        ArrayList<Integer> totalTime =  new ArrayList<Integer>();
        for(int i = 0 ; i < timeK.size() ; i++) {
            int a = K - timeK.get(i).get(0);
            int total = timeK.get(i).get(1);

            if(a > 0) {
                for(int j = i + 1 ; j < timeK.size() ; j++) {
                    if(timeK.get(j).get(0) <= a) {
                        total += timeK.get(j).get(1);
                        a -= timeK.get(j).get(0);
                    }
                }
            }

            totalTime.add(total);
        }


        int totalmax = totalTime.get(0);
        for(int i = 1 ; i < totalTime.size() ; i++) {
            if(totalTime.get(i) > totalmax)
                totalmax = totalTime.get(i);
        }

        System.out.println(partytime + totalmax);
    }
}
