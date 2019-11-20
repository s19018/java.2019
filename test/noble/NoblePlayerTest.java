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
public class NoblePlayerTest {


  public static class コンストラクタの動作確認 {

    private Master _master;
    private NobleTable _table;
    private NobleRule _rule;

    @Before
    public void setUp() throws Exception {
      _master = new Master();
      _table = new NobleTable();
      _rule = new NobleRule();
    }

    @Test
    public void コンストラクタ() throws Exception{
      NoblePlayer instance = new NoblePlayer("太郎", _master, _table, _rule);
      assertThat(instance.toString(), is("太郎"));
    }
  }

  public static class playの動作確認 {
    private Master _master;
    private NobleTable _table;
    private NobleRule _rule;
    private NoblePlayer taro;
    private NoblePlayer hanako;

      @Before
      public void setUp() throws Exception {
        _master = new NobleMaster();
        _table = new NobleTable();
        _rule = new NobleRule();
        taro = new NoblePlayer("太郎", _master, _table, _rule);
        taro.receiveCard(new Card(Card.SUIT_DIAMOND, 2));
        taro.receiveCard(new Card(Card.SUIT_DIAMOND, 5));

        hanako = new NoblePlayer("花子", _master, _table, _rule);
        hanako.receiveCard(new Card(Card.SUIT_HEART, 2));
        hanako.receiveCard(new Card(Card.SUIT_DIAMOND, 3));
        hanako.receiveCard(new Card(Card.SUIT_DIAMOND, 13));

        _table.putCard(new Card [] {new Card(Card.SUIT_HEART, 7)});

      }

      @Test
      public void おけるカードがあればおく() throws Exception {

          Hand expected = new Hand();
          expected.addCard(new Card(Card.SUIT_DIAMOND, 5));
          taro.play(hanako);
          Hand hand_ = taro.showHand();
          assertThat(hand_, IsHand.handof(expected));
        

      }
    }
	// エントリーポイント
	public static void main(String[] args){
	    org.junit.runner.JUnitCore.main(NoblePlayerTest.class.getName());
    }

  }
