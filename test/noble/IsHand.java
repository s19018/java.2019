import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.hamcrest.Description;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Matcher;
import java.util.ArrayList;
import trump.Hand;
import trump.Card;

public class IsHand extends BaseMatcher<Hand> {

  private Hand _hand;
  private ArrayList<Card> expected = new ArrayList<Card>();
  Object actual;

  // コンストラクタ
  IsHand(Hand hand) {
    this._hand = hand;
    for (int i = 0; i < _hand.getNumberofCards(); i++) {
        expected.add(hand.lookCard(i)); 
    }
  }

  // 値の比較検証
  @Override
  public boolean matches(Object actual) {
    this.actual = actual;
    ArrayList <Card> act = new ArrayList<Card>();
    if (!(actual instanceof Hand)) return false;
    Hand hand = (Hand)actual;
    for (int i = 0; i < hand.getNumberofCards(); i++) {
      act.add(hand.lookCard(i));
    }

    if (expected.size() != act.size())  return false;

    for (int i = 0; i < expected.size(); i++) {
      if (expected.indexOf(act.get(i)) == -1) {
        return false;
      }
    }
    return true;
  }

  // 比較が失敗した場合にフレームに通知する情報を作成する
  @Override
  public void describeTo(Description desc) {
    desc.appendValue(expected.toString());
    if (actual != null) {
      desc.appendText(" but actual is ");
      desc.appendValue((Hand)actual);
    }
  }

  public static Matcher<Hand> handof(Hand hand) {
    return new IsHand(hand);
  }

  
}
