package programa;

import Teclat.Teclat;

public class Funcions {

	// Variavles globals
	static final char BUIT = ' ';
	static int qFiles, qColumnes;
	static final char MOVIMENTS = 'X';
	

	// Funció per definir el tauler
	static char[][] definirTauler() {

		qFiles = Teclat.lligInt("Files que tindrà el tauler: ", 5, 9);
		qColumnes = Teclat.lligInt("Columnes que tindrà el tauler: ", 5, 9);

		char[][] tauler = new char[qFiles + 1][qColumnes + 1];

		for (int f = 1; f <= qFiles; f++) {
			for (int c = 1; c <= qColumnes; c++) {
				tauler[f][c] = BUIT;
			}
		}
		return tauler;
	}

	// Procediment per mostrar el tauler
	static void mostrarTauler(char[][] tauler) {

		System.out.println(" ");
		for (int c = 1; c < tauler.length; c++) {
			System.out.print(" " + c);
		}

		System.out.println();
		for (int f = 1; f < tauler.length; f++) {
			System.out.print(f);
			for (int c = 1; c < tauler.length; c++) {
				System.out.print(" " + tauler[f][c]);
			}
			System.out.println();

		}

	}

	// Funció seleccionar peça
	static char seleccionarPeça() {

		char peça;
		return peça = Teclat.lligChar("Quina peça vols posar. Rey,Torre,Dama,Caball,Alfil: ", "rtdca");
	}

	// Funció demanar Fila
	static int demanarCoordenades() {

		int fc;
		return fc = Teclat.lligInt("Nº de Fila i Columna:",1, 9);

	}

	// Procediment moviments peces

	static void movimentsRey(char[][] t, int f, int c) {

		if (f - 1 >= 1 && c - 1 >= 1) {
			if (t[f - 1][c - 1] == BUIT) {
				t[f - 1][c - 1] = MOVIMENTS;
			}

		}
		if (f + 1 <= qFiles && c + 1 <= qColumnes) {
			if (t[f + 1][c + 1] == BUIT) {
				t[f + 1][c + 1] = MOVIMENTS;
			}

		}
		if (f - 1 >= 1 && c + 1 <= qColumnes) {
			if (t[f - 1][c + 1] == BUIT) {
				t[f - 1][c + 1] = MOVIMENTS;
			}

		}
		if (f + 1 <= qFiles && c - 1 >= 1) {
			if (t[f + 1][c - 1] == BUIT) {
				t[f + 1][c - 1] = MOVIMENTS;
			}

		}
		if (c - 1 >= 1) {
			if (t[f][c - 1] == BUIT) {
				t[f][c - 1] = MOVIMENTS;
			}

		}
		if (c + 1 <= qColumnes) {
			if (t[f][c + 1] == BUIT) {
				t[f][c + 1] = MOVIMENTS;
			}

		}
		if (f - 1 >= 1) {
			if (t[f - 1][c] == BUIT) {
				t[f - 1][c] = MOVIMENTS;
			}

		}
		if (f + 1 <= qFiles) {
			if (t[f + 1][c] == BUIT) {
				t[f + 1][c] = MOVIMENTS;
			}

		}

	}

	static void movimentsTorre(char[][] t, int f, int c) {

		for (int c1 = c - 1; c1 >= 1; c1--) {
			if (t[f][c1] != BUIT && t[f][c1] != MOVIMENTS) {
				break;
			}
			t[f][c1] = MOVIMENTS;

		}
		for (int c1 = c + 1; c1 <= qColumnes; c1++) {
			if (t[f][c1] != BUIT && t[f][c1] != MOVIMENTS) {
				break;
			}
			t[f][c1] = MOVIMENTS;

		}
		for (int f1 = f - 1; f1 >= 1; f1--) {
			if (t[f1][c] != BUIT && t[f1][c] != MOVIMENTS) {
				break;
			}
			t[f1][c] = MOVIMENTS;

		}
		for (int f1 = f + 1; f1 <= qFiles; f1++) {
			if (t[f1][c] != BUIT && t[f1][c] != MOVIMENTS) {
				break;
			}
			t[f1][c] = MOVIMENTS;
		}

	}

