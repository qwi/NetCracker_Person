package com.netcracker.edu.trainee.firstLab.entities.repository.service.repository;

import com.netcracker.edu.trainee.firstLab.entities.Division;
import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.repository.DynamicArray;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TestDynamicArray {

    private Person person1 = new Person(1, "fName", "sName", LocalDate.now(), 20, Gender.MALE, new Division(1, "abc"), BigDecimal.valueOf(1000));
    private Person nullPerson = new Person(null, null, null, null, null, null, null, null);

    @Test
    public void testAddOneElement() {
        DynamicArray testArray = new DynamicArray();
        Assert.assertTrue(testArray.size() == 0);

        testArray.add(person1);
        Assert.assertTrue(testArray.size() == 1);
    }

    @Test
    public void testAddGetAndCheckOneElementFromArray() {
        DynamicArray testArray = new DynamicArray();
        testArray.add(person1);
        Assert.assertEquals(person1, testArray.get(0));
    }

    @Test
    public void testAddElementByIndexAndCheckIt() {
        DynamicArray testArray = new DynamicArray();
        testArray.add(nullPerson);
        testArray.add(0, person1);
        Assert.assertEquals(person1, testArray.get(0));
    }

    @Test
    public void testAddAndSetThisElement() {
        DynamicArray testArray = new DynamicArray();
        testArray.add(nullPerson);
        testArray.set(0, person1);
        Assert.assertEquals(person1, testArray.get(0));
    }

    @Test
    public void testDeleteOneElement() {
        DynamicArray testArray = new DynamicArray();
        testArray.add(person1);
        Assert.assertTrue(testArray.size() == 1);

        testArray.delete(0);
        Assert.assertTrue(testArray.size() == 0);
    }

    @Test
    public void testArrayToList() {
        DynamicArray testArray = new DynamicArray();
        Assert.assertTrue((testArray.toList()) instanceof List);
    }


}
