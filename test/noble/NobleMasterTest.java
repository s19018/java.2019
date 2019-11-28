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
import java.util.ArrayList;
import trump.Master;
import trump.Hand;
import trump.Joker;

@RunWith(Enclosed.class)
public class NobleMasterTest {


  public static class passの動作確認 {

    private Master _master;
    private NobleTable _table;
    private NobleRule _rule;
    private ArrayList passplayers;
    private NoblePlayer taro;
    private NoblePlayer hanako;
    private boolean isContinueGame = true;

    @Before
    public void setUp() throws Exception {
      _table = new NobleTable();
      _rule = new NobleRule();
      taro = new NoblePlayer("太郎", _master, _table, _rule);
      hanako.receiveCard(new Card(Card.SUIT_HEART, 5));
      hanako = new NoblePlayer("花子", _master, _table, _rule);
      hanako.receiveCard(new Card(Card.SUIT_HEART, 2));
      _table.putCard(new Card [] {new Card(Card.SUIT_HEART, 7)});
    }

    @Test
    public void pass() throws Exception{
        _master.pass(this);
        boolean status = this.isContinueGame;
        boolean expected = true;
        asserThat(status, is(expected));
    }
  }
}
