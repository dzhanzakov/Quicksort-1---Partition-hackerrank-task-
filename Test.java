import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Test {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();
        while(n>0){
            arr.add(input.nextInt());
            n--;
        }
        arr = quickSort(arr);
        for (Integer i: arr) {System.out.print(i+" ");}
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<arr.size(); i++){
            hm.put(i,arr.get(i));
        }
        int mid = hm.get(0);

        ArrayList<Integer> greater = new ArrayList<>();
        ArrayList<Integer> lesser = new ArrayList<>();


        for(int i = 0; i<arr.size(); i++){
            if(hm.get(i)<mid) lesser.add(hm.get(i));
        }
        for(int i = 0; i<arr.size(); i++){
            if(hm.get(i)>mid) greater.add(hm.get(i));
        }


        if(!lesser.isEmpty()){
            for(int i = 0;i<lesser.size();i++){
                hm.put(i, lesser.get(i));
            }
        }
        hm.put(lesser.size(), mid);
        if(!greater.isEmpty()){
            int count = 0;
            for(int i = lesser.size()+1;i<hm.size();i++){
                hm.put(i, greater.get(count));
                count++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0;i<hm.size();i++){
            list.add(hm.get(i));
        }

        return  list;
    }



}