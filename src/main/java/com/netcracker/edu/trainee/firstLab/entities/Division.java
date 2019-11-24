package com.netcracker.edu.trainee.firstLab.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vsu.lab.entities.IDivision;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Division implements IDivision {

    private Integer id;
    private String name;

    /**
     * @return random int value in the range 0-200000
     */
    public static int randomID(){
        return (int) (0 + (Math.random() * 200000));
    }

}
