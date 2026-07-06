public interface Stock {
    void registObserver(Observer o);
    void deleteObserver(Observer o);
    void messageObservers();
}