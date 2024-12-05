package ordenacaoHeapsort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class MainHeapsort {
	static int ContaLinha = 1;
	
// M�todo LineCount
	
	public static void LineCount(String arquivo) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(arquivo));
			// Pega a contidade de linhas
			ContaLinha = lines.size() - 1;
			System.out.println("N�mero de linhas do arquivo: " + (ContaLinha));
		} catch (Exception e) {
				
		} // end catch
	} // end LineCount
	
// M�todo l� do arquivo
	
	public static void LerArquivo(Airbnb[] vetDados, String path) {
		String[] test;
		String roomID, hostID, roomtype, country, city, Bairro, review,
		 	 overallSatisfaction, accommodates, bedrooms, price, propertyType;
		
		try {
			FileInputStream fstream = new FileInputStream(path);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine = "";
			br.readLine();
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
		
	public static void Menu(Airbnb[] vetDados) {
		long tempoInicial=0;

		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Digite a op��o que deseja ordenar:\n1- Crescente:\n2- Decrescente:\n3- Aleat�rio:");
			int op = Integer.parseInt(entrada.readLine());
			
			if(op == 1) {
			tempoInicial = System.currentTimeMillis();
				heapCres(vetDados);
				
			} else if(op == 2) {
				tempoInicial = System.currentTimeMillis();
						heapSortDec(vetDados,vetDados.length);
				} else if(op==3) {
					tempoInicial = System.currentTimeMillis();
						heapSortAle(vetDados,vetDados.length);
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
		//String path = "dados_airbnb - 16.000 Dados.txt"; // 16.000 Dados
		//String path = "dados_airbnb - 8.000 Dados.txt"; // 8.000 Dados
		//String path = "dados_airbnb - 4.000 Dados.txt"; // 4.000 Dados
		//String path = "dados_airbnb - 2.000 Dados.txt"; // 2.000 Dados
		//String path = "teste.txt"; // 6 Dados
		
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
				System.out.println("RoomID: " + vetDados[i].getRoomID() + "\n");
			} // end for
		} catch(Exception e ) {
			System.out.println("erro: " + e);
		} // end catch	
		
	
	} // end main
	
// M�todo heapCres que ordena em ordem Crescente
	
	public static void heapCres (Airbnb arr[]) { 
		int n = arr.length; 
	  
	    // Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 
	  
		// One by one extract an element from heap 
	    for (int i = n - 1; i > 0; i--) { 
	    	// Move current root to end 
	        Airbnb temp = arr[0]; 
	        arr[0] = arr[i]; 
	        arr[i] = temp; 
	  
	        // call max heapify on the reduced heap 
	        heapify(arr, i, 0); 
	    } // end for 
	} // end heapCres
	  
// M�todo heapify: � chamado pelo m�todo heapCres que ordena em ordem Crescente
	
	public static void heapify (Airbnb arr[], int n, int i) { 
		int largest = i; // Initialize largest as root 
	    int l = 2*i + 1; // left = 2*i + 1 
	    int r = 2*i + 2; // right = 2*i + 2 
	  
	    // If left child is larger than root 
	    if (l < n && Integer.parseInt(arr[l].getRoomID()) > Integer.parseInt(arr[largest].getRoomID())) 
	    	largest = l; 
	  
	    // If right child is larger than largest so far 
	    if (r < n && Integer.parseInt(arr[r].getRoomID()) > Integer.parseInt(arr[largest].getRoomID())) 
	    	largest = r; 
	  
	    // If largest is not root 
	    if (largest != i) { 
	    	Airbnb swap = arr[i]; 
	        arr[i] = arr[largest]; 
	        arr[largest] = swap; 
	  
	         // Recursively heapify the affected sub-tree 
	         heapify(arr, n, largest); 
	    } // end if 
	} // end heapify
	
// M�todo heapSortDec que ordena em ordem Decrescente
	 
    public static void heapSortDec (Airbnb arr[], int n) { 
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapifyDec(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) { 
              
            // Move current root to end 
            Airbnb temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapifyDec(arr, i, 0); 
        } // end for
    } // end heapSortDec
		
// M�todo heapifyDec: � chamado pelo m�todo heapSortDec que ordena em ordem Decrescente
	
    public static void heapifyDec (Airbnb arr[], int n, int i) { 
        int smallest = i; // Initialize smalles as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is smaller than root 
        if (l < n && Integer.parseInt(arr[l].getRoomID()) < Integer.parseInt(arr[smallest].getRoomID())) 
            smallest = l; 
  
        // If right child is smaller than smallest so far 
        if (r < n && Integer.parseInt(arr[r].getRoomID()) < Integer.parseInt(arr[smallest].getRoomID())) 
            smallest = r; 
  
        // If smallest is not root 
        if (smallest != i) { 
            Airbnb temp = arr[i]; 
            arr[i] = arr[smallest]; 
            arr[smallest] = temp; 
  
            // Recursively heapify the affected sub-tree 
            heapifyDec(arr, n, smallest); 
        } // end if
    } // end heapifyDec
    
// M�todo heapSortAle que ordena em ordem Aleat�ria
    
    public static void heapSortAle (Airbnb arr[], int n) { 
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapifyAle(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) { 
            
            // Move current root to end 
            Airbnb temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapifyAle(arr, i, 0); 
        } // end for
    } // end heapSortAle
    
// M�todo heapifyAle: � chamado pelo m�todo heapSortAle que ordena em ordem Aleat�ria
	
    public static void heapifyAle (Airbnb arr[], int n, int i) { 
    	Random lx = new Random();
    	int ld = lx.nextInt(n);
    	Random rx = new Random();
    	int rd = rx.nextInt(n);
        int smallest = i; // Initialize smalles as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is smaller than root 
        if (l < n && Integer.parseInt(arr[ld].getRoomID()) > Integer.parseInt(arr[rd].getRoomID())) 
            smallest = ld; 
  
        // If right child is smaller than smallest so far 
        if (r < n && Integer.parseInt(arr[rd].getRoomID()) > Integer.parseInt(arr[ld].getRoomID())) 
            smallest = rd; 
  
        // If smallest is not root 
        if (ld != i) { 
            Airbnb temp = arr[i]; 
            arr[i] = arr[ld]; 
            arr[ld] = temp; 
  
            // Recursively heapify the affected sub-tree 
            heapifyAle(arr, n, smallest); 
        } // end if
    } // end heapifyAle			
} // end class MainHeapsort