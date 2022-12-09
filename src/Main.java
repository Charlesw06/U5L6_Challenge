import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Bank App!");
        Scanner n = new Scanner(System.in);
        System.out.print("\nWhat is your name: ");
        String userName = n.nextLine();

        Scanner p = new Scanner(System.in);
        System.out.print("What is your card 1 pin number: ");
        String userPin = p.nextLine();

        Bank bank = new Bank();
        BagelShop shop = new BagelShop("Jonny's Bagels", 25, 3, bank);
        CreditCard card1 = new CreditCard(userName, userPin);

        BankApp app = new BankApp(userName, userPin, shop, card1, bank);
        Scanner a = new Scanner(System.in);
        System.out.print(app.menu());
        System.out.print("\n\nWhat is your action: ");
        String action1 = a.nextLine();
        String action2 = "";
        String chooseCard = "";
        int payment = 0;
        CreditCard card2 = new CreditCard(userName, userPin);

        while (!(action1.equals("-1"))) {
            if (action1.equals("n")) {
                if (!card1.getPersonalPIN().equals(card2.getPersonalPIN())) {
                    System.out.print("You already have a second card!");
                } else {
                    System.out.print("What is your card 2 pin number: ");
                    userPin = p.nextLine();
                    while (userPin.equals(card1.getPersonalPIN())) {
                        System.out.print("Enter a pin different from your first card's pin: ");
                        userPin = p.nextLine();
                    }
                    card2.setPersonalPIN(userPin);
                }
            }

            if (action1.equals("s")) {
                System.out.print("How many bagels do you want: ");
                action2 = a.nextLine();
            }
            if (action1.equals("p")) {
                System.out.print("How much do you want to pay back (must be integer): ");
                payment = a.nextInt();
            }

            if ((action1.equals("s")) || (action1.equals("r")) || (action1.equals("p"))) {
                if (!card2.getPersonalPIN().equals(card1.getPersonalPIN())) {
                    System.out.print("Choose a card to use (1 or 2): ");
                    chooseCard = a.nextLine();
                }
            }

            if (action1.equals("p")) {
                pickCardResult(card1, card2, chooseCard, app, shop, action1, Integer.toString(payment));
            }
            else {
                pickCardResult(card1, card2, chooseCard, app, shop, action1, action2);
            }

            System.out.print(app.menu());
            System.out.print("\n\nWhat is your action: ");
            action1 = a.nextLine();
        }
    }

    public static void pickCardResult(CreditCard c1, CreditCard c2, String chooseCard, BankApp app, BagelShop s, String action1, String action2) {
        if (!c2.getPersonalPIN().equals(c1.getPersonalPIN())) {
            if (chooseCard.equals("1")) {
                System.out.print(app.result(c1, c1, c2, s, action1, action2));
            }
            if (chooseCard.equals("2")) {
                System.out.print(app.result(c2, c1, c2, s, action1, action2));
            }
        }
        else {
            System.out.print(app.result(c1, c1, c2, s, action1, action2));
        }
    }
}
