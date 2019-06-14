
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;


public class FenetrePseudo extends JFrame implements ActionListener,KeyListener,Serializable{
	

	private static final long serialVersionUID = -7263740953733255686L;
	private String pseudo;
	private JTextField saisie;
	private Container cp;
	private Integer tailleLimite = 10;
	private Interface interf;
	
	
public FenetrePseudo(Interface theinterface)
{
	this.interf = theinterface;
	
	this.setTitle("1010");
    this.setSize(450, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.cp = this.getContentPane();
    
	this.saisie = new JTextField(10);
	this.saisie.setText(null);
	this.saisie.addActionListener(this);
	this.saisie.setActionCommand("SAISIE");
	this.saisie.addKeyListener(this);
	this.saisie.setSize(300, 200);
	
	JButton ok = new JButton("OK");
	ok.addActionListener(this);
	ok.setActionCommand("Validé");
	ok.setBackground(Color.LIGHT_GRAY);
		
	JLabel nom= new JLabel("Entrez votre pseudo (10 caractères maximum, pas d'espaces)");
	nom.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	this.getContentPane().add(ok,BorderLayout.EAST);
	this.getContentPane().add(this.saisie,BorderLayout.WEST);
	this.getContentPane().add(nom,BorderLayout.NORTH);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);	
	
	
}
public void commandeClavier(){
	if(this.saisie.getText().length() > tailleLimite - 1) {
		System.out.println("limite atteinte");
		try {
			this.saisie.setText(this.saisie.getText(0, this.tailleLimite - 1));
		} catch (BadLocationException ble) { ble.printStackTrace(); }

	}	 
}

public void lancerNewFenetre() throws RemoteException{
	   this.dispose(); //enleve la JFrame
	   this.pseudo = this.saisie.getText();
	   new FenetreMenu(this.pseudo, this.interf );
	   //this.validate();
}
	
@Override
public void actionPerformed(ActionEvent e) {
		String clic = e.getActionCommand();
		switch(clic)
		{
		   case "Validé":
			   if(this.saisie.getText().length() != 0) 
			   {
				   try 
				   {
					   lancerNewFenetre();
				   } 
				   catch (RemoteException e1) 
				   {
					   e1.printStackTrace();
				   }
				   break;
			   }
		   case "SAISIE":
			   String valeur = this.saisie.getText();
			   break;
	    }
}

@Override
public void keyTyped(KeyEvent e) 
{

	if (e.getKeyChar() == '\n' && this.saisie.getText().length() != 0) 
	{
		System.gc();
		java.awt.Window win[] = java.awt.Window.getWindows(); 
		for(int i=0;i<win.length;i++)
		{ 
		    win[i].dispose(); 
		    win[i]=null;
		} 
		try 
		{
			lancerNewFenetre();
		} 
		catch (RemoteException e1) 
		{
			e1.printStackTrace();
		}
	} 
	else if(e.getKeyChar() == KeyEvent.VK_SPACE) 
	{
		try 
		{
			Robot bot = new Robot();
			bot.keyPress(KeyEvent.VK_BACK_SPACE);
			bot.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		catch(AWTException damn) 
		{
			damn.printStackTrace();
		}
	}	
	else 
	{
		commandeClavier();
	}
}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

	
}