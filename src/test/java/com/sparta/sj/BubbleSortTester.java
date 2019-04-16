package com.sparta.sj;

import com.sparta.sj.sorters.BubbleSorter;
import com.sparta.sj.sorters.Sorter;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTester {

    private Sorter sorter = new BubbleSorter();

    @Test
    public void testLength(){
        int[] unsorted = {3,1,7,5,2,8};
        int[] sorted = sorter.sortArray(unsorted);
        assertEquals(unsorted.length, sorted.length);
    }

    @Test
    public void testEmptyArray(){
        int[] unsorted = {};
        int[] sorted = sorter.sortArray(unsorted);
        assertEquals(unsorted, unsorted);
        assertArrayEquals(unsorted, sorted);
    }

    @Test
    public void testZeros(){
        int[] unsorted = {0,3,4,5,0,34,6};
        int[] sorted = sorter.sortArray(unsorted);
        assertArrayEquals(unsorted, sorted);
    }

    @Test
    public void testNegative(){
        int[] unsorted = {0,3,4,-5,0,-34,6};
        int[] sorted = sorter.sortArray(unsorted);
        assertArrayEquals(unsorted, sorted);
    }

    @Test
    public void testName(){
        String msg = sorter.toString();
        assertEquals("Bubble sort", msg);
    }

    @Test
    public void testLetters(){
        char[] unsorted = {'a', '1', '9', 'b'};
//        int[] sorted = sorter.sortArray(unsorted);
    }

    @Test
    public void testDuplicates(){
        int[] unsorted = {2,4,5,5,6,-1,0,4};
        boolean unsortedHasDuplicates = hasDuplicates(unsorted);
        int[] sorted = sorter.sortArray(unsorted);
        boolean sortedHasDuplicates = hasDuplicates(sorted);
        if(unsortedHasDuplicates&&sortedHasDuplicates){
            System.out.println("has duplicates");
            assertArrayEquals(unsorted, sorted);
        }
    }

    public boolean hasDuplicates(int[] array){
        boolean hasNoDuplicates = true;
        int next = 0;
        int occourance = 0;
        for(int i=0; i<array.length; i++){
            next = array[i];
            occourance = 0;
            for(int j=0; j<array.length; j++){
                if(next==array[j]){
                    occourance++;
                    if(occourance>1){
                        hasNoDuplicates = false;
                        break;
                    }
                }
            }
            if(!hasNoDuplicates){
                break;
            }
        }
        return hasNoDuplicates;
    }

    @Test
    public void testisSorted(){
        int[] unsorted = {2,4,9,5,3,1};
        int[] sorted = sorter.sortArray(unsorted);
        assertArrayEquals(sorted, sorted);
    }
    
    @Test
    public void testSorted(){
        int[] unsorted = {2,4,9,5,3,1};
        int[] sorted = sorter.sortArray(unsorted);
        boolean isSorted = true;
        for(int i=1; i<sorted.length; i++) {
            if (sorted[i - 1] > sorted[i]) {
                isSorted = false;
                assert (isSorted);
            }
        }
    }
}
