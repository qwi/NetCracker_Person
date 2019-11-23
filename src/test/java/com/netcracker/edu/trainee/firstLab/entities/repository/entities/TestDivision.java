package com.netcracker.edu.trainee.firstLab.entities.repository.entities;

import com.netcracker.edu.trainee.firstLab.entities.Division;
import org.junit.Assert;
import org.junit.Test;

public class TestDivision {

    /**
     * Range 0 - 200_000
     * Check for range compliance
     */
    @Test
    public void testRandomNumberOnRange() {
        int randomIdValue = Division.randomID();
        Assert.assertTrue(randomIdValue > 0);
        Assert.assertTrue(randomIdValue < 200000);
    }
}
