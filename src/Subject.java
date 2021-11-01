public interface Subject {
    void addCustomer(Observer o);
    void removeCustomer(Observer o);
    void notifyAllCustomers();
    void sendMessage(String msg);
}