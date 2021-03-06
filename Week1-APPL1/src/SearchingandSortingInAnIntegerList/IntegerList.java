/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
// **************************************************************** 
// IntegerList.java 
// 
// Define an IntegerList class with methods to create, fill, 
// sort, and search in a list of integers. 
// 
// **************************************************************** 
import java.util.Scanner;
public class IntegerList{
    int[] list; //values in the list 
    //------------------------------------------------------- 
    //create a list of the given size 
    //------------------------------------------------------- 
    public IntegerList(int size){
        list = new int[size]; 
    } 
    //------------------------------------------------------- 
    //fill array with integers between 1 and 100, inclusive 
    //------------------------------------------------------- 
    public void randomize(){
        for (int i=0; i<list.length; i++) 
            list[i] = (int)(Math.random() * 100) + 1; 
    } 
    //------------------------------------------------------- 
    //print array elements with indices 
    //------------------------------------------------------- 
    public void print(){
        for (int i=0; i<list.length; i++) 
            System.out.println(i + ":\t" + list[i]); 
    } 
    //------------------------------------------------------- 
    //return the index of the first occurrence of target in the list. 
    //return -1 if target does not appear in the list 
    //------------------------------------------------------- 
    public int search(int target){
        int location = -1; 
        for (int i=0; i<list.length && location == -1; i++) 
            if (list[i] == target) 
                location = i; 
        return location; 
    }
    
    // Binary search "assuming the list is sorted in decreasing order"
    public int binarySearchD(int target){
        int left = 0, right = this.list.length - 1;
        
        while(left <= right){
            int middle = left + (right - left) / 2; //mengarahkan index menjadi index di tengah
            
            // Melakukan cek apakah nilai di index tengah adalah nilai yang dicari atau bukan
            // Jika iya, maka return index nilai tersebut
            if(this.list[middle] == target){
                return middle;
            }
            // Melakukan cek apakah nilai di index tengah lebih besar dari nilai yang dicari atau bukan
            // Jika iya, maka index kiri di-assign index tengah + 1
            else if(this.list[middle] > target){
                left = middle + 1;
            }
            // Melakukan cek apakah nilai di index tengah lebih kecil dari nilai yang dicari atau bukan
            // Jika iya, maka index kanan di-assign index tengah - 1
            else if(this.list[middle] < target){
                right = middle - 1;
            }
        }
        // Jika tidak ditemukan, maka akan mengembalikan nilai -1
        return -1;
    }
    //------------------------------------------------------- 
    //sort the list into ascending order using the selection sort algorithm 
    //------------------------------------------------------- 
    public void selectionSort(){
        int minIndex; 
        for (int i=0; i < list.length-1; i++){
            //find smallest element in list starting at location i 
            minIndex = i; 
            for (int j = i+1; j < list.length; j++) 
                if (list[j] < list[minIndex]) 
                minIndex = j; 
                //swap list[i] with smallest element 
                int temp = list[i];
                list[i] = list[minIndex]; 
                list[minIndex] = temp; 
        } 
    }
    
    // Decreasing sorting using selection sort
    public void sortDecreasing(){
        int maxIndex; 
        for (int i = 0; i < list.length-1; i++){
            //find largest element in list starting at location i 
            maxIndex = i; 
            for (int j = i+1; j < list.length; j++) 
                if (list[j] > list[maxIndex]) 
                maxIndex = j; 
                //swap list[i] with largest element 
                int temp = list[i];
                list[i] = list[maxIndex]; 
                list[maxIndex] = temp; 
        } 
    }
    
    public void replaceFirst(int oldVal, int newVal){
        int loc = search(oldVal);
        if (loc != -1){
            this.list[loc] = newVal;
        }else{
            System.out.print("Not Found!");
        }
    }
    
    public void replaceAll(int oldVal, int newVal){
        int idx;
        for(idx = 0; idx < this.list.length; idx++){
            if(this.list[idx] == oldVal){
                this.list[idx] = newVal;
            }
        }
    }

}
