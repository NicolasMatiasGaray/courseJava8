package streams;

import model.Developer;
import util.Factory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collector {

    public static void main(String[] args) {
        System.out.println("Grouping By");
        List<String> fruits = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> groupedFruits = fruits.stream().collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting())
        );
        System.out.println(groupedFruits);

        System.out.println("Grouping By List Objects");
        List<Developer> developers = Factory.getDevelopers();
        developers.addAll(Factory.getDevelopers());
        Map<String, Long> groupedDevelopers = developers.stream().collect(
                Collectors.groupingBy(Developer::getName, Collectors.counting())
        );
        Map<String, Integer> groupedDevelopers2 = developers.stream().collect(
                Collectors.groupingBy(Developer::getName, Collectors.summingInt(Developer::getAge))
        );
        System.out.println(groupedDevelopers);
        System.out.println(groupedDevelopers2);
    }
}
