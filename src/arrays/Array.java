package arrays;
import java.util.Scanner;

public class Array {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Hello");
        // create a program using arrays that sort a list of integers in descending order
        System.out.print("How many integers do you want?\n");
        int nIntegers = scanner.nextInt();
        int[] integers = getIntegers(nIntegers);
        int[] sortedIntegers = sortArray(integers);
        System.out.println("Below is your integers:\n");
        printArray(integers);
        System.out.println("Below is your sorted integers:\n");
        printArray(sortedIntegers);
    }

    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for(int i = 0; i< array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array){

        for(int i = 0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static int[] sortArray(int[] array){
        int[] sortedArray = new int[array.length];
        // Created the copy of original array
        for(int i = 0; i< array.length; i++){
            sortedArray[i] = array[i];
        }
        boolean flag= true;

        while(flag){
            flag = false;
            for(int i = 0; i<sortedArray.length-1; i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
