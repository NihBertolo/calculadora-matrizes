package entities;

import java.util.Scanner;


public class Matrix {
	protected int linhas;
	protected int colunas;
	public int [][] matrixRedux;
	public int [][] matrix;
	private int determinante;
	
	static Scanner k = new Scanner(System.in);
	
	public Matrix(int linhas, int colunas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.matrix = new int[this.linhas][this.colunas];
			
		
	}
	
	public void gerarMatrix() {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				this.matrix[i][j] = k.nextInt();
			}
		}
	}
	
	
	public int getMatrix(int i, int j) {
		return this.matrix[i][j];
	}
	
	public int getLinhas() {
		return this.linhas;
	}
	
	public int getColunas() {
		return this.colunas;
	}
	
	public void printMatrix() {
		printMatrix(matrix);
	}
	
	public int regraUnica(int [][] matriz) {
		determinante = matriz[0][0];
		return determinante;
	}
	
	public int regraSimples(int [][] matriz) { 								
		determinante = 	
				(matriz[0][0] * matriz[1][1]) - // a11, a22
				(matriz[0][1] * matriz[1][0]);  // a12, a21
		return determinante;
	}
	
	public int regraSarrus(int [][] matriz) {
		determinante = 
				(matriz[0][0] * matriz[1][1] * matriz[2][2]) + // a11, a22, a33
				(matriz[0][1] * matriz[1][2] * matriz[2][0]) + // a12, a23, a31
				(matriz[0][2] * matriz[1][0] * matriz[2][1]) - // a13, a21, a32
				(matriz[2][0] * matriz[1][1] * matriz[0][2]) - // a31, a22, a13
				(matriz[2][1] * matriz[1][2] * matriz[0][0]) - // a32, a23, a11
				(matriz[2][2] * matriz[1][0] * matriz[0][1]);  // a33, a21, a12
		return determinante;
	}
	
	public int[][] reduzirMatrix(int [][] matriz) {
		this.matrixRedux = new int[this.linhas-1][this.colunas-1];
		if (matrix[0][0] == 1) {
			int linhaRedux = -1;
			for (int i=0; i<matriz.length; i++) {
				if(i == 0) 
					continue;
					linhaRedux ++;
					int colunaRedux = -1;
				for (int j=0; j<matriz[i].length; j++) {
					if(j == 0) 
						continue;
					this.matrixRedux[linhaRedux][++colunaRedux] = matriz[i][j] - matriz[0][colunaRedux+1]*matriz[linhaRedux+1][0];
				}
			}
		} else {
			System.out.println("Só é possível reduzir uma matriz com o primeiro elemento equivalente à 1");
		}
		return this.matrixRedux;
	}
	
	public int gerarDeterminante(int [][] matriz) {
		if (matriz.length == 1) {
			regraUnica(matriz);
		} else if (matriz.length == 2) {
			regraSimples(matriz);
		} else if (matriz.length == 3) {
			regraSarrus(matriz);
		} else if (matriz.length == 4) {
			reduzirMatrix(matriz);		
			regraSarrus(matrixRedux);								   
		} else if (matriz.length > 4) {
			System.out.println("Só é possível calcular o determinante de uma matriz de ordem 1 à 4.");
		}
		return determinante;
	}
	
	
	public int getDeterminante() {
		return determinante;
	}
	
	
	// Funções globais.
	public void printMatrix(int [][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j <matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.print("\n");
		}	
	}
}
