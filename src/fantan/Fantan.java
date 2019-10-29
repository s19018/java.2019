//package fantan;

import trump.Card;
import trump.Master;
import trump.Table;
import trump.Hand;
import trump.Player;
import trump.Rule;


/**
 * 七並べプログラム。
 */
public class Fantan
{
    public static void main(String [] args) {

      // 進行役の生成
      Master master = new FantanMaster();

      // テーブルの生成
      Table table = new FantanTable();

      // ルールの生成
      Rule rule = new FantanRule();

      // プレイヤーの生成
      Player murata = new FantanPlayer("村田", master, table, rule);
      Player yamada = new FantanPlayer("山田", master, table, rule);
      Player saito = new FantanPlayer("斎藤", master, table, rule);

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
        return trump;
    }


    private static void print_c(Card[][] c) {
        StringBuffer tableString = new StringBuffer(200);
        for (int suit = 0; suit < Card.SUIT_NUM; suit++) {
            for ( int number = 0; number < Card.CARD_NUM; number++) {
                if (c[suit][number] != null) {
                    tableString.append(c[suit][number]);
                } else {
                    tableString.append("..");
                }
                tableString.append(" ");
            }

            tableString.append("\n");
        }

        System.out.println("配列の中身");
        System.out.println(tableString.toString());
    }
}
