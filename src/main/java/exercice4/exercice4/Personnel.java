package exercice4.exercice4;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public final class Personnel  implements InterfacePersonnel{
	  private int id;
	    private String nom;
	    private String prenom;
	    private LocalDate dateNaissance;
	    private String fonction;
	    List<Integer> tels= new ArrayList<Integer>();
		public Personnel(Builder builder) {
			this.id = builder.id;
			this.nom = builder.nom;
			this.prenom = builder.prenom;
			this.dateNaissance = builder.dateNaissance;
			
		}   
		public void print() {
			// TODO Auto-generated method stub
			System.out.print("id personnel:"+id);
			
		}
		public static class Builder{
			//parametres obligatoires
			
			private int id;
		    private String nom;
		    private String prenom;
		    private LocalDate dateNaissance;
		    
		    //parametres fonctionnels
		    private String fonction;
		    List<Integer> tels= new ArrayList<Integer>();
		    public Builder(int id, String nom, String prenom, LocalDate dateNaissance) {
				this.id = id;
				this.nom = nom;
				this.prenom = prenom;
				this.dateNaissance = dateNaissance;
			}
		    
		    //changer date de naissance
		      public Builder changer(LocalDate dateNaissance) {
		    	   this.dateNaissance=dateNaissance;
		    	   return this;
		    	   
		       }
		      //ajout fonction
		      public Builder addFonction(String fn) {
		     		
		     		this.fonction=fn;
		     		return this;
		     	}//ajout numero de telephone
		     	public Builder addDateNumeroTelephone( Integer numero) {
		     		this.tels.add(numero);
		     		
		     		return this;
		     		
		     	}
		       public Personnel build() {
		    	   return new Personnel(this);
		       }
		}
}
