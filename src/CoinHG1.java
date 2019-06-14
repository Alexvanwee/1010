import java.awt.Color;
import java.io.Serializable;

public class CoinHG1 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2033066923039502692L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} } ;
	private Color couleur = Color.CYAN;
	private String nom = "CoinHG1";
	
	public CoinHG1() 
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
