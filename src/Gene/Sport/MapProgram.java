package Gene.Sport;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted,object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "beginners all purposes symbolic instruction code");
        languages.put("Lisp", "Therein lies madness");
        if(languages.containsKey("Java")){
            System.out.println(languages.get("Java"));
        }else{
            languages.put("Java", "This course is about Java");
            System.out.println(languages.get("Java"));
        }
        System.out.println("===============================");

        if(languages.remove("Algol", "a family of algorithmic languages")){
            System.out.println("Algol removed");
        }else{
            System.out.println("Algol not removed, key/value pair not found");
        }
        // replace old and new value of a specific key
        if(languages.replace("Lisp", "Therein lies madness","a functional programming language with imperative features")){
            System.out.println("Lisp replaced");
        }else{
            System.out.println("Lisp was not replaced");
        }
//        System.out.println(languages.replace("Scala", "will not be added"));
        // Map is not Ordered
        for(String key: languages.keySet()){
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
