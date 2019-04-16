package com.sparta.sj.starter;


import com.sparta.sj.sorters.BinaryTreeSorter;
import com.sparta.sj.sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Starter {

    public static void main(String[] args){
        SortManager sortManager = new SortManager();
        sortManager.sortArray();
    }
}