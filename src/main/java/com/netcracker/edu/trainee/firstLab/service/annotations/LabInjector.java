package com.netcracker.edu.trainee.firstLab.service.annotations;

import java.lang.annotation.*;
@Target(value=ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface LabInjector {
}
