package dao;

import exercice4.exercice4.AffichageParGroup;
import exercice4.exercice4.CompositePersonnels;
import exercice4.exercice4.Personnel;

public class FactoryDao {
	 
	  
    private FactoryDao() {
    }
   
    public static Dao<Personnel> getDaoPersonnel(final String deserialize) {
        if (deserialize == null) {
            return new PersonnelDao(null);
        } else {
            return PersonnelDao.deserialize(deserialize);
        }
    }
  
    public static Dao<CompositePersonnels>
    getDaoCompositePersonnels(final String deserialize) {
        if (deserialize == null) {
            return new CompositePersonnelsDao(null);
        } else {
            return CompositePersonnelsDao.deserialize(deserialize);
        }
    }
   
    public static Dao<AffichageParGroup>
    getDaoAfficheParGroupe(final String deserialize) {
        if (deserialize == null) {
            return new AffichageParGroupDao();
        } else {
            return AffichageParGroupDao.deserialize(deserialize);
        }
    }
    

}
