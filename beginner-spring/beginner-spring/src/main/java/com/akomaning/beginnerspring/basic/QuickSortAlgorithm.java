package com.akomaning.beginnerspring.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm{
    public int[] sort(int[] arrNums) {
        //QuickSort Logic
        return arrNums;
    }
}