	static void movimentsAlfil(char[][] t, int f, int c) {

		for (int f1 = f - 1, c1 = c - 1; f1 >= 1 && c1 >= 1; f1--, c1--) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;
		}
		for (int f1 = f + 1, c1 = c + 1; f1 <= qFiles && c1 <= qColumnes; f1++, c1++) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;
		}
		for (int f1 = f - 1, c1 = c + 1; f1 >= 1 && c1 <= qFiles; f1--, c1++) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;
		}
		for (int f1 = f + 1, c1 = c - 1; f1 <= qFiles && c1 >= 1; f1++, c1--) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;

		}
	}

	static void movimentsCaball(char[][] t, int f, int c) {

		try {
			if (t[f + 1][c - 2] == BUIT) {
				t[f + 1][c - 2] = MOVIMENTS;
			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f + 2][c - 1] == BUIT) {
				t[f + 2][c - 1] = MOVIMENTS;
			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f - 1][c - 2] == BUIT) {
				t[f - 1][c - 2] = MOVIMENTS;
			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f - 2][c - 1] == BUIT)
				t[f - 2][c - 1] = MOVIMENTS;

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f - 2][c + 1] == BUIT)
				t[f - 2][c + 1] = MOVIMENTS;

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f - 1][c + 2] == BUIT)
				t[f - 1][c + 2] = MOVIMENTS;

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f + 1][c + 2] == BUIT)
				t[f + 1][c + 2] = MOVIMENTS;

		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			if (t[f + 2][c + 1] == BUIT)
				t[f + 2][c + 1] = MOVIMENTS;

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	static void movimentsDama(char[][] t, int f, int c) {

		for (int f1 = f - 1, c1 = c - 1; f1 >= 1 && c1 >= 1; f1--, c1--) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;
		}
		for (int f1 = f + 1, c1 = c + 1; f1 <= qFiles && c1 <= qColumnes; f1++, c1++) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;
		}
		for (int f1 = f - 1, c1 = c + 1; f1 >= 1 && c1 <= qFiles; f1--, c1++) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;
		}
		for (int f1 = f + 1, c1 = c - 1; f1 <= qFiles && c1 >= 1; f1++, c1--) {
			if (t[f1][c1] != BUIT && t[f1][c1] != MOVIMENTS) {
				break;
			}
			t[f1][c1] = MOVIMENTS;

		}

		for (int c1 = c - 1; c1 >= 1; c1--) {
			if (t[f][c1] != BUIT && t[f][c1] != MOVIMENTS) {
				break;
			}
			t[f][c1] = MOVIMENTS;

		}
		for (int c1 = c + 1; c1 <= qColumnes; c1++) {
			if (t[f][c1] != BUIT && t[f][c1] != MOVIMENTS) {
				break;
			}
			t[f][c1] = MOVIMENTS;

		}
		for (int f1 = f - 1; f1 >= 1; f1--) {
			if (t[f1][c] != BUIT && t[f1][c] != MOVIMENTS) {
				break;
			}
			t[f1][c] = MOVIMENTS;

		}
		for (int f1 = f + 1; f1 <= qFiles; f1++) {
			if (t[f1][c] != BUIT && t[f1][c] != MOVIMENTS) {
				break;
			}
			t[f1][c] = MOVIMENTS;
		}

	}
	
	static void borrarMoviments(char [][] tauler) {
		int movEsborrats = 0;
		for (int i = 1; i < qFiles; i++) {
			for (int j = 1; j < qColumnes; j++) {
				if (tauler[i][j] == MOVIMENTS) {
					tauler[i][j] = BUIT;
					movEsborrats ++;
				}
			}
		}
		
	}
	
	
	

}
