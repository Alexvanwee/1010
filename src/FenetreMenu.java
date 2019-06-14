
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class FenetreMenu extends JFrame implements ActionListener,Serializable{
	
	private static final long serialVersionUID = 9034967085583478094L;
	private Container cp1;
	private FenetreScoreRace cp2;
	//private Fenetre2bis cp3;
	private FenetreJoin cp4;
	private Interface interf;
	private JTabbedPane texte;
	private String pseudo;

public FenetreMenu(String userName, Interface uneinterface) throws RemoteException{
	
	this.interf = uneinterface;
	this.pseudo = userName;
	this.setTitle("1010");
    this.setSize(1150, 720);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    cp1 = this.getContentPane();
	cp2= new FenetreScoreRace(this, userName, this.interf);
	//cp3= new Fenetre2bis(this, userName);
	
	JPanel modeDeJeu = new JPanel();
	
	JButton mode1 = new JButton("Score Race");
	mode1.addActionListener(this);
	mode1.setActionCommand("mode1");
	modeDeJeu.add(mode1);
	
	/*JButton mode2 = new JButton("Time Race");
	mode2.addActionListener(this);
	mode2.setActionCommand("mode2");
	modeDeJeu.add(mode2);
	mode2.setBackground(Color.CYAN);*/
	
	JButton rejoindre = new JButton("Join play");
	rejoindre.addActionListener(this);
	rejoindre.setActionCommand("Join play");
	modeDeJeu.add(rejoindre);	
	
	texte=new JTabbedPane();
	
	JLabel ligne1 = new JLabel("Posez les blocs pour créer et détruire des lignes complètes (horizontalement ou verticalement sur toute la longueur de la grille).");
	JLabel ligne2 = new JLabel("Chaque pièce rapporte le nombre de points correspondant à sa taille (1 carré de 1x1 = 1 point), et une ligne (ou colonne) complète détruite rapporte 10 points supplémentaires.");
	JLabel ligne3 = new JLabel("Si l’on ne peut plus poser de pièces, alors on a perdu.");
	JLabel ligne4 = new JLabel("Entre 2 et 4 joueurs s’affrontent en ligne.");
	JLabel ligne5 = new JLabel("1 (ou 2) mode(s) de jeu : le premier arrivé à xxxx points a gagné ou gagner le plus de points en un temps imparti.");
	
	ligne1.setFont(new Font("Calibri", Font.PLAIN, 18));
	ligne2.setFont(new Font("Calibri", Font.PLAIN, 18));
	ligne3.setFont(new Font("Calibri", Font.PLAIN, 18));
	ligne4.setFont(new Font("Calibri", Font.PLAIN, 18));
	ligne5.setFont(new Font("Calibri", Font.PLAIN, 18));
	
	JPanel photo= new JPanel();
	JLabel image = new JLabel(new ImageIcon(this.getClass().getResource("PHOTO.png")));
	photo.add(image);
	JLabel ID = new JLabel(userName);
	ID.setOpaque(true);
	ID.setPreferredSize(new Dimension(75,20));
	ID.setBackground(Color.WHITE);
	modeDeJeu.add(ID);
	//ID.setText();

    Box regle = Box.createVerticalBox();
    regle.add(ligne1);
    regle.add(ligne2);
    regle.add(ligne3);
    regle.add(ligne4);
    regle.add(ligne5);
    
    Box tof = Box.createVerticalBox();
    tof.add(photo);
    
    //Box page1 = Box.createVerticalBox();
    //page1.add(regle);
    //page1.add(tof);
    
    regle.add(Box.createVerticalGlue());
    tof.add(Box.createVerticalGlue());
    //page1.add(Box.createVerticalGlue());
        
    texte.addTab("Règles du jeu", regle);
	
	this.getContentPane().add(modeDeJeu, BorderLayout.NORTH);
	this.getContentPane().add(texte, BorderLayout.CENTER);
	this.getContentPane().add(photo, BorderLayout.SOUTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
 }


public Container getCp1() 
{
	return this.cp1;
}

public Container getCp2() 
{
	return this.cp2;
}

/*public Container getCp3() 
{
	return this.cp3;
}*/

public Container getCp4() 
{
	return this.cp4;
}


@Override
public void actionPerformed(ActionEvent e) {
	String clic = e.getActionCommand();
	switch(clic)
	{
	   case "mode1":
		   this.setContentPane(cp2);
		   this.validate();
		   break;
	   case "RETOUR":
		   this.setContentPane(cp1);
		   this.validate();
		   break;
	   /*case "mode2":
		   this.setContentPane(cp3);
		   this.validate();
		   break;*/
	   case "Join play":
		   try 
		   {
			   new FenetreJoin(this.pseudo, this.interf);
		   } 
		   catch (RemoteException e1) 
		   {
			   e1.printStackTrace();
		   }
		   this.dispose();
		   break;
	}
	
	
}

}