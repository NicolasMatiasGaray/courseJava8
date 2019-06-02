package util;

import model.Developer;

import java.util.*;

public class Factory {

    public static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<Developer>();
        result.add(new Developer(123,"Nicolas",29));
        result.add(new Developer(456,"Martin",20));
        result.add(new Developer(789,"Juan",10));
        return result;
    }

    public static Map<Integer,Developer> getDevelopersById(){
        Map<Integer, Developer> developers = new TreeMap<>();
        getDevelopers().forEach(d -> developers.put(d.getDni(), d));
        return developers;
    }
}
