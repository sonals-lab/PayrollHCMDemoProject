package Config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class configReader {



    public static class ConfigReader {
        private final Properties props = new Properties();


        public ConfigReader(String filePath) {
            try (InputStream is = new FileInputStream(filePath)) {
                props.load(is);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load config file: " + filePath, e);
            }
        }


        public String get(String key) {
            return props.getProperty(key);
        }


        public String get(String key, String defaultValue) {
            return props.getProperty(key, defaultValue);
        }


        public int getInt(String key, int defaultValue) {
            try {
                return Integer.parseInt(props.getProperty(key));
            } catch (Exception e) {
                return defaultValue;
            }
        }
    }
}
