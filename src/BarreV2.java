import java.awt.Color;
import java.io.Serializable;


public class BarreV2 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5310244667122714151L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,0,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.BLUE;
	private String nom = "BarreV2";
	
	public BarreV2() 
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


