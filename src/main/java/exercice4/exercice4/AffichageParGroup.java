package exercice4.exercice4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class AffichageParGroup implements Iterable<InterfacePersonnel>, Serializable{
    private static final long serialVersionUID = 1371441610724778625L;
    private final int id;
	private static int index =1;
	private ArrayDeque<InterfacePersonnel> file;  
	   
		
		public AffichageParGroup() {
			   file = new ArrayDeque<InterfacePersonnel>();
		        id = index++;
	}

		public int getId() {
			return id;
		}
		 public void parcoursLargeur(final InterfacePersonnel ip) {
		        if (ip.getClass() == CompositePersonnels.class) {
		            InterfacePersonnel y, z;
		            CompositePersonnels tmp;
		            file = new ArrayDeque<InterfacePersonnel>();
		            ArrayDeque<InterfacePersonnel> d =
		                new ArrayDeque<InterfacePersonnel>();
		            d.add(ip);
		            while (!d.isEmpty()) {
		                y = d.pollFirst();
		                file.add(y);
		                if (y.getClass() == CompositePersonnels.class) {
		                    tmp = (CompositePersonnels) y;
		                    Iterator<InterfacePersonnel> ite =
		                        tmp.iterator();
		                    while (ite.hasNext()) {
		                        z = ite.next();
		                        if (!d.contains(z) && !file.contains(z)) {
		                            d.add(z);
		                        }
		                    }
		                }
		            }
		        }
		    }
		
		 public Iterator<InterfacePersonnel> iterator() {
				// TODO Auto-generated method stub
			 return file.iterator();
			 }
		  public void print() {
		        System.out.print(toString());
		    }
		    public String toString() {
		        String s = "";
		        CompositePersonnels tmp;
		        //affichage du parcours
		        for (InterfacePersonnel c2 : file) {
		            if (c2.getClass() == CompositePersonnels.class) {
		                tmp = (CompositePersonnels) c2;
		                s += tmp.getId() + "\n";
		            } else {
		                s += ((Personnel) c2).toString();
		            }
		        }
		        return s;
		    }
		    public void add(final InterfacePersonnel ip) {
		        file.add(ip);
		    }
		    public void reset() {
		        while (!file.isEmpty()) {
		            file.removeFirst();
		        }

		}
		
	

		

		
	    public void serialize(final String path) {
	        ObjectOutputStream writer = null;
	        try {
	            FileOutputStream fichier = new FileOutputStream(path);
	            writer = new ObjectOutputStream(fichier);
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
	   
	    public static AffichageParGroup deserialize(final String path) {
	        ObjectInputStream reader = null;
	        AffichageParGroup apg = null;
	        try {
	            FileInputStream fichier = new FileInputStream(path);
	            reader = new ObjectInputStream(fichier);
	            apg = (AffichageParGroup) reader.readObject();
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
	        return apg;
	    }

		
}
