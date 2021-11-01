import java.util.ArrayList;
import java.util.List;

public class Store implements Subject {
    private List<Observer> list = new ArrayList<>();
    String msg = "empty";

    @Override
    public void addCustomer(Observer o) {
        System.out.println("\t ---added the new customer: " + o.userName);
        list.add(o);
    }

    @Override
    public void removeCustomer(Observer o) throws NullPointerException {
        if (o == null){
            throw new NullPointerException("The subscriber does not exist");
        }
        System.out.println("\t ---removed the customer: " + o.userName);
        int index = list.indexOf(o);
        if(index >= 0) {
            list.remove(index);
        }
    }

    @Override
    public void notifyAllCustomers() {
        System.out.print("\n \t ---NOTIFICATION: ");
        for(Observer item : list)
            item.print(this.msg);
    }

    @Override
    public void sendMessage(String msg) {
        this.msg = msg;
        notifyAllCustomers();
    }
}
