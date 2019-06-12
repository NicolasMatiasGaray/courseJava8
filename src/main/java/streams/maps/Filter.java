package streams.maps;

import model.Developer;
import util.Factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        Map<Integer, Developer> mapDevelopers = Factory.getDevelopersById();

        Developer dev = mapDevelopers.entrySet().stream().filter(d -> d.getKey().equals(456))
                .map(d -> d.getValue()).findAny().orElse(null);
        System.out.println(dev);

        List<Developer> listDeveloper = mapDevelopers.entrySet().stream()
                .filter( d -> !d.getKey().equals(1234))
                .map(d -> d.getValue()).collect(Collectors.toList());
        System.out.println(dev);

        Map<Integer, Developer> mapResult = mapDevelopers.entrySet().stream()
                .filter( e -> e.getValue().getAge() > 15)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(mapResult);
    }
}
