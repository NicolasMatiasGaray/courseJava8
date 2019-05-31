package util;

import model.Developer;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    public static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<Developer>();
        result.add(new Developer("Nicolas", 33));
        result.add(new Developer("Garay", 20));
        result.add(new Developer("Matias", 10));
        return result;
    }
}
