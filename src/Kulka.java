
public class Kulka {
	double r=10;
	double x, y, z, vx, vy, vz;

	public Kulka(double x, double y, double z, double vx, double vy, double vz) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
	}
	public Kulka(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double v(){
		return Math.pow((vx*vx+vy*vy+vz*vz),0.5);
	}
}
