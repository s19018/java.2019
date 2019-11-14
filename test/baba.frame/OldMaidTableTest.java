import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theories;
import org.junit.Test;
import org.junit.Before;
import trump.Card;
import trump.Master;
import trump.Hand;
import trump.Joker;

@RunWith(Enclosed.class)
public class OldMaidTableTest {


  public static class コンストラクタの動作確認 {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void コンストラクタ() throws Exception{
      OldMaidTable instance = new OldMaidTable();
      assertThat((instance instanceof OldMaidTable), is(true));
    }
  }

  @RunWith(Theories.class)
  public static class putCard_getCardsの動作確認 {

    private OldMaidTable _table;

    @Before
    public void setUp() throws Exception {
      _table = new OldMaidTable();
    }

    @DataPoints
    public static Fixture[] PARAMs = {
      new Fixture(Card.SUIT_CLUB, 1),
      new Fixture(Card.SUIT_CLUB, 2),
      new Fixture(Card.SUIT_CLUB, 3),
      new Fixture(Card.SUIT_CLUB, 4),
      new Fixture(Card.SUIT_CLUB, 5),
      new Fixture(Card.SUIT_CLUB, 6),
      new Fixture(Card.SUIT_CLUB, 7),
      new Fixture(Card.SUIT_CLUB, 8),
      new Fixture(Card.SUIT_CLUB, 9),
      new Fixture(Card.SUIT_CLUB, 10),
      new Fixture(Card.SUIT_CLUB, 11),
      new Fixture(Card.SUIT_CLUB, 12),
      new Fixture(Card.SUIT_CLUB, 13),
      new Fixture(Card.SUIT_DIAMOND, 1),
      new Fixture(Card.SUIT_DIAMOND, 2),
      new Fixture(Card.SUIT_DIAMOND, 3),
      new Fixture(Card.SUIT_DIAMOND, 4),
      new Fixture(Card.SUIT_DIAMOND, 5),
      new Fixture(Card.SUIT_DIAMOND, 6),
      new Fixture(Card.SUIT_DIAMOND, 7),
      new Fixture(Card.SUIT_DIAMOND, 8),
      new Fixture(Card.SUIT_DIAMOND, 9),
      new Fixture(Card.SUIT_DIAMOND, 10),
      new Fixture(Card.SUIT_DIAMOND, 11),
      new Fixture(Card.SUIT_DIAMOND, 12),
      new Fixture(Card.SUIT_DIAMOND, 13),
      new Fixture(Card.SUIT_HEART, 1),
      new Fixture(Card.SUIT_HEART, 2),
      new Fixture(Card.SUIT_HEART, 3),
      new Fixture(Card.SUIT_HEART, 4),
      new Fixture(Card.SUIT_HEART, 5),
      new Fixture(Card.SUIT_HEART, 6),
      new Fixture(Card.SUIT_HEART, 7),
      new Fixture(Card.SUIT_HEART, 8),
      new Fixture(Card.SUIT_HEART, 9),
      new Fixture(Card.SUIT_HEART, 10),
      new Fixture(Card.SUIT_HEART, 11),
      new Fixture(Card.SUIT_HEART, 12),
      new Fixture(Card.SUIT_HEART, 13),
      new Fixture(Card.SUIT_SPADE, 1),
      new Fixture(Card.SUIT_SPADE, 2),
      new Fixture(Card.SUIT_SPADE, 3),
      new Fixture(Card.SUIT_SPADE, 4),
      new Fixture(Card.SUIT_SPADE, 5),
      new Fixture(Card.SUIT_SPADE, 6),
      new Fixture(Card.SUIT_SPADE, 7),
      new Fixture(Card.SUIT_SPADE, 8),
      new Fixture(Card.SUIT_SPADE, 9),
      new Fixture(Card.SUIT_SPADE, 10),
      new Fixture(Card.SUIT_SPADE, 11),
      new Fixture(Card.SUIT_SPADE, 12),
      new Fixture(Card.SUIT_SPADE, 13),
    };


