package card;

import java.util.Arrays;
import java.util.List;

//TODO JAVA8: add default getType() method
public interface Room extends Card {

	public static final Room KITCHEN = new SimpleRoom("Kitchen");
	public static final Room BALLROOM = new SimpleRoom("Ballroom");
	public static final Room CONSERV = new SimpleRoom("Conservatory");
	public static final Room DINING = new SimpleRoom("Dining Room");
	public static final Room BILLIARD = new SimpleRoom("Billiard Room");
	public static final Room LIBRARY = new SimpleRoom("Library");
	public static final Room LOUNGE = new SimpleRoom("Lounge");
	public static final Room HALL = new SimpleRoom("Hall");
	public static final Room STUDY = new SimpleRoom("Study");
	
	public static final List<Room> ALL_STANDARD = Arrays.asList(
		KITCHEN, BALLROOM, CONSERV, DINING, BILLIARD, LIBRARY, LOUNGE, HALL, STUDY
	);
	
}
