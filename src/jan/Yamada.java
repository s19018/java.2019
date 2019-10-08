/**
 * プレイヤーを継承した山田さんクラス。
 */
public class Yamada extends Player {
    /**
     * コンストラクタ
     *
     * @param name 名前
     */
    public Yamada(String name) {
        // スーパークラスのコンストラクタを呼び出し
        super(name);
    }
    /**
     * ジャンケンの手を出す。
     * スーパクラスの同名メソッドをオーバライドしている。
     *
     * @return ジャンケンの手
     */
    @Override
    public int showHand() {
        // 必ずパーを出す
        return PAPER;
    }
}
