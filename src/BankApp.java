public class BankApp {
    private String name;
    private BagelShop BagelShop;
    private CreditCard CreditCard;
    private Bank Bank;
    private int userBagels;

    public BankApp(String name, String cardPIN, BagelShop s, CreditCard c, Bank b) {
        this.name = name;
        BagelShop = s;
        CreditCard = c;
        Bank = b;
        userBagels = 0;
    }

    public String menu() {
        String str = "\n=========================\nEnter s to purchase at the bagel shop\nEnter r to return bagels at the shop\nEnter p to make a payment on the credit card\nEnter d to deposit bagel shop profits\nEnter i to check bagel shop inventory\nEnter c to compare credit card balances\nEnter n to create a new credit card";
        str += "\nEnter -1 to quit the program\n=========================";
        return str;
    }

    public String result(CreditCard chosenCard, CreditCard c1, CreditCard c2,BagelShop s, String action1, String action2) {
        if (action1.equals("s")) {
            return purchase(chosenCard, action2);
        }
        if (action1.equals("r")) {
            return returnBagels(chosenCard);
        }
        if (action1.equals("p")) {
            return makePayment(chosenCard, action2);
        }
        if (action1.equals("d")) {
            return depositProfit(s);
        }
        if (action1.equals("i")) {
            return checkInventory(s);
        }
        if (action1.equals("c")) {
            return compareBalances(c1, c2);
        }
        if (action1.equals("n")) {
            return "New credit card successfully created!\n";
        }
        return "";
    }

    public String purchase(CreditCard c, String action) {
        if (BagelShop.payForBagels(c, Integer.parseInt(action), c.getPersonalPIN())) {
            userBagels += Integer.parseInt(action);
            return "Purchase of " + action + " bagels was successful!\n";
        }
        return "";
    }

    public String returnBagels(CreditCard c) {
        if (userBagels == 0) {
            return "You have no bagels to return!\n";
        }
        BagelShop.returnBagels(c, userBagels, c.getPersonalPIN());
        return "You returned " + userBagels + " bagels successfully!\n";
    }

    public String makePayment(CreditCard c, String action){
        if (c.getBalanceOwed() <= 0) {
            return "You have no balance to pay off.\n";
        }
        c.reduceBalance(Integer.parseInt(action));
        return "You paid off $" + action + " successfully!\n";
    }

    public String checkInventory(BagelShop s) {
        return "The shop has " + s.getInventory() + " bagels.\n";
    }

    public String depositProfit(BagelShop s) {
        s.depositProfits();
        return "You successfully deposited profits!\n";
    }

    public String compareBalances(CreditCard c1, CreditCard c2) {
        String str = "\nCard 1 balance: " + c1.getBalanceOwed();
        if (!c2.getPersonalPIN().equals(c1.getPersonalPIN())) {
            str += "\nCard 2 balance: " + c2.getBalanceOwed();
        }
        return str + "\n";
    }

}
