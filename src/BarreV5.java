import java.awt.Color;
import java.io.Serializable;


public class BarreV5 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6139859326765094405L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0} };
	private Color couleur = Color.BLUE;
	private String nom = "BarreV5";
	
	public BarreV5() 
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
