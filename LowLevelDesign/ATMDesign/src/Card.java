public class Card {
    String cardNumber;
    int pin;

    public boolean isCardPinCorrect(int pin) {
        return this.pin == pin;
    }
}
