package trump;

/**
 * ジョーカーを表すクラス。
 * Cardクラスを継承している。
 * setNumber(), setSuit()メソッドを利用することで、どのようなカードとしても扱うことができる。
 */
public class Joker extends Card {
       /**
        * コンストラクタ。
        * デフォルトでは、ジョーカーは何の値・スートも表さない。
        * getNumber(), getSuit()は0を返す
        */
    public Joker() {
        super(0, 0);
    }

    /**
     * 数を変更する。
     *
     * @param number 数
     */
    public void setNumber(int number) {
        this.number_ = number;
    }

    /**
     * スートを変更する。
     */
    public void setSuit(int suit) {
        this.suit_ = suit;
    }

    /**
     * カードを文字列で表現する。
     * ObjectクラスのtoStringメソッドをオーバライドしたメソッド。
     *
     * @return カードの文字表現
     */
    @Override
    public String toString() {
        return "JK";
    }

}
