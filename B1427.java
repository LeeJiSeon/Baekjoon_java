import java.util.*;
public class B1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("");
        ArrayList<Integer>  num = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){
            num.add(Integer.parseInt(arr[i]));
        }

        Collections.sort(num);
        Collections.reverse(num);

        for(int i = 0 ; i < num.size() ; i++)
            System.out.print(num.get(i));
    }
}
