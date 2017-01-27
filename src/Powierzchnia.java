public class Powierzchnia {
	double a, b, c, d;

	public Powierzchnia(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public Powierzchnia(int a, int b, int c, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public double Odleglosc(Kulka kulka) {
		return (Math.abs(a * kulka.x + b * kulka.y + c * kulka.z + d) / Math.pow((a * a + b * b + c * c), 0.5));
	}
}