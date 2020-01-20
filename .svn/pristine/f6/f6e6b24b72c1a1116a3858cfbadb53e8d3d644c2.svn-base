package hardware.serialport;

public class StringToHex {  
    public static void printHexString( byte[] b) {  
   for (int i = 0; i < b.length; i++) {  
     String hex = Integer.toHexString(b[i] & 0xFF)+" ";  
     if (hex.length() == 2) {  
       hex = '0' + hex;  
     }  
     System.out.print(hex.toUpperCase() );  
   }  
 System.out.println("\t\n");  
}    
} 