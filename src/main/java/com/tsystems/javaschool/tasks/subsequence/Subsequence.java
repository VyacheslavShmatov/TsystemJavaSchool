package com.tsystems.javaschool.tasks.subsequence;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subsequence {

    /**
     * Author: Vyacheslav Shmatov
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        // TODO: Implement the logic here

        if (x == null || y == null) throw new IllegalArgumentException(); //Exception if list doesn't exist

        if (x.isEmpty()) return true; //For X empty's list, it going to be subsequence of Y

        if (x.size() > y.size()) return false; //False if list X larger than Y, so X can't be subsequence of Y


        Queue yQueue = new LinkedList<>(y);//using Queue data Structure
        Queue xQueue = new LinkedList<>(x);//using Queue data Structure

        Object xItem;
        Object yItem;


        xItem = xQueue.remove();
        while (!yQueue.isEmpty()) //removing items from X until y list is not emtpy
        {
            yItem = yQueue.remove();
            if (yItem.equals(xItem)) {
                if (xQueue.isEmpty()) return true;
                xItem = xQueue.remove();
            }
        }
        return false;
    }
}
