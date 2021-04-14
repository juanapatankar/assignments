public abstract class Substitution implements Cipher {
    /**
     * 
     * @param c to test each character 
     * @return char c that's the encrypted character if appropriate
     */
    // Declare abstract methods, don't need implementation
    public abstract char encrypt(char c);
    public abstract char decrypt(char c);

    /*** Takes a string, and encrypts it by calling encrypt(char c) on each character
     * @param string plaintext to encode
     * @return string encoded, the encrypted string
     */
    public String encrypt(String plaintext) {
        // Declares and intialises String encoded as empty
        String encoded = "";
        // Calls encrypt(char c) iteratively with each character in the input string
        for (int i = 0; i < plaintext.length(); i++) {
            // Appends the encrypted character to encoded
            encoded += encrypt(plaintext.charAt(i));
        }
        // Return the encrypted string
        return encoded;
    }

    /*** Takes a string, and decrypts it by calling decrypt(char c) on each character
     * @param string cryptotext to decode
     * @return string decoded, the plaintext string
     */
    public String decrypt(String cryptotext) {
        // Intialise the decoded variable as an empty string
        String decoded = "";
        // Calls decrypt(char c) with the input string iteratively
        for (int i = 0; i < cryptotext.length(); i++) {
            // Appends the decrypted character to the decoded output
            decoded += decrypt(cryptotext.charAt(i));
        }
        // Return the final decoded result
        return decoded;
    }

    

}