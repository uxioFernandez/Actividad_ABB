package bst;

import java.util.ArrayList;
public class BinarySearchTree {

    //Se declaran los arraylist para ser devueltos en los recorridos
    ArrayList<Integer> inOrder = new ArrayList<Integer>();
    ArrayList<Integer> preOrder = new ArrayList<Integer>();
    ArrayList<Integer> postOrder = new ArrayList<Integer>();
    private Node root;

    //Constructor de arbol vacio

    public BinarySearchTree (){
        root = null;
    }

    //Se implementa método insertado de nodos
    public void insert (Integer i){

        root =recursiveInsert (root, i);
    }

    private Node recursiveInsert (Node node, int i){
        if (node == null){
            node = new Node(i);
        }
        else if (i < node.value){
            node.left = recursiveInsert (node.left,i);
        }
        else if (i > node.value){
            node.right = recursiveInsert(node.right,i);
        }
        return node;
    }

    //se implementa metodo eliminación de nodos
    public void delete (Integer i){

        root = recursiveDelete(root,i);
    }

    private Node recursiveDelete (Node node, int i){
        if(node == null){
           /* sería el caso en el que el arbol está vacío
           podría implementar un exception para dar un error
           pero no se solicita
           */
        }
        /*Primero se comprueba si el elemento a borrar es
        mayor o menor que el nodo evaluado. En caso de serlo,
        se inicia recursividad por la rama derecha o izquierda*/

        if (i > node.value){
            node.right = recursiveDelete(node.right,i);
        } else if (i < node.value){
            node.left= recursiveDelete(node.left,i);
        }
        //a continuación se encuentra la posicion necesaria
        else{

            //caso en el que el nodo no tiene hijos
            if (node.left == null && node.right == null){
                node = null;
            }
            /*caso en el que el nodo tiene al menos hijo derecho
            se inicia recursividad para encontrar al menor de los subnodos
            de la rama derecha*/

            else if (node.right != null){
                node.value=sucesor(node);
                node.right = recursiveDelete(node.right,node.value);
            }
            /* en caso de no tener hijos derechos, se comprueba en rama izquierda
            se escogerá al mayor de los subnodos de la rama izquierda
             */
            else{
                node.value = predecesor(node);
                node.left = recursiveDelete(node.left,node.value);
            }
        }

    return node;
    }

    //Funcion de busqueda del menor de los subnodos derechos
    private int sucesor(Node node){
        node = node.right;
        while (node.left != null){
            node = node.left;
        }
        return node.value;
    }

    //Función de búsqueda del mayor de los subnodos izquierdos
    private int predecesor(Node node){
        node = node.left;
        while (node.right != null){
            node = node.right;
        }
        return node.value;
    }


    //Implementacion recorrido preorder
    public ArrayList<Integer> preorder (){


        preorder_aux(root);

        return preOrder;
    }

    private void preorder_aux (Node node){

        if (node == null){
            return; //se detiene la recursividad
        }
        else{

            preOrder.add(node.value);
            preorder_aux(node.left);
            preorder_aux(node.right);
        }
    }

    //Implementacion recorrido inorder
    public ArrayList<Integer> inorder (){

        inorder_aux(root);
        return inOrder;
    }

    private void inorder_aux (Node node){
        if (node == null){
            return; //se detiene la recursividad
        }
        else{

            inorder_aux(node.left);
            inOrder.add(node.value);
            inorder_aux(node.right);
        }
    }

    //Implementacion recorrido postorder
    public ArrayList<Integer> postorder (){

        postorder_aux(root);
        return postOrder;
    }

    private void postorder_aux (Node node){
        if (node == null){
            return; //se detiene la recursividad
        }
        else{

            postorder_aux(node.left);
            postorder_aux(node.right);
            postOrder.add(node.value);
        }
    }

}