    @Theory
    public void putCard_getCardsの動作確認(Fixture p) throws Exception{
      Card [] cards = new Card []{
              new Card(p.suit, p.number),
      };

      _table.putCard(cards);

      Card [][] actual = _table.getCards();

      assertThat(actual[p.suit - 1][p.number -1] , is(p.expected));
    }

    static class Fixture {
      int suit;
      int number;
      Card expected;

      Fixture(int suit, int number) {
        this.suit = suit;
        this.number = number;
        this.expected = new Card(suit, number);
      }
    }
  }

  public static class toStringの動作確認 {
    private OldMaidTable _table;

    private Card [] cards = {
      new Card(Card.SUIT_CLUB, 1),
      new Card(Card.SUIT_CLUB, 2),
      new Card(Card.SUIT_CLUB, 3),
      new Card(Card.SUIT_CLUB, 4),
      new Card(Card.SUIT_CLUB, 5),
      new Card(Card.SUIT_CLUB, 6),
      new Card(Card.SUIT_CLUB, 7),
      new Card(Card.SUIT_CLUB, 8),
      new Card(Card.SUIT_CLUB, 9),
      new Card(Card.SUIT_CLUB, 10),
      new Card(Card.SUIT_CLUB, 11),
      new Card(Card.SUIT_CLUB, 12),
      new Card(Card.SUIT_CLUB, 13),
      new Card(Card.SUIT_DIAMOND, 1),
      new Card(Card.SUIT_DIAMOND, 2),
      new Card(Card.SUIT_DIAMOND, 3),
      new Card(Card.SUIT_DIAMOND, 4),
      new Card(Card.SUIT_DIAMOND, 5),
      new Card(Card.SUIT_DIAMOND, 6),
      new Card(Card.SUIT_DIAMOND, 7),
      new Card(Card.SUIT_DIAMOND, 8),
      new Card(Card.SUIT_DIAMOND, 9),
      new Card(Card.SUIT_DIAMOND, 10),
      new Card(Card.SUIT_DIAMOND, 11),
      new Card(Card.SUIT_DIAMOND, 12),
      new Card(Card.SUIT_DIAMOND, 13),
      new Card(Card.SUIT_HEART, 1),
      new Card(Card.SUIT_HEART, 2),
      new Card(Card.SUIT_HEART, 3),
      new Card(Card.SUIT_HEART, 4),
      new Card(Card.SUIT_HEART, 5),
      new Card(Card.SUIT_HEART, 6),
      new Card(Card.SUIT_HEART, 7),
      new Card(Card.SUIT_HEART, 8),
      new Card(Card.SUIT_HEART, 9),
      new Card(Card.SUIT_HEART, 10),
      new Card(Card.SUIT_HEART, 11),
      new Card(Card.SUIT_HEART, 12),
      new Card(Card.SUIT_HEART, 13),
      new Card(Card.SUIT_SPADE, 1),
      new Card(Card.SUIT_SPADE, 2),
      new Card(Card.SUIT_SPADE, 3),
      new Card(Card.SUIT_SPADE, 4),
      new Card(Card.SUIT_SPADE, 5),
      new Card(Card.SUIT_SPADE, 6),
      new Card(Card.SUIT_SPADE, 7),
      new Card(Card.SUIT_SPADE, 8),
      new Card(Card.SUIT_SPADE, 9),
      new Card(Card.SUIT_SPADE, 10),
      new Card(Card.SUIT_SPADE, 11),
      new Card(Card.SUIT_SPADE, 12),
      new Card(Card.SUIT_SPADE, 13),
    };

