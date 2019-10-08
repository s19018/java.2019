/**
 * プレイヤーを継承した村田クラス。
 */
public class Murata extends Player {
    /**
     * コンストラクタ
     *
     * @param name 名前
     */
    public Murata(String name) {
        // スーパークラスのコンストラクタを呼び出す
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
        // 必ずグーを出す
        return STONE;
    }
}
