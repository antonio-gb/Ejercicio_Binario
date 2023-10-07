

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ABin2 {
	static List <String> listaStringActual;
	static String stringActual = "";
	static String stringPrimo = "";
    static String stringLarge = "";
	static int numActual;
	static int numPrimo;


	
    public static void main (String[] args){

Node a = new Node(2); 
Node b = new Node(3);
Node c = new Node(8);
Node d = new Node(1);
Node e = new Node(3);
Node f = new Node(5);
Node g = new Node(1);

a.left =b;
a.right=c;
b.left=d;
b.right=e;
c.right=f;
c.left=g;


List<Integer> PrimoLargo = CaminoPrimo(a);
stringLarge = PrimoLargo.stream().map(String::valueOf).collect(Collectors.joining("")); 
    	int NumPrimoLargo = Integer.valueOf(stringLarge);
System.out.println("El numero primo más grande que se pudo encontrar es: "+ NumPrimoLargo);

}

  private static boolean Primo(int num){
    if(num <= 1){
        return false;
    }
    if(num <= 3){
        return true;
    }
    if(num % 2 == 0 || num % 3 == 0){
        return false;
    }
    for(int i = 5; i * i <= num; i += 6){
        if(num % i == 0 || num % (i + 2) == 0){
            return false;
        }
    }
    return true;
}

public static void EncontrarCamino(Node node, List<Integer> CaminoActual, List<Integer> CaminoMasLargo) {
    if (node == null) {
        return;
    }

    CaminoActual.add(node.value);

    if (node.left == null && node.right == null) {
        stringActual = CaminoActual.stream().map(String::valueOf).collect(Collectors.joining("")); 
    	numActual = Integer.valueOf(stringActual);
    	System.out.println("El numero actual es: " + numActual);
        if(CaminoMasLargo.isEmpty()) {
    		numPrimo = 0;
        	System.out.println("El primo mas grande actual es: " + numPrimo);

    	}
    	else {
        	//convertimos nuestra lista del camino con primo mas largo a un string y despues de vuelta a un int
        	stringPrimo = CaminoMasLargo.stream().map(String::valueOf).collect(Collectors.joining("")); 
        	numPrimo = Integer.valueOf(stringPrimo);
        	System.out.println("El primo mas grande actual es: " + numPrimo);

    	}


        if (Primo(numActual) && (numActual > numPrimo)) {
            CaminoMasLargo.clear();
            CaminoMasLargo.addAll(CaminoActual);
        }
    } else {
        EncontrarCamino(node.left, CaminoActual, CaminoMasLargo);
        EncontrarCamino(node.right, CaminoActual, CaminoMasLargo);
    }

    CaminoActual.remove(CaminoActual.size() - 1);
}

  public static List<Integer> CaminoPrimo (Node node){
    List<Integer> CaminoActual = new ArrayList<>();
    List<Integer> CaminoMasLargo = new ArrayList<>();

    EncontrarCamino(node, CaminoActual, CaminoMasLargo);
    return CaminoMasLargo;
}
}



