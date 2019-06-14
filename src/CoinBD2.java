import java.awt.Color;
import java.io.Serializable;

public class CoinBD2 extends Piece implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3445041950392814698L;
	/**
	 * 
	 */
	private byte[][] disposition = { {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,1},{0,0,0,0,1},{0,0,1,1,1} };
	private Color couleur = Color.YELLOW;
	private String nom = "CoinBD2";
	
	public CoinBD2() 
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
