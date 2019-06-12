package util;

import model.Developer;

import java.util.*;
import java.util.stream.Collectors;

public class Factory {

    public static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<Developer>();
        result.add(new Developer(123,"Nicolas",29));
        result.add(new Developer(456,"Martin",25));
        result.add(new Developer(789,"Juan",19));
        result.add(new Developer(789,"Juan2",19));
        return result;
    }

    public static Map<Integer,Developer> getDevelopersById(){
        // Way A
//        Map<Integer, Developer> developers = new TreeMap<>();
//        getDevelopers().forEach(d -> developers.put(d.getDni(), d));
//        return developers;

        Map<Integer, Developer> developers = getDevelopers().stream().collect(
                Collectors.toMap(d -> d.getDni(), d -> d, (d1, d2) -> d1));
        return developers;
    }
}
