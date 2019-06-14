import java.awt.Color;
import java.io.Serializable;

public class CoinBG1 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 901119792309292766L;
	/**
	 * 
	 */
	private byte[][] disposition = { {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,0,0} };
	private Color couleur = Color.GREEN;
	private String nom = "CoinBG1";
	
	public CoinBG1() 
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
