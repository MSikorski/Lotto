
public class Powierzchnie {
	Powierzchnia[] powierzchnia = new Powierzchnia[6];

	public Powierzchnie() {
		powierzchnia[0] = new Powierzchnia(0, -1, 0, 0);
		powierzchnia[1] = new Powierzchnia(0, 0, 1, 0);
		powierzchnia[2] = new Powierzchnia(0, -1, 0, 600);
		powierzchnia[3] = new Powierzchnia(0, 0, 1, -400);
		powierzchnia[4] = new Powierzchnia(-1, 0, 0, 0);
		powierzchnia[5] = new Powierzchnia(-1, 0, 0, 200);
	}
}
