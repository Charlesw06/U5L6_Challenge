public class BankApp {
    private String name;
    private int numOfCards;
    private String cardPIN;
    private BagelShop BagelShop;
    private CreditCard CreditCard;
    private Bank Bank;
    private int userBagels;

    public BankApp(String name, String cardPIN, BagelShop s, CreditCard c, Bank b) {
        this.name = name;
        numOfCards = 1;
        this.cardPIN = cardPIN;
        BagelShop = s;
        CreditCard = c;
        Bank = b;
        userBagels = 0;
    }

    public String menu() {
        String str = "\n=========================\nEnter s to purchase at the bagel shop\nEnter r to return bagels at the shop\nEnter p to make a payment on the credit card\nEnter d to deposit bagel shop profits\nEnter i to check bagel shop inventory\nEnter c to compare credit card balances";
        if (numOfCards == 1) {
            str += "\nEnter n to create second credit card";
        }
        str += "\nEnter -1 to quit the program\n=========================";
        return str;
    }

    public String result(String action1, String action2) {
        if (action1.equals("s")) {
            return purchase(action2);
        }
        if (action1.equals("r")) {
            return returnBagels();
        }
        if (action1.equals("p")) {

        }
        if (action1.equals("i")) {

        }
        if (action1.equals("c")) {

        }
        if (action1.equals("n")) {

        }
        if (action1.equals("r")) {

        }
        if (action1.equals("-1")) {

        }
        return "";
    }

    public String purchase(String action) {
        if (BagelShop.payForBagels(CreditCard, Integer.parseInt(action), cardPIN)) {
            userBagels += Integer.parseInt(action);
            return "\n\n=========================\nPurchase of " + action + " bagels was successful!\n=========================";
        }
        return "";
    }

    public String returnBagels() {
        if (userBagels == 0) {
            return "\n\n=========================\nYou have no bagels to return!\n=========================";
        }
        BagelShop.returnBagels(CreditCard, userBagels, cardPIN);
        return "\n\n=========================\nYou returned " + userBagels + "successfully!\n=========================";
    }

    public String makePayment(){

    }
    public String deposit() {
        
    }
}
