import java.awt.Color;
import java.io.Serializable;


public class BarreH2 extends Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8574962935537822766L;
	/**
	 * 
	 */
	private byte[][] disposition = { {1,1,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.ORANGE;
	private String nom = "BarreH2";
	
	public BarreH2() 
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


