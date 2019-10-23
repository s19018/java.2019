import trump.Card;
import trump.Master;
import trump.Table;
import trump.Player;
import trump.Rule;
import trump.Hand;

/**
 * ババ抜きのプレイヤークラス。
 */
public class OldMaidPlayer extends Player {

    /**
     * コンストラクタ。
     *
     * @param name プレイヤーの名前
     * @param master 進行役
     * @param table テーブル
     * @param rule ルール
     */
    public OldMaidPlayer(String name, Master master, Table table, Rule rule) {
        super(name, master, table, rule);
    }

    /** カードを配る。
     *
     * @param card 受け取ったカード
     */
    @Override
    public void receiveCard(Card card) {
        // 引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
        dealCard(card);

    }

    /**
     * 順番を指名する。
     *
     * @param nextPlayer 次のプレイヤー
     */
    @Override
    public void play(Player nextPlayer) {
        // 次のプレイヤーに手札を出してもらう
        Hand nextHand = ((OldMaidPlayer)nextPlayer).showHand();

        // 相手の手札からカードを1枚引く
        Card pickedCard = nextHand.pickCard(0);

        // 引いた結果を表示
        System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + " を引きました");

        // 引いたカードを手札に加え、同じ数のカードがあったらすてる 
        dealCard(pickedCard);

        // 手札がゼロになったかどうか調べる
        if (myHand_.getNumberofCards() == 0) {
            // 進行役に上がりを宣言する
            master_.declareWin(this);
        } else {
            // 現在の手札を表示する
            System.out.println(this + ":残りの手札は " + myHand_ + "です");
        }
    }

    /**
     * 手札を見せる。
     *
     * @return 自分の手札
     */
    public Hand showHand() {
        // もしこの時点で手札が残り1枚ならば上がりとなるので宣言する
        if  (myHand_.getNumberofCards() == 1) {
            // 進行役に上がりを宣言する
            master_.declareWin(this);
        }

        // 見せる前にシャッフルする
        myHand_.shuffle();

        return myHand_;
    }

    /**
     * カードを自分の手札に加え、同じ数のカードがあったら捨てる。
     *
     * @param card
     */
    private void dealCard(Card card) {
        // カードを自分の札に加える
        super.receiveCard(card);

        // 今加えたカードと同じカードを探す
        Card[] cards = rule_.findCandidate(myHand_, table_); 

        // 同じカードの組み合わせがそんざいした場合
        if (cards != null) {
            // テーブルへカードを捨てる
            table_.putCard(cards);
        }
    }
}
