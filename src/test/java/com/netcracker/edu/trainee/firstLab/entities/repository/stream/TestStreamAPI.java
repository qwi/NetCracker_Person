package com.netcracker.edu.trainee.firstLab.entities.repository.stream;

import com.netcracker.edu.trainee.firstLab.entities.Person;
import com.netcracker.edu.trainee.firstLab.service.parser.Parser;
import com.netcracker.edu.trainee.firstLab.service.repository.DynamicArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI {

    String separator = File.separator;
    String filePath = "src" + separator + "main" + separator + "resources" + separator + "persons.csv";

    Scanner scanner;

    {
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("File persons.cvs not found!");
            e.printStackTrace();
        }
    }

    Parser parser = new Parser(scanner);

    DynamicArray collection = (DynamicArray) parser.parse();

    /*
    Выдать людей которые старше 30 лет,
    в фамилии есть буква "А" и
    зарплата которых меньше Б 5000(получить список)
     */
    @Test
    public void testPersonAfter30andContainsNameAAndSalaryLessMore5000() {
        List<Person> list = collection.toList();
        list.stream()
                .filter(p -> p.getAge() > 30)
                .filter(p -> p.getSalary().intValue() < 5000)
                .filter(p -> p.getFirstName().toLowerCase().contains("a"))
                .forEach(System.out::println);
    }

    /*
    Проверить есть ли в списке люди в фамилии которых идут 2 буквы "А" подряд
     */
    @Test
    public void testPersonContainsAaInName() {
        List<Person> list = collection.toList();
        list.stream()
                .filter(p -> p.getFirstName().toLowerCase().contains("aa"))
                .forEach(System.out::println);
    }

    /*
    Выдать год рождения и сколько людей было рождено в этот год
    (создать мапу или лист)
     */
    @Test
    public void testGetYearAndHowMuchPeopleInThisYear() {
        List<Person> list = collection.toList();
        List<Group> group = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            group.add(new Group(list.get(i).getBirthdate().getYear(), 1));
        }

        Map<Integer, Long> map3 = group.stream()
                .collect(Collectors.groupingBy(Group::getDate, Collectors.counting()));
        map3.forEach((k, v) -> System.out.println(k + " - " + v));
    }

    @AllArgsConstructor
    @Data
    static class Group {
        Integer date;
        Integer people;
    }

    /*
    Создать мапу которая содержит в себе название подразделения
    и сколько всего денег платиться в этом подразделении
     */
    @Test
    public void testCreateMapAndHowMuchTotalSalaryInDivision() {
        List<Person> list = collection.toList();
        List<Div> div = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            div.add(new Div(list.get(i).getDivision().getName(), list.get(i).getSalary().intValue()));
        }
        Map<String, Integer> map = div.stream()
                .collect(
                        Collectors.groupingBy(Div::getName,
                                Collectors.summingInt(Div::getSalary)));
        map.forEach((k, v) -> System.out.println(k + " - " + v));

    }

    @AllArgsConstructor
    @Data
    static class Div {
        String name;
        Integer salary;
    }
}

