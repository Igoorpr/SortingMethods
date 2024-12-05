package ordenacaoSelecao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MainSelecao {
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
			// Read File Line By Linint x
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
	
	public static void Menu(Airbnb[] vetDados) {
		long tempoInicial =0;
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Digite a op��o que deseja ordenar:\n1- Crescente:\n2- Decrescente:\n3- Aleat�rio:");
				int op = Integer.parseInt(entrada.readLine());
			
			if (op == 1) {
				  tempoInicial = System.currentTimeMillis();
				selectionCres(vetDados,vetDados.length);
			} else if(op == 2) {
				  tempoInicial = System.currentTimeMillis();
					selectionDec(vetDados,vetDados.length);
			} else if(op == 3) {
				  tempoInicial = System.currentTimeMillis();
					selectionAle(vetDados,vetDados.length);
			} // end else
			System.out.println("Tempo de Execu��o em milissegundos: " + (System.currentTimeMillis() - tempoInicial) + "ms.");
			System.out.println("Tempo de Execu��o em segundos: " + ((System.currentTimeMillis() - tempoInicial)/ 1000) + "s.");
		} catch(Exception e) {
			
		} // end catch
	} // end Menu
	
// M�todo Principal
	
	public static void main(String[] args) {

		String path = "dados_airbnb.txt"; // TODOS OS DADOS (128.000) dados
		// String path = "dados_airbnb - 64.000 Dados.txt"; // 64.000 Dados
		 //String path = "dados_airbnb - 32.000 Dados.txt"; // 32.000 Dados
		 //String path = "dados_airbnb - 16.000 Dados.txt"; // 16.000 Dados
		// String path = "dados_airbnb - 8.000 Dados.txt"; // 8.000 Dados
		//String path = "dados_airbnb - 4.000 Dados.txt"; // 4.000 Dados
		//String path = "dados_airbnb - 2.000 Dados.txt"; // 2.000 Dados
	//	String path = "teste.txt"; // 6 Dados
				
		try {
			// conta linhas
			LineCount(path);
			Airbnb[] vetDados = new Airbnb[ContaLinha]; // N�mero de Linhas
			LerArquivo(vetDados,path);
			Menu(vetDados);
			
			for (int i = 1; i < vetDados.length;  i++) {
			/*	System.out.println("RoomID: "+vetDados[i].getRoomID()+"\nHostId: " + vetDados[ i].getHostID()+"\nRoom Type: " 
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
	
// M�todo Sele��o que ordena em ordem Crescente

	public static void selectionCres (Airbnb[] nome, int tam) {
		int i, j,pos;
		Airbnb eleito,menor;

		//ordenando de forma crescente
		//la�o que percorre da 1 posicao a penultima posicao 
		//elegendo um numero para ser comparado
		int dx = (nome.length - 2);
		
		for (i = 1; i <= dx; i++) {
			eleito = nome[i];
			// encontrando o menor numero a direita do eleito
			//com sua respectiva posicao 
			//posicao do eleito = i, primeiro numero a direita do eleito na posi i+1
			menor = nome[i+1];
			pos = i+1;
			//laco q percorre os elementos q estao a direita do num eleito, retornando o menor numero a direita de usa posi
			
			for(j = i+2; j < tam; j++) {
				if(Integer.parseInt(nome[j].getRoomID()) < Integer.parseInt(menor.getRoomID())) {
					menor = nome[j];
					pos = j;
				} // end if
			} // end for
			//troca do numero eleito com o numero da pos post
			//o numero da posicao e o menor numero a direita
			//do num eletio
			if(Integer.parseInt(menor.getRoomID()) < Integer.parseInt(eleito.getRoomID())) {
				nome[i] = nome[pos];
				nome[pos] = eleito;
			} // end if
		} // end for	
	} // end selectionCres 
		
// M�todo Sele��o que ordena em ordem Decrescente
	
	public static void selectionDec (Airbnb[] nome, int tam) {
		int i, j,pos;
		Airbnb eleito,menor;

		//ordenando de forma crescente
		//la�o que percorre da 1 posicao a penultima posicao 
		//elegendo um numero para ser comparado
		int dx = (nome.length - 2);
		
		for(i = 1; i <= dx; i++) {
			eleito = nome[i];
			// encontrando o menor numero a direita do eleito
			//com sua respectiva posicao 
			//posicao do eleito = i, primeiro numero a direita do eleito na posi i+1
			menor = nome[i+1];
			pos = i+1;
			//laco q percorre os elementos q estao a direita do num eleito, retornando o menor numero a direita de usa posi
			
			for(j=i+2;j<tam;j++) {
				if(Integer.parseInt(nome[j].getRoomID()) > Integer.parseInt(menor.getRoomID())) {
					menor = nome[j];
					pos = j;
				} // end if 
			} // end for
			//troca do numero eleito com o numero da pos post
			//o numero da posicao e o menor numero a direita
			//do num eletio
			if(Integer.parseInt(menor.getRoomID()) > Integer.parseInt(eleito.getRoomID())) {
				nome[i] = nome[pos];
				nome[pos] = eleito;
			} // end if
		} // end for	
	} // end selectionDec
	
// M�todo Sele��o que ordena em ordem Aleat�ria
	
	public static void selectionAle(Airbnb[] nome, int tam) {
		int i, j,pos;
		Airbnb eleito,menor;

		//ordenando de forma crescente
		//la�o que percorre da 1 posicao a penultima posicao 
		//elegendo um numero para ser comparado
		int dx = (nome.length - 2);
		
		for (i = 1; i <= dx; i++) {
			Random randomI =new Random();
			int randI = randomI.nextInt(tam);
			//int randJ = randomJ.nextInt(tam);
			eleito = nome[randI];
			// encontrando o menor numero a direita do eleito
			//com sua respectiva posicao 
			//posicao do eleito = i, primeiro numero a direita do eleito na posi i+1
			menor = nome[randI+1];
			pos = i+1;
			
			//laco q percorre os elementos q estao a direita do num eleito, retornando o menor numero a direita de usa posi
			//Random randomJ = new Random();
			for(j = i+2; j < tam; j++) {	
				if(Integer.parseInt(nome[randI].getRoomID()) > Integer.parseInt(menor.getRoomID())) {
					menor = nome[j];
					pos = j;
				} // end if
			} // end for
			
			//troca do numero eleito com o numero da pos post
			//o numero da posicao e o menor numero a direita
			//do num eletio
			if(Integer.parseInt(menor.getRoomID()) > Integer.parseInt(eleito.getRoomID())) {
				nome[i] = nome[pos];
				nome[pos] = eleito;
			} // end if
		} // end for	
	} // end selectionAle
} // end class MainSelecao