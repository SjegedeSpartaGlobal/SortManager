package com.sparta.sj.sorters;

public class MergeSorter implements Sorter {

    public int[] mergeSort(int[] array){
        int length = array.length;
        int half = length/2;
        int[] left = new int[half];
        int[] right = new int[half];
        int counterLeft = 0;
        int counterRight = 0;
        int remainderLeft = 0;
        int remainderRight = 0;

        if(array.length==1){
            return array;
        }

        if(length%2!=0){
            right = new int[half+1];
        }
        for(int i=0; i<length; i++){
            if(i<half) {
                left[i] = array[i];
            }
            else if(i>=half){
                right[i-half] = array[i];
            }
        }

        mergeSort(left);
        mergeSort(right);

        for(int k=0; k<length; k++){
            remainderLeft = left.length - counterLeft;
            remainderRight = right.length - counterRight;

            if(counterLeft<left.length&&counterRight<right.length) {
                if ((left[counterLeft] <= right[counterRight])) {
                    array[k] = left[counterLeft];
                    counterLeft++;
                } else if (right[counterRight] < left[counterLeft]) {
                    array[k] = right[counterRight];
                    counterRight++;
                }
            }
            else if(counterRight>=right.length&&remainderLeft>remainderRight){
                array[k] = left[counterLeft];
                counterLeft++;
            }
            else if(counterLeft>=left.length&&remainderRight>remainderLeft){
                array[k] = right[counterRight];
                counterRight++;
            }
        }

        return array;

    }
    @Override
    public int[] sortArray(int[] unsortedArray){
        return mergeSort(unsortedArray);
    }

    @Override
    public String toString(){
        return "Merge sort";
    }
}
