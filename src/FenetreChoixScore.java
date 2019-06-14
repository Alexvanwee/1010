
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreChoixScore extends JFrame implements ActionListener,Serializable{
	
	private static final long serialVersionUID = -2378678659946289324L;
	private JComboBox<String> liste1;
	private JPanel choix;
	private String userName;
	private Interface interf;
	private int nbrjoueurs;
	
	public  FenetreChoixScore(String userName, Interface theinterface, int joueurs)
	{
		super("score");
		
		this.nbrjoueurs = joueurs;
		this.interf = theinterface;
		this.userName = userName;
		
		this.setSize(1150, 720);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.choix = new JPanel();
		
		String[] elements = {"1000 points", "1500 points", "2000 points", "2500 points", "3000 points"};
		 
		this.choix.setLayout(new FlowLayout());
		this.liste1 = new JComboBox<String>(elements);
		this.liste1.setSize(new Dimension(300,200));

		JButton ok = new JButton("OK");
		ok.setBackground(Color.lightGray);
		ok.setSize(300, 200);
		ok.addActionListener(this);
		ok.setActionCommand("ok");
		
		this.choix.add(this.liste1);
		this.choix.add(ok);
		
		//JLabel ID = new JLabel(userName);
		//ID.setOpaque(true);
		//ID.setBackground(Color.LIGHT_GRAY);
		//choix.add(ID);
		
		JPanel north = new JPanel();	
		
		north.setLayout(new FlowLayout());
		JLabel texte = new JLabel("Choisissez un score limite pour la partie");
		texte.setFont(new Font("Calibri", Font.PLAIN, 20));
		north.add(texte);
		
		this.add(this.choix,BorderLayout.CENTER);
		this.add(north, BorderLayout.NORTH);

		validate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		
	}

	
	
	public void lancerNewFenetre(int nombre) throws RemoteException
	{
	    this.dispose(); //enleve la JFrame	   
	    new FenetreAttente(this.interf, this.userName, this.nbrjoueurs, nombre);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String clic = e.getActionCommand();
		if(clic == "ok") 
		{
			String choix = (String)this.liste1.getSelectedItem();
			String stringpoints = choix.substring(0, 4);
			int points = Integer.parseInt(stringpoints);
			
			System.gc();
			java.awt.Window win[] = java.awt.Window.getWindows(); 
			for(int i=0;i<win.length;i++)
			{ 
			    win[i].dispose(); 
			    win[i]=null;
			} 
			
			try 
			{
				this.lancerNewFenetre(points);
			} 
			catch (RemoteException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		
	}
	
}