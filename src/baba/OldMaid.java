import java.util.ArrayList;
public class OldMaid {
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int number = 1; number <= 13; number++) {
            cards.add(new Card(Card.SUIT_CLUB, number));
            cards.add(new Card(Card.SUIT_DIAMOND, number));
            cards.add(new Card(Card.SUIT_HEART, number));
            cards.add(new Card(Card.SUIT_SPADE, number));
        }

        // ジョーカーの作成
        cards.add(new Card(0, Card.JOKER));

        for (int i = 0; i < 53; i++) {
            System.out.print(cards.get(i));
            System.out.print(" ");
            System.out.println(cards.get(i).geNumber());
        }
        
    }
}
