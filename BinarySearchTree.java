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
public class BinarySearchTree<E extends Comparable<E>>{
    Node<E> root;//root
    
    //constructors
    public BinarySearchTree(){
        root =null;
    }
    
    public BinarySearchTree(E e){
        root = new Node<>(e);
    }
    
    //add recursivly 
    public boolean add(E e){
        if(root == null){
          root = new Node<>(e);
          return true;
        }
        return add(root, e);
    }
    private boolean add(Node<E> root, E e){
        int comparison = e.compareTo(root.getItem());
        if(comparison <= 0){//e is smaller than root
          if(root.left == null){
              root.left = new Node<>(e);
              return true;
          }else{
              return add(root.left, e);
          }  
        }else{//e is bigger than root
          if(root.right == null){
              root.right = new Node<>(e);
              return true;
          }else{
              return add(root.right, e);
          }    
        }
    }
    
    //recursive find methods
    public boolean find(E e){
        if(root == null){
            return false;
        }
        return find(root, e);
    }
    private boolean find(Node<E> root, E e){
        if(root == null){
            return false;
        }
        
        int comparison = e.compareTo(root.getItem());
        if(comparison == 0){
            return true;//could return element
        }else if(comparison < 0 ){
          return find(root.left, e);
        }else{
          return find(root.right, e);
        }
    }
    
    //Binary Tree Delete Method
    //Delete is the public method that gets called it returns nothing
    public void delete(E item){
        root = delete(root, item);
        //root gets set to whatever your trying to delete
    }
    
    //This private method gets called when you delete something
    private Node<E> delete(Node<E> root, E item){
        if(root == null){//This checks if Binary tree even exists
            return null;//If there are no nodes yet just keeps root at null
        }
        //comparison will be -1, 0 or 1
        int comparison = item.compareTo(root.getItem());
        
        //if its -1 or < 0 recurse left
        if(comparison < 0){
            //so move over to the left and delete at that node
            root.left = delete(root.left, item);
            //when the recursion finishes it will return whatever root was
            return root;
        }else if(comparison > 0){
            //or else move right recusivly and return the root
            root.right = delete(root.right, item);
            return root;
        }else{
            //This is if comparison is == 0 root.item here is what 
            //you are trying to delete
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                if(root.left.right == null ){
                    root.left.right = root.right;
                    return root.left;
                }
                
                Node<E> current  = root.left;
                Node<E> parent = root.left;
                while(current.right != null){
                  parent = current;
                  current = current.right;
                }
                
                root.setItem(current.getItem());
                parent.right = current.left;
                return root;
            }
        }  
    }
    
    
    
}
