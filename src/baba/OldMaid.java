/**
 * ばば抜きプログラム。
 */
public class OldMaid {
    public static void main(String[] args) {
        // 進行役の生成
        Master master = new Master();

        //  テーブルの生成
        Table field = new Table();

        // プレイヤーの生成
        Player murata = new Player("村田", master,  field);
        Player yamada = new Player("山田", master,  field);
        Player saito = new Player("斎藤", master, field);
        Player yamauchi = new Player("山内", master, field);

        // 進行役へのプレイヤーの登録
        master.registerPlayer(murata);
        master.registerPlayer(yamada);
        master.registerPlayer(saito);
        master.registerPlayer(yamauchi);

        // トランプを生成する
        Hand trump = createTrump();

        // ゲームの準備をする
        master.prepareGame(trump);

        // ゲームを開始する
        master.startGame();
        
        // Table table = new Table();

        // Player taro = new Player("太郎", table);
        // Player hanako = new Player("花子", table);
        // System.out.println(taro);
        // System.out.println(hanako);

        // taro.receiveCard(new Card(Card.SUIT_DIAMOND, 1));
        // taro.receiveCard(new Card(Card.SUIT_DIAMOND, 2));
        // taro.receiveCard(new Card(Card.SUIT_DIAMOND, 3));
        // System.out.println(taro.showHand());

        // hanako.receiveCard(new Card(Card.SUIT_HEART, 1));
        // hanako.receiveCard(new Card(Card.SUIT_HEART, 2));
        // hanako.receiveCard(new Card(Card.SUIT_HEART, 3));
        // hanako.receiveCard(new Card(Card.JOKER, 0));
        // System.out.println(hanako.showHand());

        // taro.play(hanako);
        // System.out.println(taro.showHand());
        // System.out.println(hanako.showHand());

        // hanako.play(taro);
        // System.out.println(taro.showHand());
        // System.out.println(hanako.showHand());

        // taro.play(hanako);
        // System.out.println(taro.showHand());
        // System.out.println(hanako.showHand());

        // hanako.play(taro);
        // System.out.println(taro.showHand());
        // System.out.println(hanako.showHand());



        // Card [] samecards = null;
        // Hand hand = new Hand();
        // samecards = hand.findSameNumberCard();
        // System.out.println(samecards);

        // hand.addCard(new Card(Card.SUIT_HEART, 1));
        // samecards = hand.findSameNumberCard();
        // System.out.println(samecards);

        // hand.addCard(new Card(Card.SUIT_HEART, 2));
        // samecards = hand.findSameNumberCard();
        // System.out.println(samecards);

        // hand.addCard(new Card(Card.SUIT_HEART, 3));
        // samecards = hand.findSameNumberCard();
        // System.out.println(samecards);

        // hand.addCard(new Card(Card.SUIT_DIAMOND, 3));

        // System.out.println(hand);
        // samecards = hand.findSameNumberCard();
        // for (int i = 0; i < samecards.length; i++) {
        //     System.out.println(samecards[i]);
        // }
        // Table table = new Table();
        // table.disposedCard(samecards);
        // System.out.println(hand);

        // hand.addCard(new Card(Card.SUIT_DIAMOND, 4));
        // samecards = hand.findSameNumberCard();
        // System.out.println(samecards);

        // hand.addCard(new Card(Card.SUIT_DIAMOND, 5));

        // samecards = hand.findSameNumberCard();
        // System.out.println(samecards);

        // System.out.println(hand);
        // hand.shuffle();
        // System.out.println(hand);

        // Card pick = hand.pickCard();
        // System.out.println(pick);
        // System.out.println(hand);


        // ArrayList<Card> cards = new ArrayList<Card>();

        // for (int number = 1; number <= 13; number++) {
        //     cards.add(new Card(Card.SUIT_CLUB, number));
        //     cards.add(new Card(Card.SUIT_DIAMOND, number));
        //     cards.add(new Card(Card.SUIT_HEART, number));
        //     cards.add(new Card(Card.SUIT_SPADE, number));
        // }

        // // ジョーカーの作成
        // cards.add(new Card(0, Card.JOKER));

        // for (int i = 0; i < 53; i++) {
        //     System.out.print(cards.get(i));
        //     System.out.print(" ");
        //     System.out.println(cards.get(i).getNumber());
        // }
        
    }

    /**
     * 53枚のトランプを生成する。
     *
     * @return トランプを格納したHand
     */
    private static Hand createTrump() {
        Hand trump = new Hand();

        // 各スート53枚のカードを生成する

        for (int number = 1; number <= 13; number++) {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));

        }

        // ジョーカーの作成
        trump.addCard(new Card(0, Card.JOKER));

        return trump;
    }
}
