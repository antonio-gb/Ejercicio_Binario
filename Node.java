package Estructura_2_Parcial;

public class Node {
    Node left;
    Node right;
    int value;
    
        public Node(int value){
            this.value = value;
            right = null; //Por default no hay nada en la izquierda y derehca
            left= null;
        }
}
