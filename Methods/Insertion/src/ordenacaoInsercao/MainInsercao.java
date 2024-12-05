package ordenacaoInsercao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MainInsercao {
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
				 
				// String idRoom = tmp[0];
				
				 
				 vetDados[x] = new Airbnb(roomID,hostID, roomtype, country,city,Bairro,review,overallSatisfaction,accommodates,bedrooms,price,propertyType);
				 x++;		
			} // end while
			
			//Close the input stream
			fstream.close();
			/*
			//mostra array a partir do 1, que s�o de fato os valores dos campos
			for (int o = 1; o < x; o++) {
				System.out.println("RoomID: "+vetDados[o].getRoomID()+"\nHostId: " + vetDados[o].getHostID()+"\nRoom Type: " 
								+ vetDados[o].getRoomtype() + "\nPa�s: "+vetDados[o].getCountry()+"\nCidade: "+ vetDados[o].getCity()
								+ "\nBairro: " + vetDados[o].getBairro()+"\nReviews: "+vetDados[o].getReview()+"\nSatisfa��es Gerais: " 
								+ vetDados[o].getOverallSatisfaction()+"\nAcomoda��es: "+ vetDados[o].getAccommodates()+"\nQuartos: "
								+vetDados[o].getBedrooms() + "\nPre�o: "+vetDados[o].getPrice()+"\nPropriedade: " 
								+ vetDados[o].getPropertyType() );
				
				// Teste r�pido
				System.out.println("RoomID: "+vetDados[o].getRoomID()	
			} // end for */		
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
				InserCresc(vetDados,vetDados.length-1);
			} else if(op == 2) {
				 tempoInicial = System.currentTimeMillis();
					InserDec(vetDados,vetDados.length-1);
			} else if(op == 3) {
				 tempoInicial = System.currentTimeMillis();
					InserRand(vetDados,vetDados.length-1);
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
		// String path = "dados_airbnb - 32.000 Dados.txt"; // 32.000 Dados
		//String path = "dados_airbnb - 16.000 Dados.txt"; // 16.000 Dados
		//String path = "dados_airbnb - 8.000 Dados.txt"; // 8.000 Dados
		//String path = "dados_airbnb - 4.000 Dados.txt"; // 4.000 Dados
		//String path = "dados_airbnb - 2.000 Dados.txt"; // 2.000 Dados
		//String path = "teste.txt"; // 6 Dados
		
		try {
			// Conta linhas
			LineCount(path);
			Airbnb[] vetDados = new Airbnb[ContaLinha];
			LerArquivo(vetDados,path);
			Menu(vetDados);
			
			for (int i = 0; i < vetDados.length; i++) {
			  /* System.out.println("RoomID: "+vetDados[o].getRoomID()+"\nHostId: " + vetDados[o].getHostID()
				 +"\nRoom Type: " +vetDados[o].getRoomtype() + "\nPa�s: "+vetDados[o].getCountry()+"\nCidade: "
				 + vetDados[o].getCity() + "\nBairro: " + vetDados[o].getBairro()+"\nReviews: "+vetDados[o].getReview()
				 +"\nSatisfa��es Gerais: " + vetDados[o].getOverallSatisfaction()+"\nAcomoda��es: "+ vetDados[o].getAccommodates()
				   +"\nQuartos: "+vetDados[o].getBedrooms() + "\nPre�o: "+vetDados[o].getPrice()+"\nPropriedade: " 
				   + vetDados[o].getPropertyType() + "\n");
				   */
				// Teste r�pido
				System.out.println("RoomID: " + vetDados[i].getRoomID() + "\n");
			} // end for
		} catch(Exception e ) {
			System.out.println("erro: "+e);
		} // end catch
		
		
	} // end main
	
// M�todo Inser��o que ordena em ordem Crescente
	
	public static void InserCresc(Airbnb[] nome, int tam) {
		Airbnb eleito;
		
		for (int i = 1; i < tam; i++) {
			eleito = nome[i];
			int j = i-1;
			//laco q percorre elementos a esquerda do numero eleito
			//ou ate encontrar a posicao para
			//realocao do numero eleito
			//rxing a ordenacao procurada
			
			while(j>=0 && Integer.parseInt(nome[j].roomID) >= Integer.parseInt(eleito.roomID)) {
				nome[j+1] = nome[j];
				j = j -1;
			} // end while
			nome[j+1] = eleito;
		} // end for	
	} // InserCresc
	
// M�todo Inser��o que ordena em ordem Decrescente
	
	public static void InserDec(Airbnb[] nome, int tam) {
		Airbnb eleito;
		
		for (int i = 1; i < tam; i++) {
			eleito = nome[i];
			int j = i-1;
			//laco q percorre elementos a esquerda do numero eleito
			//ou ate encontrar a posicao para
			//realocao do numero eleito
			//rxing a ordenacao procurada
			
			while (j>=0 && Integer.parseInt(nome[j].roomID) <= Integer.parseInt(eleito.roomID)) {
				nome[j+1] = nome[j];
				j = j -1;
			} // end while
			nome[j+1] = eleito;
		} // end for	
	} // end InserDec
	
// M�todo Inser��o que ordena em ordem Aleat�ria	
	
	public static void InserRand(Airbnb[] nome, int tam) {	
		Airbnb eleito;
		Random randomI = new Random();
		
		int randI = randomI.nextInt(tam); 
		
		for (int i = 1; i < tam; i++) {
			eleito = nome[randI];
			int j = randI-1;
			//laco q percorre elementos a esquerda do numero eleito
			//ou ate encontrar a posicao para
			//realocao do numero eleito
			//rxing a ordenacao procurada
			
			while (j>=0 && Integer.parseInt(nome[j].roomID) >= Integer.parseInt(eleito.roomID)) {
				nome[j+1] = nome[j];
				j = j -1;
			} // end while
			nome[j+1] = eleito;
		} // end for	
	} // end InserRand
} // end class MainInsercao
