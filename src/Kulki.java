import java.util.Random;

public class Kulki {
	Random rand = new Random();
	Kulka[] kulka = new Kulka[50];

	public Kulki() {
		double rx, ry, rz, rvx, rvy, rvz;
		for (int i = 0; i < 50; i++) {

			rx = rand.nextInt(180) + 10;
			ry = rand.nextInt(600) + 10;
			rz = rand.nextInt(90) + 10;
			rvx = rand.nextDouble() * 50.5;
			rvy = rand.nextDouble() * 50.5;
			rvz = rand.nextDouble() * 50.5;
			kulka[i] = new Kulka(rx, ry, rz, rvx, rvy, rvz);
			if (i > 0) {
				for (int j = 0; j < i; j++) {
					while (Odleglosc(i, j) < 15) {
						rx = rand.nextInt(180) + 10;
						ry = rand.nextInt(600) + 10;
						rz = rand.nextInt(90) + 10;
						kulka[i] = new Kulka(rx, ry, rz);
					}
				}
			}
		}
	}

	public boolean Fizyka(double t) {
		Grawitacja(t);
		Wiatrak(t);
		Przemieszczenie(t);
		if(Sprawdz()) return true;
		else return false;
	}

	public boolean Sprawdz() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (Odleglosc(i, j) <= 10 && !(i==j)) {
					Zderzenie(i, j);
					return true;
				}
			}
		}
		return false;
	}

	public double Odleglosc(int i, int j) {
		return Math.pow((Math.pow((kulka[i].x - kulka[j].x), 2) + Math.pow((kulka[i].y - kulka[j].y), 2)
				+ Math.pow((kulka[i].z - kulka[j].z), 2)), 0.5);
	}

	public void Zderzenie(int i, int j) {
		double sina, cosa;
		double nx, ny, nz;
		double vnix, vniy, vniz, vnjx, vnjy, vnjz;

		nx = kulka[j].x - kulka[i].x;
		ny = kulka[j].y - kulka[i].y;
		nz = kulka[j].z - kulka[i].z;

		cosa = (nx * kulka[j].vx + ny * kulka[j].vy + nz * kulka[j].vz)
				/ ((kulka[j].v()) * (nx * nx + ny * ny + nz * nz));
		sina = Math.pow((1 - cosa * cosa), 0.5);
		vnix = Math.pow((nx * nx / (nx * nx + ny * ny + nz * nz)), 0.5) * sina * kulka[j].v();
		vniy = Math.pow((ny * ny / (nx * nx + ny * ny + nz * nz)), 0.5) * sina * kulka[j].v();
		vniz = Math.pow((nz * nz / (nx * nx + ny * ny + nz * nz)), 0.5) * sina * kulka[j].v();
		if (nx < 0)
			vnix = -vnix;
		if (ny < 0)
			vniy = -vniy;
		if (nz < 0)
			vniz = -vniz;

		nx = -nx;
		ny = -ny;
		nz = -nz;
		cosa = (nx * kulka[i].vx + ny * kulka[i].vy + nz * kulka[i].vz)
				/ ((kulka[i].v()) * (nx * nx + ny * ny + nz * nz));
		sina = Math.pow((1 - cosa * cosa), 0.5);
		vnjx = Math.pow((nx * nx / (nx * nx + ny * ny + nz * nz)), 0.5) * sina * kulka[i].v();
		vnjy = Math.pow((ny * ny / (nx * nx + ny * ny + nz * nz)), 0.5) * sina * kulka[i].v();
		vnjz = Math.pow((nz * nz / (nx * nx + ny * ny + nz * nz)), 0.5) * sina * kulka[i].v();
		if (nx < 0)
			vnjx = -vnjx;
		if (ny < 0)
			vnjy = -vnjy;
		if (nz < 0)
			vnjz = -vnjz;

		kulka[i].vx += vnix;
		kulka[i].vy += vniy;
		kulka[i].vz += vniz;
		kulka[j].vx += vnjx;
		kulka[j].vy += vnjy;
		kulka[j].vz += vnjz;
	}

	public void Grawitacja(double t) {
		for (int i = 0; i < 50; i++) {
			kulka[i].vz--;
		}
	}

	public void Przemieszczenie(double t) {
		for (int i = 0; i < 50; i++) {
			kulka[i].x += t * kulka[i].vx;
			kulka[i].y += t * kulka[i].vy;
			kulka[i].z += t * kulka[i].vz;	
		}
	}

	public void Wiatrak(double t) {
		for (int i = 0; i < 50; i++) {
			if(kulka[i].z<15){
				kulka[i].vz += 500 / kulka[i].z;
				//kulka[i].vx += (kulka[i].x-100)/10;
				//kulka[i].vy += (kulka[i].y-100)/10;
			}
		}
	}
}
