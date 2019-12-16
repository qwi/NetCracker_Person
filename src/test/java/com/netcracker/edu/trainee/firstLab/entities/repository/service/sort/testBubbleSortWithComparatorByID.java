package com.netcracker.edu.trainee.firstLab.entities.repository.service.sort;

import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.comparators.PersonComparatorByID;
import com.netcracker.edu.trainee.firstLab.service.sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.IPerson;

public class testBubbleSortWithComparatorByID {

    /**
     * The test creates an array of objects from Person,
     * sets random ID values, sorts and checks that each previous element
     * is smaller than the next
     */
    @Test
    public void testDoBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        PersonComparatorByID personComparatorByID = new PersonComparatorByID();
        Object[] array = new Object[10];

        for (int i = 0; i < 10; i++) {
            IPerson person = new Person();
            person.setId((int) (0 + (Math.random() * 500)));
            array[i] = person;
        }

        bubbleSort.doSort(array, personComparatorByID);

        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(personComparatorByID.compare(array[i], array[i + 1]) == -1);
        }
    }
}