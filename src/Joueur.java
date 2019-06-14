import java.io.Serializable;

public class Joueur implements Serializable{
	
	private static final long serialVersionUID = 3289840705927184906L;
	private int score, rang;
	private String pseudo, etat;
	
	public Joueur(String nom) 
	{
		this.pseudo = nom;
		this.score = 0;
		this.rang = 0;
		this.etat = "joue";
	}
	
	public int getScore(int id, int idp) 
	{
		return this.score;
	}
	
	public void setScore(int nombre, int id, int idpartie) 
	{
		this.score = this.score + nombre;
	}
	
	public String getPseudo(int id, int idp) 
	{
		return this.pseudo;
	}

	public void setRang(int id, int idp) 
	{
		this.rang = this.rang + 1;
	}
	
	public int getRang(int id) 
	{
		return this.rang;
	}
	
	public void setState(String ee, int id, int idp) 
	{
		this.etat = ee;
	}
	
	public String getState(int id, int idp) 
	{
		return this.etat;
	}
	

}
