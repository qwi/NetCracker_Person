package com.netcracker.edu.trainee.firstLab.service.repository;

import lombok.EqualsAndHashCode;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@EqualsAndHashCode
public class DynamicArray<T> implements IRepository<T> {

    /**
     * INIT_SIZE - a field that specifies the size of the array
     */
    private final int INIT_SIZE = 16;
    /**
     * CUT_RATE - variable with which we check and cut the array
     */
    private final int CUT_RATE = 4;
    /**
     * Person[] array - array of persons in size INIT_SIZE
     */
    private Object[] array = new Object[INIT_SIZE];
    /**
     * the pointer of array
     */
    private int pointer = 0;

    /**
     * @param person what are you going to add
     *               Add a new item to the list. When the size of the internal array is reached, it increases by 2 times
     */
    public void add(T person) {
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        array[pointer++] = person;

    }

    /**
     * @param index  number in which to insert the item
     * @param person what are you going to add
     *               Add a new item to the list. When the size of the internal array is reached, it increases by 2 times
     */
    public void add(int index, T person) {
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        for (int i = pointer; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = person;
        pointer++;

    }

    /**
     * @param index the number of the item you want to return
     * @return an element from an array by index
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * @param index the number of the item you want to delete
     *              remove an element from the array by index
     *              If, after deleting an element, the number of elements in CUT_RITE
     *              is less than the size of the internal array, IT is reduced to save space
     */
    public T delete(int index) {
        T deleteItem = (T) array[index];
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
        return deleteItem;
    }

    /**
     * @param index    - the index of the element
     * @param newValue - the new value for the element
     * @return the element that previously existed at the specified index
     * Throws ArrayIndexOutOfBoundsException
     */
    public T set(int index, T newValue) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        T old = (T) array[index];
        array[index] = newValue;
        return old;
    }


    /**
     * @return the length of the array
     */
    public int size() {
        return pointer;
    }

    /**
     * @return a list of persons
     */
    public List<T> toList() {
        return (List<T>) Arrays.asList(array);
    }

    /**
     *
     * @param comparator
     */
    @Override
    public void sortBy(Comparator<T> comparator) {
       /* for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T temp = (T) array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }*/
    }

    /**
     * @param condition - the condition for the search
     * @return repository with found objects
     */
    @Override
    public IRepository<T> searchBy(Predicate<T> condition) {
        IRepository<T> repository = new DynamicArray<>();
        for (int i = 0; i < size(); i++) {
            if (condition.test((T) array[i])) {
                repository.add((T) array[i]);
            }
        }
        return repository;
    }


    /**
     * @param newLength a method that increases the size of an array when it overflows
     */
    private void resize(int newLength) {
        IPerson[] newArray = new IPerson[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}

