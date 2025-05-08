import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int opt = 0, flag = 0;
        String defaultPass = "admin", passwrd;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter option:\n1. Default Password\n2. Printed Password\n3. Password with text only");

        // Input validation for integer
        if (scanner.hasNextInt()) {
            opt = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline
        } else {
            System.out.println("\n[ERROR] Invalid input. Please enter a number (1-3).");
            scanner.close();
            return;
        }

        switch (opt) {
            case 1:
                System.out.print("Enter Password: ");
                passwrd = scanner.nextLine();
                if (passwrd.equals(defaultPass)) {
                    System.out.println("\nThis is the default password!!\nEnter another password: ");
                    defaultPass = scanner.nextLine();
                } else {
                    System.out.println("\nThis is not a default password.");
                    defaultPass = passwrd;
                }
                break;

            case 2:
                System.out.print("\nPassword in star format: ");
                for (int i = 0; i < defaultPass.length(); i++) {
                    System.out.print("*");
                }
                System.out.println("\nActual password is: " + defaultPass);
                break;

            case 3:
                for (char ch : defaultPass.toCharArray()) {
                    if (!Character.isLetter(ch)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("\nYour password is alphanumeric.");
                } else {
                    System.out.print("\nYour password does not contain numbers. Re-enter a new one: ");
                    defaultPass = scanner.nextLine();
                }
                break;

            default:
                System.out.println("\n[ERROR] Invalid option. Please select 1, 2, or 3.");
        }

        scanner.close();
    }
}
