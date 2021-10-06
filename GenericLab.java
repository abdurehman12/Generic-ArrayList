package HomeAssignment;

import java.util.ArrayList;

public class GenericLab<T extends Comparable<T>> {

    T[] arr;
    int currIndex;

    GenericLab() {// default constructor to create an array {
        arr = (T[]) new Comparable[10];
        currIndex = -1;
    }

    GenericLab(int size) // constructor to create an array
    {
        arr = (T[]) new Comparable[size];
        currIndex = -1;
    }
    public  boolean isEmpty(){
        if (currIndex==-1){
            return true;
        }
        else return false;
    }


    public String toString() {
        String str = "";
        for (int i = 0; i < arr.length; i++)
            str = str + arr[i];
        return str;
    }

    public void PrintList(){
        for(int i = 0; i < currIndex+1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public void InsertInOrder(T v) {
        if (currIndex == arr.length - 1) {
            T[] newArray = (T[]) new Comparable[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
            newArray = null;
        }
        if (currIndex == -1) {
            arr[++currIndex] = v;
        } else {
            boolean isLess = false;
            int index = -1;
            for (int i = 0; i <= currIndex; i++) {
                if (v.compareTo(arr[i])<0)
                {
                    isLess = true;
                    index = i;
                    break;
                }
            }
            if (isLess) {
                for (int j = currIndex + 1; j > index; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[index] = v;
                ++currIndex;
            } else {
                arr[++currIndex] = v;
            }
        }
    }

    public void addAtFront( T value) {

        if (currIndex < arr.length) {

            for (int i = currIndex; i >= 0; i--) {
                arr[i+1] = arr[i];
            }
            currIndex+=1;
            arr[0]=value;
        }
    }

    public void addAtEnd(T value){
        if(currIndex==arr.length-1){
            T[] newArray = (T[]) new Comparable[arr.length * 2];
            for(int i=0;i<arr.length;i++){
                newArray[i]=arr[i];
            }
        }
        currIndex+=1;
        arr[currIndex]=value;
    }


    public int Length() {
        return currIndex + 1;
    }


    public int Find(T value) {
        for (int i = 0; i <= currIndex; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void  Reverse(){
        T[] newArray = (T[]) new Comparable[arr.length];
        int address=0;
        for(int i=currIndex;i>=0;i--){
            newArray[address]=arr[i];
            address++;
        }
        arr=newArray;
    }
    public void RemoveFirst(T value) {
        int index = Find(value);
        if (index != -1) {
            if (index == currIndex) {
                arr[index] = null;
            } else {
                for (int i = index; i <= currIndex; i++) {
                    arr[i] = arr[i + 1];
                }
            }
            currIndex--;
        }
    }
    public void RemoveAll (T value) {
        if (currIndex==-1){
            return;
        }else {
            ArrayList<Integer> addresses= new ArrayList<>();
            for(int i=0;i<=currIndex; i++){
                if(arr[i]==value) {
                    addresses.add(i);
                }
            }
            int value_address=addresses.get(0);
            for(int j=0 ; j < addresses.size();j++){
                for(int x=value_address;x<= currIndex;x++){
                    arr[x] = arr[x + 1];
                }
                currIndex--;
            }
        }
    }


    public static void main(String [] args){

        GenericLab myarr = new GenericLab(5);
        GenericLab stdarray= new GenericLab(10);
        Student std1= new Student(21772,"abbasi",21);
        Student std2= new Student(21773,"Abdul Rehman",19);
        Student std3 = new Student(21774,"Arham",17);
        Student std4 = new Student(21775,"Bilal", 26);
        stdarray.InsertInOrder(std1);
        stdarray.InsertInOrder(std2);
        stdarray.InsertInOrder(std3);
        stdarray.InsertInOrder(std4);
        stdarray.PrintList();
        myarr.InsertInOrder(12);
        myarr.InsertInOrder(15);
        myarr.InsertInOrder(7);
        myarr.InsertInOrder(9);
        int MyLength=myarr.Length();
        myarr.PrintList();
        myarr.RemoveFirst(12);
        myarr.PrintList();
        myarr.addAtFront(8);
        myarr.PrintList();
        myarr.addAtEnd(56);
        myarr.PrintList();
        myarr.Reverse();
        myarr.PrintList();
        myarr.Reverse();
        myarr.InsertInOrder(14);
        myarr.InsertInOrder(14);
        myarr.InsertInOrder(14);
        myarr.PrintList();
        myarr.RemoveAll(14);
        myarr.PrintList();

    }
}
