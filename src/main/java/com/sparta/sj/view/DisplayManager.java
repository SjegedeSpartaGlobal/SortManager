package com.sparta.sj.view;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DisplayManager {

    public void printSortedArray(int[] sortedArray, String sorter, long timeTaken){
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("Sorting using : "+ sorter);
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Time taken = "+ (df.format(timeTaken)));
    }

    public void printUnsorted(int[] unsortedArray){
        System.out.println("unsorted Array: \n"+Arrays.toString(unsortedArray));
    }
}
