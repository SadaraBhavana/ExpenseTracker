import java.util.Scanner;

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] categories = new String[100];
        double[] amounts = new double[100];
        String[] dates = new String[100];

        int count = 0;
        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Record Daily Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Monthly Spending");
            System.out.println("4. Categorise Expenses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    if (count < 100) {
                        System.out.print("Enter expense date (DD-MM-YYYY): ");
                        dates[count] = sc.nextLine();

                        System.out.print("Enter category (Food, Travel, Shopping, Bills): ");
                        categories[count] = sc.nextLine();

                        System.out.print("Enter amount: ");
                        amounts[count] = sc.nextDouble();

                        if (amounts[count] > 0) {
                            count++;
                            System.out.println("Expense recorded successfully!");
                        } else {
                            System.out.println("Amount must be greater than zero.");
                        }
                        sc.nextLine();
                    } else {
                        System.out.println("Expense storage is full!");
                    }
                    break;

                case 2:
                    System.out.println("\n----- ALL EXPENSES -----");

                    if (count == 0) {
                        System.out.println("No expenses recorded.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println(
                                dates[i] + " | " +
                                categories[i] + " | Rs. " +
                                amounts[i]
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter month (MM): ");
                    String month = sc.nextLine();

                    System.out.print("Enter year (YYYY): ");
                    String year = sc.nextLine();

                    double total = 0;

                    for (int i = 0; i < count; i++) {
                        String[] parts = dates[i].split("-");

                        if (parts.length == 3 &&
                            parts[1].equals(month) &&
                            parts[2].equals(year)) {
                            total += amounts[i];
                        }
                    }

                    System.out.println("Monthly Spending: Rs. " + total);
                    break;

                case 4:
                    System.out.println("\n----- EXPENSE CATEGORIES -----");

                    String[] types = {
                        "Food", "Travel", "Shopping", "Bills"
                    };

                    for (String type : types) {
                        double categoryTotal = 0;

                        for (int i = 0; i < count; i++) {
                            if (categories[i].equalsIgnoreCase(type)) {
                                categoryTotal += amounts[i];
                            }
                        }

                        System.out.println(
                            type + ": Rs. " + categoryTotal
                        );
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
