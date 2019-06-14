import java.awt.Color;
import java.io.Serializable;

public class CoinBG2 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2332198055229471687L;
	/**
	 * 
	 */
	private byte[][] disposition = { {0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,0,0} };
	private Color couleur = Color.GREEN;
	private String nom = "CoinBG2";
	
	public CoinBG2() 
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
