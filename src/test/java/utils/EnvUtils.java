package utils;

import java.io.IOException;
import java.util.Properties;

import static utils.UserUtils.extractUsernameFromEmail;

public class EnvUtils {

    private final Properties prop;

    private static EnvUtils envUtils;

    private EnvUtils() throws IOException {
        // Get environment from system property or default to STAGING
        String env = System.getProperty("env", "STAGING").toUpperCase();

        switch (env) {
            case "PRODUCTION" -> prop = ConfigUtils.readConfig("src/properties/production.properties");
            case "STAGING" -> prop = ConfigUtils.readConfig("src/properties/staging.properties");
            case "LOCAL" -> prop = ConfigUtils.readConfig("src/properties/local.properties");
            default -> throw new RuntimeException("Environment is not supported: " + env);
        }
    }

    // Singleton: only create one instance
    public static EnvUtils getInstance() throws IOException {
        if (envUtils == null) {
            envUtils = new EnvUtils();
        }
        return envUtils;
    }

    public static String extractPrettyUsername(String email) {
        String username = extractUsernameFromEmail(email);

        String[] parts = username.split("\\.");
        StringBuilder formatted = new StringBuilder();

        for (String part : parts) {
            formatted.append(part.substring(0, 1).toUpperCase())
                    .append(part.substring(1).toLowerCase())
                    .append(" ");
        }

        return formatted.toString().trim();
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
    public String getFormattedUsername() {return UserUtils.extractFormattedUsername(getEmail());
    }








}