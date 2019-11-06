import trump.Card;
import trump.Master;
import trump.Table;
import trump.Player;
import trump.Rule;

/**
 * 大貴族のプレイヤークラス。
 */
public class NoblePlayer extends Player {

  /**
   * コンストラクタ。
   *
   * @param name プレイヤーの名前
   * @param master 進行役
   * @param table テーブル
   * @param rule ルール
   */
  public NoblePlayer(String name, Master master, Table table, Rule rule) {
    super(name, master, table, rule);
  }

  /**
   * 順番を指名する。
   *
   * @param nextPlayer 次のプレイヤー
   */
  @Override
  public void play(Player nextPlayer) {
    // 現在の手札を表示する
    System.out.println("手札: " + myHand_);
    // テーブルのカードを表示する
    System.out.println("テーブル: " + table_);

    // 現在の手札からテーブルに出せるものを探す
    Card [] candidate = null;
    if (((NobleMaster)master_).isContinueGame()) {

      candidate = rule_.findCandidate(myHand_, table_);
    } else {
      candidate = ((NobleRule)rule_).findCandidate(myHand_, table_, true);
    }

    // 候補がある場合はテーブルに出す
    if (candidate != null) {
      ((NobleMaster)master_).setisContinueGame(); // 継続フラグのセット、パスしたプレイヤーのバッファのリセット
      for (int i = 0; i < candidate.length; i++) {
        System.out.print(" " + candidate[i]);
      }
      System.out.println("を置きました。\n");
      table_.putCard(candidate);

      // 手札がなくなったら、上がりを宣言する
      if (myHand_.getNumberofCards() == 0) {
        master_.declareWin(this);
      } 
    } else {
      // テーブルに出せるカードがなかった場合、パスする
      ((NobleMaster)master_).pass(this);
    }
  }
}
