package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import exercice4.exercice4.AffichageParGroup;
import exercice4.exercice4.InterfacePersonnel;

public class AffichageParGroupDao 
	implements Dao<AffichageParGroup>, Serializable {
	   
	    private static final long serialVersionUID = 7495792860593545943L;
	   
	    private ArrayList<AffichageParGroup> list;
	   
	    public AffichageParGroupDao() {
	        list = new ArrayList<AffichageParGroup>();
	    }
	   
	    public void add(final AffichageParGroup object) {
	        list.add(object);
	    }
	   
	    public AffichageParGroup get(final int id) {
	        for (AffichageParGroup apg : list) {
	            if (apg.getId() == id) {
	                return apg;
	            }
	        }
	        return null;
	    }
	   
	    @SuppressWarnings("unchecked")
	    public ArrayList<AffichageParGroup> getAll() {
	        return (ArrayList<AffichageParGroup>) list.clone();
	    }
	 
	    @SuppressWarnings("unchecked")
	    public void update(final AffichageParGroup object,
	            final Map<String, Object> params) {
	        if (list.contains(object)) {
	            ArrayList<InterfacePersonnel> remplace =
	            (ArrayList<InterfacePersonnel>) params.get("file");
	            if (params.containsKey("file")) {
	                object.reset();
	                for (InterfacePersonnel ip : remplace) {
	                    object.add(ip);
	                }
	            }
	        }
	    }
	    
	   
	    public void remove(final AffichageParGroup object) {
	        list.remove(object);
	    }
	   
	    public void serialize(final String path) {
	        ObjectOutputStream writer = null;
	        try {
	            FileOutputStream file = new FileOutputStream(path);
	            writer = new ObjectOutputStream(file);
	            writer.writeObject(this);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            System.err.println(
	            "La serialization a échoué vers le fichier \""
	            + path + "\"");
	        }
	        try {
	            if (writer != null) {
	                writer.flush();
	                writer.close();
	            }
	        } catch (IOException e2) {
	            e2.printStackTrace();
	        }
	    }
	    
	    public static AffichageParGroupDao deserialize(final String path) {
	        ObjectInputStream reader = null;
	        AffichageParGroupDao dapg = null;
	        try {
	            FileInputStream file = new FileInputStream(path);
	            reader = new ObjectInputStream(file);
	            dapg = (AffichageParGroupDao) reader.readObject();
	        } catch (IOException e) {
	            System.err.println(
	            "La deserialization a échoué depuis le fichier \""
	            + path + "\"");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            if (reader != null) {
	                reader.close();
	            }
	        } catch (IOException e2) {
	            e2.printStackTrace();
	        }
	        return dapg;
	    }
		
}
