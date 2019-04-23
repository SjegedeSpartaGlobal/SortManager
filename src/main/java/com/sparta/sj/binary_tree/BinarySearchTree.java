package com.sparta.sj.binary_tree;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree implements BinaryTree {

    private Node root;
    private int counter;
    private Node currentNode;
    private LinkedList<Integer> ascendingList;
    private LinkedList<Integer> descendingList;
    private LinkedList<Integer> stack;

    private static Logger logger = Logger.getLogger(BinarySearchTree.class.getName());

    public class Node {

        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


    @Override
    public int getRootElement(){
        if(root!=null) {
            return root.getValue();
        }
        return 0;
    }

    @Override
    public int getNumberOfElements(){
        return counter;
    }

    @Override
    public void addElement(int element){
        if(root==null){
            root = new Node(element);
        }else{
            addElementHelper(element, root);
        }
        counter++;
    }

    @Override
    public void addElements(int[] elements){
        for(int i=0; i<elements.length; i++){
            addElement(elements[i]);
        }
    }

    @Override
    public boolean findElement(int value){
        return findElementHelper(value, root);
    }

    //gets the left child of the current node
    @Override
    public int getLeftChild(int element){
        Node node = findNode(element, root);
        logger.info("node val: "+node.getValue()+" element: "+element+" current node: "+currentNode.getLeft().getValue());
        if(hasLeft(currentNode)){
            return currentNode.getLeft().getValue();
        }
        return 0;
    }

    //gets the right child of the current node
    @Override
    public int getRightChild(int element){
        Node node = findNode(element, root);
        logger.info("node val: "+node.getValue()+" element: "+element);
        if(hasRight(currentNode)){
            System.out.println("runs has right");
            return currentNode.getRight().getValue();
        }
        return 0;
    }

    @Override
    public List<Integer> getSortedTreeAsc(){
        return sortedListHelper(root);
    }

    @Override
    public List<Integer> getSortedTreeDesc(){
        List<Integer> ls = getSortedTreeAsc();
        List<Integer> newls = new LinkedList<Integer>();

        for(int i=ls.size()-1; i>=0; i--){
            newls.add(ls.get(i));
        }
        return newls;
    }

    public boolean hasRight(Node current){
        if(current.getRight()!=null){
            return true;
        }
        return false;
    }

    public boolean hasLeft(Node current){

        if(current.getLeft()!=null){
            return true;
        }
        return false;
    }

    //Add element in the correct place if the element is not null
    private void addElementHelper(int element, Node current){
        int currentElement =  current.getValue();
        Node node = new Node(element);
        if(element<currentElement){
            if(current.getLeft()==null){
                current.setLeft(node);
            }else if(current.getLeft()!=null){
                current = current.getLeft();
                addElementHelper(element, current);
            }
        }else if(element>currentElement){
            if(current.getRight()==null){
                current.setRight(node);
            }else if(current.getRight()!=null){
                current = current.getRight();
                addElementHelper(element, current);
            }
        }
    }

    //finds element in the correct place if the element is null returns false
    private boolean findElementHelper(int element, Node current){
        int currentElement =  current.getValue();


        if(element==currentElement){
            return true;
        }
        else if(element<currentElement){
            if(current.getLeft()==null){
                return false;
            }else if(current.getLeft()!=null){
                current = current.getLeft();
                findElementHelper(element, current);
            }
        }else if(element>currentElement){
            if(current.getRight()==null){
                return false;
            }else if(current.getRight()!=null){
                current = current.getRight();
                findElementHelper(element, current);
            }
        }
        return false;
    }

    //finds the node that matches the element
    private Node findNode(int element, Node current){
        int currentElement =  current.getValue();
        logger.info("element: "+element+" currentElement: "+currentElement);

        if(element==currentElement){
            logger.info("found node: "+current.getValue());
            currentNode = current;
            return current;
        }
        if(element<currentElement){
            if(current.getLeft()==null){
                return current;
            }else if(current.getLeft()!=null){
                current = current.getLeft();
                findNode(element, current);
            }
        }else if(element>currentElement){
            if(current.getRight()==null){
                return current;
            }else if(current.getRight()!=null){
                current = current.getRight();
                findNode(element, current);
            }
        }
        return current;
    }

    private LinkedList<Integer> sortedListHelper(Node current){
        LinkedList<Integer> ls = new LinkedList<Integer>();
        LinkedList<Integer> rightls = new LinkedList<Integer>();
        if(hasLeft(current)){
            ls = sortedListHelper(current.getLeft());
            ls.add(current.getValue());
            if(hasRight(current)){
                rightls = sortedListHelper(current.getRight());
                ls.addAll(rightls);
            }
            return ls;
        }else if(!hasLeft(current)){
            ls.add(current.getValue());
            if(hasRight(current)){
                rightls = sortedListHelper(current.getRight());
                ls.addAll(rightls);
            }
            return ls;
        }
        return ls;
    }


}