package exercice4.exercice4;

import java.util.ArrayList;
import java.util.List;
public class CompositePersonnels implements InterfacePersonnel {
	 int id;
		List<InterfacePersonnel> listperso= new ArrayList<InterfacePersonnel>();
		public void print() {
			// TODO Auto-generated method stub
			
			System.out.print("Id de groupe " +id);
			for(InterfacePersonnel pres:listperso ) {
				pres.print();
			}
		}
		
		public CompositePersonnels addPersonnel(InterfacePersonnel inP) {
			this.listperso.add(inP);
			return this;
		}
		public CompositePersonnels removePersonnel(InterfacePersonnel inP) {
			this.listperso.remove(inP);
			return this;
		}
		
}
