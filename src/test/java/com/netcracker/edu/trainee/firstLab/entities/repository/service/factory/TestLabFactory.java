package com.netcracker.edu.trainee.firstLab.entities.repository.service.factory;

import com.netcracker.edu.trainee.firstLab.entities.Division;
import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.factory.LabFactory;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

public class TestLabFactory {

    LabFactory factory = new LabFactory();

    @Test
    public void testCreatePersonWithFactoryAndCheckInstancePerson() {
        Person testPerson = (Person) factory.createPerson();
        Assert.assertTrue(testPerson instanceof IPerson);
    }

    @Test
    public void testCreateDivisionWithFactoryAndCheckInstancePerson(){
        Division testDivision = (Division) factory.createDivision();
        Assert.assertTrue(testDivision instanceof IDivision);
    }

    @Test
    public void testCreateRepositoryWithFactoryAndCheckInstance(){
        IRepository testRepository = factory.createRepository(Person.class);
        Assert.assertTrue(testRepository instanceof  IRepository);
    }

}
