package dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import exercice4.exercice4.Personnel;

public class DaoPersonnelTest {

    @Test
    public void testAddGet() {
        PersonnelDao dp = new PersonnelDao(null);
        List<Integer>  numero= new ArrayList<Integer>()  ;
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        dp.add(p);
        assertTrue(dp.getAll().size() == 1 && dp.getAll().get(0) == p);
    }

    @Test
    public void testRemove() {
        PersonnelDao dp = new PersonnelDao(null);
        List<Integer>  numero= new ArrayList<Integer>()  ;
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        dp.add(p);
        dp.remove(p);
        assertTrue(dp.getAll().isEmpty());
    }
    
    @Test
    public void testgetNull() {
        PersonnelDao dp = new PersonnelDao(null);
        assertNull(dp.get(0));
    }
    
    @Test
    public void testUpdate() {
        PersonnelDao dp = new PersonnelDao(null);
        List<Integer>  numero= new ArrayList<Integer>()  ;
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        dp.add(p);
        Map<String, Object> params = new HashMap<String, Object> ();
        params.put("nom", "hhh");
        params.put("prenom", "ggg");
        dp.update(p, params);
        Personnel p2 = new Personnel.Builder("hhh", "ggg", LocalDate.of(1955, 05, 02), numero).build();
        assertTrue(dp.getAll().get(0).toString().equalsIgnoreCase(p2.toString()));
    }
    
    @Test
    public void testSerialize() {
        PersonnelDao dp = new PersonnelDao(null);
        List<Integer>  numero= new ArrayList<Integer>()  ;
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        dp.add(p);
        
        dp.serialize("dp.ser");
        PersonnelDao dp2 = PersonnelDao.deserialize("dp.ser");
        File f = new File("dp.ser");
        f.delete();
        assertTrue(dp.getAll().toString().equals(dp2.getAll().toString()));
    }
    
    @Test
    public void testEchecDeserialize() {
        PersonnelDao c = PersonnelDao.deserialize("cc");
        assertNull(c);
    }

}
