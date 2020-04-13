package dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import exercice4.exercice4.CompositePersonnels;
import exercice4.exercice4.InterfacePersonnel;

public class DaoCompositePersonnelsTest {
	 @Test
	    public void testAddGet() {
	        CompositePersonnelsDao dcp = new CompositePersonnelsDao(null);
	        CompositePersonnels cp = new CompositePersonnels();
	        dcp.add(cp);
	        assertTrue(dcp.getAll().size() == 1 && dcp.get(cp.getId()) == cp);
	    }

	    @Test
	    public void testRemove() {
	    	CompositePersonnelsDao dcp = new CompositePersonnelsDao(null);
	        CompositePersonnels cp = new CompositePersonnels();
	        dcp.add(cp);
	        dcp.remove(cp);
	        assertTrue(dcp.getAll().isEmpty());
	    }
	    
	    @Test
	    public void testgetNull() {
	    	CompositePersonnelsDao dcp = new CompositePersonnelsDao(null);
	        assertNull(dcp.get(0));
	    }
	    
	    @Test
	    public void testUpdate() {
	    	CompositePersonnelsDao dcp = new CompositePersonnelsDao(null);
	        CompositePersonnels cp = new CompositePersonnels();
	        CompositePersonnels cp2 = new CompositePersonnels();
	        CompositePersonnels cp3 = new CompositePersonnels();
	        cp.add(cp2);
	        cp.add(cp3);
	        dcp.add(cp);
	        Map<String, Object> params = new HashMap<String, Object> ();
	        params.put("personnels", new ArrayList<InterfacePersonnel> ());
	        dcp.update(cp, params);
	        String s = "Id : " + cp.getId() + "\n";
	        assertTrue(dcp.get(cp.getId()).toString().equals(s));
	    }
	    
	    @Test
	    public void testSerialize() {
	    	CompositePersonnelsDao dcp = new CompositePersonnelsDao(null);
	        CompositePersonnels cp = new CompositePersonnels();
	        dcp.add(cp);
	        
	        dcp.serialize("dcp.ser");
	        CompositePersonnelsDao dcp2 = CompositePersonnelsDao.deserialize("dcp.ser");
	        File f = new File("dcp.ser");
	        f.delete();
	        assertTrue(dcp.getAll().toString().equals(dcp2.getAll().toString()));
	    }
	    
	    @Test
	    public void testEchecDeserialize() {
	    	CompositePersonnelsDao c = CompositePersonnelsDao.deserialize("cc");
	        assertNull(c);
	    }
}
