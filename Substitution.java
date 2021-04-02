abstract class Substitution implements Cipher {
    public abstract char encrypt(char c);
    public abstract char decrypt(char c);

    public String encrypt(String plaintext) {
        String encoded = "";
        for (int i = 0; i < plaintext.length(); i++) {
            encoded += encrypt(plaintext.charAt(i));
        }
        return encoded;
    }
    public String decrypt(String cryptotext) {
        String decoded = "";
        for (int i = 0; i < cryptotext.length(); i++) {
            decoded += encrypt(cryptotext.charAt(i));
        }
        return decoded;
    }

}