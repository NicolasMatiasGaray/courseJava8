package lambda;

import model.Developer;
import util.Factory;

import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        List<Developer> listDevelopers = Factory.getDevelopers();
        System.out.println("Before Sort");
        listDevelopers.forEach(developer -> System.out.println(developer));

        System.out.println("Sorted by Name");
        listDevelopers.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));
        listDevelopers.forEach(d -> System.out.println(d));

        System.out.println("Sorted by Age");
        listDevelopers.sort((d1, d2) -> d1.getAge() - d2.getAge());
        listDevelopers.forEach(d -> System.out.println(d));

        System.out.println("Sorted by Name");
        Comparator<Developer> ageComparator = (d1, d2) -> d1.getAge() - d2.getAge();
        listDevelopers.sort(ageComparator.reversed());
        listDevelopers.forEach(d -> System.out.println(d));
    }
}
