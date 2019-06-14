import java.awt.Color;
import java.io.Serializable;

public class Carre2 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8618691935975367887L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,0,0,0},{1,1,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.RED;
	private String nom = "Carre2";
	
	
	public Carre2() 
	{
		
		
	}
	
	public byte[][] getDisposition()
	{
		return disposition;
	}
	
	public Color getCouleur() 
	{
		return this.couleur;
	}
	public String getNom() 
	{
		return this.nom;
	}


}
