import trump.Master;
import trump.Player;
import java.util.ArrayList;

/**
 * 大貴族の進行役のクラス
 */
public class NobleMaster extends Master {
  /* パスしたplayerのインスタンスを保存する */
  private ArrayList<Player> passPlayers = new ArrayList<>();

  private boolean isContinueGame = true;

  /*
   * パスを宣言する。
   *
   * @param player パスするプレイヤー
   */
  public void pass(NoblePlayer player) {
    System.out.println(player + "さんがパスしました。");

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

  /**
   * ゲーム継続中フラグをセットする。
   *
   */
  public void setisContinueGame() {
    passPlayers.clear();
    isContinueGame = true;
  }
}
