import javax.swing.*;  
class MenuExample  
{  
          JMenu menu, submenu;  
          JMenuItem i1, i2, i3, i4, i5;  
          MenuExample(){  
          JFrame f= new JFrame("Menu and MenuItem Example");  
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("Menu");  
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("Item 1");  
          i2=new JMenuItem("Item 2");  
          i3=new JMenuItem("Item 3");  
          i4=new JMenuItem("Item 4");  
          i5=new JMenuItem("Item 5");  
          menu.add(i1); menu.add(i2); menu.add(i3);  
          submenu.add(i4); submenu.add(i5);  
          menu.add(submenu);  
          mb.add(menu);  
          f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
}  
public static void main(String args[])  
{  
new MenuExample();  
}}  
/*
import javax.swing.*;    
import java.awt.event.*;    
public class MenuExample implements ActionListener{    
JFrame f;    
JMenuBar mb;    
JMenu file,edit,help;    
JMenuItem cut,copy,paste,selectAll;    
JTextArea ta;    
MenuExample(){    
f=new JFrame();    
cut=new JMenuItem("cut");    
copy=new JMenuItem("copy");    
paste=new JMenuItem("paste");    
selectAll=new JMenuItem("selectAll");    
cut.addActionListener(this);    
copy.addActionListener(this);    
paste.addActionListener(this);    
selectAll.addActionListener(this);    
mb=new JMenuBar();    
file=new JMenu("File");    
edit=new JMenu("Edit");    
help=new JMenu("Help");     
edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);    
mb.add(file);mb.add(edit);mb.add(help);    
ta=new JTextArea();    
ta.setBounds(5,5,360,320);    
f.add(mb);f.add(ta);    
f.setJMenuBar(mb);  
f.setLayout(null);    
f.setSize(400,400);    
f.setVisible(true);    
}     
public void actionPerformed(ActionEvent e) {    
if(e.getSource()==cut)    
ta.cut();    
if(e.getSource()==paste)    
ta.paste();    
if(e.getSource()==copy)    
ta.copy();    
if(e.getSource()==selectAll)    
ta.selectAll();    
}     
public static void main(String[] args) {    
    new MenuExample();    
}    
}    */
