
public class Powierzchnia {
	int typ;
	double a, b, c, d;
	double xo, yo, zo, r;
	public Powierzchnia(int typ, double a, double b, double c, double d){
		if(typ==1){
			this.typ=1;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}else if(typ==2){
			this.typ=2;
			this.xo=a;
			this.yo=b;
			this.zo=c;
			this.d=d;
		}
	}
	public double Odleglosc()
	
}
