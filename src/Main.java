import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /* Subject technodom = new Store();

        Observer appleCustomer = new AppleCustomer("Marzhan"),
                 samsungCustomer = new SamsungCustomer("Adil"),
                 oppoCustomer = new OppoCustomer("Ruslan");

        technodom.addCustomer(appleCustomer);
        technodom.addCustomer(samsungCustomer);
        technodom.addCustomer(oppoCustomer);

        appleCustomer.print("The arrival of a new Iphone. More information:...");
        technodom.removeCustomer(appleCustomer);
        samsungCustomer.print("The arrival of a new Samsung smartphone. More information:...");
        technodom.sendMessage("1st October - Black Friday");*/

        Subject store = new Store();

        Observer observer1 = attachCustomer(store);
        try {
            observer1.print("Message for Observer1");
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }

        Observer observer2 = attachCustomer(store);
        try {
            observer2.print("Message for Observer2");
            store.removeCustomer(observer2);
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }

        Observer observer3 = new SamsungCustomer("Ruslan");
        store.addCustomer(observer3);
        observer3.print("Message for Observer3");

        store.sendMessage("Hello! Hi..");

        Observer observer4 = attachCustomer(store);
        try {
            observer4.print("Message for Observer4");
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }

        store.notifyAllCustomers();

    }

    private static Observer attachCustomer(Subject store){
        Observer observer = null;
        System.out.println( "Would you want to subscribe to the store's product notifications?\n" +
                "\tPlease answer: \"yes\" or \"no\"");
        String choice = scanner.nextLine();
        String userName;
        if (choice.equalsIgnoreCase("yes")){
            System.out.println( "Select the brand of products you need:\n" +
                    "\t1. \"Apple\"\n" +
                    "\t2. \"Samsung\"\n" +
                    "\t3. \"Oppo\"");
            String inputBrand = scanner.nextLine();
            switch (inputBrand){
                case "Apple":
                    userName = askUserName();
                    observer = new AppleCustomer(userName);
                    store.addCustomer(observer);
                    break;
                case "Samsung":
                    userName = askUserName();
                    observer = new SamsungCustomer(userName);
                    store.addCustomer(observer);
                    break;
                case "Oppo":
                    userName = askUserName();
                    observer = new OppoCustomer(userName);
                    store.addCustomer(observer);
                    break;
                default:
                    System.out.println("Incorrect brand name...");
            }
        } else if (choice.equalsIgnoreCase("no")){
            System.out.println("Ok..");
        }
        return observer;
    }

    private static String askUserName(){
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        return name;
    }

}
