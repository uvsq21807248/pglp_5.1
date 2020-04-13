package exercice4.exercice4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CompositePersonnels implements InterfacePersonnel, Iterable<InterfacePersonnel>,Serializable {
	 private static final long serialVersionUID = 5189666711357927869L;
	private final int id ;

    private static int idNext = 1;
	private	List<InterfacePersonnel> listperso= new ArrayList<InterfacePersonnel>();
	 public void print() {
	        System.out.print(toString());
	    }
		public String toString() {
			// TODO Auto-generated method stub
			 String s = "Id : " + id + "\n";
		        for (InterfacePersonnel pres:listperso) {
		            s += pres.toString();
		        }
		        return s;
			
		}
		
		

		public CompositePersonnels() {
			id = idNext++;
			listperso = new ArrayList<InterfacePersonnel>();
		}



		public Iterator<InterfacePersonnel> iterator() {
			// TODO Auto-generated method stub
			return  listperso.iterator();
		}
		public int getId() {
			return id;
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
		    /**
		     * deserialize vers le fichier voulu.
		     * @param path nom du fichier pour deserializer
		     * @return l'instance de classe créé avec deserialization
		     */
		    public static CompositePersonnels deserialize(final String path) {
		        ObjectInputStream reader = null;
		        CompositePersonnels cp = null;
		        try {
		            FileInputStream file = new FileInputStream(path);
		            reader = new ObjectInputStream(file);
		            cp = (CompositePersonnels) reader.readObject();
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
		        return cp;
		    }
		    /**
		     * vide la liste.
		     */
		    public void reset() {
		    	listperso.clear();
		    }
			public CompositePersonnels add(InterfacePersonnel ip) {
				// TODO Auto-generated method stub
				  if (!listperso.contains(ip)) {
					  listperso.add(ip);
			        }
			        return this;
			}
			public CompositePersonnels remove(InterfacePersonnel it) {
				// TODO Auto-generated method stub
				System.out.println(listperso.remove(it));
		        return this;
			}
}
