package utils;

public class UserUtils {

    /**
     * Extracts username from email.
     * Example: sirine.argoubi@gmail.com -> sirine.argoubi
     */
    public static String extractUsernameFromEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }

        return email.substring(0, email.indexOf("@"));
    }

    /**
     * Formats username nicely.
     * Example: sirine.argoubi@gmail.com -> Sirine Argoubi
     */
    public static String extractFormattedUsername(String email) {
        String raw = extractUsernameFromEmail(email);

        String[] parts = raw.split("[._]");
        StringBuilder formatted = new StringBuilder();

        for (String part : parts) {
            if (!part.isEmpty()) {
                formatted.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1))
                        .append(" ");
            }
        }

        return formatted.toString().trim();
    }

}