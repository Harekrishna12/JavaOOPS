import java.util.Scanner;

public class MiniBank {

    public static void main(String[] args) {
        BankInfo bankInfo = new BankInfo("MiniBank", "Downtown Branch");
        System.out.println(bankInfo);
        System.out.println();

        Account[] accounts = new Account[] {
            new Account("Alice", 5000),
            new Account("Bob", 2500),
            new Account("Charlie")
        };

        accounts[0].deposit(2000);
        accounts[1].withdraw(1000);
        accounts[2].deposit(1500);
        accounts[2].withdraw(500);

        System.out.println("Account balances after sample operations:");
        for (Account account : accounts) {
            System.out.printf("%s (%s): %d\n", account.getOwnerName(), account.getAccountNumber(), account.getBalance());
        }
        System.out.println();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exitRequested = false;

            while (!exitRequested) {
                printMenu();
                int choice = readChoice(scanner);
                MenuOption option = MenuOption.fromChoice(choice);

                exitRequested = switch (option) {
                    case OPEN_ACCOUNT -> {
                        System.out.println("Open Account - to be implemented in a later lab");
                        yield false;
                    }
                    case DEPOSIT -> {
                        System.out.println("Deposit - to be implemented in a later lab");
                        yield false;
                    }
                    case WITHDRAW -> {
                        System.out.println("Withdraw - to be implemented in a later lab");
                        yield false;
                    }
                    case TRANSFER -> {
                        System.out.println("Transfer - to be implemented in a later lab");
                        yield false;
                    }
                    case EXIT -> {
                        System.out.println("Goodbye! Thank you for using MiniBank.");
                        yield true;
                    }
                };
            }
        }
    }

    private static void printMenu() {
        System.out.println("MiniBank Menu:");
        System.out.println("1. Open Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int readChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= 5) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }
            System.out.print("Invalid choice. Please enter a number from 1 to 5: ");
        }
    }

    public record BankInfo(String name, String branch) {
    }

    private enum MenuOption {
        OPEN_ACCOUNT(1),
        DEPOSIT(2),
        WITHDRAW(3),
        TRANSFER(4),
        EXIT(5);

        private final int choice;

        MenuOption(int choice) {
            this.choice = choice;
        }

        public static MenuOption fromChoice(int choice) {
            for (MenuOption option : values()) {
                if (option.choice == choice) {
                    return option;
                }
            }
            throw new IllegalArgumentException("Invalid menu choice: " + choice);
        }
    }
}

class Customer {

    private static long customerCounter = 100;

    private final String customerId;
    private final String name;
    private final String email;
    private final String mobile;

    public Customer(String name, String email, String mobile) {
        this.customerId = generateCustomerId();
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    private static String generateCustomerId() {
        return "CUST" + (++customerCounter);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}

class Account {

    private static long accountCounter = 0;

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    public Account(String ownerName, long openingBalance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    private static String generateAccountNumber() {
        return String.format("AC%04d", ++accountCounter);
    }

    public boolean deposit(long amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(long amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}
