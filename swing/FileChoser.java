import java.io.*;  
importjavax.swing.*;  
importjava.awt.event.*;  
importjavax.swing.filechooser.*;  
classHelloWorld  
{  
public static void main(String[] args) {  
        // creating object to the JFileChooser class  
        JFileChooserjf = new JFileChooser(); // default constructor JFileChooser is called.  
        jf.showSaveDialog(null);  
    }  
}  
