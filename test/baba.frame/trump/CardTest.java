import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theories;
import trump.Card;

@RunWith(Enclosed.class)
public class CardTest {

  @RunWith(Theories.class)
  public static class toStringの動作確認 {
    private Card card;

    @Before
    public void setUp() throws Exception {
    }

    @DataPoints
    public static Fixture[] PARAMs = {
      new Fixture(Card.SUIT_CLUB, 1, "CA"),
      new Fixture(Card.SUIT_CLUB, 2, "C2"),
      new Fixture(Card.SUIT_CLUB, 3, "C3"),
      new Fixture(Card.SUIT_CLUB, 4, "C4"),
      new Fixture(Card.SUIT_CLUB, 5, "C5"),
      new Fixture(Card.SUIT_CLUB, 6, "C6"),
      new Fixture(Card.SUIT_CLUB, 7, "C7"),
      new Fixture(Card.SUIT_CLUB, 8, "C8"),
      new Fixture(Card.SUIT_CLUB, 9, "C9"),
      new Fixture(Card.SUIT_CLUB, 10, "CT"),
      new Fixture(Card.SUIT_CLUB, 11, "CJ"),
      new Fixture(Card.SUIT_CLUB, 12, "CQ"),
      new Fixture(Card.SUIT_CLUB, 13, "CK"),
      new Fixture(Card.SUIT_DIAMOND, 1, "DA"),
      new Fixture(Card.SUIT_DIAMOND, 2, "D2"),
      new Fixture(Card.SUIT_DIAMOND, 3, "D3"),
      new Fixture(Card.SUIT_DIAMOND, 4, "D4"),
      new Fixture(Card.SUIT_DIAMOND, 5, "D5"),
      new Fixture(Card.SUIT_DIAMOND, 6, "D6"),
      new Fixture(Card.SUIT_DIAMOND, 7, "D7"),
      new Fixture(Card.SUIT_DIAMOND, 8, "D8"),
      new Fixture(Card.SUIT_DIAMOND, 9, "D9"),
      new Fixture(Card.SUIT_DIAMOND, 10, "DT"),
      new Fixture(Card.SUIT_DIAMOND, 11, "DJ"),
      new Fixture(Card.SUIT_DIAMOND, 12, "DQ"),
      new Fixture(Card.SUIT_DIAMOND, 13, "DK"),
      new Fixture(Card.SUIT_HEART, 1, "HA"),
      new Fixture(Card.SUIT_HEART, 2, "H2"),
      new Fixture(Card.SUIT_HEART, 3, "H3"),
      new Fixture(Card.SUIT_HEART, 4, "H4"),
      new Fixture(Card.SUIT_HEART, 5, "H5"),
      new Fixture(Card.SUIT_HEART, 6, "H6"),
      new Fixture(Card.SUIT_HEART, 7, "H7"),
      new Fixture(Card.SUIT_HEART, 8, "H8"),
      new Fixture(Card.SUIT_HEART, 9, "H9"),
      new Fixture(Card.SUIT_HEART, 10, "HT"),
      new Fixture(Card.SUIT_HEART, 11, "HJ"),
      new Fixture(Card.SUIT_HEART, 12, "HQ"),
      new Fixture(Card.SUIT_HEART, 13, "HK"),
      new Fixture(Card.SUIT_SPADE, 1, "SA"),
      new Fixture(Card.SUIT_SPADE, 2, "S2"),
      new Fixture(Card.SUIT_SPADE, 3, "S3"),
      new Fixture(Card.SUIT_SPADE, 4, "S4"),
      new Fixture(Card.SUIT_SPADE, 5, "S5"),
      new Fixture(Card.SUIT_SPADE, 6, "S6"),
      new Fixture(Card.SUIT_SPADE, 7, "S7"),
      new Fixture(Card.SUIT_SPADE, 8, "S8"),
      new Fixture(Card.SUIT_SPADE, 9, "S9"),
      new Fixture(Card.SUIT_SPADE, 10, "ST"),
      new Fixture(Card.SUIT_SPADE, 11, "SJ"),
      new Fixture(Card.SUIT_SPADE, 12, "SQ"),
      new Fixture(Card.SUIT_SPADE, 13, "SK"),
    };


    @Theory
    public void toStringの動作確認(Fixture p) throws Exception{
      card = new Card(p.suit, p.number);
      String ret = card.toString();
      assertThat(ret, is(p.expected));
    }

    static class Fixture {
      int suit;
      int number;
      String expected;

      Fixture(int suit, int number, String expected) {
        this.suit = suit;
        this.number = number;
        this.expected = expected;
      }
    }
  }


  public static class コンストラクタの確認 {
    @Test
    public void コンストラクタ() throws Exception{
      Card instance = new Card(Card.SUIT_CLUB, 1);
      assertThat(instance.getSuit(), is(Card.SUIT_CLUB));
      assertThat(instance.getNumber(), is(1));
    }
  }

  @RunWith(Theories.class)
  public static class equalsの動作確認 {
    private Card card;
    private Card other;

    @Before
    public void setUp() throws Exception {
    }

    @DataPoints
    public static Fixture[] PARAMs = {
      new Fixture(Card.SUIT_CLUB, 1, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 2, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 3, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 4, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 5, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 6, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 7, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 8, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 9, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 10, Card.SUIT_CLUB, 10, true),
      new Fixture(Card.SUIT_CLUB, 11, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 12, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_CLUB, 13, Card.SUIT_CLUB, 10, false),
      new Fixture(Card.SUIT_DIAMOND, 1, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 2, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 3, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 4, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 5, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 6, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 7, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 8, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 9, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 10, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 11, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 12, Card.SUIT_HEART, 13, false),
      new Fixture(Card.SUIT_DIAMOND, 13, Card.SUIT_DIAMOND, 13, true),
      new Fixture(Card.SUIT_HEART, 1, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 2, Card.SUIT_HEART, 2, true),
      new Fixture(Card.SUIT_HEART, 3, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 4, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 5, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 6, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 7, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 8, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 9, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 10, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 11, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 12, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_HEART, 13, Card.SUIT_SPADE, 2, false),
      new Fixture(Card.SUIT_SPADE, 1, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 2, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 3, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 4, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 5, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 6, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 7, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 8, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 9, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 10, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 11, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 12, Card.SUIT_CLUB, 1, false),
      new Fixture(Card.SUIT_SPADE, 13, Card.SUIT_CLUB, 1, false),
    };


    @Theory
    public void equalsの動作確認(Fixture p) throws Exception{
      // debug
      // System.out.println(" mysuit = " + p.mysuit + " mynumber = " + p.mynumber);
      // System.out.println(" othersuit = " + p.othersuit + " othernumber = " + p.othernumber);
      card = new Card(p.mysuit, p.mynumber);
      other = new Card(p.othersuit, p.othernumber);
      boolean ret = card.equals(other);
      assertThat(ret, is(p.expected));
    }

    static class Fixture {
      int mysuit;
      int mynumber;
      int othersuit;
      int othernumber;
      boolean expected;

      Fixture(int mysuit, int mynumber, int othersuit, int othernumber, boolean expected) {
        this.mysuit = mysuit;
        this.mynumber = mynumber;
        this.othersuit = othersuit;
        this.othernumber = othernumber;
        this.expected = expected;
      }
    }
  }


	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(CardTest.class.getName());
	}
}
