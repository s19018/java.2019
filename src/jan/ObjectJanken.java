/**
 * オブジェクト指向によるジャンケンプログラム。
 */
public class ObjectJanken {
    public static void main(String[] args) {
        // 審判(斎藤さん)のインスタンス生成
        Judge saito = new Judge();

        // プレイヤー１(村田さん)の生成
        Player murata = new Player("村田さん");

        // 村田さんに渡す戦略クラスを生成する
        // Tactics murataTactics = new CyclicTactics();

        try {
            Class<?> tacticsClass = Class.forName("CyclicTactics");
            Tactics murataTactics = (Tactics)tacticsClass.getDeclaredConstructor().newInstance();

            // 村田さんに戦略クラスを渡す
            murata.setTactics(murataTactics);
        } catch(Exception e) {
        }

        // プレイヤー２(山田さん)の生成
        Player yamada = new Player("山田さん");

        // 山田さんに渡す戦略クラスを生成する
        Tactics yamadaTactics = new RandomTactics();

        // 山田さんに戦略クラスを渡す
        yamada.setTactics(yamadaTactics);

        // 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
        saito.startJanken(murata, yamada);
    }
}
