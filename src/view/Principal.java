package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Principal {
	public static void main(String[] args) {
		Semaphore limite = new Semaphore(2);
		String dir = null;

		for (int cta = 1; cta <= 4; cta++) {
			
			int random = (int) (Math.random()*2);

			if (random == 0)
				dir = "norte";
			if (random == 1)
				dir = "sul";
			
			Thread t = new ThreadAeroporto(cta, limite, dir);
			t.start();
		}
	}
}		