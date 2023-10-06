package Estructura_2_Parcial;

import java.util.ArrayList;
import java.util.List;


public class ABin2 {
    public static void main (String[] args){

Node a = new Node(7); 
Node b = new Node(3);
Node c = new Node(2);
Node d = new Node(1);
Node e = new Node(5);
Node f = new Node(9);
Node g = new Node(4);

/*
 * 
 *               7
 *              / \
 *             3   2
 *            / \  / \
 *           1  5  9  4
 * 
 * Ejemplo del árbol construido
 * 
 */


a.left =b;
a.right=c;
b.left=d;
b.right=e;
c.right=g;
c.left=f;

List<Integer> PrimoLargo = CaminoPrimo(a);
System.out.println("El numero primo más grande que se pudo encontrar es: "+ PrimoLargo);
}

/* 
Esta función verifica si el número seleccionado es primo, primero verifica si es menor o igual a uno pues 1 no es primo,
despues verifica si es mayor o igual a 3, por que 3 y 2 son primos. Posteriormente verifica si el numero es divisible entre 2 y 3, 
si si es divisible, regresa false pues no es un primo. Posteriormente entra en un bucle en el que va a revisar si el número es 
Por lo tanto solo necesitamos verificar una secuencia para ver si es primo o no.
*/

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

/*
 * Este método es DFS o Búsqueda de profundidad. Lo que está haciendo es buscar un camino que empieza desde la raiz del árbol hasta una hoja
 * Para empezar el método empieza verificando si el nodo es null, en el caso de que lo sea simplemente no regresa nada. Después 
 * Después añade el valor del nodo a la lista que guarda el camino actual y después verifica si el nodo es una hoja, es decir no tiene
 * hijos ni a la izquierda ni a la derecha. Si cumple con esto se concatenan los valores y se guardan en camino actual. Posteriormente
 * se verifica que el número encontrado es primo, si es primo y su longitud es mayor que la de CaminoMasLargo este se va a guardar en CaminoMasLargo
 * Después de hacer esto la función hace recursividad para recorrer todos los hijos del árbol, y en caso de que algún valor sea primo y sea mayor que CaminoMasLargo
 * se actualizara esta Lista.
 */
public static void EncontrarCamino(Node node, List<Integer> CaminoActual, List<Integer> CaminoMasLargo){
    int num = 0;
    if(node == null){
        return;
    }

    CaminoActual.add(node.value);


    if(node.left == null && node.right == null){
        //int num = 0;
        for(int val : CaminoActual){
            num = num + val;
        }
    }

    if(Primo(num) && CaminoActual.size() > CaminoMasLargo.size()){
        CaminoMasLargo.clear();
        CaminoMasLargo.addAll(CaminoActual);
    }else{
        EncontrarCamino(node.left, CaminoActual, CaminoMasLargo);
        EncontrarCamino(node.right, CaminoActual, CaminoMasLargo);
    }

    CaminoActual.remove(CaminoActual.size()-1);
}

// Este metodo simplemente ejecuta todos los otros metodos y regresa el valor final del camino más largo.

public static List<Integer> CaminoPrimo (Node node){
    List<Integer> CaminoActual = new ArrayList<>();
    List<Integer> CaminoMasLargo = new ArrayList<>();
    EncontrarCamino(node, CaminoActual, CaminoMasLargo);
    return CaminoMasLargo;
}

}





