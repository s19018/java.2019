import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;
// import org.junit.experimental.Enclosed;
import trump.Card;

// @RunWith(Enclosed.class)
public class CardTest {

  private Card card;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void toString_CLUB_1() {
    card = new Card(Card.SUIT_CLUB, 1);
    String ret = card.toString();
    assertThat(ret, is("CA"));
  }

  @Test
  public void toString_CLUB_2() {
    card = new Card(Card.SUIT_CLUB, 2);
    String ret = card.toString();
    assertThat(ret, is("C2"));
  }

  @Test
  public void toString_CLUB_3() {
    card = new Card(Card.SUIT_CLUB, 3);
    String ret = card.toString();
    assertThat(ret, is("C3"));
  }

  @Test
  public void toString_CLUB_4() {
    card = new Card(Card.SUIT_CLUB, 4);
    String ret = card.toString();
    assertThat(ret, is("C4"));
  }

  @Test
  public void toString_CLUB_5() {
    card = new Card(Card.SUIT_CLUB, 5);
    String ret = card.toString();
    assertThat(ret, is("C5"));
  }

  @Test
  public void toString_CLUB_6() {
    card = new Card(Card.SUIT_CLUB, 6);
    String ret = card.toString();
    assertThat(ret, is("C6"));
  }

  @Test
  public void toString_CLUB_7() {
    card = new Card(Card.SUIT_CLUB, 7);
    String ret = card.toString();
    assertThat(ret, is("C7"));
  }

  @Test
  public void toString_CLUB_8() {
    card = new Card(Card.SUIT_CLUB, 8);
    String ret = card.toString();
    assertThat(ret, is("C8"));
  }

  @Test
  public void toString_CLUB_9() {
    card = new Card(Card.SUIT_CLUB, 9);
    String ret = card.toString();
    assertThat(ret, is("C9"));
  }

  @Test
  public void toString_CLUB_10() {
    card = new Card(Card.SUIT_CLUB, 10);
    String ret = card.toString();
    assertThat(ret, is("CT"));
  }

  @Test
  public void toString_CLUB_11() {
    card = new Card(Card.SUIT_CLUB, 11);
    String ret = card.toString();
    assertThat(ret, is("CJ"));
  }

  @Test
  public void toString_CLUB_12() {
    card = new Card(Card.SUIT_CLUB, 12);
    String ret = card.toString();
    assertThat(ret, is("CQ"));
  }

  @Test
  public void toString_CLUB_13() {
    card = new Card(Card.SUIT_CLUB, 13);
    String ret = card.toString();
    assertThat(ret, is("CK"));
  }

  @Test
  public void toString_HEART_1() {
    card = new Card(Card.SUIT_HEART, 1);
    String ret = card.toString();
    assertThat(ret, is("HA"));
  }

  @Test
  public void toString_HEART_2() {
    card = new Card(Card.SUIT_HEART, 2);
    String ret = card.toString();
    assertThat(ret, is("H2"));
  }

  @Test
  public void toString_HEART_3() {
    card = new Card(Card.SUIT_HEART, 3);
    String ret = card.toString();
    assertThat(ret, is("H3"));
  }

  @Test
  public void toString_HEART_4() {
    card = new Card(Card.SUIT_HEART, 4);
    String ret = card.toString();
    assertThat(ret, is("H4"));
  }

  @Test
  public void toString_HEART_5() {
    card = new Card(Card.SUIT_HEART, 5);
    String ret = card.toString();
    assertThat(ret, is("H5"));
  }

  @Test
  public void toString_HEART_6() {
    card = new Card(Card.SUIT_HEART, 6);
    String ret = card.toString();
    assertThat(ret, is("H6"));
  }

  @Test
  public void toString_HEART_7() {
    card = new Card(Card.SUIT_HEART, 7);
    String ret = card.toString();
    assertThat(ret, is("H7"));
  }

  @Test
  public void toString_HEART_8() {
    card = new Card(Card.SUIT_HEART, 8);
    String ret = card.toString();
    assertThat(ret, is("H8"));
  }

  @Test
  public void toString_HEART_9() {
    card = new Card(Card.SUIT_HEART, 9);
    String ret = card.toString();
    assertThat(ret, is("H9"));
  }

  @Test
  public void toString_HEART_10() {
    card = new Card(Card.SUIT_HEART, 10);
    String ret = card.toString();
    assertThat(ret, is("HT"));
  }

  @Test
  public void toString_HEART_11() {
    card = new Card(Card.SUIT_HEART, 11);
    String ret = card.toString();
    assertThat(ret, is("HJ"));
  }

  @Test
  public void toString_HEART_12() {
    card = new Card(Card.SUIT_HEART, 12);
    String ret = card.toString();
    assertThat(ret, is("HQ"));
  }

  @Test
  public void toString_HEART_13() {
    card = new Card(Card.SUIT_HEART, 13);
    String ret = card.toString();
    assertThat(ret, is("HK"));
  }

  @Test
  public void toString_DIAMOND_1() {
    card = new Card(Card.SUIT_DIAMOND, 1);
    String ret = card.toString();
    assertThat(ret, is("DA"));
  }

