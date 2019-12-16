package com.netcracker.edu.trainee.firstLab.entities.repository.service.reflexion;

import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.exceptions.InjectorException;
import com.netcracker.edu.trainee.firstLab.service.reflexion.Reflector;
import com.netcracker.edu.trainee.firstLab.service.repository.DynamicArray;
import com.netcracker.edu.trainee.firstLab.service.sort.BubbleSort;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class TestReflection {
    @Test
    public void testCheckWhatReturnReflection() throws NoSuchFieldException, IllegalAccessException, InjectorException {
        DynamicArray<Person> repository = new DynamicArray<>();
        Reflector.inject(repository);
        Field field = repository.getClass().getDeclaredField("sort");
        field.setAccessible(true);
        assertEquals(field.get(repository).getClass(), BubbleSort.class);
    }
}
