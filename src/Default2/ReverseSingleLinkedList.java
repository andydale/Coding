package Default2;
//Time taken 25 minutes

//In single linked lists we can use traversed length to determine several factors.Ex. finding the head of circular linked list. 

public class ReverseSingleLinkedList{

    public static void main(String args[]){
        Node start = null;
//        start=getFirstNode(); //Assuming this function is provided.       
        try{
            start=reverseList(start);
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static Node reverseList(Node start) throws Exception{
        if(start == null ) 
          throw new Exception("Null Input");        
        Node p1=start;
        Node p2=p1.next;
        p1.next=null;
        while(p2!=null){
            Node temp=p2.next;
            p2.next=p1;
            p1=p2;
            p2=temp;
       }
       return p1;       
    }
    
    public static class Node{
        Node next;
        int data;
    }
}