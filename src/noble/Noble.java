import trump.Card;
import trump.Master;
import trump.Table;
import trump.Hand;
import trump.Player;
import trump.Rule;
import trump.Joker;

/**
 * 大貴族のプログラム。
 */
public class Noble {
  public static void main(String[] args) {
    Table table = new NobleTable();
    Card[] cards;

    cards = new Card[] {
      new Card(Card.SUIT_SPADE, 3),
      new Card(Card.SUIT_DIAMOND, 3),
      new Card(Card.SUIT_CLUB, 3),
      new Card(Card.SUIT_HEART, 3)
    };

    table.putCard(cards);

    cards = new Card[] {
      new Card(Card.SUIT_SPADE, 6),
      new Card(Card.SUIT_DIAMOND, 6),
      new Card(Card.SUIT_CLUB, 6),
      new Card(Card.SUIT_HEART, 6)
    };

    table.putCard(cards);

    cards = new Card[] {
      new Card(Card.SUIT_SPADE, 13),
      new Card(Card.SUIT_DIAMOND, 13),
      new Card(Card.SUIT_CLUB, 13),
      new Card(Card.SUIT_HEART, 13)
    };

    table.putCard(cards);

    System.out.println(table);

    Card [][] ret = table.getCards();

    System.out.print("現在のカード: ");
    for (int i = 0; i < ret[0].length; i++) {
      System.out.print(ret[0][i] + " ");
    }
    System.out.println();

    Hand hand = new Hand();
    hand.addCard(new Card(Card.SUIT_CLUB, 10));
    hand.addCard(new Card(Card.SUIT_SPADE, 10));
    hand.addCard(new Card(Card.SUIT_DIAMOND, 10));
    hand.addCard(new Card(Card.SUIT_CLUB, 1));
    hand.addCard(new Card(Card.SUIT_SPADE, 1));
    hand.addCard(new Card(Card.SUIT_DIAMOND, 1));
    hand.addCard(new Joker());

    System.out.println("手札: " + hand);

    Rule rule = new NobleRule();
    Card [] ret2 = rule.findCandidate(hand, table);

    if ( ret2 != null) {
      System.out.print("テーブルに置けるカード: ");
      for (int i = 0; i < ret2.length; i++) {
        System.out.print(ret2[i] + " ");
      }
      System.out.println();

      table.putCard(ret2);

      ret = table.getCards();
      System.out.print("テーブル: ");
      for (int i = 0; i < ret[0].length; i++) {
        System.out.print(ret[0][i] + " ");
      }
      System.out.println();

      System.out.println("手札: " + hand);


    } else {
      System.out.println("テーブルに置けるカードはありません。");
    }
  }
}
