package com.netcracker.edu.trainee.firstLab.entities.repository.entities;

import com.netcracker.edu.trainee.firstLab.entities.Person;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestPerson {

    /**
     * The test checks the calculateAge () method,
     * Subtract the current year since the method may not work correctly when iterating the year
     */
    @Test
    public void testCalculateAge(){
        Person testPerson = new Person();
        testPerson.setBirthdate(LocalDate.now());
        int calculatedAge = testPerson.calculateAge();

        Assert.assertEquals(0, calculatedAge);
    }
}
