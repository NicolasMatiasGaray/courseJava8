package model;

import lombok.Getter;

@Getter
public class Developer {

    private String name;

    private Integer age;

    public Developer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
