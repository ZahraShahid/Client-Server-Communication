import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;

public class Task2bserver{
public static void main(String args[]) throws Exception{

ServerSocket s=new ServerSocket(1000);

System.out.println("Waiting for Client connection");

Socket c=s.accept();
System.out.println("Connection established");
System.out.println("-----------------------------------------------------------");

int arrFromClient[]=new int[100];
PrintStream ps1 = new PrintStream(c.getOutputStream());	
DataInputStream inFromClient = new DataInputStream(c.getInputStream());
String dec="";

while (true) { 

      for(int i=0;i<100;i++) {
        arrFromClient[i] = inFromClient.readInt();
    }
            
      for(int i=0;i<100;i++) {
                 int x = arrFromClient[i];
                       if (x >= 97 && x<= 122) {  
                              x = x - 3;
                       }  
                      else if (x >= 65 && x<= 90) {  
                              x = x - 2;
                       }  
                      else if (x >= 48 && x<= 57) {  
                              x = x - 1;  
                       }  
                      else {  
                               x = x - 0;
                       } 
                       dec = dec + (char)x;  
       }

System.out.println("Decrypted data: "); 
System.out.println(dec); 
ps1.println(dec);


ps1.close();
c.close();
     }
}
}

