import trump.Card;
import trump.Table;
import trump.Hand;
import trump.Rule;

/**
 * ババ抜きのルールクラス。
 */
public class OldMaidRule implements Rule {
    /**
     * テーブルに置けるカードを探す。
     *
     * @param hand 手札
     * @param table テーブル
     * @return 見つかったカードの組み合わせ。見つからなかった場合はnullを返す
     */
    public Card[] findCandidate(Hand hand, Table table) {
        // テーブルに置けるカードの候補
        Card[] candidate = null;

        // 最後に追加されたカードと同じ番号のカードがないかチェック 
        int numberOfCards = hand.getNumberofCards();

        // 手札にカードが1枚もない場合は何もしない
        if (numberOfCards > 0) {
            // 最後に追加されたカードを取得する
            int lastIndex = numberOfCards - 1;
            Card lastAddedCard = hand.lookCard(lastIndex);

            // 最後に追加されたカードの数字を取得する
            int lastAddedCardNum = lastAddedCard.getNumber();

            for (int index = 0; index < lastIndex; index++) {
                Card card = hand.lookCard(index);
                if (card.getNumber() == lastAddedCardNum) {
                    // 最後に追加されたカードと同じカードが見つかった場合
                    // 見つかった組み合わせをsameCardsに格納し、ループを抜ける
                    candidate = new Card[2];
                    candidate[0] = hand.pickCard(lastIndex);
                    candidate[1] = hand.pickCard(index);
                    break;
                }

            }
        }

        return candidate;
    }
}
