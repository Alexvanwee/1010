import java.awt.Color;
import java.io.Serializable;

public class CoinHD1 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6506579675584610133L;
	/**
	 * 
	 */
	private byte[][] disposition = { {0,0,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.PINK;
	private String nom = "CoinHD1";
	
	public CoinHD1() 
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
