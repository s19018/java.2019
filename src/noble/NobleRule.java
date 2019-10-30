import trump.Card;
import trump.Table;
import trump.Hand;
import trump.Rule;

/**
 * 大貴族用のルールクラス。
 */
public class NobleRule implements Rule {
  /**
   * テーブルに置けるカードを探す。
   *
   * @param hand 手札
   * @param table テーブル
   * @return 見つかったカードの組み合わせ。見つからなかった場合はnullを返す
   */
  @Override
  public Card[]  findCandidate(Hand hand, Table table ) {
    // テーブルに置けるカードの候補
    Card [] candidate = null;

    // 現在テーブルに置かれているカードを取得
    Card [][] putCards = table.getCards();

    // カードの数と何枚組かを取得
    int cardNo = putCards[0][0].getNumber();
    int cardNum = putCards[0].length;

    int candidateNo = isThereCard(table, hand, cardNo, cardNum);

    System.out.println("candidateNo = " + candidateNo);

    if (candidateNo >= 0) {
      // カードの組数分のエリアを確保
      candidate = new Card[cardNum];
      int index = 0;
      // 手札にあるカードを1枚ずつチェックして、テーブルに置けるか調べる
      int numberOfHand = hand.getNumberofCards();
      for ( int position = 0; position < numberOfHand; position++) {
        // 手札にあるカードを見る
        Card lookingCard = hand.lookCard(position);
        int number = lookingCard.getNumber();

        if (number == candidateNo) {
          // 手札からカードを引いて候補とする
          candidate[index] = hand.pickCard(position);
          index += 1;
        }
      }
    }
    return candidate;
  }

  /**
   * テーブルに置けるnumberを調べる。
   *
   * @param table テーブル
   * @param hand 手札
   * @param cardNo 現在テーブルに置かれているカードの数
   * @param cardNum 現在テーブルに置かれているカードの組数
   * @return 置けるカードのnumber
   */
  private int isThereCard(Table table, Hand hand, int cardNo, int cardNum) {

    // 見つかったカードの番号を返す
    int ret = -1;
    // カードの数と枚数を保存する
    int [] cardCount = new int[14];

    // 手札にあるカードのカードの数と枚数を調べる
    int numberOfHand = hand.getNumberofCards();
    for ( int position = 0; position < numberOfHand; position++) {
      // 手札にあるカードを見る
      Card lookingCard = hand.lookCard(position);
      int number = lookingCard.getNumber();
      // 3 4 5 6 7 8 9 10 J(11) Q(12) K(13) JK(0)  1  2
      // 0 1 2 3 4 5 6  7     8     9    10    11 12 13
      if (number <= 2) {
        number += 11;
      }
      number -= 3;
      cardCount[number]++;
    }

    // debug
    System.out.print("cardCount:");
    for (int i = 0; i < cardCount.length; i++) {
      System.out.print(cardCount[i] + " ");
    }
    System.out.println();

    if (cardNo <= 2) {
      cardNo += 11;
    }
    cardNo -= 3;

    for (int i = cardNo + 1; i < cardCount.length; i++) {
      System.out.println("cardCount[" + i + "] = " + cardCount[i] + " cardNum = " + cardNum);
      if (cardCount[i] >= cardNum) {
        ret = i + 3;
        if (ret > 13) {
          ret -= 11;
        }
        break;
      }
    }
    return ret;
  }
}
