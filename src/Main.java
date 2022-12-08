import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Bank App!");
        Scanner n = new Scanner(System.in);
        System.out.print("\nWhat is your name: ");
        String userName = n.nextLine();

        Scanner p = new Scanner(System.in);
        System.out.print("What is your pin number: ");
        String userPin = p.nextLine();

        Bank bank = new Bank();
        BagelShop shop = new BagelShop("Jonny's Bagels", 25, 3, bank);
        CreditCard card1 = new CreditCard(userName, userPin);

        BankApp app = new BankApp(userName, userPin, shop, card1, bank);
        Scanner a = new Scanner(System.in);
        System.out.print(app.menu());
        System.out.print("\n\nWhat is your action: ");
        String action = a.nextLine();
        String action2 = "";

        Scanner pin = new Scanner(System.in);
        String enteredPin = "";

        while (!action.equals("-1")) {
            System.out.print("Enter your pin: ");
            enteredPin = pin.nextLine();

            if ((action.equals("s")) || (action.equals("r")) || (action.equals("p")) && Bank
            if (action.equals("s")) {
                System.out.print("How many bagels do you want: ");
                action2 = a.nextLine();
                System.out.print(app.result(action, action2));
            }
            if (action.equals("r")) {
                System.out.print(app.result(action, action2));
            }

            System.out.print(app.menu());
            System.out.print("\n\nWhat is your action: ");
            action = a.nextLine();
        }

    }
}
