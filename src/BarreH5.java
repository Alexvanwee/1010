import java.awt.Color;
import java.io.Serializable;

public class BarreH5 extends Piece implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7537038969546806215L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,1,1,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.ORANGE;
	private String nom = "BarreH5";
	
	public BarreH5() 
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
