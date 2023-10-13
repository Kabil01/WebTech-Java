import java.util.HashSet;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 2, 3, 4, 4, 5};

        // Convert the array to a HashSet to remove duplicates
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int num : originalArray) {
            uniqueSet.add(num);
        }

        // Convert the HashSet back to an array
        int[] newArray = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            newArray[index] = num;
            index++;
        }

        // Print the array with duplicates removed
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Array with Duplicates Removed: " + Arrays.toString(newArray));
    }
}

