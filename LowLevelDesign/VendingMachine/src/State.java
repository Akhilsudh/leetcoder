public interface State {
    void clickAcceptCoin();

    void clickAcceptItemCode();



    int returnChange(int change);
    int returnAllChange(VendingMachine machine);
}
