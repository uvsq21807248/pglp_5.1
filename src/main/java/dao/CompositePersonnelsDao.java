package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import exercice4.exercice4.CompositePersonnels;
import exercice4.exercice4.InterfacePersonnel;

public class CompositePersonnelsDao implements Dao<CompositePersonnels>, Serializable {
	   
	    private static final long serialVersionUID = 5587699980189412278L;
	   
	    private ArrayList<CompositePersonnels> list;
	 
	   
	    public CompositePersonnelsDao(ArrayList<CompositePersonnels> list) {
			super();
			this.list = list;
		}
		
	    public void add(final CompositePersonnels object) {
	        list.add(object);
	    }
	    public CompositePersonnels get(final int id) {
	        for (CompositePersonnels cp : list) {
	            if (cp.getId() == id) {
	                return cp;
	            }
	        }
	        return null;
	    }
	    @SuppressWarnings("unchecked")
	    public ArrayList<CompositePersonnels> getAll() {
	        return (ArrayList<CompositePersonnels>) list.clone();
	    }
	   
	    @SuppressWarnings("unchecked")
	    public void update(final CompositePersonnels object,
	            final Map<String, Object> params) {
	        if (list.contains(object)) {
	            if (params.containsKey("personnels")) {
	                ArrayList<InterfacePersonnel> remplace =
	                (ArrayList<InterfacePersonnel>)
	                params.get("personnels");
	                object.reset();
	                for (InterfacePersonnel ip : remplace) {
	                    object.add(ip);
	                }
	            }
	        }
	    }
	    
	    public void remove(final CompositePersonnels object) {
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
	    
	    public static CompositePersonnelsDao deserialize(final String path) {
	        ObjectInputStream reader = null;
	        CompositePersonnelsDao dcp = null;
	        try {
	            FileInputStream file = new FileInputStream(path);
	            reader = new ObjectInputStream(file);
	            dcp = (CompositePersonnelsDao) reader.readObject();
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
	        return dcp;
	    }
		
		
		
}
