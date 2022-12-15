package Ano2019_2020_Recurso.Ex1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("Bob");
        names.add("Mary");
        names.add("Steve");
        names.add("Derek");
        names.add("Mary");
        names.add("Derek");
        names.add("Joe");
        names.add("Derek");
        names.add("Nicole");
        names.add("Mary");


        List<String> apelidos = new LinkedList<>();

        apelidos.add("Jones");
        apelidos.add("Ford");
        apelidos.add("Akers");
        apelidos.add("Smith");
        apelidos.add("Giles");
        apelidos.add("Smith");
        apelidos.add("Caiu");
        apelidos.add("Jones");
        apelidos.add("Jones");
        apelidos.add("Stepp");

        System.out.println(commonFirstName(names, apelidos));

    }

    public static String commonFirstName(List<String> names, List<String> nicknames) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            if (!map.containsKey(names.get(i))) {
                List<String> apelido = new LinkedList<>();
                apelido.add(nicknames.get(i));
                map.put(names.get(i), apelido);
            } else {
                if(! map.get(names.get(i)).contains(nicknames.get(i))) {
                    map.get(names.get(i)).add(nicknames.get(i));
                }
            }
        }
        List<Map.Entry<String, List<String>>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());
        return list.get(0).getKey();
    }
}
