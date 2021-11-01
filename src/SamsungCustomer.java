public class SamsungCustomer extends Observer {

    public SamsungCustomer(String name) {
        this.userName = name;
    }

    @Override
    public void print(String msg) throws NullPointerException{
        if (userName == null){
            throw new NullPointerException("The subscriber does not exist");
        }
        System.out.println("\n" + this.userName + ": " + msg);
    }

}