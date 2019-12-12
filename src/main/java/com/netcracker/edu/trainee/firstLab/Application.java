package com.netcracker.edu.trainee.firstLab;

import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.factory.LabFactory;
import com.netcracker.edu.trainee.firstLab.service.parser.Parser;
import com.netcracker.edu.trainee.firstLab.service.repository.DynamicArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String filePath = "src" + separator + "main" + separator + "resources" + separator + "persons.csv";

        LabFactory factory = new LabFactory();
        Scanner scanner = new Scanner(new File(filePath));
        Parser parser = new Parser(scanner);

        DynamicArray dynamicArray = (DynamicArray) parser.parse();

        List<Person> persons = new ArrayList<>();
        persons = dynamicArray.toList();
        persons.stream().forEach(System.out::println);


      /*  for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }
*/
/*
        IPerson person = factory.createPerson();
        @SuppressWarnings("unchecked")
        DynamicArray<IPerson> dynamicArray2 = (DynamicArray<IPerson>) factory.createRepository(person.getClass());
        dynamicArray.add(new Person());

        dynamicArray2.get(0).setId(1000);
        System.out.println(dynamicArray.get(0).toString());
        */
    }
}
