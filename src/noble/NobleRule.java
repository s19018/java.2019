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
  public Card[]  findCandidate(Hand hand, Table table) {
    // テーブルに置けるカードの候補
    Card [] candidate = null;

    int [] cardCount = checkHand(hand);

    // 現在テーブルに置かれているカードを取得
    Card [][] putCards = table.getCards();

    // カードの数と何枚組かを取得
    int cardNo = putCards[0][0].getNumber();
    int cardNum = putCards[0].length;

    int candidateNo = contGetNo(table, hand, cardNo, cardNum, cardCount);

    // debug
    // System.out.println("cardNo =" + cardNo + " ,cardNum = " + cardNum);
    // System.out.println("candidateNo = " + candidateNo);

    if (candidateNo >= 0) {
      // カードの組数分のエリアを確保
      candidate = new Card[cardNum];
      // 手札にあるカードを1枚ずつチェックして、テーブルに置けるか調べる
      for ( int position = 0, index = 0; position < hand.getNumberofCards() && index < cardNum; position++) {
        // 手札にあるカードを見る
        Card lookingCard = hand.lookCard(position);
        int number = lookingCard.getNumber();

        // 候補の番号かまたはジョーカ(0)
        if (number == candidateNo || number == 0) {
          // 手札からカードを引いて候補とする
          candidate[index] = hand.pickCard(position);
          index += 1; // candidateに格納する位置を１つずらす
          position -= 1; // 手札から1枚引いたので、引いたカードの次がとばされないように
        }
      }
    }
    return candidate;
  }

  /**
   * テーブルに置けるカードを探す。
   * 新規なので手札の一番弱いカード
   *
   * @param hand 手札
   * @param table テーブル
   * @return 見つかったカードの組み合わせ。見つからなかった場合はnullを返す
   */
  public Card[]  findCandidate(Hand hand, Table table, boolean reset) {
    // テーブルに置けるカードの候補
    Card [] candidate = null;
    int cardNum = 0;

    int [] cardCount = checkHand(hand);
    int candidateNo = -1;

    for (int i = 0; i < cardCount.length; i++) {
   // 0  1  2  3  4  5  6  7  8  9 10 11 12 13
   // 3  4  5  6  7  8  9  T  J  Q  K  A  2 JK
      if (cardCount[i] > 0) {
        if (i <= 10) {
          candidateNo = i + 3;
        } else if( i <= 12) {
          candidateNo = i - 10;
        } else {
          candidateNo = 1;
        }
        cardNum = cardCount[i];
        break;
      }
    }


    // debug
    // System.out.println("candidateNo = " + candidateNo);
    // System.out.println("cardNum = " + cardNum);

    // カードの組数分のエリアを確保
    candidate = new Card[cardNum];
    int index = 0;
    // 手札にあるカードを1枚ずつチェックして、テーブルに置けるか調べる
    for ( int position = 0; position < hand.getNumberofCards(); position++) {
      // 手札にあるカードを見る
      Card lookingCard = hand.lookCard(position);
      int number = lookingCard.getNumber();

      // 候補の番号か
      if (number == candidateNo) {
        // 手札からカードを引いて候補とする
        candidate[index] = hand.pickCard(position);
        index += 1; // candidateに格納する位置を１つずらす
        position -= 1; // 手札から1枚引いたので、引いたカードの次がとばされないように
      }
    }
    return candidate;
  }

  /**
   * 手札の数字ごとの枚数を調べる。
   *
   * @param hand 手札
   *
   * @return 数字ごとの枚数
   * 添字と数字の対応
   *  0  1  2  3  4  5  6  7  8  9 10 11 12 13
   *  3  4  5  6  7  8  9  T  J  Q  K  A  2 JK
   */
  private int [] checkHand(Hand hand) {
    // カードの数と枚数を保存する
    int [] cardCount = new int[Card.CARD_NUM + 1];
    // 手札にあるカードのカードの数と枚数を調べる
    int numberOfHand = hand.getNumberofCards();
    for ( int position = 0; position < numberOfHand; position++) {

      Card lookingCard = hand.lookCard(position);
      int number = lookingCard.getNumber();

      if (number > 0) {
        // 手札にあるカードを見る
        // 3 4 5 6 7 8 9 10 J(11) Q(12) K(13)  1  2 JK
        // 0 1 2 3 4 5 6  7     8     9    10 11 12 13
        if (number <= 2) {
          number += 10; // 1,2 はk(13)より強い
        } else {
          number -= 3;    // 3からk(13)の格納位置の指定
        }
        cardCount[number]++;
      } else {
        // 手札にジョーカがあった
        cardCount[Card.CARD_NUM]++;
      }
    }
    return cardCount;
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
  private int contGetNo(Table table, Hand hand, int cardNo, int cardNum, int [] cardCount) {

    // 見つかったカードの番号を返す
    int ret = -1;

    // debug
    // System.out.print("cardCount:");
    // for (int i = 0; i < cardCount.length; i++) {
    //   System.out.print(cardCount[i] + " ");
    // }
    // System.out.println();

    if (cardNo <= 2) {
      cardNo += 10;
    } else {
      cardNo -= 3;
    }

    for (int i = cardNo + 1; i < cardCount.length - 1; i++) {
      // debug
      // System.out.println("cardCount[" + i + "] = " + cardCount[i] + " cardNum = " + cardNum);
      // 3 4 5 6 7 8 9 10 J(11) Q(12) K(13)  1  2
      // 0 1 2 3 4 5 6  7     8     9    10 11 12
      if (cardCount[i] + cardCount[cardCount.length - 1] >= cardNum) {
        if (i <= 10) {
          ret = i + 3;
        } else {
          ret = i - 10;
        }
        break;
      }
    }
    return ret;
  }
}