    private Card [] cards2 = {
      // new Card(Card.SUIT_CLUB, 1),
      new Card(Card.SUIT_CLUB, 2),
      new Card(Card.SUIT_CLUB, 3),
      new Card(Card.SUIT_CLUB, 4),
      new Card(Card.SUIT_CLUB, 5),
      new Card(Card.SUIT_CLUB, 6),
      new Card(Card.SUIT_CLUB, 7),
      new Card(Card.SUIT_CLUB, 8),
      new Card(Card.SUIT_CLUB, 9),
      new Card(Card.SUIT_CLUB, 10),
      new Card(Card.SUIT_CLUB, 11),
      new Card(Card.SUIT_CLUB, 12),
      new Card(Card.SUIT_CLUB, 13),
      new Card(Card.SUIT_DIAMOND, 1),
      new Card(Card.SUIT_DIAMOND, 2),
      new Card(Card.SUIT_DIAMOND, 3),
      new Card(Card.SUIT_DIAMOND, 4),
      new Card(Card.SUIT_DIAMOND, 5),
      new Card(Card.SUIT_DIAMOND, 6),
      new Card(Card.SUIT_DIAMOND, 7),
      new Card(Card.SUIT_DIAMOND, 8),
      new Card(Card.SUIT_DIAMOND, 9),
      new Card(Card.SUIT_DIAMOND, 10),
      new Card(Card.SUIT_DIAMOND, 11),
      new Card(Card.SUIT_DIAMOND, 12),
      // new Card(Card.SUIT_DIAMOND, 13),
      new Card(Card.SUIT_HEART, 1),
      new Card(Card.SUIT_HEART, 2),
      new Card(Card.SUIT_HEART, 3),
      new Card(Card.SUIT_HEART, 4),
      new Card(Card.SUIT_HEART, 5),
      new Card(Card.SUIT_HEART, 6),
      new Card(Card.SUIT_HEART, 7),
      new Card(Card.SUIT_HEART, 8),
      new Card(Card.SUIT_HEART, 9),
      // new Card(Card.SUIT_HEART, 10),
      new Card(Card.SUIT_HEART, 11),
      new Card(Card.SUIT_HEART, 12),
      new Card(Card.SUIT_HEART, 13),
      new Card(Card.SUIT_SPADE, 1),
      new Card(Card.SUIT_SPADE, 2),
      new Card(Card.SUIT_SPADE, 3),
      new Card(Card.SUIT_SPADE, 4),
      // new Card(Card.SUIT_SPADE, 5),
      new Card(Card.SUIT_SPADE, 6),
      new Card(Card.SUIT_SPADE, 7),
      new Card(Card.SUIT_SPADE, 8),
      new Card(Card.SUIT_SPADE, 9),
      new Card(Card.SUIT_SPADE, 10),
      new Card(Card.SUIT_SPADE, 11),
      new Card(Card.SUIT_SPADE, 12),
      new Card(Card.SUIT_SPADE, 13),
    };

    private String  expected = 
      "SA S2 S3 S4 S5 S6 S7 S8 S9 ST SJ SQ SK \n" +
      "DA D2 D3 D4 D5 D6 D7 D8 D9 DT DJ DQ DK \n" +
      "CA C2 C3 C4 C5 C6 C7 C8 C9 CT CJ CQ CK \n" +
      "HA H2 H3 H4 H5 H6 H7 H8 H9 HT HJ HQ HK \n";
    
    private String  expected2 = 
      "SA S2 S3 S4 .. S6 S7 S8 S9 ST SJ SQ SK \n" +
      "DA D2 D3 D4 D5 D6 D7 D8 D9 DT DJ DQ .. \n" +
      ".. C2 C3 C4 C5 C6 C7 C8 C9 CT CJ CQ CK \n" +
      "HA H2 H3 H4 H5 H6 H7 H8 H9 .. HJ HQ HK \n";

    @Before
    public void setUp() throws Exception {
      _table = new OldMaidTable();
    }

    @Test
    public void テーブルにカードを全部置いた時の文字列表現を確認() throws Exception {
      _table.putCard(cards);
      String actual = _table.toString();
      assertThat(actual, is(expected));
    }

    @Test
    public void テーブルにカードをいくつか置いた時の文字列表現を確認() throws Exception {
      _table.putCard(cards2);
      String actual = _table.toString();
      assertThat(actual, is(expected2));
    }
  }

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(OldMaidTableTest.class.getName());
	}
}
