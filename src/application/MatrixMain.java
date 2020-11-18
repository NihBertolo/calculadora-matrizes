/*
 * Autor: Nicholas Bertolo
 */

package application;

import java.util.Scanner;
import entities.Matrix; //Classe mãe
import entities.MatrixTransposta; //Classe filha, usada para transpor uma matriz inserida.
import entities.MatrixInversa;
import entities.MatrixMultiplicador;

public class MatrixMain {
	
	static int linhas;
	static int colunas;
	static Scanner k = new Scanner(System.in);

	public static void main(String[] args) {

		
		int query;
		
		do {
		exibirMenu();
		
 		query = k.nextInt();
 				
		
		switch (query) {
			case 1:			
				queryDimensao();
				Matrix matrix = new Matrix(linhas, colunas);
				if (linhas == colunas) {
					System.out.println("Insira a Matriz a ser calculada:");
					matrix.gerarMatrix();
					matrix.gerarDeterminante(matrix.matrix);
					System.out.println("O determinante da matriz é: " +matrix.getDeterminante());
					matrix.printMatrix(matrix.matrix);			 
				} else {
					System.out.println("Só é possível calcular o determinante de uma matriz quadrada!(2x2,3x3 e 4x4).");
				}
				break;
			case 2:
				queryDimensao();
				MatrixTransposta matrixT = new MatrixTransposta(linhas, colunas);
				System.out.println("Insira a matriz a ser calculada:");
				matrixT.gerarMatrix();
				matrixT.gerarMatrixTransposta(matrixT.matrix);
				System.out.println("A matriz transposta é:");
	        	matrixT.printMatrixTransposta();
	        	break;
			case 3:
				queryDimensao();
				if(linhas == colunas) {
					MatrixInversa matrixI = new MatrixInversa(linhas, colunas);
					System.out.println("Insira a Matriz a ser calculada:");
					matrixI.gerarMatrix();
					matrixI.gerarMatrixCofator(matrixI.matrix);
					System.out.println("### Matriz dos Cofatores: ###");
					matrixI.printMatrixCofator();
					matrixI.gerarDeterminante(matrixI.matrix);
					matrixI.gerarMatrixInversa(matrixI.getMatrixCofator());
					System.out.println("### Matriz Inversa ###");
					matrixI.printMatrixInversa();
				} else {
					System.out.println("Só é possível calcular a matriz inversa de uma matriz quadrada!(2x2,3x3 e 4x4)");
				} 
				break;
			case 4:				
				queryDimensao();
				matrix = new Matrix(linhas, colunas);
				if(linhas == colunas) {
					System.out.println("Insira a matriz a ser reduzida.");
					matrix.gerarMatrix();
					matrix.reduzirMatrix(matrix.matrix);
					//System.out.println("A matriz reduzida da matriz de ordem" +linhas + "é:" +matrix.getMatrixRedux());
					matrix.printMatrix(matrix.matrixRedux);
				} else {
					System.out.println("Só é possível reduzir uma matriz quadrada!(2x2, 3x3, 4x4....)");
				}
				break;
			case 5:				

				System.out.println("O que deseja fazer? 1- Multiplicar matriz por um número inteiro. // 2 - Multiplicar por outra matriz.");
				int query2 = k.nextInt();
					switch (query2) {
					case 1:
						queryDimensao();
						MatrixMultiplicador matrixM = new MatrixMultiplicador(linhas, colunas);
						matrixM.gerarMatrix();
						System.out.println("Insira um número inteiro a ser multiplicado pela matriz");	
						int nInteiro = k.nextInt();
						matrixM.multMatrixInt(matrixM.matrix, nInteiro);
						matrixM.printMatrixM();
						break;
					case 2:
						queryDimensao();
						matrix = new Matrix(linhas,colunas);
						System.out.println("Insira a matriz a ser multiplicada.");
						matrix.gerarMatrix();
						System.out.println("Agora digite o número de linhas da segunda matriz:");
						int linhasProduto = k.nextInt();
						System.out.println("Digite o número de colunas da segunda matriz:");
						int colunasProduto = k.nextInt();
						if (colunas != linhasProduto) {
							System.out.println("Erro! \n Só é possível multiplicar duas matrizes com número de colunas da primeira igual ao número de linhas da segunda");
						} else {
							MatrixMultiplicador matrixMP = new MatrixMultiplicador(linhasProduto, colunasProduto);
							System.out.println("Agora digite a segunda matriz:");
							matrixMP.gerarMatrixProduto();
							matrixMP.multMatrix(matrix.matrix, matrixMP.matrixProduto);
							System.out.println("A matriz resultante é: \n");
							matrixMP.printMatrixM();
							break;
						}
					}
					break;
			case 0:
				System.out.println("Obrigado por usar o programinha! =)");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}while(query!=0);
	}
	
	public static void exibirMenu() {
		 System.out.println("\n\n### Calculadora de Matrizes - por Niih Bertolo ###");
         System.out.println("===========================================");
         System.out.println("      |       O que deseja fazer? =)      |");
         System.out.println("      |     1 - Calcular determinante     |");
         System.out.println("      |     2 - Transpor matriz           |");
         System.out.println("      |     3 - Inverter matriz           |");
         System.out.println("      |     4 - Reduzir matriz            |");
         System.out.println("      |     5 - Operações c/ matriz       |");
         System.out.println("      |     0 - Sair                      |");
         System.out.println("===========================================\n");
	}
	
	public static void queryDimensao() {
		System.out.println("Insira o número de linhas da matriz:");
		linhas = k.nextInt();
		System.out.println("Agora digite o número de colunas:");
		colunas = k.nextInt();
	}

}
