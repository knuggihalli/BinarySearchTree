/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author kavunnuggihalli
 * @param <E>
 */

public class Node<E>{
    public Node<E> left;
    public Node<E> right;
    private E item;
    
    public Node(E e){
        item = e;
    }
    
    public E getItem(){
        return item;
    }
    
    public void setItem(E item){
        this.item = item;
    }
    
}
