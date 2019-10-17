import trump.Card;
import trump.Table;

/**
 * ババ抜きのテーブルを表すクラス。
 */
public class OldMaidTable implements Table {
    /** カードを並べるテーブルを表す2次元配列 */
    private Card[][] table_ = new Card[Card.SUIT_NUM][Card.CARD_NUM];

    /**
     * カードを置く。
     *
     * @param card カード
     */
    @Override
    public void putCard(Card[] card) {
       for (int i = 0; i < card.length; i++) {
           int number = card[i].getNumber();
           int suit = card[i].getSuit();

           // テーブルにカードを置く
           table_[suit - 1][number - 1] = card[i];
       } 
    }

    /**
     * カードを見る。
     *
     * @return テーブルに置かれたカードを表す配列
     */
    @Override
    public Card[][]  getCards() {
        return table_;
    }

    /**
     * テーブルを文字列で表現する。
     * ObjectクラスのtoStringメソッドのをオーバライドしたメソッド。
     *
     * @return テーブルの文字列表現
     */
    public String toString() {
        StringBuffer tableString = new StringBuffer(200);
        for (int suit = 0; suit < Card.SUIT_NUM; suit++) {
            for (int number = 0; number < Card.CARD_NUM; number++) {
                if (table_[suit][number] != null) {
                    tableString.append(table_[suit][number]);
                } else {
                    tableString.append("..");
                }

                tableString.append(" ");
            }
            tableString.append("\n");
        }

        return tableString.toString();
    }
}
