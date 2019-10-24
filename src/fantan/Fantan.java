//package fantan;

import trump.Card;
import trump.Master;
import trump.Table;
import trump.Hand;
import trump.Player;
import trump.Rule;


/**
 * 七並べプログラム。
 */
public class Fantan
{
    public static void main(String [] args) {
        Table table = new FantanTable();
        System.out.println(table);
        Card [] cards = {new Card(Card.SUIT_HEART, 1)};
        table.putCard(cards);
        cards[0] = new Card(Card.SUIT_CLUB, 13);
        table.putCard(cards);
        cards[0] = new Card(Card.SUIT_DIAMOND, 5);
        table.putCard(cards);
        cards[0] = new Card(Card.SUIT_SPADE, 8);
        table.putCard(cards);
        System.out.println(table);

        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_SPADE, 7));
        hand.addCard(new Card(Card.SUIT_DIAMOND, 7));
        Rule rule = new FantanRule();
        cards = rule.findCandidate(hand, table);
        System.out.println(cards[0]);
        cards = rule.findCandidate(hand, table);
        if (cards == null) {
            System.out.println("not found");
        } else {
            System.out.println("error");
        }
        

        // Card[][] tmp = table.getCards();
        // print_c(tmp);
    }

    private static void print_c(Card[][] c) {
        StringBuffer tableString = new StringBuffer(200);
        for (int suit = 0; suit < Card.SUIT_NUM; suit++) {
            for ( int number = 0; number < Card.CARD_NUM; number++) {
                if (c[suit][number] != null) {
                    tableString.append(c[suit][number]);
                } else {
                    tableString.append("..");
                }
                tableString.append(" ");
            }

            tableString.append("\n");
        }

        System.out.println("配列の中身");
        System.out.println(tableString.toString());
    }
}
