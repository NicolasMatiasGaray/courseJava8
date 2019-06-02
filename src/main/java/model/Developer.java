package model;

import lombok.Getter;

@Getter
public class Developer {

    private Integer dni;
    private String name;
    private Integer age;

    public Developer(Integer dni, String name, Integer age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
