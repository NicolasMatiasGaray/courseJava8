package streams.maps;

import model.Developer;
import util.Factory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sort {

    public static void main(String[] args) {
        System.out.println("Before Sorting");
        Map<Integer, Developer> mapDevelopers = Factory.getDevelopersById();
        System.out.println(mapDevelopers);

        System.out.println("Sorting a Map by Key");
        Map<Integer, Developer> sortedMapDevelopers = mapDevelopers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (d1, d2) -> d1, LinkedHashMap::new));

        System.out.println(sortedMapDevelopers);

        System.out.println("Sorting a Map by Value");
        sortedMapDevelopers = mapDevelopers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((d1, d2) -> d2.getName().compareTo(d1.getName())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (d1, d2) -> d1, LinkedHashMap::new));
        System.out.println(sortedMapDevelopers);
    }
}
