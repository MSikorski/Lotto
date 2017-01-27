import java.util.Random;

public class Lotto {
	static Random rand = new Random();
	static int a = 0;
	static int b[] = new int[6];
	static int c = 0;

	static Kulki kulki = new Kulki();

	static Powierzchnie powierzchnie = new Powierzchnie();

	public static void Sprawdz() {
		for (int i = 0; i < 50; i++) {
			if (kulki.kulka[i].x <= 15 || kulki.kulka[i].x >= 185) {
				kulki.kulka[i].vx *= -1;
			}
			if (kulki.kulka[i].y <= 15 || kulki.kulka[i].y >= 385) {
				kulki.kulka[i].vy *= -1;
			}
			if (kulki.kulka[i].z <= 15 || kulki.kulka[i].z >= 585) {
				kulki.kulka[i].vz *= -1;
			}
		}
	}

	public static void Wciagnij() {
		for (int i = 0; i < 50; i++) {
			if (kulki.kulka[i].x >= 85 && kulki.kulka[i].x <= 115 && kulki.kulka[i].y >= 185 && kulki.kulka[i].y <= 215
					&& kulki.kulka[i].z >= 285 && kulki.kulka[i].z <= 315) {
				kulki.kulka[i].x = rand.nextInt(150)+15;
				kulki.kulka[i].y = rand.nextInt(350)+15;
				kulki.kulka[i].z = rand.nextInt(550)+15;
				b[c] = i+1;
				c++;
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {
		while (1 > 0) {
			if (c >= 6) {
				System.out.println(
						"Wylosowano 6 liczb: " + b[0] + " " + b[1] + " " + b[2] + " " + b[3] + " " + b[4] + " " + b[5]);
				System.out.println("W trakcie nastapilo "+a+" zderzen");
				break;
			}
			System.out.println(kulki.kulka[0].x + " " + kulki.kulka[0].y + " " + kulki.kulka[0].z);
			// System.out.println(kulki.kulka[0].vx + " " +
			 //kulki.kulka[0].vy +
			// " " + kulki.kulka[0].vz);
			Sprawdz();
			if (kulki.Fizyka(0.01))
				a++;
			//Thread.sleep(1);
			Wciagnij();

		}

	}
}
