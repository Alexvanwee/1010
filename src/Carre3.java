import java.awt.Color;
import java.io.Serializable;

public class Carre3 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 656066515573331980L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,1,0,0},{1,1,1,0,0},{1,1,1,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.RED;
	private String nom = "Carre3";
	
	
	public Carre3() 
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
