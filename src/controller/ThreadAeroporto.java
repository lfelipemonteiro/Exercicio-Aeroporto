package controller;

import java.util.concurrent.Semaphore;
public class ThreadAeroporto extends Thread {

	private Semaphore limite;
	private int av;
	private String direcao;

	public ThreadAeroporto(int nAviao, Semaphore limite, String direcao) {
		this.av = nAviao;
		this.direcao = direcao;
		this.limite = limite;
	}

	@Override
	public void run() {
		procedimentoDecolagem();
	}

	private void procedimentoDecolagem() {
		try {
			limite.acquire();
			manobra();
			taxiar();
			decolar();
			afastar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			limite.release();
		}
	}
 // metodos para calcular o afastar do avião
	private void afastar() {
		// sleep de 3 a 8 seg
		int s = (int) ((Math.random() * 5001) + 3000);
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + av + " se afastou após " + (s / 1000) + " segundos");
	}
// metodo para calcular a decolagem do avião
	private void decolar() {
		// sleep de 1 a 4 seg
		int s = (int) ((Math.random() * 3001) + 1000);
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + av + " decolou após " + (s / 1000) + " segundos sentido " + direcao);
	}
// metodo para calcular o taxiamento do avião
	private void taxiar() {
		// sleep de 5 a 10 seg
		int s = (int) ((Math.random() * 5001) + 5000);
		try {
			sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O avião " + av + " taxiou " + (s / 1000) + " segundos");
	}
// metodo para calcular o tempo de manobra do avião
	private void manobra() {
		// sleep de 3 a 7 seg
		int s = (int) ((Math.random() * 4001) + 3000);
		try {
			sleep(s);
			} 
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		System.out.println("O avião " + av + " manobrou após " + (s / 1000) + " segundos");
	}

}