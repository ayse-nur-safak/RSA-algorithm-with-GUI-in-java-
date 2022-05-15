import java.io.*;
import java.math.BigInteger;
import java.util.*;
import javax.swing.JOptionPane;

public class RSA {
    // array of encrypted bytes.
    protected static byte[] encrypt;
    // array od decrypted bytes.
    protected static byte[] decrypt;
    private static BigInteger[] privateKeys = new BigInteger[2];
    private static BigInteger[] publicKeys = new BigInteger[2];
    private static File files;
    private static Scanner input;
    public static String encrypt(String text) {
        getPublicKeys();
        encrypt = encrypt(text.getBytes());
        return fromBytesToStr(encrypt);
    }
    public static String decrypt(String text) {
        getPrivateKeys();
        if(!text.equals(fromBytesToStr(encrypt)))
            return "Could not decode the message."
                    + "Please try to decode by copying the given encrypted message.";
        else {
            decrypt = decrypt(encrypt);
            return new String(decrypt);
        }
    }
    public static String fromBytesToStr(byte[] encrypted) {
        String str = "";
        for (byte byt : encrypted) {
            str += Byte.toString(byt);
        }
        return str;
    }

    private static void getPublicKeys() {
        try {
            files = new File("public_keys.txt");
            input = new Scanner(files);
            int i = 0;
            while (input.hasNext()) {
                publicKeys[i] = new BigInteger(input.nextLine());
                i++;
            }
            input.close();
        }
        catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Opening the file error.");
        }
    }
    private static void getPrivateKeys() {
        try {
            files = new File("private_keys.txt");
            input = new Scanner(files);
            int index = 0;
            while (input.hasNext()) {
                privateKeys[index] = new BigInteger(input.nextLine());
                index++;
            }
            input.close();
        }
        catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Opening the file error.");
        }
    }
    private static byte[] encrypt(byte[] txt) {
        return (new BigInteger(txt)).modPow(publicKeys[0], publicKeys[1]).toByteArray();
    }
    private static byte[] decrypt(byte[] txt) {
        return (new BigInteger(txt)).modPow(privateKeys[0], privateKeys[1]).toByteArray();
    }
}
