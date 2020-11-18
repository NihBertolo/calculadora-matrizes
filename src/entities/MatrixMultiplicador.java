package entities;

import java.util.Scanner;

public class MatrixMultiplicador extends Matrix{
	public int [][] matrixProduto;
	public int [][] matrixResult;		
	
	static Scanner k = new Scanner(System.in);
	
	public MatrixMultiplicador(int linhas, int colunas) {
		super(linhas, colunas);
		this.matrixProduto = new int [this.linhas][this.colunas];
	}
	
	public void gerarMatrixProduto() {
		for (int i=0; i<matrixProduto.length; i++) {
			for (int j=0; j<matrixProduto[i].length; j++) {
				this.matrixProduto[i][j] = k.nextInt();
			}
		}
	}

	public int [][] multMatrixInt (int [][] matriz, int x) {
		this.matrixResult = new int [this.linhas][this.colunas];
		
		for (int i=0; i<matrixResult.length; i++) {
			this.colunas = matrixResult[i].length;
			for (int j=0; j<matriz[i].length; j++) {
				this.matrixResult[i][j] = matriz[i][j] * x;
			}
		}
		return matrixResult;
	}
	
	public int [][] multMatrix (int [][] matriz, int [][] matriz2) {
		this.matrixResult = new int [matriz.length][this.colunas];	
		
		for (int linhaMulti=0; linhaMulti<matrixResult.length; linhaMulti++) {
			for (int colunaMulti=0; colunaMulti<matrixResult[linhaMulti].length; colunaMulti++) {
				this.matrixResult[linhaMulti][colunaMulti] = multiMatrixController(matriz, matriz2, linhaMulti, colunaMulti);
			}
		}
		return matrixResult;
	}
	
	public int multiMatrixController (int [][] matriz, int [][] matriz2, int linha, int coluna) {
		int controle = 0;
		
		for (int i=0; i<matriz2.length; i++) {
			controle += matriz[linha][i] * matriz2[i][coluna];
		}
		return controle;
	}
	
	public void printMatrixM () {
		printMatrix(matrixResult);
	}
}
