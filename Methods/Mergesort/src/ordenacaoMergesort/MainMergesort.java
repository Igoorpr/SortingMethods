package ordenacaoMergesort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MainMergesort {
	static int ContaLinha = 1;
	
// M�todo LineCount
	
	public static void LineCount(String arquivo) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(arquivo));
			// Pega a contidade de linhas
			ContaLinha = lines.size()-1;
			System.out.println("N�mero de linhas do arquivo: " + ContaLinha);
		} catch(Exception e) {
			
		} // end catch
	} // end LineCount
	
// M�todo l� do arquivo
	
	public static void LerArquivo (Airbnb[] vetDados, String path) {
		String[] test;
		String roomID, hostID, roomtype, country, city, Bairro, review,
		 	 overallSatisfaction, accommodates, bedrooms, price, propertyType;
		
		try {
			FileInputStream fstream = new FileInputStream(path);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			br.readLine();
			String strLine = "";
			//tmp = strLine.split("\\t");
			//Read File Line By Linint x
			int x =0;
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				 test = strLine.split("\\t");
				 roomID = test[0];
				 hostID = test[1];
				 roomtype = test[2];
				 country = test[3];
				 city = test[4];
				 Bairro = test[5];
				 review = test[6];
				 overallSatisfaction = test[7];
				 accommodates = test[8];
				 bedrooms = test[9];
				 price = test[10];
				 propertyType= test[11];
								 
				 vetDados[x] = new Airbnb(roomID,hostID, roomtype, country,city,Bairro,review,overallSatisfaction,accommodates,bedrooms,price,propertyType);
				 x++;		
			} // end while
			
			//Close the input stream
			fstream.close();
			
			//mostra array a partir do 1, que s�o de fato os valores dos campos
			/*for(int o=1;o<x;o++) {
				System.out.println("RoomID: "+vetDados[o].getRoomID()+"\nHostId: " + vetDados[o].getHostID()+"\nRoom Type: " +vetDados[o].getRoomtype() + "\nPa�s: "+vetDados[o].getCountry()+"\nCidade: "+ vetDados[o].getCity() + "\nBairro: " + vetDados[o].getBairro()+"\nReviews: "+vetDados[o].getReview()+"\nSatisfa��es Gerais: " + vetDados[o].getOverallSatisfaction()+"\nAcomoda��es: "+ vetDados[o].getAccommodates()+"\nQuartos: "+vetDados[o].getBedrooms() + "\nPre�o: "+vetDados[o].getPrice()+"\nPropriedade: " + vetDados[o].getPropertyType() );
			}*/	
		} catch(Exception e) {
			System.out.println("RoomID ordena��o:");
		} // end catch
	} // end LerArquivo
	
// M�todo Exibir Menu
	
	public static void Menu (Airbnb[] vetDados) {
		long tempoInicial = 0;
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		
		int a = vetDados.length;
		
		try {
			System.out.println("Digite a op��o que deseja ordenar:\n1- Crescente:\n2- Decrescente:\n3- Aleat�rio:");
			
			int op = Integer.parseInt(entrada.readLine());
			
			if(op == 1) {
				  tempoInicial = System.currentTimeMillis();
				MergeCres (vetDados, 0, (a - 1));
			} else if(op == 2) {
				  tempoInicial = System.currentTimeMillis();
					MergeDec(vetDados, 0, (a - 1));
			} else if(op==3) {
				  tempoInicial = System.currentTimeMillis();
					MergeAleatorio (vetDados, 0, (a - 1));
				} // end if
			
			System.out.println("Tempo de Execu��o em milissegundos: " + (System.currentTimeMillis() - tempoInicial) + "ms.");
			System.out.println("Tempo de Execu��o em segundos: " + ((System.currentTimeMillis() - tempoInicial)/ 1000) + "s.");
		} catch(Exception e) {
			
		} // end catch
	} // end Menu
	
