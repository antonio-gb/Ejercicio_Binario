package Estructura_2_Parcial;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ABin{
 public static void main (String[] args){

int opcion = 0;
Scanner scan = new Scanner(System.in);
Node a = new Node(1); 
Node b = new Node(2);
Node c = new Node(3);
Node d = new Node(4);
Node e = new Node(5);
Node f = new Node(6);
Node g = new Node(7);
Node x = null;

a.left =b;
a.right=c;
b.left=d;
b.right=e;
c.right=g;
c.left=f;

do{
System.out.println("Da el valor que quieres buscar, para salir teclee 10");
opcion=scan.nextInt();
boolean busqueda = Buscar_Valor(a, opcion);
System.out.println(busqueda);
}while(opcion != 10);



}



public static boolean Buscar_Valor(Node node, int opcion){
boolean bus=false;
    if(node == null){
return bus;
    }
        if(node.value == opcion){
            return true;
        }else{
            bus = Buscar_Valor(node.left, opcion) || Buscar_Valor(node.right, opcion);
        }

        return bus;
        
        
    }


}
