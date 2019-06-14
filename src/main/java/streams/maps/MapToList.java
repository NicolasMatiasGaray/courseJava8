package streams.maps;

import model.Developer;
import util.Factory;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {

    /**
     *  In java8 is possible to convert a Map into
     *  a stream, process it (filter, etc) and returns it back as a List
     */
    public static void main(String[] args) {
        Map<Integer, Developer> developers = Factory.getDevelopersById();

        System.out.println("Getting keys");
        List<Integer> keys = developers.keySet().stream().collect(Collectors.toList());
        keys.forEach(System.out::println);

        System.out.println("Getting values");
        String valueToFilter = "Nicolas";
        List<Developer> values = developers.values().stream()
                    .filter( x -> !x.getName().equals(valueToFilter)).collect(Collectors.toList());

        values.forEach(System.out::println);

        System.out.println("Splitting Map into 2 Lists");

        List<Integer> resultSortedKeys = new ArrayList<>();
        List<Developer> resultValues = developers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .peek( x -> {
                    System.out.println("Adding key " + x.getKey());
                    resultSortedKeys.add(x.getKey());
                    // https://www.baeldung.com/java-streams-peek-api
                })
                .map(x -> {
                        System.out.println("Mapping value " + x.getValue());
                        System.out.println("Size " + resultSortedKeys.size());
                        return x.getValue();
                    })
                .filter(x -> x.getAge() > 20)
                .collect(Collectors.toList());

        resultValues.forEach(System.out::println);
    }
}
