import java.io.*;
import java.text.DecimalFormat;  
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;

public class Task2bclient{
public static void main(String args[]) throws IOException,ClassNotFoundException{

Socket c=new Socket("localhost",1000);

BufferedReader reader;
DataOutputStream dos = new DataOutputStream(c.getOutputStream()); 
BufferedReader bis=new BufferedReader(new InputStreamReader(c.getInputStream()));

       try{
               reader = new BufferedReader(new FileReader("fileData.txt"));
	                        
                int ch = 0,i=0;
                int[] send = new int[100];	
               System.out.println("Encrypted Data: ");	
                while((ch=reader.read()) != -1){
                        System.out.println(ch);
                       if (Character.isUpperCase(ch)) {  
                              ch = ch + 2;
                       }  
                      else if (Character.isLowerCase(ch)) {  
                              ch = ch + 3;
                       }  
                      else if (Character.isDigit(ch)) {  
                              ch = ch + 1;  
                       }  
                      else {  
                               ch = ch + 0;
                       } 
                       send[i] = ch;
                       System.out.println(send[i]);
                       i++;
                   }
                       // send to the server 
                     for(int x=0;x<100;x++){
                        dos.writeInt(send[x]);
                     }
                        // receive from the server     
                          
                          System.out.println("Decrypted data sent by the server: ");                  
                          System.out.println(bis.readLine());
                          System.out.println(bis.readLine());
                          System.out.println(bis.readLine());
                          reader.close();

                }catch(IOException e){
                              System.out.println(e.getMessage());
                               e.printStackTrace();     
                }

bis.close();
c.close();

}
}