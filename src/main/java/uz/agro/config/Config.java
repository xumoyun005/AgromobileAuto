package uz.agro.config;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties topilmadi");
            }
            PROPERTIES.load(in);
        } catch (Exception e) {
            throw new IllegalStateException("config.properties yuklanmadi", e);
        }
    }

    private Config() {}

    public static String get(String key) {
        String value = System.getProperty(key, PROPERTIES.getProperty(key));
        return value == null ? "" : value.trim();
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBool(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static boolean isBlank(String key) {
        return get(key).isEmpty();
    }
}
