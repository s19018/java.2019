import trump.Card;
import trump.Table;

/**
 * 大貴族のテーブルを表すクラス。
 */
public class NobleTable implements Table {

  /** 最新の置かれたカード */
  private Card[] putTopCards =  {
    new Card(Card.SUIT_CLUB, 2),
    new Card(Card.SUIT_DIAMOND, 2),
    new Card(Card.SUIT_HEART, 2),
    new Card(Card.SUIT_SPADE, 2),
  };

    /**
     * カードを置く
     *
     * @param card カード
     */
    @Override
    public void putCard(Card[] card) {
      putTopCards = new Card[card.length];
      for (int i = 0; i < card.length; i++) {
        putTopCards[i] = card[i];
      }
    }

    /**
     * カードを見る。
     *
     * @return テーブルに置かれたカードを表す配列
     */
    @Override
    public Card[][] getCards() {
        Card [][] cards = new Card[1][putTopCards.length];
          System.arraycopy(putTopCards, 0, cards[0], 0, putTopCards.length);
        return cards;
    }

    /**
     * テーブルを文字列で表現する。
     * ObjectクラスのtoStringメソッドをオーバライドしたメソッド。
     *
     * @return テーブルの文字列表現
     */
    @Override
    public String toString() {
        StringBuffer cardsString = new StringBuffer(200);
        for (int i = 0; i < putTopCards.length; i++) {
          cardsString.append(putTopCards[i]);
          cardsString.append(" ");
        }
        cardsString.append("\n");

        return cardsString.toString();
    }
}
