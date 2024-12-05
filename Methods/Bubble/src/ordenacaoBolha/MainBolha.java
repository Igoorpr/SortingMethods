package ordenacaoBolha;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MainBolha {
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

			String strLine = "";
			//Read File Line By Linint x
			int x = 0;
			while ((strLine = br.readLine()) != null) {
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
				// System.out.println("RoomID: " + vetDados[i].getRoomID());
			} // end for
			*/
			// Close the input stream
			fstream.close();			
		} catch(Exception e) {
			System.out.println("erro:" +e);
		} // end catch
	} // end LerArquivo
	
// M�todo Exibir Menu 
	
	public static void Menu(Airbnb[] vetDados) {
		long tempoInicial=0 ;

		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Digite a op��o que deseja ordenar:\n1- Crescente:\n2- Decrescente:\n3- Aleat�rio:");
				int op = Integer.parseInt(entrada.readLine());
			
			if (op == 1) {
				 tempoInicial = System.currentTimeMillis();
				sortBolhaCresc(vetDados,vetDados.length);
				
			} else if(op == 2) {
				 tempoInicial = System.currentTimeMillis();
					sortBolhaDec(vetDados,vetDados.length);
			} else if(op == 3) {
			

				 tempoInicial = System.currentTimeMillis();
					sortBolhaRandom(vetDados,vetDados.length);
					
					
			} // end else
			
			System.out.println("Tempo de Execu��o em milissegundos: " + (System.currentTimeMillis() - tempoInicial) + "ms.");
			System.out.println("Tempo de Execu��o em segundos: " + ((System.currentTimeMillis() - tempoInicial)/ 1000) + "s.");
		} catch(Exception e) {
			
		} // end catch
	} // end Menu

// M�todo Principal
	
	public static void main(String[] args) {

		//String path = "dados_airbnb.txt"; // TODOS OS DADOS (128.000) dados
		//String path = "dados_airbnb - 64.000 Dados.txt"; // 64.000 Dados
		//String path = "dados_airbnb - 32.000 Dados.txt"; // 32.000 Dados
		//String path = "dados_airbnb - 16.000 Dados.txt"; // 16.000 Dados
		//String path = "dados_airbnb - 8.000 Dados.txt"; // 8.000 Dados
	    //String path = "dados_airbnb - 4.000 Dados.txt"; // 4.000 Dados
		String path = "dados- 2.000 Dados.txt"; // 2.000 Dados
		//String path = "teste.txt"; // 6 Dados
		
		try {
			// conta linhas
			LineCount(path);
			Airbnb[] vetDados = new Airbnb[ContaLinha]; // N�mero de Linhas
			LerArquivo(vetDados,path);
			Menu(vetDados);
			
			for (int i = 0; i < vetDados.length;  i++) {
				/*System.out.println("RoomID: "+vetDados[i].getRoomID()+"\nHostId: " + vetDados[ i].getHostID()+"\nRoom Type: " 
					+ vetDados[i].getRoomtype() + "\nPa�s: "+ vetDados[i].getCountry()+"\nCidade: "+ vetDados[i].getCity() 
					+ "\nBairro: " + vetDados[i].getBairro()+"\nReviews: "+vetDados[i].getReview() + "\nSatisfa��es Gerais: " 
					+ vetDados[i].getOverallSatisfaction() + "\nAcomoda��es: " + vetDados[i].getAccommodates()+"\nQuartos: " 
					+ vetDados[i].getBedrooms() + "\nPre�o: "+vetDados[i].getPrice()+"\nPropriedade: " + vetDados[i].getPropertyType() + "\n");
					*/
				// Teste R�pido
				System.out.println("RoomID: " + vetDados[i].getRoomID() + "\n");
			} // end for
		} catch(Exception e ) {
			System.out.println("erro: " + e);
		} // end catch	
		
		
	} // end main	

// M�todo Bolha que ordena em ordem Crescente

	public static void sortBolhaCresc(Airbnb[] nome, int tam) {
		Airbnb temp;
		
		for (int j = 1; j < tam - 1; j++) {
			for(int i = j+1; i < tam;i ++) {
				if (Integer.parseInt(nome[j].getRoomID()) >= Integer.parseInt(nome[i].getRoomID())+1) {
					temp = nome[j];
					nome[j] = nome[i];
					nome[i] = temp;
				} // end if	
			} // end for
		} // end for
	} // end sortBolhaCresc
	
// M�todo Bolha que ordena em ordem Decrescente
	
	public static void sortBolhaDec(Airbnb[] nome, int tam) {	
		Airbnb temp;
		
		for (int j = 1; j < tam - 1; j++) {
			for(int i = j+1; i < tam;i ++) {
				if (Integer.parseInt(nome[j].getRoomID()) <= Integer.parseInt(nome[i].getRoomID())+1) {
					temp = nome[j];
					nome[j] = nome[i];
					nome[i] = temp;
				} // end if	
			} // end for
		} // end for
	} // end sortBolhaDec
	
// M�todo Bolha que ordena em ordem Aleat�ria	

	public static void sortBolhaRandom (Airbnb[] nome, int tam) {	
		Airbnb temp;
		
		for (int j = 1; j < tam-1; j++) {
			Random randomJ =new Random();
			for(int i = j+1; i < tam; i++) {
				Random randomI =new Random();
				int randI = randomI.nextInt(tam);
				int randJ = randomJ.nextInt(tam);
				if(Integer.parseInt(nome[randJ].getRoomID()) <= Integer.parseInt(nome[randI].getRoomID())+1) {
					temp = nome[randJ];
					nome[randJ] = nome[randI];
					nome[randI] = temp;
				} // end if	
			} // end for
		} // end for
	} // end sortBolhaRandom
} // end class MainBolha
