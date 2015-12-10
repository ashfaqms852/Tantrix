package tantrix.model;

public class Rules {

	String solitaireRule,discoveryRule;
	
	public Rules(){
		solitaireRule = "\t\tRules of Solitaire\t\t\n"
						+ "1.Starts with one Tile\n"
						+ "2.Every Time each tile is generated as random, there will 14 tiles\n"
						+ "3.You have to match the upcoming tile either as a loop or as line\n"
						+ "4.For a successfull loop, u will get points of two\n"
						+ "5.For a successfull line, u will get points of one\n"
						+ "6.The maximum score can user will earn is 28\n"
						+ "7.Enjoy the game";
		discoveryRule = "\t\tRules of Discovery\t\t\n"
						+ "1.Starts with three tile\n"
						+ "2.User have to form a loop that mentioned in the screen\n"
						+ "3.After finishing the loop, user have to validate that\n"
						+ "4.If validation is success, user will allow to create a new tile\n"
						+ "5.Else it will prompt a message as to check the loop of tile\n"
						+ "6.User have to follow this procedure till with the tenth tile\n"
						+ "7.Enjoy the game";
	}
	
	public String getSolitaireRule(){
		return solitaireRule;
	}
	
	public String getDiscoveryRule(){
		return discoveryRule;
	}
	
}
