package com.netcracker.edu.trainee.firstLab.service.sort;

import java.util.Comparator;

public interface ISorter<T> {
    public void doSort(T[] array, Comparator<T> comparator);
}
