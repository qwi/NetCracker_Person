package com.netcracker.edu.trainee.firstLab.service.parser;

import com.netcracker.edu.trainee.firstLab.entities.Division;
import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.repository.DynamicArray;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Parser {

    private Scanner scanner;
    private Map<String, Division> divMap = new HashMap<>();

    public Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return repository where received objects from the file are stored
     * The method passes the file line by line, splits the file into an array of strings and
     * puts the obtained values in Person objects. Objects are placed in Repository
     */
    public IRepository<IPerson> parse() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        IRepository<IPerson> resultList = new DynamicArray<>();
        scanner.nextLine();

        while (scanner.hasNext()) {
            Person person = new Person();
            String[] array = scanner.nextLine().split(";");

            person.setId(Integer.valueOf(array[0]));
            person.setFirstName(array[1]);
            if (array[2].contains("Male")) {
                person.setGender(Gender.MALE);
            } else person.setGender(Gender.FEMALE);
            person.setBirthdate(LocalDate.parse(array[3], formatter));
            person.setDivision(getDivision(array[4]));
            person.setSalary(BigDecimal.valueOf(Integer.parseInt(array[5])));
            person.setAge(person.calculateAge());

            resultList.add(person);

        }
        return resultList;
    }

    /**
     * @param line - the name of the division
     * @return An object of type Division
     * The method checks for the presence of a key in the map.
     * If there is, gives the finished value. If not, adds a new division
     */
    private IDivision getDivision(String line) {
        if (divMap.containsKey(line)) {
            return divMap.get(line);
        } else {
            Division resDiv = new Division(Division.randomID(), line);
            divMap.put(line, resDiv);
            return resDiv;
        }
    }
}
