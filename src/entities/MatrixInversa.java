package entities;

public class MatrixInversa extends Matrix {
	private int [][] subMatrix;
	private int [][] matrixCofator;
	private int [][] matrixInversa;
	
	MatrixTransposta matrixT = new MatrixTransposta(linhas,colunas);
		
	public MatrixInversa(int linhas, int colunas) {
		super(linhas, colunas);
		this.subMatrix = new int [this.linhas-1][this.colunas-1];
		this.matrixCofator = new int [this.linhas][this.colunas];
		this.matrixInversa = new int [this.linhas][this.colunas];
	}
	
	public int [][] gerarSubMatrix(int linhaExcluida, int colunaExcluida) {
		int linhaSub = -1;
		for (int i=0; i<super.matrix.length; i++) {
			if(i == linhaExcluida) 
				continue;
				linhaSub ++;
				int colunaSub = -1;
			for (int j=0; j<super.matrix[i].length; j++) {
				if(j == colunaExcluida) 
					continue;
				this.subMatrix[linhaSub][++colunaSub] = super.getMatrix(i, j);
			}
		}
		return this.subMatrix;
	}
	
	public void printSubMatrix () {
		printMatrix(subMatrix);
	}
	
	public int [][] gerarMatrixCofator(int [][] matriz) {
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[i].length; j++) {				
				this.matrixCofator[i][j] = (int) Math.pow((-1), (i+1)+(j+1)) * gerarDeterminante(gerarSubMatrix(i,j)) ;
			}
		}
		return matrixCofator;
	}
	
	public void gerarMCTransposta() {
		matrixT.gerarMatrixTransposta(matrixCofator);
	}
	
	public int [][] getMatrixCofator() {
		return matrixCofator;
	}
	
	public void printMatrixCofator () {
		printMatrix(matrixCofator);
	}
	
	public int [][] gerarMatrixInversa (int [][] matriz) {
		matrixT.gerarMatrixTransposta(matrixCofator);
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[i].length; j++) {
				this.matrixInversa[i][j] = (matrixT.matrixTransposta[i][j]);
			}
		}
		return matrixInversa;
	}
	
	 public static int MDC(int x, int y){
		    int resto;
		 
		    while(y != 0){
		      resto = x % y;
		      x = y;
		      y = resto;
		    }
		 
		    return x;
		  } 
	
	public void printMatrixInversa () {
		int denominador;
		int divisor;
		String resultado;
		
		for (int i = 0; i < matrixInversa.length; i++) {
			for (int j = 0; j <matrixInversa[i].length; j++) {
				if (MDC(matrixInversa[i][j], getDeterminante()) != 0) {
					denominador = matrixInversa[i][j]/MDC(matrixInversa[i][j], getDeterminante());
					divisor = getDeterminante()/MDC(matrixInversa[i][j], getDeterminante());
				} else {
					denominador = matrixInversa[i][j];
					divisor = getDeterminante();
				}
				if (divisor == 1) {
					resultado = denominador + "\t";
				} else {
					resultado = denominador+"/"+divisor + "\t";
				}
				if (divisor <-1) {
					resultado = "-" +denominador +"/"+(-1)*divisor + "\t";
				}
				System.out.print(resultado);
				
			}
			System.out.print("\n");
		}
	}
	

}
