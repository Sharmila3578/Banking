import java.io.*;
import java.util.*;

public class BankSystem {
    private List<BankAccount> accounts = new ArrayList<>();
    private final String fileName = "accounts.txt";

    public void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accounts.add(BankAccount.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing accounts found.");
        }
    }

    public void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (BankAccount acc : accounts) {
                writer.write(acc.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }

    public void createAccount(String accNum, String name, double balance) {
        accounts.add(new BankAccount(accNum, name, balance));
    }

    public BankAccount findAccount(String accNum) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) return acc;
        }
        return null;
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (BankAccount acc : accounts) {
            System.out.println(acc.getAccountNumber() + " | " + acc.getHolderName() + " | Balance: ₹" + acc.getBalance());
        }
    }
}
