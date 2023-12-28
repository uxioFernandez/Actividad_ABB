package bst;


import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner datosEntrada = new Scanner (System.in);
        int opcion = 0;
        int elemento = 0;
        int elemento_del = 0;
        BinarySearchTree arbol = new BinarySearchTree();

        do {

            System.out.println("Seleccione una opcion:" +
                    "\n 1) Introducir un elemento " +
                    "\n 2) Borrar un elemento " +
                    "\n 3) Mostrar Preorder" +
                    "\n 4) Mostrar Inorder" +
                    "\n 5) Mostrar Postorder" +
                    "\n 6) Salir");

            opcion = datosEntrada.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Introduce el elemento a insertar: ");
                    elemento = datosEntrada.nextInt();
                    arbol.insert(elemento);
                    break;
                case 2:
                    System.out.println("Introduce el elemento a eliminar: ");
                    elemento_del = datosEntrada.nextInt();
                    arbol.delete(elemento_del);
                    break;
                case 3:
                    System.out.println("El recorrido Preorder es: "+arbol.preorder().toString());
                    arbol.preorder().clear();
                    break;
                case 4:
                    System.out.println("El recorrido Inorder es: "+arbol.inorder().toString());
                    arbol.inorder().clear();
                    break;
                case 5:
                    System.out.println("El recorrido Postorder es: "+arbol.postorder().toString());
                    arbol.postorder().clear();
                    break;
            }

        } while (opcion != 6);
    }
}
