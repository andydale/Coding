package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessUIDDates{

public static void main(String args[]) throws FileNotFoundException{		
        Scanner sc=new Scanner(new File(args[0]));
        while(sc.hasNext()){
              String str= sc.nextLine();
               try{
              	String uid=str.split("\t")[0];
              	String yyyy=str.split("/")[2].split(" ")[0];
              	String MM=getTwoDigit(str.split("/")[0].split("\t")[1]);                
                String dd=getTwoDigit(str.split("/")[1]);
                String tt=getTwoDigit(str.split("/")[2].split(" ")[1].split(":")[0]);
                
                String date= yyyy+"_"+MM+"_"+dd+"_"+tt;
                
                String command="data_file_"+date+".txt | grep "+uid;                
                System.out.println(command);                
               }catch(Exception e){
            	  e.printStackTrace(); 
               }
        	}
          sc.close();
        }

public static String getTwoDigit(String input){
        int a=Integer.parseInt(input);
        String output= (a < 10 ? "0"+a : ""+a);
        return output;
        }
}