package lambda;

import model.Developer;
import util.Factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach {

    public static void main(String[] args) {
        System.out.println("Looping Map");
        Map<Integer, Developer> developers = Factory.getDevelopersById();
        developers.forEach((k,v)->System.out.println("Key : " + k + " - Value : " + v));

        developers.forEach((k,v)->{
            if(k.equals(123)){
                System.out.println("Hi 123 -> Key : " + k + " - Value : " + v);
            }
        });

        System.out.println("Looping List");
        List<Developer> listDevelopers = Factory.getDevelopers();
        listDevelopers.forEach(developer -> System.out.println(developer));
    }
}
