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
public class OldMaidRuleTest {


  public static class コンストラクタの動作確認 {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void コンストラクタ() throws Exception{
      OldMaidRule instance = new OldMaidRule();
      assertThat((instance instanceof OldMaidRule), is(true));
    }
  }

  @RunWith(Theories.class)
  public static class findCandidateの動作確認 {

    private Hand _hand;
    private OldMaidTable _table;
    private OldMaidRule _rule;

    @Before
    public void setUp() throws Exception {
      _hand = new Hand();
      for (int i = 1; i <= Card.CARD_NUM; i+=2) {
        _hand.addCard(new Card(Card.SUIT_CLUB, i));
      }
      _table = new OldMaidTable();
      _rule = new OldMaidRule();
    }

    @DataPoints
    public static Fixture[] PARAMs = {
      new Fixture(new Card(Card.SUIT_SPADE, 1),
          new Card[] {new Card(Card.SUIT_SPADE, 1), new Card(Card.SUIT_CLUB, 1)}),
      new Fixture(new Card(Card.SUIT_SPADE, 2), null),
      new Fixture(new Card(Card.SUIT_SPADE, 3),
          new Card[] {new Card(Card.SUIT_SPADE, 3), new Card(Card.SUIT_CLUB, 3)}),
      new Fixture(new Card(Card.SUIT_SPADE, 4), null),
      new Fixture(new Card(Card.SUIT_SPADE, 5),
          new Card[] {new Card(Card.SUIT_SPADE, 5), new Card(Card.SUIT_CLUB, 5)}),
      new Fixture(new Card(Card.SUIT_SPADE, 6), null),
      new Fixture(new Card(Card.SUIT_SPADE, 7),
          new Card[] {new Card(Card.SUIT_SPADE, 7), new Card(Card.SUIT_CLUB, 7)}),
      new Fixture(new Card(Card.SUIT_SPADE, 8), null),
      new Fixture(new Card(Card.SUIT_SPADE, 9),
          new Card[] {new Card(Card.SUIT_SPADE, 9), new Card(Card.SUIT_CLUB, 9)}),
      new Fixture(new Card(Card.SUIT_SPADE, 10), null),
      new Fixture(new Card(Card.SUIT_SPADE, 11),
          new Card[] {new Card(Card.SUIT_SPADE, 11), new Card(Card.SUIT_CLUB, 11)}),
      new Fixture(new Card(Card.SUIT_SPADE, 12), null),
      new Fixture(new Card(Card.SUIT_SPADE, 13),
          new Card[] {new Card(Card.SUIT_SPADE, 13), new Card(Card.SUIT_CLUB, 13)}),
    };


    @Theory
    public void findCandidateの動作確認(Fixture p) throws Exception{
      _hand.addCard(p.card);
       Card [] actual = _rule.findCandidate(_hand, _table);
       if (p.expected == null) {
        assertThat(actual, is(nullValue()));
       } else {
        assertThat(actual, is(p.expected));
       }
    }

    static class Fixture {
      Card card;
      Card [] expected;

      Fixture(Card card, Card [] expected) {
        this.card = card;
        this.expected = expected;
      }
    }
  }

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(OldMaidRuleTest.class.getName());
	}
}