// M�todo Principal
	
	public static void main (String[] args) {
			
		String path = "dados_airbnb.txt"; // TODOS OS DADOS (128.000) dados
		 //String path = "dados_airbnb - 64.000 Dados.txt"; // 64.000 Dados
		//String path = "dados_airbnb - 32.000 Dados.txt"; // 32.000 Dados
		//String path = "dados_airbnb - 16.000 Dados.txt"; // 16.000 Dados
		//String path = "dados_airbnb - 8.000 Dados.txt"; // 8.000 Dados
	 	//String path = "dados_airbnb - 4.000 Dados.txt"; // 4.000 Dados
	    //String path = "dados_airbnb - 2.000 Dados.txt"; // 2.000 Dados
		 //String path = "teste.txt"; // 6 Dados
		
		// Conta linhas
		LineCount(path);
		Airbnb[] vetDados = new Airbnb[ContaLinha];
		LerArquivo(vetDados,path);
		Menu(vetDados);
		
		try {
			for (int i = 0; i < vetDados.length;  i++) {
				/*	
				System.out.println("RoomID: "+vetDados[i].getRoomID()+"\nHostId: " + vetDados[ i].getHostID()+"\nRoom Type: " 
					+ vetDados[i].getRoomtype() + "\nPa�s: "+ vetDados[i].getCountry()+"\nCidade: "+ vetDados[i].getCity() 
					+ "\nBairro: " + vetDados[i].getBairro()+"\nReviews: "+vetDados[i].getReview() + "\nSatisfa��es Gerais: " 
					+ vetDados[i].getOverallSatisfaction() + "\nAcomoda��es: " + vetDados[i].getAccommodates()+"\nQuartos: " 
					+ vetDados[i].getBedrooms() + "\nPre�o: "+vetDados[i].getPrice()+"\nPropriedade: " + vetDados[i].getPropertyType() + "\n");
				*/
				
				// Teste R�pido
				System.out.println("RoomID: " + vetDados[i].getRoomID() + "\n");
			} // end for		
		} catch(Exception e) {
			
		} // end catch
	
	} // end Main
	
// M�todo MergeCresc que ordena em ordem Crescente
	
	public static void MergeCres (Airbnb[] X, int inicio, int fim) {
		int meio;
		
		if (inicio < fim) {
			meio = (inicio+fim) / 2;
			MergeCres (X, inicio, meio);
			MergeCres(X, meio + 1, fim);
			IntercalaCres (X, inicio, fim, meio);
		} // end if
	} // end MergeCres
	
// M�todo IntercalaCres: � chamado pelo m�todo MergeCres que ordena em ordem Crescente
	
	public static void IntercalaCres (Airbnb X[], int inicio, int fim, int meio) {
		int posLivre, inicioVet1, inicioVet2, i;
		Airbnb aux[] = new Airbnb[X.length];
		inicioVet1 = inicio;
		inicioVet2 = meio + 1;
	 	posLivre = inicio;
	 	
	 	while (inicioVet1 <= meio && inicioVet2 <= fim) {	
			if (Integer.parseInt(X[inicioVet1].getRoomID()) <= Integer.parseInt(X[inicioVet2].getRoomID())) {
				aux[posLivre] = X[inicioVet1];
				inicioVet1 = inicioVet1+1;	
			} else {
				aux[posLivre] = X[inicioVet2];
				inicioVet2 = inicioVet2+1;
				} // end else
			posLivre = posLivre+1;
		} // end while
	 	
		// se ainda existirem numeros no primeiro vetor
		// q n foram intercalados:
		for (i = inicioVet1; i <= meio; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre+1;
		} // end for
		
		// se ainda existirem numeros no SEGUNDO vetor
		// q n foram intercalados:
		for (i = inicioVet2; i <= fim; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre+1;
		} // end for
		
		// retorna valores do vetor aux para vetor X
		for (i = inicio; i <= fim; i++) {
			X[i] = aux[i];
		} // end for
	} // end IntercalaCres

