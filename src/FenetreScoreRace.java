
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreScoreRace extends Container implements ActionListener,Serializable{
	
	private static final long serialVersionUID = -1439039398991223066L;
	private String userName;
	private FenetreMenu fenetre;
	private Interface interf;


	public FenetreScoreRace(FenetreMenu fenetre,String userName, Interface unainterface){
		
		this.interf = unainterface;
		
		JPanel titre = new JPanel();
		titre.setBackground(Color.WHITE);
		JLabel joueurs = new JLabel("Choisissez le nombre de joueurs");
		joueurs.setFont(new Font("Calibri", Font.PLAIN, 28));
		titre.add(joueurs);
		
		this.userName = userName;
		this.fenetre = fenetre;
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(fenetre);
		retour.setActionCommand("retour");
		
		JButton bouton1 = new JButton("1");
		bouton1.setBackground(Color.ORANGE);
		JButton bouton2 = new JButton("2");
		bouton2.setBackground(Color.ORANGE);
		JButton bouton3 = new JButton("3");
		bouton3.setBackground(Color.GREEN);		
		JButton bouton4 = new JButton("4");
		bouton4.setBackground(Color.ORANGE);
		JButton bouton5 = new JButton("5");
		bouton5.setBackground(Color.GREEN);
		JButton bouton6 = new JButton("6");
		bouton6.setBackground(Color.CYAN);
		
		bouton1.addActionListener(this);
		bouton1.setActionCommand("1");
		bouton2.addActionListener(this);
		bouton2.setActionCommand("2");
		bouton3.addActionListener(this);
		bouton3.setActionCommand("3");
		bouton4.addActionListener(this);
		bouton4.setActionCommand("4");
		bouton5.addActionListener(this);
		bouton5.setActionCommand("5");
		bouton6.addActionListener(this);
		bouton6.setActionCommand("6");
		
		JPanel grille = new JPanel();
		grille.setBackground(Color.WHITE);
		grille.setLayout(new GridLayout(3, 2, 100, 100)); 
		grille.add(bouton1);
		grille.add(bouton2);
		grille.add(bouton3);
		grille.add(bouton4);
		grille.add(bouton5);
		grille.add(bouton6);
		
		JPanel vide1 = new JPanel();
		vide1.setBackground(Color.WHITE);
		JPanel vide2 = new JPanel();
		vide2.setBackground(Color.WHITE);
		
		JLabel ID = new JLabel(userName);
		ID.setOpaque(true);
		ID.setPreferredSize(new Dimension(75,20));
		ID.setBackground(Color.lightGray);
		titre.add(ID);
		
		this.setLayout(new BorderLayout());
		this.add(grille,BorderLayout.CENTER);
		this.add(titre,BorderLayout.NORTH);
		this.add(retour,BorderLayout.SOUTH);
		this.add(vide1,BorderLayout.WEST);
		this.add(vide2,BorderLayout.EAST);
		
	}
	
	
@Override
public void actionPerformed(ActionEvent e) {
		String clic = e.getActionCommand();
		
		if(clic == "retour") 
		{
			//this.fenetre.setContentPane(fenetre.getCp1());
		}
		
		else if(clic.length() == 1)
		{
			int players = Integer.parseInt(clic);
			
			System.gc();
			java.awt.Window win[] = java.awt.Window.getWindows(); 
			for(int i=0;i<win.length;i++)
			{ 
			    win[i].dispose(); 
			    win[i]=null;
			} 
			
			new FenetreChoixScore(this.userName, this.interf, players);
			
		}
		
	}				
	
}

