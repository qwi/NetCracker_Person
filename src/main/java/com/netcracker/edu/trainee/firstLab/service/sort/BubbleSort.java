package com.netcracker.edu.trainee.firstLab.service.sort;

import java.util.Comparator;

public class BubbleSort<T> implements ISorter<T>{

    /**
     * @param array - array of objects
     * @param comparator - comparator to get comparison rules
     * @return sorted array of objects
     */
    @Override
    public void doSort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T temp = (T) array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
