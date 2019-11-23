package com.netcracker.edu.trainee.firstLab.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements IPerson {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Integer age;
    private Gender gender;
    private IDivision division;
    private BigDecimal salary;

    /**
     * @return age of Person
     * Calculates the number of years based on subtracting the year of birth and the current date
     */
    public int calculateAge(){
        return LocalDate.now().getYear() - birthdate.getYear();
    }

}
