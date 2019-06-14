import java.awt.Color;
import java.io.Serializable;


public class BarreH4 extends Piece implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2660469220079715188L;
	/**
	 * 
	 */
	private byte[][] disposition =  { {1,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
	private Color couleur = Color.ORANGE;
	private String nom = "BarreH4";
	
	public BarreH4() 
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
