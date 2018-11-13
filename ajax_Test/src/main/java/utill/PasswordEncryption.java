package utill;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {

    private static final int rounds = 11;

    public static String encryptPassword(String plaintext) {
        String res = BCrypt.gensalt(rounds);
        return (BCrypt.hashpw(plaintext, res));
    }

    public static boolean checkPassword(String password, String hash) {
        if (hash == null) {
            return false;
        }
        try {
            return BCrypt.checkpw(password, hash);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

