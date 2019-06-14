import java.awt.Color;
import java.io.Serializable;

public class BarreH3 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -278699415020160098L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,1,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.ORANGE;
	private String nom = "BarreH3";
	
	public BarreH3() 
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
