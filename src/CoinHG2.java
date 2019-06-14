import java.awt.Color;
import java.io.Serializable;

public class CoinHG2 extends Piece implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 455058650945988750L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,1,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.CYAN;
	private String nom = "CoinHG2";
	
	public CoinHG2() 
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
