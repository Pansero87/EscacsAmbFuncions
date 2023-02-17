package programa;

import Teclat.*;

public class Escacs {

	public static void main(String[] args) {

		char[][] tauler;
		tauler = Funcions.definirTauler();

		int opcio = 0;
		while (opcio != 5) {

			Funcions.mostrarTauler(tauler);

			System.out.println();
			System.out.println("//////////////////////////////////////////");
			Pantalla.titol("ET MOSTRE EL SEGÜENT MENÚ");
			System.out.println("1- Posar una peça.");
			System.out.println("2- Mostrar els moviments d'una peça.");
			System.out.println("3- Esborrar els moviments.");
			System.out.println("4- Esborrar el tauler (Peces i Moviments).");
			System.out.println("5- Eixir.");
			System.out.println();
			Pantalla.titolet("SELECCIONA UNA DE LE OPCIONS ANTERIORS: ");

			opcio = Teclat.lligInt("Opció: ", 1, 5);
			char p;
			int f;
			int c;
			switch (opcio) {
			case 1:
				p = Funcions.seleccionarPeça();
				f = Funcions.demanarCoordenades();
				c = Funcions.demanarCoordenades();
				tauler[f][c] = p;
				break;

			case 2:
				f = Funcions.demanarCoordenades();
				c = Funcions.demanarCoordenades();
				switch (tauler[f][c]) {

				case 'R':
					Funcions.movimentsRey(tauler, f, c);
					break;
					
				case 'T':
					Funcions.movimentsTorre(tauler, f, c);
					break;
					
				case 'A':
					Funcions.movimentsAlfil(tauler, f, c);
					break;
				case 'C':
					Funcions.movimentsCaball(tauler, f, c);
					break;
				case 'D':
					Funcions.movimentsDama(tauler, f, c);
					break;
				}
				
			case 3:
			Funcions.borrarMoviments(tauler);

			}

		}
		System.out.println("FINISH");
	}

}
