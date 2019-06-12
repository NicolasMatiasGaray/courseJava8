package streams.maps;

import model.Developer;
import util.Factory;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterWithPredicate {

    // Generic Map filterByValue, with predicate
    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate){
        return map.entrySet().stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }

    public static void main(String[] args) {
        Map<Integer, Developer> mapDevelopers = Factory.getDevelopersById();

        Map<Integer, Developer> result = filterByValue(mapDevelopers, x -> x.getName().equals("Martin"));
        System.out.println(result);

        result = filterByValue(mapDevelopers, x -> x.getName().contains("Mar") || x.getName().contains("Juan"));
        System.out.println(result);
    }
}
