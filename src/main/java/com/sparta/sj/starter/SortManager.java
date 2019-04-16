package com.sparta.sj.starter;

import com.sparta.sj.sorters.Sorter;
import com.sparta.sj.view.DisplayManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Random;

public class SortManager {

    private Logger log = Logger.getLogger(SortManager.class.getName());

    {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    public void sortArray() {
        log.trace("Hello");
        int[] unsortedArray = generatorArray(20);
        Sorter sorter = SortFactory.getInstance();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray.clone());
        long end = System.nanoTime();

        DisplayManager displayManager = new DisplayManager();
        displayManager.printUnsorted(unsortedArray);
        displayManager.printSortedArray(sortedArray, sorter.toString(), end-start);
    }

    //add random array number generator
    private int[] generatorArray(int amount){
        Random rand = new Random();
        int[] a = new int[amount];
        for(int i=0; i<amount; i++){
            a[i] = rand.nextInt(1000);
        }
        return a;
    }

}
