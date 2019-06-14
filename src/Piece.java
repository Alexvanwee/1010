import java.awt.Color;
import java.io.Serializable;

public abstract class Piece implements Serializable{

	private static final long serialVersionUID = 523656604631477783L;


	public Piece() 
	{
		
	}
	
	public abstract Color getCouleur();
		
	
	public abstract byte[][] getDisposition();
	
	
	public abstract String getNom();
	
	


}
