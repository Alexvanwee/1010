import java.awt.Color;
import java.io.Serializable;

public class CoinHD2 extends Piece implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2026142110148448512L;
	/**
	 * 
	 */
	private byte[][] disposition = { {0,0,1,1,1},{0,0,0,0,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.PINK;
	private String nom = "CoinHD2";
	
	public CoinHD2() 
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
