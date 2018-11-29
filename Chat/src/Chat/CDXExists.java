package Chat;

import java.util.ArrayList;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XQueryService;

import daw.com.Teclado;

// Una clase que actua directamente con la base de datos lanzando Xquerys
public class CDXExists {

	final private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";
	final private static String driver = "org.exist.xmldb.DatabaseImpl";
	
	// Funcion que sirve para realizar una consulta xquery y retornar un arrayList con lo que devulva la consulta
	public static ArrayList<String> consultaCompuesta (String consulta) {
        
		 ArrayList <String> array = new ArrayList <>();
		
        try {
            
        	Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            
            Collection col = null;
        	
            col = DatabaseManager.getCollection(URI + "db","admin", "admin");
            
            XQueryService xpqs = (XQueryService)col.getService("XQueryService", "1.0");
            
            xpqs.setProperty("indent", "yes");
            //ResourceSet result = xpqs.query(args[1]);
            ResourceSet result = xpqs.query(consulta);
            ResourceIterator i = result.getIterator();
            Resource res = null;
            
            while(i.hasMoreResources()) {
            	
                try {
                	
                    res = i.nextResource();
                    
                    array.add(res.getContent().toString());
                    
                } finally {
                    try { ((EXistResource)res).freeResources(); } catch(XMLDBException xe) {xe.printStackTrace();}
                }
            }
            
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        
		return array;
		
	}

	// Funcion que sirve para realizar una consulta xquery de una sola linea de resultado y retornar un String con dicha linea
	public static String consultaSimple (String consulta) {
        
		 String resultado = "";
		
        try {
        	
        	Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            
            Collection col = null;
            
            col = DatabaseManager.getCollection(URI + "db","admin", "admin");
            
            XQueryService xpqs = (XQueryService)col.getService("XQueryService", "1.0");
            
            xpqs.setProperty("indent", "yes");
            //ResourceSet result = xpqs.query(args[1]);
            ResourceSet result = xpqs.query(consulta);
            ResourceIterator i = result.getIterator();
            Resource res = null;
            
            try {
               	
            	res = i.nextResource();
                   
                resultado = res.getContent().toString();
                   
            } finally {
                try { ((EXistResource)res).freeResources(); } catch(XMLDBException xe) {xe.printStackTrace();}
            }
            
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        
		return resultado;
		
	}
	
	// Funcion que sirve para realizar una consulta xquery que modifique una tabla
	public static void modificar (String consulta) {
		
        try {

    		Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            
            Collection col = null;
            
            col = DatabaseManager.getCollection(URI + "db","admin", "admin");
            
            XQueryService xpqs = (XQueryService)col.getService("XQueryService", "1.0");
            
            xpqs.setProperty("indent", "yes");
            //ResourceSet result = xpqs.query(args[1]);
            ResourceSet result = xpqs.query(consulta);
            
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		
	}
	
}
