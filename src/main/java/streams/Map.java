package streams;

import model.Developer;
import util.Factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream().map() lets you convert an object to something else
 */
public class Map {

    public static void main(String[] args) {

        System.out.println("Map to UpperCase");
        List<String> languages = Arrays.asList("java", "python", "html", "c++");
        List<String> languagesUpper = languages.stream().map(String::toUpperCase).collect(Collectors.toList());
        languagesUpper.forEach(System.out::println);

        System.out.println("Changing numbers");
        List<Integer> numbers = Arrays.asList(1,2,3);
        List<Integer> numbersResult = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        numbersResult.forEach(System.out::println);

        System.out.println("Objects to String");
        List<Developer> developers = Factory.getDevelopers();
        List<String> developersNames = developers.stream().map(Developer::getName).collect(Collectors.toList());
        developersNames.forEach(System.out::println);
    }
}
