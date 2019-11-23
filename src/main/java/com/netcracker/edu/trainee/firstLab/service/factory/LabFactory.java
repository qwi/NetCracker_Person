package com.netcracker.edu.trainee.firstLab.service.factory;

import com.netcracker.edu.trainee.firstLab.entities.Division;
import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.repository.DynamicArray;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

public class LabFactory implements ILabFactory {
    /** @return Factory method returning a new person  */
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    /** @return Factory method returning a new Division*/
    @Override
    public IDivision createDivision() {
        return new Division();
    }

    /** @return Factory method returning a new repository */
    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {
        return new DynamicArray<T>();
    }

    /** @return  Factory method returning a new repository without generics */
    @Override
    public IPersonRepository createPersonRepository() {
        return null;
    }
}
