package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exercice4.exercice4.Personnel;

public class PersonnelDao implements Dao<Personnel>, Serializable {
  
    private static final long serialVersionUID = 9721705196084890L;

	private static final int Integer = 0;
   
    private ArrayList<Personnel> list;
  
   
    public PersonnelDao(ArrayList<Personnel> list) {
		super();
		this.list = list;
	}
	
    public void add(final Personnel object) {
        list.add(object);
    }

    public Personnel get(final int id) {
        for (Personnel p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
  
    @SuppressWarnings("unchecked")
    public ArrayList<Personnel> getAll() {
        return (ArrayList<Personnel>) list.clone();
    }

    @SuppressWarnings("unchecked")
    public void update(final Personnel object,
            final Map<String, Object> params) {
        if (list.remove(object)) {
            String nom = "";
            if (params.containsKey("nom")) {
                nom = (String) params.get("nom");
            } else {
                nom = object.getNom();
            }
            String prenom = "";
            if (params.containsKey("prenom")) {
                prenom = (String) params.get("prenom");
            } else {
                prenom = object.getPrenom();
            }
            LocalDate dateNaissance;
            if (params.containsKey("dateNaissance")) {
                dateNaissance = (LocalDate) params.get("dateNaissance");
            } else {
                dateNaissance = object.getDateNaissance();
            }
            List<Integer> tels = null;
            if (params.containsKey("Téléphone")) {
            	List<Integer> tmp;
                tmp = (List<Integer>) params.get("Telephone");
                tels.addAll(tmp);
             
            } else {
                tels = object.getTels();
            }
            Personnel p = new Personnel.Builder(nom, prenom, dateNaissance,tels).build();
            list.add(p);
        }
    }
    
    public void remove(final Personnel object) {
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
   
    public static PersonnelDao deserialize(final String path) {
        ObjectInputStream reader = null;
        PersonnelDao dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (PersonnelDao) reader.readObject();
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
        return dp;
    }
	

	
}