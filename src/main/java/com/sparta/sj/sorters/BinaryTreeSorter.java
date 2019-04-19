package com.sparta.sj.sorters;


import com.sparta.sj.binary_tree.BinarySearchTree;

import java.util.LinkedList;

public class BinaryTreeSorter implements Sorter {

    private BinarySearchTree bst = new BinarySearchTree();



    @Override
    public int[] sortArray(int[] unsortedArray) {
        LinkedList<Integer> ls = new LinkedList<Integer>();
        bst.addElements(unsortedArray);
        ls = (LinkedList<Integer>) bst.getSortedTreeAsc();
        int[] a = new int[ls.size()];


        for(int i=0; i<ls.size(); i++){
            a[i] = ls.get(i);
        }
        return a;
    }

    @Override
    public String toString(){ return "Binary sort"; }
}
