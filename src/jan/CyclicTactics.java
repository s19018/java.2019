/**
 * グー・チョキ・パーの順番で手を出す
 */
public class CyclicTactics implements Tactics {
    /**
     * 戦略を読み、ジャンケンの手を得る。
     * グー・チョキ・パーのいずれかをPlayerクラスに定義された
     * 以下の定数で返す。
     * Player.STONE       - グー
     * Player.SCISSORS    - チョキ
     * Player.PAPER       - パー
     *
     * @return ジャンケンの手
     */
    private int [] hands = {Player.STONE, Player.SCISSORS, Player.PAPER};
    private int index = 0;
    public int readTactics() {

        int hand = hands[index];
        index = ++index % 3;

        // 必ずグーを出す
        return hand;
    }
}
