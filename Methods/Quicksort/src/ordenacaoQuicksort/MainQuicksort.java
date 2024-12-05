package ordenacaoQuicksort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MainQuicksort {
	static int ContaLinha = 1;
	
// M�todo LineCount
	
	public static void LineCount(String arquivo) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(arquivo));
			// Pega a contidade de linhas
			ContaLinha = lines.size()-1;
			System.out.println("N�mero de linhas do arquivo: " + (ContaLinha));
		} catch (Exception e) {
			
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
			int x = 0;
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
			/*
			for (int i = 1; i < vetDados.length;  i++) {
				System.out.println("RoomID: "+vetDados[i].getRoomID()+"\nHostId: " + vetDados[ i].getHostID()+"\nRoom Type: " 
					+ vetDados[i].getRoomtype() + "\nPa�s: "+ vetDados[i].getCountry()+"\nCidade: "+ vetDados[i].getCity() 
					+ "\nBairro: " + vetDados[i].getBairro()+"\nReviews: "+vetDados[i].getReview() + "\nSatisfa��es Gerais: " 
					+ vetDados[i].getOverallSatisfaction() + "\nAcomoda��es: " + vetDados[i].getAccommodates()+"\nQuartos: " 
					+ vetDados[i].getBedrooms() + "\nPre�o: "+vetDados[i].getPrice()+"\nPropriedade: " + vetDados[i].getPropertyType() + "\n");
				
				// Teste R�pido
				 System.out.println("RoomID: " + vetDados[i].getRoomID());
			} // end for
				*/
			// Close the input stream
			fstream.close();			
		} catch(Exception e) {
			System.out.println("erro:" +e);
		} // end catch
	} // end LerArquivo
	
// M�todo Exibir Menu 
		
	public static void Menu (Airbnb[] vetDados) {		
		long tempoInicial =0;

		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Digite a op��o que deseja ordenar:\n1- Crescente:\n2- Decrescente:\n3- Aleat�rio:");
			
			int op = Integer.parseInt(entrada.readLine());
			
			if(op == 1) {
				  tempoInicial = System.currentTimeMillis();
				quickSort(vetDados,0,vetDados.length-1);
			} else if(op == 2) {
				  tempoInicial = System.currentTimeMillis();
					quickSortDec(vetDados,0,vetDados.length-1);
					} else if(op==3) {
						  tempoInicial = System.currentTimeMillis();
							quickSortAle(vetDados,0,vetDados.length-1);
							} // end if
			System.out.println("Tempo de Execu��o em milissegundos: " + (System.currentTimeMillis() - tempoInicial) + "ms.");
			System.out.println("Tempo de Execu��o em segundos: " + ((System.currentTimeMillis() - tempoInicial)/ 1000) + "s.");
		} catch(Exception e) {
			
		} // end catch
	} // end Menu
	
// M�todo Principal	
	
	public static void main(String[] args) {
		
		String path = "dados_airbnb.txt"; // TODOS OS DADOS (128.000) dados
		// String path = "dados_airbnb - 64.000 Dados.txt"; // 64.000 Dados
		// String path = "dados_airbnb - 32.000 Dados.txt"; // 32.000 Dados
		//  String path = "dados_airbnb - 16.000 Dados.txt"; // 16.000 Dados
		// String path = "dados_airbnb - 8.000 Dados.txt"; // 8.000 Dados
	    // String path = "dados_airbnb - 4.000 Dados.txt"; // 4.000 Dados
		 //String path = "dados_airbnb - 2.000 Dados.txt"; // 2.000 Dados
	//	String path = "teste.txt"; // 6 Dados
		
		try {
			// conta linhas
			LineCount(path);
			Airbnb[] vetDados = new Airbnb[ContaLinha]; // N�mero de Linhas
			LerArquivo(vetDados,path);
			Menu(vetDados);
			
			for (int i = 0; i < vetDados.length;  i++) {
			/*	System.out.println("RoomID: "+vetDados[i].getRoomID()+"\nHostId: " + vetDados[ i].getHostID()+"\nRoom Type: " 
					+ vetDados[i].getRoomtype() + "\nPa�s: "+ vetDados[i].getCountry()+"\nCidade: "+ vetDados[i].getCity() 
					+ "\nBairro: " + vetDados[i].getBairro()+"\nReviews: "+vetDados[i].getReview() + "\nSatisfa��es Gerais: " 
					+ vetDados[i].getOverallSatisfaction() + "\nAcomoda��es: " + vetDados[i].getAccommodates()+"\nQuartos: " 
					+ vetDados[i].getBedrooms() + "\nPre�o: "+vetDados[i].getPrice()+"\nPropriedade: " + vetDados[i].getPropertyType() + "\n");
					*/
				// Teste R�pido
			//	System.out.println("RoomID: " + vetDados[i].getRoomID() + "\n");
			} // end for
		} catch(Exception e ) {
			System.out.println("erro: " + e);
		} // end catch		
		
	
	} // end main
	
