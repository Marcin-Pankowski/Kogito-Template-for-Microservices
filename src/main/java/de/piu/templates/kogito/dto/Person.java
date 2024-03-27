package de.piu.templates.kogito.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Person {
    private String name;
    private Integer age;
}
