import javax.swing.*;
import java.awt.event.*;

public class ButtonExample{
	public static void main(String []args){
		JFrame f=new JFrame("Button Example");
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		t1.setBounds(50,50,100,40);
		t2.setBounds(50,100,100,40);
		JButton b=new JButton("=");
		b.setBounds(50,150,50,40);
		b.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
	t1.setText("Hello");
	t2.setText("World");		
		}
	});
	f.add(t1);
	f.add(t2);
	f.add(b);
	f.setSize(400,400);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
