import trump.Card;
import trump.Table;

/**
 * 大貴族のテーブルを表すクラス。
 */
public class NobleTable implements Table {
  /** カード並べるテーブルを表す2次元配列 */
  private Card[][] table_ = new Card[Card.SUIT_NUM][Card.CARD_NUM];

  /** 最新の置かれたカード */
  private Card[] putCard_ = new Card[Card.CARD_NUM];
}
