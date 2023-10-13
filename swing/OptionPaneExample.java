import javax.swing.*;  
import java.awt.event.*;  
public class OptionPaneExample extends WindowAdapter{  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();   
    f.addWindowListener(this);  
    f.setSize(300, 300);  
    f.setLayout(null);  
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.setVisible(true);  
}  
public void windowClosing(WindowEvent e) {  
    int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
if(a==JOptionPane.YES_OPTION){  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
}  
public static void main(String[] args) {  
    new  OptionPaneExample();  
}     
} 

/*
import javax.swing.*;  
public class OptionPaneExample {  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);     
}  
public static void main(String[] args) {  
    new OptionPaneExample();  
}  
}  */

/*
import javax.swing.*;  
public class OptionPaneExample {  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();   
    String name=JOptionPane.showInputDialog(f,"Enter Name");      
}  
public static void main(String[] args) {  
    new OptionPaneExample();  
}  
}  */ 
