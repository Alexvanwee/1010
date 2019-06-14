import java.awt.BorderLayout;
//import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreAttente extends JFrame
{

	private static final long serialVersionUID = 6709760790691115854L;
	private Interface hodor;
	private String nomjoueur;
	private int nombrejoueurs, scoremax, chiffre, hehe, IDPartie,idj;
	private boolean hehemodif;
	private JPanel panneau;
	private JLabel label;
	
	
	public FenetreAttente(Interface interf,String joueur, int nombrej, int scorelimite) throws RemoteException 
	{
		this.setTitle("1010");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
        
		this.hodor = interf;
		this.nomjoueur = joueur;
		this.nombrejoueurs = nombrej;
		this.scoremax = scorelimite;
		this.hehemodif = false;
		this.hehe = -1;	
		this.hodor.setNombreJoueurs(this.nombrejoueurs);
		this.panneau = new JPanel();
		this.chiffre = this.hodor.getLobbySize();
		
		this.add(this.panneau, BorderLayout.CENTER);
		this.idj = this.hodor.addJoueur(this.nomjoueur);
		this.hodor.setScoreFlottant(this.scoremax);
		this.setVisible(true);
		
		while(this.hehemodif == false) 
		{
			this.hehe = this.hodor.lobby();
			validate();
			if(this.hehe != -1) 
			{
				this.IDPartie = this.hehe;
				this.hehemodif = true;
			}
		}
		
		new TEST(this.hodor, this.nomjoueur, this.nombrejoueurs, this.scoremax, this.IDPartie, this.idj);
		this.dispose();
	}
	
	public void setAffichage() 
	{
		try 
		{
			this.chiffre = this.hodor.getLobbySize();
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		this.label.setText("En attente des autres joueurs..."+"("+chiffre+"/"+this.nombrejoueurs+")");
	}
	
		
	
	
	
}
