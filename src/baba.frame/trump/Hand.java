package trump;

import java.util.ArrayList;

/**
 * 手札を表すクラス。
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
     * カードを見る。
     * positionは 0 から getNumberofCards() の範囲で指定すること。
     *
     * @param position カードの位置
     * @return position で指定された位置のカード、範囲外の場合はnullを返す
     */
    public Card lookCard(int position) {
        Card lookingCard =null;

        // 引数で指定された位置が妥当であるかチェックする
        if ((0 <= position) && (position < hand_.size())) {
            lookingCard = hand_.get(position);
        }

        return lookingCard;
    }

    /**
     * カードを引く。
     * 引いたカードは手札から削除される。
     *
     * @param position カードの位置
     * @return position で指定された引いたカード。範囲外の場合はnullを返す。
     */
    public Card pickCard(int position) {
        Card pickedCard = null;

        // 引数で指定された位置が妥当であるかチェックする
        if ((0 <= position) && (position < hand_.size())) {
            pickedCard = hand_.remove(position);
        }
        return pickedCard;
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

    /**
     * 同じ数のカードを探す。
     * 同じ数のカードが無い場合は null を返します。
     *
     * @return 同じ数のカード
     */
    // public Card[] findSameNumberCard() {
    //     int numberOfCards = hand_.size();
    //     Card[] sameCards = null;

    //     // 手札にカードが1枚もない場合は何もしない
    //     if (numberOfCards > 0) {
    //         // 最後に追加されたカードを取得する
    //         int lastIndex = numberOfCards - 1;
    //         Card lastAddedCard = hand_.get(lastIndex);

    //         // 最後に追加されたカードの数字を取得する
    //         int lastAddedCardNum = lastAddedCard.getNumber();

    //         for (int index = 0; index < lastIndex; index++) {
    //             Card card = hand_.get(index);
    //             if (card.getNumber() == lastAddedCardNum) {
    //                 // 最後に追加されたカードと同じカードが見つかった場合
    //                 // 見つかった組み合わせをsameCardsに格納し、ループを抜ける
    //                 sameCards = new Card[2];
    //                 sameCards[0] = hand_.remove(lastIndex);
    //                 sameCards[1] = hand_.remove(index);
    //                 break;
    //             }

    //         }
    //     }

    //     return sameCards;
    // }

    /**
     * 手札にあるカードを文字列で表現する。
     * ObjectクラスのtoStringメソッドをオーバライドしたメソッド。
     *
     * @return 手札にあるカードの文字列表現
     */
    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();

        int size = hand_.size();
        if (size > 0) {
            for (int index = 0; index < size; index++) {
                Card card = hand_.get(index);
                string.append(card);
                string.append(" ");
            }
        }

        return string.toString();
    }

}
