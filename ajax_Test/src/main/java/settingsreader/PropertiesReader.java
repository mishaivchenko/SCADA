package settingsreader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader implements Reader {


    private Properties properties;
    private List<String> paramNames;

    public PropertiesReader(InputStream inputStream, List<String> params) {

        try {
            properties = new Properties();
            properties.load(inputStream);
            paramNames = params;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, String> read() {
        String p;
        Map<String, String> map = new HashMap<>();
        for (String param : paramNames) {
            p = String.valueOf(properties.get(param));
            map.put(p, param.replace('_', ' '));
        }
        return map;
    }
}
