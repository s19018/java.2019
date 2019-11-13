import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;
// import org.junit.experimental.Enclosed;
import trump.Joker;

// @RunWith(Enclosed.class)
public class JokerTest {

  private Joker card;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void toString_() {
    card = new Joker();
    String ret = card.toString();
    assertThat(ret, is("JK"));
  }

	@Test
	public void コンストラクタ() throws Exception{
    Joker instance = new Joker();
    assertThat(instance.getSuit(), is(0));
    assertThat(instance.getNumber(), is(0));
	}

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(JokerTest.class.getName());
	}
}
