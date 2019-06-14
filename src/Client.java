import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client implements Serializable
{

	private static final long serialVersionUID = -665706853944078303L;
	public static Interface interf;

	
	public static void main(String[] args) 
    {      
        try 
        {
        	Registry registry = LocateRegistry.getRegistry();
        	interf = (Interface)registry.lookup("localhost");
            new FenetrePseudo(interf);
        }
        catch (Exception e)
        {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
    
    

    
    
    
    
    
    
    
    
    
