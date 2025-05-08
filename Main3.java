import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    // Function to perform Single Columnar Transposition Cipher Encryption
    public static String encrypt(String plainText, String keyword) {
        int keyLength = keyword.length();
        int numRows = (int) Math.ceil((double) plainText.length() / keyLength);

        // Create a grid with numRows and keyLength
        char[][] grid = new char[numRows][keyLength];

        // Fill the grid row by row with the plain text
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (index < plainText.length()) {
                    grid[i][j] = plainText.charAt(index++);
                } else {
                    grid[i][j] = '_'; // Padding character
                }
            }
        }

        // Create keyword order list
        List<Integer> keywordOrder = new ArrayList<>();
        for (int i = 0; i < keyLength; i++) {
            keywordOrder.add(i);
        }

        // Sort indices based on corresponding characters in keyword
        Collections.sort(keywordOrder, (a, b) -> Character.compare(keyword.charAt(a), keyword.charAt(b)));

        // Read columns in the order of sorted keyword
        StringBuilder cipherText = new StringBuilder();
        for (int i : keywordOrder) {
            for (int r = 0; r < numRows; r++) {
                cipherText.append(grid[r][i]);
            }
        }

        return cipherText.toString();
    }

    // Function to perform Single Columnar Transposition Cipher Decryption
    public static String decrypt(String cipherText, String keyword) {
        int keyLength = keyword.length();
        int numRows = (int) Math.ceil((double) cipherText.length() / keyLength);

        char[][] grid = new char[numRows][keyLength];

        // Create keyword order list
        List<Integer> keywordOrder = new ArrayList<>();
        for (int i = 0; i < keyLength; i++) {
            keywordOrder.add(i);
        }

        // Sort indices based on characters in keyword
        Collections.sort(keywordOrder, (a, b) -> Character.compare(keyword.charAt(a), keyword.charAt(b)));

        // Fill the grid column by column using sorted keyword order
        int index = 0;
        for (int i : keywordOrder) {
            for (int r = 0; r < numRows; r++) {
                if (index < cipherText.length()) {
                    grid[r][i] = cipherText.charAt(index++);
                } else {
                    grid[r][i] = '_';
                }
            }
        }

        // Read the grid row by row to reconstruct the plaintext
        StringBuilder plainText = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < keyLength; c++) {
                plainText.append(grid[r][c]);
            }
        }

        // Remove filler characters
        return plainText.toString().replace("_", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plain text: ");
        String plainText = scanner.nextLine().toUpperCase();

        System.out.print("Enter the keyword: ");
        String keyword = scanner.nextLine().toUpperCase();

        // Encrypt
        String cipherText = encrypt(plainText, keyword);
        System.out.println("Cipher Text: " + cipherText);

        // Decrypt
        String decryptedText = decrypt(cipherText, keyword);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}
