package HashProblems;
import java.util.HashSet;

public class subset{
    public static Boolean IscheckSubset(int arr1[], int arr2[]){
        HashSet<Integer> hashset = new HashSet<>();
        for (int num: arr1){
            hashset.add(num);
        }
        for(int num: arr2){
            if(!hashset.contains(num)){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {4,3,2};
        if(IscheckSubset(arr1, arr2)){
            System.out.println("YESSSS!!!!");
        }
        else{
            System.out.println("Noooo!!!");
        }
    }

}
