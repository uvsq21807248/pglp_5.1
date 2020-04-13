package dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exercice4.exercice4.AffichageParGroup;
import exercice4.exercice4.CompositePersonnels;
import exercice4.exercice4.Personnel;

public class DaoFactoryTest {
	   @Test
	    public void testDaoPersonnel() {
	        Dao<Personnel> dao = FactoryDao.getDaoPersonnel(null);
	        assertTrue(dao.getAll().isEmpty());
	    }

	    @Test
	    public void testDaoCompositePersonnels() {
	        Dao<CompositePersonnels> dao = FactoryDao.getDaoCompositePersonnels(null);
	        assertTrue(dao.getAll().isEmpty());
	    }
	    
	    @Test
	    public void testDaoAfficheParGroupe() {
	        Dao<AffichageParGroup> dao = FactoryDao.getDaoAfficheParGroupe(null);
	        assertTrue(dao.getAll().isEmpty());
	    }
	    
	    @Test
	    public void testDaoPersonnelDeserialize() {
	        PersonnelDao dp = (PersonnelDao) FactoryDao.getDaoPersonnel(null);
	        List<Integer>  numero= new ArrayList<Integer>()  ;
	    	numero.add(18121595);
	    	numero.add(2468516);
	        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
	        dp.add(p);
	        dp.serialize("dp.ser");
	        PersonnelDao dp2 = PersonnelDao.deserialize("dp.ser");
	        File f = new File("dp.ser");
	        f.delete();
	        assertTrue(dp2.get(p.getId()).getNom().equals("hajar") && dp2.get(p.getId()).getPrenom().equals("atmani"));
	    }

	    @Test
	    public void testDaoCompositePersonnelsDeserialize() {
	        CompositePersonnelsDao dcp = (CompositePersonnelsDao) FactoryDao.getDaoCompositePersonnels(null);
	        CompositePersonnels cp = new CompositePersonnels();
	        dcp.add(cp);
	        dcp.serialize("dcp.ser");
	        CompositePersonnelsDao dcp2 = (CompositePersonnelsDao) FactoryDao.getDaoCompositePersonnels("dcp.ser");
	        File f = new File("dcp.ser");
	        f.delete();
	        assertTrue(dcp.getAll().toString().equals(dcp2.getAll().toString()));
	    }
	    
	    @Test
	    public void testDaoAfficheParGroupeDeserialize() {
	    	AffichageParGroupDao dapg = (AffichageParGroupDao) FactoryDao.getDaoAfficheParGroupe(null);
	    	AffichageParGroup apg = new AffichageParGroup();
	        CompositePersonnels c = new CompositePersonnels();
	        apg.parcoursLargeur(c);
	        dapg.add(apg);
	        
	        dapg.serialize("dapg.ser");
	        AffichageParGroupDao dapg2 = (AffichageParGroupDao) FactoryDao.getDaoAfficheParGroupe("dapg.ser");
	        File f = new File("dapg.ser");
	        f.delete();
	        assertTrue(dapg.getAll().toString().equals(dapg2.getAll().toString()));
	    }
	    
	    @Test
	    public void testDaoPersonnelEchec() {
	        assertNull(FactoryDao.getDaoPersonnel("file"));
	    }
	    
	    @Test
	    public void testDaoCompositePersonnelsEchec() {
	        assertNull(FactoryDao.getDaoCompositePersonnels("file"));
	    }
	    
	    @Test
	    public void testDaoAfficheParGroupeEchec() {
	        assertNull(FactoryDao.getDaoAfficheParGroupe("file"));
	    }
}
