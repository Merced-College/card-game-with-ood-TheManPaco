/**
 * Card class represents a playing card with suit, name, value and picture
 */
public class Card {
    // Instance variables
    private String cardSuit;
    private String cardName;
    private int cardValue;
    private String cardPicture;

    /**
     * Constructor for Card
     * @param cardSuit the suit of the card (e.g., Hearts, Spades)
     * @param cardName the name of the card (e.g., Ace, King)
     * @param cardValue the numeric value of the card
     * @param cardPicture the picture representation of the card
     */
    public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
        this.cardSuit = cardSuit;
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.cardPicture = cardPicture;
    }

    // Accessors (getters)
    public String getCardSuit() {
        return cardSuit;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardPicture() {
        return cardPicture;
    }

    // Mutators (setters)
    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public void setCardPicture(String cardPicture) {
        this.cardPicture = cardPicture;
    }

    /**
     * Checks if two cards are equal based on their name and value
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return cardValue == other.cardValue && cardName.equals(other.cardName);
    }

    /**
     * Returns a string representation of the card
     */
    @Override
    public String toString() {
        return cardName + " of " + cardSuit + " (Value: " + cardValue + ")";
    }
}
