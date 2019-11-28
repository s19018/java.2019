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
public class NobleRuleTest {


  public static class コンストラクタの動作確認 {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void コンストラクタ() throws Exception{
      NobleRule instance = new NobleRule();
      assertThat((instance instanceof NobleRule), is(true));
    }
  }

  public static class テーブルにおけるカードの候補確認 {
    private NobleRule _rule;
    private Hand _hand;
    private NobleTable _table;

    @Before
    public void setUp() throws Exception {
      _rule = new NobleRule();
      _table = new NobleTable();
      _hand = new Hand();
      _hand.addCard(new Card(Card.SUIT_HEART, 4));
      _hand.addCard(new Card(Card.SUIT_HEART, 9));
      _table.putCard(new Card [] {new Card(Card.SUIT_HEART, 7)});
    }

    @Test
    public void findCandidateの候補() {
    Card [] card = _rule.findCandidate(_hand, _table);
    Card [] expected = (new Card [] {new Card(Card.SUIT_HEART, 9)});
    assertThat(card, is(expected));
    }
  }

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(NobleRuleTest.class.getName());
	}
}
