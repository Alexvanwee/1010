import java.awt.Color;
import java.io.Serializable;

public class Carre1 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3833341999379518702L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.RED;
	private String nom = "Carre1";
	
	
	public Carre1() 
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
