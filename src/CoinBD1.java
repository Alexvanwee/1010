import java.awt.Color;
import java.io.Serializable;

public class CoinBD1 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6663247530008622444L;
	/**
	 * 
	 */
	private byte[][] disposition =  { {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,1},{0,0,0,1,1} };
	private Color couleur = Color.YELLOW;
	private String nom = "CoinBD1";
	
	public CoinBD1() 
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
