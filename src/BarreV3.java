import java.awt.Color;
import java.io.Serializable;

public class BarreV3 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7071286017054867712L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}, };
	private Color couleur = Color.BLUE;
	private String nom = "BarreV3";
	
	public BarreV3() 
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
