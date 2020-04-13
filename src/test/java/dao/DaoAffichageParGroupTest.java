package dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import exercice4.exercice4.AffichageParGroup;
import exercice4.exercice4.CompositePersonnels;
import exercice4.exercice4.InterfacePersonnel;
import java.util.Iterator;

public class DaoAffichageParGroupTest {

    @Test
    public void testAddGet() {
    	AffichageParGroupDao dapg = new AffichageParGroupDao();
    	AffichageParGroup apg = new AffichageParGroup();
        dapg.add(apg);
        assertTrue(dapg.getAll().size() == 1 && dapg.get(apg.getId()) == apg);
    }

    @Test
    public void testRemove() {
    	AffichageParGroupDao dapg = new AffichageParGroupDao();
    	AffichageParGroup apg = new AffichageParGroup();
        dapg.add(apg);
        dapg.remove(apg);
        assertTrue(dapg.getAll().isEmpty());
    }
    
    @Test
    public void testgetNull() {
    	AffichageParGroupDao dapg = new AffichageParGroupDao();
        assertNull(dapg.get(0));
    }
    
    @Test
    public void testUpdate() {
    	AffichageParGroupDao dapg = new AffichageParGroupDao();
    	AffichageParGroup apg = new AffichageParGroup();
        CompositePersonnels c = new CompositePersonnels();
        CompositePersonnels c2 = new CompositePersonnels();
        apg.parcoursLargeur(c);
        dapg.add(apg);
        ArrayList<InterfacePersonnel> lapg = new ArrayList<InterfacePersonnel>();
        lapg.add(c);
        lapg.add(c2);
        Map<String, Object> params = new HashMap<String, Object> ();
        params.put("file", lapg);
        dapg.update(apg, params);
        boolean expected = true;
        Iterator<InterfacePersonnel> it = apg.iterator();
        for(InterfacePersonnel contain : lapg) {
            if(it.hasNext()) expected = expected && contain.toString().equals(it.next().toString());
            else expected = false;
        }
        assertTrue(expected);
    }
    
    @Test
    public void testSerialize() {
    	AffichageParGroupDao dapg = new AffichageParGroupDao();
    	AffichageParGroup apg = new AffichageParGroup();
        CompositePersonnels c = new CompositePersonnels();
        apg.parcoursLargeur(c);
        dapg.add(apg);
        
        dapg.serialize("dapg.ser");
        AffichageParGroupDao dapg2 = AffichageParGroupDao.deserialize("dapg.ser");
        File f = new File("dapg.ser");
        f.delete();
        assertTrue(dapg.getAll().toString().equals(dapg2.getAll().toString()));
    }
    
    @Test
    public void testEchecDeserialize() {
    	AffichageParGroupDao c = AffichageParGroupDao.deserialize("ccc");
        assertNull(c);
    }
}
