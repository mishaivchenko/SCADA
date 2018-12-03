package Entity;

import java.util.*;

public class Holder {


    private static List<Device> words;
    private static List<Device> values;
    private static List<Device> info;
    private static Map<String, List<Param>> map = new HashMap<>();

    public static Map<String, List<Param>> getMap() {
        return map;
    }

    public static void setMap(Map<String, List<Param>> map) {
        Holder.map = map;
    }


    public static void addToMap(String name, String value) {
        List<Param> params = map.get(name);
        if (params != null) {
            if (params.size() < 300) {
                params.add(new Param(value, new Date()));
            } else {
                params.removeAll(params.subList(0,100));
                params.add(new Param(value, new Date()));
            }
        } else {
            params = new ArrayList<>();
            params.add(new Param(value, new Date()));
            getMap().put(name, params);
        }
    }

    public static List<Device> getInfo() {
        return info;
    }

    public static void setInfo(List<Device> info) {
        Holder.info = info;
    }

    public static List<Device> getWords() {
        return words;
    }

    public static void setWords(List<Device> wordsList) {
        words = wordsList;
    }

    public static List<Device> getValues() {
        return values;
    }

    public static void setValues(List<Device> valuesList) {
        values = valuesList;
    }
}
