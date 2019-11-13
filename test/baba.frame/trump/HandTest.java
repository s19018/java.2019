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
import trump.Hand;

@RunWith(Enclosed.class)
public class HandTest {

  public static class 動作確認 {
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void addCardで3件カードを追加し3件追加されていることを確認() throws Exception{
      int expected = 3;
      
      Hand _hand = new Hand();
      _hand.addCard(new Card(Card.SUIT_CLUB, 1));
      _hand.addCard(new Card(Card.SUIT_DIAMOND, 2));
      _hand.addCard(new Card(Card.SUIT_SPADE, 3));
      int size = _hand.getNumberofCards();

    }

    @Test
    public void addCardで1件カードを追加しlookCardを確認() throws Exception{
      String expected = "CA";
      
      Hand _hand = new Hand();
      _hand.addCard(new Card(Card.SUIT_CLUB, 1));
      Card _card = _hand.lookCard(0);

      assertThat(_card.toString(), is(expected));
    }

    @Test
    public void addCardで1件カードを追加しpickCardを確認() throws Exception{
      String expected1 = "CA";
      int expected2 = 0; 
      
      Hand _hand = new Hand();
      _hand.addCard(new Card(Card.SUIT_CLUB, 1));
      Card _card = _hand.pickCard(0);

      assertThat(_card.toString(), is(expected1));
      assertThat(_hand.getNumberofCards(), is(expected2));

    }

    @Test
    public void toStringの動作確認() throws Exception{
      String expected = "CA ";
      Hand _hand = new Hand();
      _hand.addCard(new Card(Card.SUIT_CLUB, 1));
      assertThat(_hand.toString(), is(expected));
    }
  }

  public static class コンストラクタの確認 {
    @Test
    public void コンストラクタ() throws Exception{
      Hand instance = new Hand();
      assertThat((instance instanceof Hand), is(true));
    }
  }

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(HandTest.class.getName());
	}
}
