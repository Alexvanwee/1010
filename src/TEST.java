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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TEST extends JFrame implements ActionListener,Serializable
{
	
	private JButton[][] cases;
	private JButton bouton1,bouton2,bouton3, forfait;
	private String nompiece1, nompiece2, nompiece3, nomjoueur, nompiece, etat, st;
	private Color couleur1, couleur2, couleur3, couleur;
	private byte[][] disposition1, disposition2, disposition3, disposition;
	private Piece piece1, piece2, piece3, piece;
	private byte p1, p2, p3;
	private Interface ninja;
	private JPanel grille, zonepieces, zonedroite, zonehaut;
    private int id, scoremax, quelbouton, IDPartie, players;
    private Piece[] unpool;
    private boolean laverite;
    private JLabel affichescore, pseudo;
    private Grille grilletemp;
    

    public TEST(Interface uneinterface, String joueur, int nombrej, int scorelimite, int numpartie, int who) throws RemoteException 
    {
    	this.id = who;
    	this.ninja = uneinterface;
    	this.IDPartie = numpartie;
    	this.nomjoueur = joueur;
    	this.players = nombrej;
    	this.scoremax = scorelimite;
    	this.etat = "";
    	
    	System.out.println("votre id est "+this.id);
    	
    	try 
    	{
	    	this.ninja.setScoreLimite(this.scoremax, this.IDPartie);
		} 
    	catch (RemoteException e1) 
    	{
			e1.printStackTrace();
		}
    
    
    /*----- Attributs : trois variables pour etat boutons pieces ----*/
    	
    	this.p1 = 0;
    	this.p2 = 0;
    	this.p3 = 0;
    	
    /*---------- Creations de la grille pour les cases --------------*/
    	
    	this.cases = new JButton[10][10];
    	
    /*------------------- Ajout des Panels --------------------------*/
        
        this.grille = new JPanel();
        this.zonepieces = new JPanel();
        this.zonedroite = new JPanel();
        this.zonehaut = new JPanel();        
        
    /*--------------- Mise en place de la grille --------------------*/
        
        this.grille.setLayout(new GridLayout(10, 10, 2, 2));     
        
        for(int j = 0; j<10; j++)
        {
        	for(int i = 0; i<10; i++) 
        	{
	        	this.cases[j][i] = new JButton(" ");
	        	this.cases[j][i].addActionListener(this);
	        	this.cases[j][i].setActionCommand(""+j+i);
	        	this.cases[j][i].setBackground(Color.gray);
	        	this.grille.add(this.cases[j][i]);
        	}
        }
        
        this.grille.setMaximumSize(new Dimension(200,200));
        
    /*------------- Ajout des boutons pour les pièces ---------------*/
        
        this.bouton1 = new JButton();
        this.bouton1.addActionListener(this);
        this.bouton1.setBackground(Color.WHITE);
        this.bouton1.setSize(200, 200);
        
        this.bouton2 = new JButton();
        this.bouton2.addActionListener(this);
        this.bouton2.setBackground(Color.WHITE);
        this.bouton2.setSize(200, 200);
        
        this.bouton3 = new JButton();
        this.bouton3.addActionListener(this);
        this.bouton3.setBackground(Color.WHITE);
        this.bouton3.setSize(200, 200);
        
        this.zonepieces.setLayout(new FlowLayout());    
        this.zonepieces.add(this.bouton1);    
        this.zonepieces.add(this.bouton2);    
        this.zonepieces.add(this.bouton3); 
        
    /*---------------- Ajout texte panneau du haut -------------------*/
        
        this.pseudo = new JLabel(this.nomjoueur);
        this.pseudo.setFont(new Font("Calibri", Font.PLAIN, 28));
        this.zonehaut.add(this.pseudo);
        
        this.forfait = new JButton("Forfait");
        this.forfait.addActionListener(this);
        this.forfait.setActionCommand("Forfait");
        this.zonehaut.add(this.forfait);
         
    /*--------------- Ajout Texte panneau du bas ---------------------*/
        
        
		this.affichescore = new JLabel("Score : 0");
		this.affichescore.setFont(new Font("Calibri", Font.PLAIN, 28));
        this.zonedroite.add(this.affichescore);
        
    /*------------ Ajout des panels au ContentPane -------------------*/
        
        add(this.grille, BorderLayout.CENTER);
        add(this.zonepieces, BorderLayout.SOUTH);
        add(this.zonedroite, BorderLayout.EAST);
        add(this.zonehaut, BorderLayout.NORTH);
        
        this.setTitle("1010");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        try 
        {
        	this.unpool = this.ninja.PoolPieces(this.id, this.IDPartie);
    		System.out.println(unpool);
    		this.setBoutons(this.unpool);
    	} 
        catch (RemoteException e) 
        {
    		e.printStackTrace();
    	}
    }
    
    public void setPseudo(String nom) 
    {
    	this.nomjoueur = nom;
    }
    
    public void setScoreAffiche(int score) 
    {
    	this.affichescore.setText("Score : " + score);
    	this.affichescore.setFont(new Font("Calibri", Font.PLAIN, 28));
    }    

    public void setBoutons(Piece[] bloc) 
	{
		this.piece1 = bloc[0];
		this.piece2 = bloc[1];
		this.piece3 = bloc[2];		
		
		this.nompiece1 = this.piece1.getNom();
		this.nompiece2 = this.piece2.getNom();
		this.nompiece3 = this.piece3.getNom();
		
		this.bouton1.setActionCommand(this.nompiece1);
		this.bouton2.setActionCommand(this.nompiece2);
		this.bouton3.setActionCommand(this.nompiece3);
		
		this.couleur1 = this.piece1.getCouleur();
		this.couleur2 = this.piece2.getCouleur();
		this.couleur3 = this.piece3.getCouleur();
		
		this.disposition1 = this.piece1.getDisposition();
		this.disposition2 = this.piece2.getDisposition();
		this.disposition3 = this.piece3.getDisposition();
		
		ImageIcon image1 = new ImageIcon(this.getClass().getResource(this.nompiece1 + ".png"));
		ImageIcon image2 = new ImageIcon(this.getClass().getResource(this.nompiece2 + ".png"));
		ImageIcon image3 = new ImageIcon(this.getClass().getResource(this.nompiece3 + ".png"));
		
		this.bouton1.setIcon(image1);
		this.bouton2.setIcon(image2);
		this.bouton3.setIcon(image3);
		
		this.bouton1.setVisible(true);;
		this.bouton2.setVisible(true);
		this.bouton3.setVisible(true);;
		
	}
	
	/*------------------- Action des boutons -------------------------*/

    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
    	
    	String action = arg0.getActionCommand();
    	
    	if(action.equals("Forfait")) 
    	{
    		try 
    		{
				this.ninja.setState("perdu",this.id, this.IDPartie);
			} 
    		catch (RemoteException e) 
    		{
				e.printStackTrace();
			}
    	}
    	
    	if(action.length()>3)
    	{
    		if(action == this.nompiece1 && this.p1 != 3) 
    		{
    			this.p1 = 1;
    			
    			if(this.p2 != 3) 
    			{
    				this.p2 = 0;
    			}
    			
    			if(this.p3 != 3) 
    			{
    				this.p3 = 0;
    			}
    			System.out.println(action);
    		}
    		
    		else if(action == this.nompiece2 && this.p2 != 3) 
    		{
    			if(this.p1 != 3) 
    			{
    				this.p1 = 0;
    			}
    			
    			this.p2 = 1;
    			
    			if(this.p3 != 3) 
    			{
    				this.p3 = 0;
    			}
    			System.out.println(action);
    		}
    		
    		else if(action == this.nompiece3 && this.p3 != 3) 
    		{
    			if(this.p1 != 3) 
    			{
    				this.p1 = 0;
    			}
    			
    			if(this.p2 != 3) 
    			{
    				this.p2 = 0;
    			}
    			
    			this.p3 = 1;
    			System.out.println(action);
    		}
    	}
    	
    	/* Si clic sur une case de la grille de jeu */
    	
    	if(action.length()<=3)
    	{	
			char lignechar = action.charAt(0);
			char colonnechar = action.charAt(1);
			String lignestring = lignechar + "";
			String colonnestring = colonnechar + "";
			int ligne = Integer.parseInt(lignestring);
			int colonne = Integer.parseInt(colonnestring);			
			
			try 
			{
				this.quelbouton = 0;
				this.grilletemp = this.ninja.getGrille(this.id, this.IDPartie);
				if(this.p1 == 1 && (this.p2 == 0 || this.p2 == 3) && (this.p3 == 0 || this.p3 == 3)) 
				{
					this.laverite = this.grilletemp.PoserPiece(ligne,colonne,this.disposition1, this.nompiece1, this.id, this.IDPartie);
					this.quelbouton = 1;
				}
				else if((this.p1 == 0 || this.p1 == 3) && this.p2 == 1 && (this.p3 == 0 || this.p3 == 3)) 
				{
					this.laverite = this.grilletemp.PoserPiece(ligne,colonne,this.disposition2, this.nompiece2, this.id, this.IDPartie);
					this.quelbouton = 2;
				}
				else if((this.p1 == 0 || this.p1 == 3) && (this.p2 == 0 || this.p2 == 3) && this.p3 == 1) 
				{
					this.laverite = this.grilletemp.PoserPiece(ligne,colonne,this.disposition3, this.nompiece3, this.id, this.IDPartie);
					this.quelbouton = 3;
				}
				
				
				if(this.laverite == true)
				{
					this.ninja.setGrille(this.id, this.grilletemp, this.IDPartie);
					if(this.quelbouton == 1) 
					{
						this.nompiece = this.nompiece1;
						this.disposition = this.disposition1;
						this.couleur = this.couleur1;
						this.piece = this.piece1;
					}
					if(this.quelbouton == 2) 
					{
						this.nompiece = this.nompiece2;
						this.disposition = this.disposition2;
						this.couleur = this.couleur2;
						this.piece = this.piece2;
					}
					if(this.quelbouton == 3) 
					{
						this.nompiece = this.nompiece3;
						this.disposition = this.disposition3;
						this.couleur = this.couleur3;
						this.piece = this.piece3;
					}
					
					if(this.nompiece.contains("CoinBD")) 
					{
						
						int token1 = -4;
						for(int l = 4; l>-1; l--) 
						{
							int token2 = -4;
							for(int c = 4; c>-1; c--) 
							{
								if(this.disposition[l][c] == 1) 
								{
									this.cases[ligne-token1-l][colonne-token2-c].setBackground(this.couleur);
								}
								token2 = token2 + 2;
							}
							token1 = token1 + 2;
						}
					}
					
					else if(nompiece.contains("CoinBG")) 
					{
						int token1 = -4;
						for(int li = 4; li>-1; li--) 
						{
							for(int co = 0; co<5; co++) 
							{
								if(this.disposition[li][co] == 1) 
								{
									this.cases[ligne-(token1 + li)][colonne +co].setBackground(this.couleur);
								}
							}
							token1 = token1 + 2;
						}						
					
					}
					
					
					else if(nompiece.contains("CoinHD")) 
					{
						for(int l = 0; l<5; l++) 
						{
							int token2 = -4;
							for(int c = 4; c>-1; c--) 
							{
								if(this.disposition[l][c] == 1) 
								{
									this.cases[ligne+l][colonne-token2-c].setBackground(this.couleur);
								}
								token2 = token2 + 2;
							}
						}
					}
					
					else 
					{
						for(int l = 0; l<5; l++) 
						{
							for(int c = 0; c<5; c++) 
							{
								if(this.disposition[l][c] == 1) 
								{
									this.cases[ligne+l][colonne+c].setBackground(this.couleur);
								}
							}
						}
					}
					
					this.ninja.setScore(5, this.id, this.IDPartie);
					this.setScoreAffiche(this.ninja.getScore(this.id, this.IDPartie));
					
					ArrayList<ArrayList<Integer>> letest = this.ninja.getGrille(this.id, this.IDPartie).Check(this.id, this.IDPartie);
					int longueurl = letest.get(0).size();
					int longueurc = letest.get(1).size();
					System.out.println(longueurl + " " + longueurc);
					ArrayList<Integer> leslignes = letest.get(0);
					ArrayList<Integer> lescolonnes = letest.get(1);
					
					if(longueurl != 0) 
					{
						for(int u = 0; u < longueurl; u++) 
						{
							for(int s = 0; s < 10; s++) 
							{
								this.cases[leslignes.get(u)][s].setBackground(Color.gray);
							}
						}
						this.ninja.setScore((letest.get(0).size())*10, this.id, this.IDPartie);
						this.affichescore.setText("Score : "+this.ninja.getScore(this.id, this.IDPartie));
						System.out.println(letest.get(0).size()+" "+"lignes complétées");
					}
											
					if(longueurc != 0) 
					{
						for(int q = 0; q < longueurc; q++) 
						{
							for(int x = 0; x < 10; x++) 
							{
								this.cases[x][lescolonnes.get(q)].setBackground(Color.gray);
							}
						}
						this.ninja.setScore((letest.get(1).size())*10, this.id, this.IDPartie);
						this.affichescore.setText("Score : "+this.ninja.getScore(this.id, this.IDPartie));
						System.out.println(letest.get(1).size()+" "+"colonnes complétées");
					}
					
					if(this.quelbouton == 1) 
					{
						this.p1 = 3;
						this.bouton1.setVisible(false);
					}
					if(this.quelbouton == 2) 
					{
						this.p2 = 3;
						this.bouton2.setVisible(false);
					}
					if(this.quelbouton == 3) 
					{
						this.p3 = 3;
						this.bouton3.setVisible(false);
					}

					if(this.p1 == 3 && this.p2 == 3 && this.p3 == 3) 
					{
						try 
						{
							this.setBoutons(this.ninja.PoolPieces(this.id, this.IDPartie));
							this.p1 = 0;
							this.p2 = 0;
							this.p3 = 0;
						} 
						
						catch (RemoteException e) 
						{
							e.printStackTrace();
						}
					}
				}
				else
				{
					if(this.quelbouton == 1) 
					{
						this.p1 = 0;
					}
					if(this.quelbouton == 2) 
					{
						this.p2 = 0;
					}
					if(this.quelbouton == 3) 
					{
						this.p3 = 0;
					}
				}
			} 
			
			catch (RemoteException e) 
			{
				e.printStackTrace();
			}
    	}
	//***********************************************************************************************************
    	if((this.p1 == 0 || this.p1 == 3) && (this.p2 == 0 || this.p2 == 3) && (this.p3 == 0 || this.p3 == 3)) 
		{
    		try 
			{
				String[] gg = this.ninja.ScoreAtteint(this.id, this.IDPartie);
				
				try 
				{
				    Thread.sleep(100);            
				}
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}
				
				if(gg[this.id] != null) 
				{
					int score = this.ninja.getScore(this.id, this.IDPartie);
					if(gg[this.id].startsWith("g")) 
					{
						this.etat = "gagne";
						new FenetreFin(this.etat);
					}
					else if(gg[this.id].startsWith("p")) 
					{
						this.etat = "perdu";
						new FenetreFin(this.etat);
					}
				}
			} 
			catch (RemoteException e) 
			{
				e.printStackTrace();
			}
		}
    }
}


