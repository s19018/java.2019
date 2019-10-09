import java.util.ArrayList;

/**
 * ばば抜きの手札を表すクラス。
 */
public class Hand {
    /** 手札にあるカードを保持するためのリスト */
    private ArrayList<Card> hand_ = new ArrayList<>();

    /**
     * カードを加える。
     *
     * @param card 加えるカード
     */
    public void addCard(Card card) {
        //  カードをリストの最後に追加する
        hand_.add(card);
    }

    /**
     * カードを引く。
     *
     * @return 引いたカード
     */
    public Card pickCard() {
        Card pickCard = hand_.remove(0);
        return pickCard;
    }

    /**
     * シャッフルする。
     */
    public void shuffle() {
        // 手札の枚数を取得
        int number = hand_.size();

        // カードを抜き出す位置
        int pos;

        // カードをランダムに抜き取って最後に加える動作を繰り返す
        for (int count = 0; count < number * 2; count++) {
            // ランダムな位置からカードを1枚抜き取る
            pos = (int) (Math.random() * number);
            Card pickCard = hand_.remove(pos);

            // 抜き取ったカードを最後に加える
            hand_.add(pickCard);
        }
    }

    /**
     * 枚数を数える。
     *
     * @return 手札にあるカードの枚数
     */
    public int getNumberofCards() {
        return hand_.size();
    }
}
