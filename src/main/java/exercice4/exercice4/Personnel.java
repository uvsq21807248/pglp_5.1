package exercice4.exercice4;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public final class Personnel  implements InterfacePersonnel,Serializable{
	    private static final long serialVersionUID = 8028856539374241727L;
		private final int id;
	    private final String nom;
	    private final String prenom;
	    private final LocalDate dateNaissance;
	    private String fonction;
	    private List<Integer> tels= new ArrayList<Integer>();
	    public String getFonction() {
			return fonction;
		}
		public void setFonction(String fonction) {
			this.fonction = fonction;
		}
		public int getId() {
			return id;
		}
		public String getNom() {
			return nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public LocalDate getDateNaissance() {
			return dateNaissance;
		}
		public List<Integer> getTels() {
			return tels;
		}
		
		  
		public void print() {
			// TODO Auto-generated method stub
			System.out.print("id personnel:"+id);
			
		}
		public static class Builder{
			//parametres obligatoires
			private static int idNext =1;
			private final int id;
		    private final String nom;
		    private final String prenom;
		    private LocalDate dateNaissance;
		    
		    
		    //parametres fonctionnels
		    private String fonction;
		    private List<Integer> tels= new ArrayList<Integer>();
		    public List<Integer> getTels() {
				return tels;
			}

			public void setTels(List<Integer> tels) {
				this.tels = tels;
			}

			public Builder(final String nom,final String prenom,final LocalDate dateNaissance,final List<Integer> tels ) {
				this.id = idNext;
				this.nom = nom;
				this.prenom = prenom;
				this.dateNaissance = dateNaissance;
				this.tels = tels;
			}
		    
		    //changer date de naissance
		      public Builder changer(final LocalDate dateNaissance) {
		    	   this.dateNaissance=dateNaissance;
		    	   return this;
		    	   
		       }
		      //ajout fonction
		      public Builder addFonction(String fn) {
		     		
		     		this.fonction=fn;
		     		return this;
		     	}

			public Personnel build() {
		    	   return new Personnel(this);
		       }
		}
		
	   
		 public void print1() {
		        System.out.print(toString());
		    }
	  
	    public String toString() {
	        String s = prenom + " " + nom
	                + ", naissance : " + dateNaissance
	                + ", numéros de téléphone : ";
	        for (Integer i : tels) {
	            s += i + "  ";
	        }
	        return s + "\n";
	    }
	    public Personnel(final Builder builder) {
			id = builder.id;
			nom = builder.nom;
			prenom = builder.prenom;
			dateNaissance = builder.dateNaissance;
			tels = builder.tels;
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
	  
	    public static Personnel deserialize(final String path) {
	        ObjectInputStream reader = null;
	        Personnel p = null;
	        try {
	            FileInputStream file = new FileInputStream(path);
	            reader = new ObjectInputStream(file);
	            p = (Personnel) reader.readObject();
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
	        return p;
	    }
}
