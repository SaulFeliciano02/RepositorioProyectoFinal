package persistivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logico.CentralAltice;

public class ArchivarCentral {
	
	//private static ArchivarCentral archivo = null;
	
	public ArchivarCentral() {
		super();
		
	}
	
	/*public static ArchivarCentral getInstance()
	{
		if(archivo == null)
		{
			archivo = new ArchivarCentral();
		}
		
		return archivo;
	}*/
	
	public void guardar(CentralAltice esta) throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("central.obj"));
		salida.writeObject(esta);
		salida.close();
	}
	
	public CentralAltice recuperar() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("central.obj"));
		CentralAltice recuperada = (CentralAltice) entrada.readObject();
		entrada.close();
		return recuperada;
	}
	
}
