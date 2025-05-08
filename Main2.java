import java.util.Scanner;
public class Main2 {
 // Normalize the key to be within the range [0, 25]
 private static int normalizeKey(int key) {
 return key % 26; // Ensure the key is between 0 and 25
 }
 // Function for encryption
 public static String encrypt(String plainText, int key) {
 key = normalizeKey(key); // Normalize the key
 StringBuilder cipherText = new StringBuilder();
 // Traverse through each character in the plain text
 for (char ch : plainText.toCharArray()) {
 if (ch >= 'a' && ch <= 'z') {
 // Encrypt lowercase letters using the formula: (key + character index) % 26
 int shiftedChar = (ch - 'a' + key) % 26 + 'a';
 cipherText.append((char) shiftedChar);
 } else if (ch >= 'A' && ch <= 'Z') {
 // Encrypt uppercase letters using the formula: (key + character index) % 26
 int shiftedChar = (ch - 'A' + key) % 26 + 'A';
 cipherText.append((char) shiftedChar);
 } else {
 // Non-alphabetic characters are added as-is
 cipherText.append(ch);
 }
 }
 return cipherText.toString();
 }
 // Function for decryption
 public static String decrypt(String cipherText, int key) {
 key = normalizeKey(key); // Normalize the key
 StringBuilder plainText = new StringBuilder();
 // Traverse through each character in the cipher text
 for (char ch : cipherText.toCharArray()) {
 if (ch >= 'a' && ch <= 'z') {
 // Decrypt lowercase letters using the formula: (p - k) % 26
 int shiftedChar = (ch - 'a' - key + 26) % 26 + 'a';
 plainText.append((char) shiftedChar);
 } else if (ch >= 'A' && ch <= 'Z') {
 // Decrypt uppercase letters using the formula: (p - k) % 26
 int shiftedChar = (ch - 'A' - key + 26) % 26 + 'A';
 plainText.append((char) shiftedChar);
 } else {
 // Non-alphabetic characters are added as-is
 plainText.append(ch);
 }
 }
 return plainText.toString();
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 String plainText;
 int key;
 // Taking input from the user
 System.out.print("Enter the plain text: ");
 plainText = scanner.nextLine();
 System.out.print("Enter the key (integer): ");
 key = scanner.nextInt();
 // Encrypting the plain text
 String cipherText = encrypt(plainText, key);
 System.out.println("Cipher Text: " + cipherText);
 // Decrypting the cipher text
 String decryptedText = decrypt(cipherText, key);
 System.out.println("Decrypted Text: " + decryptedText);

 scanner.close();
 }
}
