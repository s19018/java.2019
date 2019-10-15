import java.util.ArrayList;

/**
 * ババ抜きの進行役を表すクラス。
 */
public class Master {
    /** プレイヤーのリスト */
    private ArrayList<Player> players_ = new ArrayList<>();

    /**
     * ゲームの準備をする。
     *
     * @param cards トランプを進行役の手札として渡す
     */
    public void prepareGame(Hand cards) {
        System.out.println("【カードを配ります】");

        // トランプをシャッフルする
        cards.shuffle();

        // トランプの枚数を取得する
        int numberOfCards = cards.getNumberofCards();

        // プレイヤーの人数を取得する
        int numberOfPlayers = players_.size();

        for (int index = 0; index < numberOfPlayers; index++) {
            // カードを1枚引く
            Card card = cards.pickCard();

            // 各プレイヤーに順番にカードを配る
            Player player = players_.get(index % numberOfPlayers);
            player.receiveCard(card);
        }
    }

    /**
     * ゲームを開始する。
     */
    public void startGame() {
        System.out.println("\n【ババ抜きを開始します】");

        // プレイヤーの人数を取得する
        for (int count = 0; players_.size() > 1; count++) {
            int playerIndex = count % players_.size();
            int nextPlayerIndex = (count + 1) % players_.size();

            // 指名するプレイヤーの取得
            Player player = players_.get(playerIndex);

            // 次のプレイヤーの取得
            Player nextPlayer = players_.get(nextPlayerIndex);

            // プレイヤーを指名する
            System.out.println("\n" + player + "さんの番です");
            player.play(nextPlayer);

        }

        // プレイヤーが上がって残り1名になるとループを抜ける
        System.out.println("【ババ抜きを終了しました】");
    }

}
