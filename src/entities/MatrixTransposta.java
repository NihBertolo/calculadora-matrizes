package entities;


public class MatrixTransposta extends Matrix {
	protected int [][] matrixTransposta;

	public MatrixTransposta(int linhas, int colunas) {
		super(linhas, colunas);
		this.matrixTransposta = new int [this.colunas][this.linhas];
	}
	
	public int[][] gerarMatrixTransposta(int [][] matriz) {
		for (int i=0; i<matrixTransposta.length; i++) {
			for (int j=0; j<matrixTransposta[i].length; j++) {
				this.matrixTransposta[i][j] = matriz[j][i];
			}
		}
		return matrixTransposta;
	}
	
	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}
	
	public void setColunos(int colunas) {
		this.colunas = colunas;
	}
	
	public void printMatrixTransposta() {
		printMatrix(matrixTransposta);
	}
	
	public int getMatrixTransposta(int i, int j) {
		return this.matrixTransposta[i][j];
	}

}
	

