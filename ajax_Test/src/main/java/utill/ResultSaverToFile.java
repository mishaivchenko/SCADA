package utill;

import Entity.Holder;
import Entity.Param;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ResultSaverToFile implements ResultSaver {
private final String fileName = "src" + File.separator + "result.txt";
private Map<String, List<Param>> map = Holder.getMap();

@Override
    public void save() {
        try (BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File(fileName)))) {
            for (Map.Entry<String,List<Param>> entry:map.entrySet()){
                outputWriter.write(entry.getKey() + "\n");
                for (Param p:entry.getValue()) {
                    outputWriter.write(p.getValue() + " " + p.getDate() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
