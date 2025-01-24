public class VendingMachine {

    private VendingMachine() {}
    private static class VendingMachineSingleton {
        private static final VendingMachine vendingMachineSingleton = new VendingMachine();
    }
    public static VendingMachine getInstance() {
        return VendingMachineSingleton.vendingMachineSingleton;
    }
}
