import trump.Master;
import trump.Player;
import java.util.ArrayList;

/**
 * 大貴族の進行役のクラス
 */
public class NobleMaster extends Master {
  /** パスできる制限回数 */
  public static final int PASS_LIMIT = 3;

  /* パスしたplayerのインスタンスを保存する */
  private ArrayList<Player> passPlayers = new ArrayList<>();

  private boolean isContinueGame = false;

    /*
     * パスを宣言する。
     *
     * @param player パスするプレイヤー
     */
    public void pass(NoblePlayer player) {
      // パスを表示
      System.out.println (
        " " + player + "さんは" + player.getPass() + " 回目のパスをしました！");

      // ゲームがリセットした場合
      if (!isContinueGame) {
        passPlayers.clear();
        isContinueGame = true; // 以降継続
      }      

      passPlayers.add(player);

      if (passPlayers.size() >= players_.size() -1) {
        // ゲームはリセット
        isContinueGame = false;
      }

    }

    /**
     * ゲームが継続中かどうかを返す。
     *
     * @return 継続中 true、 新規 false
     */
    public boolean isContinueGame() {
      return isContinueGame;
    }
}
