import java.util.ArrayList;

public class StockMarket implements Stock {

    private ArrayList<Observer> observers;
    private double price;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void registObserver(Observer o) {
        observers.add(o);
    }

    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    public void messageObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }

    // Method to change price
    public void changePrice(double price) {
        this.price = price;
        messageObservers(); // notify all
    }
}