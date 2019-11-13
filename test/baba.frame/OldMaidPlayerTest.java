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
public class OldMaidPlayerTest {


  public static class コンストラクタの動作確認 {

    private Master _master;
    private OldMaidTable _table;
    private OldMaidRule _rule;

    @Before
    public void setUp() throws Exception {
      _master = new Master();
      _table = new OldMaidTable();
      _rule = new OldMaidRule();
    }

    @Test
    public void コンストラクタ() throws Exception{
      OldMaidPlayer instance = new OldMaidPlayer("太郎", _master, _table, _rule);
      assertThat(instance.toString(), is("太郎"));
    }
  }

  public static class receiveCardの動作確認 {
    private Master _master;
    private OldMaidTable _table;
    private OldMaidRule _rule;

    @Before
    public void setUp() throws Exception {
      _master = new Master();
      _table = new OldMaidTable();
      _rule = new OldMaidRule();
    }

    @Test
    public void ばらばらのカードを配る() throws Exception{

      Hand expected = new Hand();
      expected.addCard(new Card(Card.SUIT_CLUB, 1));
      expected.addCard(new Card(Card.SUIT_DIAMOND, 2));
      expected.addCard(new Card(Card.SUIT_HEART, 3));
      expected.addCard(new Card(Card.SUIT_SPADE, 4));

      OldMaidPlayer instance = new OldMaidPlayer("太郎", _master, _table, _rule);
      instance.receiveCard(new Card(Card.SUIT_CLUB, 1));
      instance.receiveCard(new Card(Card.SUIT_DIAMOND, 2));
      instance.receiveCard(new Card(Card.SUIT_HEART, 3));
      instance.receiveCard(new Card(Card.SUIT_SPADE, 4));
      Hand hand_ = instance.showHand();
      assertThat(hand_, IsHand.handof(expected));

    }

    @Test
    public void 何組かそろったカードを配る() throws Exception{

      Hand expected = new Hand();
      expected.addCard(new Card(Card.SUIT_CLUB, 1));
      expected.addCard(new Card(Card.SUIT_SPADE, 4));
      expected.addCard(new Joker());

      OldMaidPlayer instance = new OldMaidPlayer("太郎", _master, _table, _rule);
      instance.receiveCard(new Card(Card.SUIT_CLUB, 1));
      instance.receiveCard(new Card(Card.SUIT_DIAMOND, 2));
      instance.receiveCard(new Card(Card.SUIT_HEART, 3));
      instance.receiveCard(new Card(Card.SUIT_SPADE, 4));
      instance.receiveCard(new Card(Card.SUIT_HEART, 2));
      instance.receiveCard(new Card(Card.SUIT_DIAMOND, 3));
      instance.receiveCard(new Joker());
      Hand hand_ = instance.showHand();
      assertThat(hand_, IsHand.handof(expected));

    }
	}

  // public static class playの動作確認 {

  // }


	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(OldMaidPlayerTest.class.getName());
	}
}
