import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        bank.loadAccounts();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Simple Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Initial Deposit: ");
                    double deposit = scanner.nextDouble();
                    bank.createAccount(accNum, name, deposit);
                    System.out.println("Account created.");
                    break;
                case 2:
                    bank.listAccounts();
                    break;
                case 3:
                    System.out.print("Account Number: ");
                    accNum = scanner.nextLine();
                    BankAccount acc = bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.print("Deposit Amount: ");
                        acc.deposit(scanner.nextDouble());
                        System.out.println("Deposited.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Account Number: ");
                    accNum = scanner.nextLine();
                    acc = bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.print("Withdraw Amount: ");
                        if (acc.withdraw(scanner.nextDouble())) {
                            System.out.println("Withdrawn.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    bank.saveAccounts();
                    System.out.println("Exiting. Data saved.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
