package exercice4.exercice4;
import java.util.ArrayList;
public class AffichageParGroup {
	 private ArrayList list;
	    
	   public void afficheGroupe() {
		   
	   }
		
		private class GroupIterator implements Iterator{
	        
			public GroupIterator() {
				int verif=0;
				while(verif<list.size()){
					if (list.get(verif) instanceof CompositePersonnels) {
						
						for( InterfacePersonnel pers: ((CompositePersonnels)list.get(verif)).listperso )
						list.add(pers);
					}
				}
			}
			private int index;
			public boolean hasNext() {
				
				if(index<list.size()) {
					return true;
				}
				// TODO Auto-generated method stub
				return false;
			}

			public InterfacePersonnel next() {
				// TODO Auto-generated method stub
				return null;
			}
			
		}
		
		public Iterator getIterator() {
			return new GroupIterator();
			
		}
}
