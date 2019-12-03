package com.netcracker.edu.trainee.firstLab.service.sort;

import java.util.Comparator;

public class SelectionSort<T> implements ISorter<T> {

    @Override
    public void doSort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int compare = comparator.compare(array[i], array[j]);
                if (compare > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