// M�todo quickSort que ordena em ordem Crescente	
	
	public static void quickSort (Airbnb X[],int p, int r) {
		int q;
		
		if (p < r) {
			q = particao(X,p,r);
			quickSort(X,p,q);
			quickSort(X,q+1,r);
		} // end if
	} // end quickSort
	
// M�todo particao: � chamado pelo m�todo quickSort que ordena em ordem Crescente
	
	public static int particao (Airbnb X[], int p , int r) {
		int i,j;
		Airbnb pivo;
		pivo= X[(p+r)/2];
		i = p-1;
		j = r+1;
		
		while (i < j) {			
			do {
				j = j - 1;
			} // end do
			
			while(Integer.parseInt(X[j].getRoomID()) > Integer.parseInt(pivo.getRoomID()));
			
			do {
				i=i+1;
			} // end do
			
			while (Integer.parseInt(X[i].getRoomID()) < Integer.parseInt(pivo.getRoomID()));
				if (i < j)
					troca(X,i,j);
		} // end while
		
		return j;
	} // end particao
	
// M�todo troca: � chamado pelo m�todo particao que ordena em ordem Crescente
	
	public static void troca(Airbnb X[], int i ,int j) {
		Airbnb aux;
		aux = X[i];
		X[i] = X[j];
		X[j] = aux;
	} // end troca
	
// M�todo quickSortDec que ordena em ordem Decrescente	
	
	public static void quickSortDec (Airbnb X[],int p, int r) {
		int q;
		
		if (p < r) {
			q = particaoDec(X,p,r);
			quickSortDec(X,p,q);
			quickSortDec(X,q+1,r);
		} // end if
	} // end quickSortDec
		
// M�todo particaoDec: � chamado pelo m�todo quickSortDec que ordena em ordem Decrescente
		
	public static int particaoDec(Airbnb X[], int p , int r) {
			int i,j;
			Airbnb pivo;
			pivo= X[(p+r)/2];
			i = p-1;
			j = r+1;
			
			while (i < j) {	
				do {
					j = j-1;
				} // end do
				
				while(Integer.parseInt(X[j].getRoomID()) < Integer.parseInt(pivo.getRoomID()));
				
				do {
					i=i+1;
				} // end do
				
				while(Integer.parseInt(X[i].getRoomID()) > Integer.parseInt(pivo.getRoomID()));
					if (i < j)
						trocaDec(X,i,j);
			} // end while
			
			return j;
		} // end particaoDec
		
// M�todo trocaDec: � chamado pelo m�todo particaoDec que ordena em ordem Decrescente
		
	public 	static void trocaDec (Airbnb X[], int i ,int j) {
		Airbnb aux;
		aux = X[i];
		X[i] = X[j];
		X[j] = aux;
	} // end trocaDec
		
// M�todo quickSortAle que ordena em ordem Aleat�ria	
		
	public static void quickSortAle (Airbnb X[],int p, int r) {
		int q;
		
		if (p < r) {
			q = particaoAle(X,p,r);
			quickSortAle(X,p,q);
			quickSortAle(X,q+1,r);
		} // end if
	} // end quickSortAle
		
// M�todo particaoAle: � chamado pelo m�todo quickSortAle que ordena em ordem Aleat�ria
		
	public static int particaoAle(Airbnb X[], int p , int r) {
		int i,j;
		Random randI = new Random();
		Random randJ = new Random();
		int rarandI = randI.nextInt(X.length-1);
		int rarandJ = randJ.nextInt(X.length);
		Airbnb pivo;
		pivo= X[rarandI];
		i = p-1;
		j = r+1;

		while (i < j) {
			do {
				rarandJ = rarandJ-1;
			} // end do
			
			while(Integer.parseInt(X[rarandJ].getRoomID()) < Integer.parseInt(pivo.getRoomID()));
			
			do {
				rarandI=rarandI+1;
			} // end do
			
			while(Integer.parseInt(X[rarandI].getRoomID()) > Integer.parseInt(pivo.getRoomID()));
				if (i < j)
					trocaAle(X,rarandI,rarandJ);
		} // end while
		
		return rarandJ;
	} // end particaoAle
		
// M�todo trocaAle: � chamado pelo m�todo particaoAle que ordena em ordem Crescente
		
	public static void trocaAle (Airbnb X[], int i ,int j) {
		Airbnb aux;
			
		aux = X[i];
		X[i] = X[j];
		X[j] = aux;
	} // end trocaAle		
} // end class MainQuicksort
