import javax.swing.*;    
class SeparatorExample    
{    
          JMenu menu, submenu;    
          JMenuItem i1, i2, i3, i4, i5;    
          SeparatorExample()  {    
          JFrame f= new JFrame("Separator Example");    
          JMenuBar mb=new JMenuBar();    
          menu=new JMenu("Menu");    
          i1=new JMenuItem("Item 1");    
          i2=new JMenuItem("Item 2");       
          menu.add(i1);  
          menu.addSeparator();  
          menu.add(i2);  
          mb.add(menu);    
          f.setJMenuBar(mb);    
          f.setSize(400,400);    
          f.setLayout(null);    
          f.setVisible(true);    
}    
public static void main(String args[])    
{    
new SeparatorExample();    
}}  

/*
import javax.swing.*;    
import java.awt.*;  
public class SeparatorExample    
{    
    public static void main(String args[]) {  
        JFrame f = new JFrame("Separator Example");      
        f.setLayout(new GridLayout(0, 1));  
        JLabel l1 = new JLabel("Above Separator");  
        f.add(l1);  
        JSeparator sep = new JSeparator();  
        f.add(sep);  
        JLabel l2 = new JLabel("Below Separator");  
        f.add(l2);  
        f.setSize(400, 100);  
        f.setVisible(true);  
      }  
    }  
   */