  @Test
  public void toString_DIAMOND_2() {
    card = new Card(Card.SUIT_DIAMOND, 2);
    String ret = card.toString();
    assertThat(ret, is("D2"));
  }

  @Test
  public void toString_DIAMOND_3() {
    card = new Card(Card.SUIT_DIAMOND, 3);
    String ret = card.toString();
    assertThat(ret, is("D3"));
  }

  @Test
  public void toString_DIAMOND_4() {
    card = new Card(Card.SUIT_DIAMOND, 4);
    String ret = card.toString();
    assertThat(ret, is("D4"));
  }

  @Test
  public void toString_DIAMOND_5() {
    card = new Card(Card.SUIT_DIAMOND, 5);
    String ret = card.toString();
    assertThat(ret, is("D5"));
  }

  @Test
  public void toString_DIAMOND_6() {
    card = new Card(Card.SUIT_DIAMOND, 6);
    String ret = card.toString();
    assertThat(ret, is("D6"));
  }

  @Test
  public void toString_DIAMOND_7() {
    card = new Card(Card.SUIT_DIAMOND, 7);
    String ret = card.toString();
    assertThat(ret, is("D7"));
  }

  @Test
  public void toString_DIAMOND_8() {
    card = new Card(Card.SUIT_DIAMOND, 8);
    String ret = card.toString();
    assertThat(ret, is("D8"));
  }

  @Test
  public void toString_DIAMOND_9() {
    card = new Card(Card.SUIT_DIAMOND, 9);
    String ret = card.toString();
    assertThat(ret, is("D9"));
  }

  @Test
  public void toString_DIAMOND_10() {
    card = new Card(Card.SUIT_DIAMOND, 10);
    String ret = card.toString();
    assertThat(ret, is("DT"));
  }

  @Test
  public void toString_DIAMOND_11() {
    card = new Card(Card.SUIT_DIAMOND, 11);
    String ret = card.toString();
    assertThat(ret, is("DJ"));
  }

  @Test
  public void toString_DIAMOND_12() {
    card = new Card(Card.SUIT_DIAMOND, 12);
    String ret = card.toString();
    assertThat(ret, is("DQ"));
  }

  @Test
  public void toString_DIAMOND_13() {
    card = new Card(Card.SUIT_DIAMOND, 13);
    String ret = card.toString();
    assertThat(ret, is("DK"));
  }

  @Test
  public void toString_SPADE_1() {
    card = new Card(Card.SUIT_SPADE, 1);
    String ret = card.toString();
    assertThat(ret, is("SA"));
  }

  @Test
  public void toString_SPADE_2() {
    card = new Card(Card.SUIT_SPADE, 2);
    String ret = card.toString();
    assertThat(ret, is("S2"));
  }

  @Test
  public void toString_SPADE_3() {
    card = new Card(Card.SUIT_SPADE, 3);
    String ret = card.toString();
    assertThat(ret, is("S3"));
  }

  @Test
  public void toString_SPADE_4() {
    card = new Card(Card.SUIT_SPADE, 4);
    String ret = card.toString();
    assertThat(ret, is("S4"));
  }

  @Test
  public void toString_SPADE_5() {
    card = new Card(Card.SUIT_SPADE, 5);
    String ret = card.toString();
    assertThat(ret, is("S5"));
  }

  @Test
  public void toString_SPADE_6() {
    card = new Card(Card.SUIT_SPADE, 6);
    String ret = card.toString();
    assertThat(ret, is("S6"));
  }

  @Test
  public void toString_SPADE_7() {
    card = new Card(Card.SUIT_SPADE, 7);
    String ret = card.toString();
    assertThat(ret, is("S7"));
  }

  @Test
  public void toString_SPADE_8() {
    card = new Card(Card.SUIT_SPADE, 8);
    String ret = card.toString();
    assertThat(ret, is("S8"));
  }

  @Test
  public void toString_SPADE_9() {
    card = new Card(Card.SUIT_SPADE, 9);
    String ret = card.toString();
    assertThat(ret, is("S9"));
  }

  @Test
  public void toString_SPADE_10() {
    card = new Card(Card.SUIT_SPADE, 10);
    String ret = card.toString();
    assertThat(ret, is("ST"));
  }

  @Test
  public void toString_SPADE_11() {
    card = new Card(Card.SUIT_SPADE, 11);
    String ret = card.toString();
    assertThat(ret, is("SJ"));
  }

  @Test
  public void toString_SPADE_12() {
    card = new Card(Card.SUIT_SPADE, 12);
    String ret = card.toString();
    assertThat(ret, is("SQ"));
  }

  @Test
  public void toString_SPADE_13() {
    card = new Card(Card.SUIT_SPADE, 13);
    String ret = card.toString();
    assertThat(ret, is("SK"));
  }

	@Test
	public void コンストラクタ() throws Exception{
    Card instance = new Card(Card.SUIT_CLUB, 1);
    assertThat(instance.getSuit(), is(Card.SUIT_CLUB));
    assertThat(instance.getNumber(), is(1));
	}

	// エントリーポイント
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main(CardTest.class.getName());
	}
}
