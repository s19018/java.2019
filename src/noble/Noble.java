import trump.Card;
import trump.Master;
import trump.Table;
import trump.Hand;
import trump.Player;
import trump.Rule;
import trump.Joker;

/**
 * 大貴族のプログラム。
 */
public class Noble {
  public static void main(String[] args) {
    // 進行役の生成
    Master master = new NobleMaster();

    // テーブルの生成
    Table table = new NobleTable();

    // ルールの生成
    Rule rule = new NobleRule();

    // プレイヤーの生成
    Player murata = new NoblePlayer("村田", master, table, rule);
    Player yamada =  new NoblePlayer("山田", master, table, rule);
    Player saito = new NoblePlayer("斎藤", master, table, rule);

  // プレイヤーの登録
  master.registerPlayer(murata);
  master.registerPlayer(yamada);
  master.registerPlayer(saito);

  // トランプを生成する
  Hand trump = createTrump();

  // ゲームの準備をする
  master.prepareGame(trump);

  // ゲームを開始する
  master.startGame();
  }


  /**
   * 52枚のトランプを生成する。
   *
   * @return トランプを格納したHand
   */
  private static Hand createTrump() {
      Hand trump = new Hand();

      // 各スート52枚のカードを生成する

      for (int number = 1; number <= 13; number++) {
          trump.addCard(new Card(Card.SUIT_CLUB, number));
          trump.addCard(new Card(Card.SUIT_DIAMOND, number));
          trump.addCard(new Card(Card.SUIT_HEART, number));
          trump.addCard(new Card(Card.SUIT_SPADE, number));

      }
      // ジョーカも追加
      trump.addCard(new Joker());
      return trump;
  }
}
