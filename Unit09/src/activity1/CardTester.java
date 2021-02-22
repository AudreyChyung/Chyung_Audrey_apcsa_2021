package activity1;

import activity2.Card;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card aceDiamonds1 = new Card("ace", "diamonds", 1);
		Card fourSpades1 = new Card("4", "spades", 4);
		Card fourSpades2 = new Card("4", "spades", 4);
		
		System.out.println("ace of diamonds 1 tests");
		System.out.println(aceDiamonds1.rank());
		System.out.println(aceDiamonds1.suit());
		System.out.println(aceDiamonds1.pointValue());
		System.out.println(aceDiamonds1.toString());
		
		System.out.println("four of spades 1 tests");
		System.out.println(fourSpades1.rank());
		System.out.println(fourSpades1.suit());
		System.out.println(fourSpades1.pointValue());
		System.out.println(fourSpades1.toString());
		
		System.out.println("four of spades 2 tests");
		System.out.println(fourSpades2.rank());
		System.out.println(fourSpades2.suit());
		System.out.println(fourSpades2.pointValue());
		System.out.println(fourSpades2.toString());
	}
}
