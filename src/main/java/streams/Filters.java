package streams;

import model.Developer;
import util.Factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filters {

    public static void main(String[] args) {
        System.out.println("Filter and Collect");
        List<String> languages = Arrays.asList("java", "python", "html", "c++", null, null, null);

        List<String> result = languages.stream()
                .filter(language -> !"html".equals(language))
                .collect(Collectors.toList());

        result.forEach(System.out::println);

        System.out.println("Filter Null and Collect");
        languages.stream().filter(language -> language != null)
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Filter, FindAny and Else");
        List<Developer> developers = Factory.getDevelopers();
        Developer dev = developers.stream()
                .filter(d -> d.getName().equals("Nicolas") && d.getAge().equals(29))
                .findAny()
                .orElse(null);
        System.out.println(dev);

        System.out.println("Filter and Map");
        Integer devAge = developers.stream()
                .filter(d -> d.getName().equals("Martin"))
                .map(Developer::getAge)
                .findAny()
                .orElse(null);
        System.out.println(devAge);
    }
}
