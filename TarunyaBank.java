import java.util.*;

class UserData {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    long generateAccountNumber = 0;

    public void users() {
        String[] userNames = { "Tarunya Chaudhary", "Saurabh Sharma", "Rajat Talwar", "Prajjwal Singh", "Abhishek Pal" };
        Integer[] debitCardData = { 8757, 9633, 9771, 8002, 9065 };

        try {
            System.out.println("Enter the first 4-digits of your Debit Card:");
            int debitCardInput = input.nextInt();

            boolean found = false;
            for (int i = 0; i < debitCardData.length; i++) {
                if (debitCardInput == debitCardData[i]) {
                    System.out.println("Welcome, " + userNames[i] + "!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("User not found in the Database!");
                CreateBankAccount();
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter the correct input value!");
            input.nextLine();
        }
    }

    public void GenerateAccountNumber() {
        generateAccountNumber = Math.abs(random.nextLong() % 10000000000L);
    }

    public void CreateBankAccount() {
        System.out.println("Step-1:");
        String firstName;
        String lastName;
        int age;
        String address;
        long phoneNumber;
        long aadharNumber;
        String accountType;
        String IFSC = "TRIB0509484";

        input.nextLine();
        System.out.println("Fill the details in the Application to open the Account...");

        System.out.print("Enter your First name: ");
        firstName = input.nextLine();

        System.out.print("Enter your Last name: ");
        lastName = input.nextLine();

        System.out.print("Enter your Age: ");
        age = input.nextInt();

        input.nextLine();
        System.out.print("Enter your Resident Address: ");
        address = input.nextLine();

        System.out.print("Enter your Phone Number: ");
        phoneNumber = input.nextLong();

        input.nextLine();
        System.out.print("Enter your Account Type: ");
        accountType = input.nextLine();

        System.out.println("Saving data...");
        sleep(1000);

        System.out.println("Details saved Successfully!");

        System.out.println("\nStep-2:");
        System.out.println("Please complete your KYC to open your wallet:");
        sleep(3000);

        System.out.print("Enter your Aadhar Number: ");
        aadharNumber = input.nextLong();

        System.out.println("Wait, fetching details...");
        sleep(2000);
        System.out.println("DigiLocker Fetching...");
        sleep(5000);

        System.out.println("Congrats, KYC completed successfully!");
        System.out.println("Your " + accountType + " is created!");

        GenerateAccountNumber();
        System.out.println("Account Number: " + generateAccountNumber);
        System.out.println("IFSC Code: " + IFSC);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.println("Error during wait!");
        }
    }
}

class BankClass extends UserData {
    private double balance = 1000000;
    private int pin = 8757;
    private long registeredPhoneNumber = 8757509484L;
    private int generatedOtp = 0;
    private Random random = new Random();

    public void GenerateOtp() {
        generatedOtp = 1000 + random.nextInt(9000);
        System.out.println("OTP is: " + generatedOtp); // For simulation
    }

    public boolean LoginPin() {
        try {
            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Enter your 4-digit pin: ");
                int enteredPin = input.nextInt();
                if (enteredPin == pin) {
                    System.out.println("Login Successful!");
                    return true;
                } else {
                    System.out.println("Incorrect Pin!");
                    attempts++;
                }
            }
            System.out.println("Too many failed attempts. Transaction cancelled.");
            return false;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter digits only.");
            input.nextLine();
            return false;
        }
    }

    public void BankSystem() {
        try {
            users();

            input.nextLine(); // clear buffer
            System.out.println("\nKindly wait, Processing...");
            String[] accountTypes = { "Saving Account", "Current Account", "Business Account" };
            System.out.println("Available Account Types:");
            for (String type : accountTypes) {
                System.out.println("- " + type);
            }

            System.out.print("Choose Your Account Type: ");
            String userChoice = input.nextLine();

            if (userChoice.equalsIgnoreCase("Saving Account") ||
                userChoice.equalsIgnoreCase("Current Account") ||
                userChoice.equalsIgnoreCase("Business Account")) {

                boolean exit = false;
                while (!exit) {
                    System.out.println("\n===== MENU =====");
                    options();
                    System.out.print("Choose your option: ");
                    String choice = input.nextLine().toLowerCase();

                    switch (choice) {
                        case "deposit":
                            DepositMoney();
                            break;
                        case "withdrawal":
                            WithdrawalMoney();
                            break;
                        case "changepin":
                            changePin();
                            break;
                        case "checkbalance":
                            checkBalance();
                            break;
                        case "exit":
                            exit = true;
                            System.out.println("Thank you for using Tarunya Bank!");
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                }
            } else {
                System.out.println("Invalid account type selected!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter the correct input value!");
        }
    }

    public void options() {
        String[] menuOptions = { "Deposit", "Withdrawal", "ChangePin", "CheckBalance", "Exit" };
        for (String option : menuOptions) {
            System.out.println("- " + option);
        }
    }

    public void DepositMoney() {
        try {
            System.out.print("Enter the Deposit Amount: ");
            double depositAmount = input.nextDouble();

            if (!LoginPin()) return;

            if (depositAmount <= 0) {
                System.out.println("Amount should be greater than zero!");
            } else if (depositAmount > 500000) {
                System.out.println("Deposit limit at once is ₹500,000 only.");
            } else {
                balance += depositAmount;
                System.out.println("Amount Deposited Successfully!");
                System.out.println("New Balance: ₹" + balance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount!");
            input.nextLine();
        }
        input.nextLine();
    }

    public void WithdrawalMoney() {
        try {
            System.out.print("Enter the Withdrawal Amount: ");
            double withdrawalAmount = input.nextDouble();

            if (!LoginPin()) return;

            if (withdrawalAmount > balance) {
                System.out.println("Insufficient Balance!");
            } else if (withdrawalAmount > 100000) {
                System.out.println("Withdrawal limit exceeded (₹100,000 max per transaction).");
            } else {
                System.out.println("Processing withdrawal...");
                balance -= withdrawalAmount;
                System.out.println("Withdrawal Successful!");
                System.out.println("Remaining Balance: ₹" + balance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount!");
            input.nextLine();
        }
        input.nextLine();
    }

    public void checkBalance() {
        if (LoginPin()) {
            System.out.println("Your current Balance is: ₹" + balance);
        }
    }

    public void changePin() {
        try {
            System.out.print("Enter your registered Mobile Number: ");
            long phoneNumber = input.nextLong();

            if (phoneNumber != registeredPhoneNumber) {
                System.out.println("Incorrect registered phone number!");
                return;
            }

            GenerateOtp();
            System.out.print("Enter the OTP sent to your number: ");
            int userOtp = input.nextInt();

            if (userOtp == generatedOtp) {
                System.out.print("Enter your new 4-digit pin: ");
                int newPin = input.nextInt();
                pin = newPin;
                System.out.println("Pin changed successfully!");
            } else {
                System.out.println("Invalid OTP. Try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter digits only.");
            input.nextLine();
        }
        input.nextLine();
    }
}

public class TarunyaBank {
    public static void main(String[] args) {
        BankClass data = new BankClass();
        data.BankSystem();
    }
}

