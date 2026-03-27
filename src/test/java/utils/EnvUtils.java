package utils;

import java.io.IOException;
import java.util.Properties;

public class EnvUtils {

    private final Properties prop;

    public static EnvUtils envUtils;
    private EnvUtils() throws IOException {
        String env = System.setProperty("env", "STAGING");
        switch (env){
            case "PRODUCTION" -> {
                prop = ConfigUtils.readConfig("src/properties/production.properties");
            }
            case "STAGING" -> {
                prop = ConfigUtils.readConfig("src/properties/staging.properties");
            }
            case "LOCAL" -> {
                prop = ConfigUtils.readConfig("src/properties/Local.properties");
            }default -> {
                throw new RuntimeException("Environment is not supported ");
            }
        }
    }

    public static EnvUtils getInstance() throws IOException {
        envUtils = new EnvUtils();
        return envUtils;
    }

    public String getURL(){
        return prop.get("URL").toString();
    }

    public String getEmail(){
        return prop.get("EMAIL").toString();
    }
    public String getPassword(){
        return prop.get("PASSWORD").toString();
    }


}
