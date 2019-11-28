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
public class NobleTableTest {

  public static class コンストラクタの動作確認 {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void コンストラクタ() throws Exception{
      NobleTable instance = new NobleTable();
      assertThat((instance instanceof NobleTable), is(true));
    }
  }




  public static class putCard_getCardsの動作確認 {

    private NobleMaster _master;
    private NobleRule _rule;
    private Card _card;
    private NobleTable _table;

    @Before
    public void setUp() throws Exception {
      _master = new NobleMaster();
      _table = new NobleTable();
    }


    @Test
    public void putCardの動作確認() throws Exception {
        _table.putCard(new Card [] {new Card(Card.SUIT_HEART, 9)});
        Card [][] expected = _table.getCards();
        assertThat((new Card(Card.SUIT_HEART, 9)), is(expected));
    }

  }


	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(NobleTableTest.class.getName());
	}
}
