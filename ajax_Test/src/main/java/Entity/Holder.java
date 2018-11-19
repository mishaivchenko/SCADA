package Entity;

import java.util.List;

public class Holder {
    private static List<Device> words;
    private static List<Device> values;

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
