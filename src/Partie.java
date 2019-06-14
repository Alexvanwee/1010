import java.io.Serializable;
import java.util.ArrayList;

public class Partie implements Serializable
{

	private static final long serialVersionUID = -1012210695781809407L;
	private Pieces lespieces;
	private int scorelimite,nombrejoueurs,IDPartie, fini;
	private Piece[][] piecespartie;	
	private Grille[] grilles;	
	private ArrayList<Joueur> listejoueurs;
	private Piece[] leretourpieces;
	private String[] retour, hh;


	public Partie(ArrayList<Joueur> lesjoueurs) 
	{
		this.lespieces = new Pieces();
		this.piecespartie = new Piece[50][3];
		this.scorelimite = 0;
		this.listejoueurs = lesjoueurs;
		this.nombrejoueurs = lesjoueurs.size();
		this.grilles = new Grille[this.nombrejoueurs];
		for(int i = 0; i<this.nombrejoueurs; i++) 
		{
			this.grilles[i] = new Grille();
		}
		this.fini = 0;
		
		for(int i = 0; i<50; i++) 
		{
			for(int j = 0; j<3; j++) 
			{
				this.piecespartie[i][j] = this.lespieces.getPiece();
			}
		}
	}
	
	public ArrayList<Joueur> getJoueurs(int idp) 
	{
		return this.listejoueurs;
	}
	
	public void setIDPartie(int k) 
	{
		this.IDPartie = k;
	}
	
	public int getScoreLimite(int i) 
	{
		return this.scorelimite;
	}
	
	public int getNbrJoueurs(int idp) 
	{
		return this.nombrejoueurs;
	}
	
	public void setRang(int id, int rang) 
	{
		Joueur temp = this.listejoueurs.get(id);
		temp.setRang(id,rang);
		this.listejoueurs.set(id, temp);
	}
	
	public Piece[] PoolPieces(Integer id, int idp) 
	{
		Integer rang = this.listejoueurs.get(id).getRang(id);
		Integer retour = rang + 1;
		this.listejoueurs.get(id).setRang(id,retour);
		this.leretourpieces = this.piecespartie[rang];
		return this.leretourpieces;
	}
	
	public void setScoreLimite(int numero, int idp) 
	{
		this.scorelimite = numero;
	}
	
	public Joueur getJoueur(int id, int idp) 
	{
		return this.listejoueurs.get(id);
	}
	
	public void setJoueur(int id, Joueur player, int idp) 
	{
		this.listejoueurs.set(id, player);
	}
	
	public String[] ScoreAtteint(int qui, int idp) 
	{
		this.retour = new String[this.nombrejoueurs];
		Joueur lejoueur = this.listejoueurs.get(qui);
		int lescore = lejoueur.getScore(qui, idp);
		if(this.fini == 1) 
		{
			return this.hh;
		}
		if(lescore >= this.scorelimite) 
		{
			Joueur lej = this.listejoueurs.get(qui);
			lej.setState("gagne", qui, idp);
			this.listejoueurs.set(qui, lej);
			this.retour[qui] = "gagne";
			System.out.println("joueur "+qui+" a gagne");
			
			for(int i = 0; i < this.listejoueurs.size(); i++) 
			{
				if(i != qui) 
				{
					Joueur pl = this.listejoueurs.get(i);
					pl.setState("perdu", qui, idp);
					this.listejoueurs.set(i, pl);
					this.retour[i] = "perdu";
					System.out.println("joueur "+i+" a perdu");
				}
			}
			this.hh = this.retour;
			this.fini = 1;
			return retour;
		}
		
		else 
		{
			return retour;
		}
	}
	
	public String getWin(int id, int idp) 
	{
		return this.listejoueurs.get(id).getState(id, idp);
	}
	
	public void addGrille(int id, int idp) 
	{
		this.grilles[id] = new Grille();
	}
	
	public Grille getGrille(int id, int idp) 
	{
		return this.grilles[id];
	}
	
	public void setGrille(int id, Grille grid, int idp) 
	{
		this.grilles[id] = grid;
	}
	
	public Piece[][] getPiecesPartie(int idp) 
	{
		return this.piecespartie;
	}

}