// M�todo MergeDec que ordena em ordem Decrescente
	
	public static void MergeDec (Airbnb[] X, int inicio, int fim) {
		int meio;
		
		if (inicio < fim) {
			meio = (inicio + fim) / 2;
			MergeDec(X, inicio, meio);
			MergeDec(X, meio + 1, fim);
			IntercalaDec (X, inicio, fim, meio);
		} // end if
	} // end MergeDec
	
// M�todo IntercalaDec: � chamado pelo m�todo MergeDec que ordena em ordem Decrescente
	
	public static void IntercalaDec (Airbnb X[], int inicio, int fim, int meio) {
		int posLivre, inicioVet1, inicioVet2, i;
		Airbnb aux[] = new Airbnb[X.length];
		inicioVet1 = inicio;
		inicioVet2 = meio + 1;
	 	posLivre = inicio;
	 	
	 	while (inicioVet1 <= meio && inicioVet2 <= fim) {
			if (Integer.parseInt(X[inicioVet1].getRoomID()) >= Integer.parseInt(X[inicioVet2].getRoomID())) {
				aux[posLivre] = X[inicioVet1];
				inicioVet1 = inicioVet1+1;		
			} else {
				aux[posLivre] = X[inicioVet2];
				inicioVet2 = inicioVet2+1;
			} // end else 
			posLivre = posLivre+1;
		} // end while
	 	
		// se ainda existirem numeros no primeiro vetor
		// q n foram intercalados:
		
	 	for (i = inicioVet1; i <= meio; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre+1;
		} // end for
		
		// se ainda existirem numeros no SEGUNDO vetor
		// q n foram intercalados:
		
	 	for (i = inicioVet2; i <=fim; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre+1;
		} // end for
		
		// retorna valores do vetor aux para vetor X
		for (i = inicio; i <= fim; i++) {
			X[i] = aux[i];
		} // end for
	} // end IntercalaDec
	
// M�todo MergeAleatorio que ordena em ordem Aleat�ria
		
	public static void MergeAleatorio (Airbnb[] X, int inicio, int fim) {
		int meio;
		
		if (inicio < fim) {
			meio = (inicio+fim) / 2;
			MergeAleatorio(X, inicio, meio);
			MergeAleatorio(X, meio + 1, fim);
			IntercalaAleatorio(X, inicio, fim, meio);
		} // end if
	} // end MergeAleatorio
	
// M�todo IntercalaAleatorio: � chamado pelo m�todo MergeDec que ordena em ordem Aleat�ria
	
	public static void IntercalaAleatorio (Airbnb X[], int inicio, int fim, int meio) {
		int posLivre, i;
		Airbnb aux[] = new Airbnb[X.length];	
	 	posLivre = inicio;
	 	
	 	Random randomI =new Random();
	 	int randI = randomI.nextInt(meio);
	 	Random randomJ =new Random();
	 	int randJ = randomJ.nextInt(meio);
	 	Random posx = new Random();
 		int posxi = posx.nextInt(fim);
 		posLivre = posxi;
 		
	 	while (randI <= meio && randJ <= fim) {
			if (Integer.parseInt(X[randI].getRoomID()) >= Integer.parseInt(X[randJ].getRoomID())) {
				aux[posLivre] = X[randI];
				randI = randI+1;	
			} else {
				aux[posLivre] = X[randJ];
				randJ = randJ+1;
			} // end else
			posLivre = posLivre+1;
		} // end while
	 	
		// se ainda existirem numeros no primeiro vetor
		// q n foram intercalados:
		for (i = randI; i <= meio; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre+1;
		} // end for
		
		// se ainda existirem numeros no SEGUNDO vetor
		// q n foram intercalados:
		for (i = randJ; i <= fim; i++) {
			aux[posLivre] = X[i];
			posLivre = posLivre+1;
		} // end for
		
		// retorna valores do vetor aux para vetor X
		for (i = inicio; i <= fim; i++) {
			X[i] = aux[i];
		} // end for
	} // end IntercalaAleatorio
} // end class MainMergesort
