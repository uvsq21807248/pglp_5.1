package exercice4.exercice4;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.junit.Test;

public class AffichageParGroupeTest {
	@Test
	public void test() {
		CompositePersonnels c1 = new CompositePersonnels();
    	CompositePersonnels c2 = new CompositePersonnels();
    	CompositePersonnels c3 = new CompositePersonnels();
    	CompositePersonnels c4 = new CompositePersonnels();
    	CompositePersonnels c5 = new CompositePersonnels();
    	CompositePersonnels c6 = new CompositePersonnels();
    	CompositePersonnels c7 = new CompositePersonnels();
    	List<Integer> numero = new ArrayList<Integer>();
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder(
        	"hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        c7.add(p);
        c4.add(c6);
        c4.add(c7);
        c3.add(c4);
        c3.add(c5);
        c1.add(c2);
        c1.add(c3);
        AffichageParGroup apg = new AffichageParGroup();
        apg.parcoursLargeur(c1);
        Iterator<InterfacePersonnel> tmp = apg.iterator();
        
        ArrayList<InterfacePersonnel> list = new ArrayList<InterfacePersonnel>();
        ArrayList<InterfacePersonnel> list2 = new ArrayList<InterfacePersonnel>();
        
        for (; tmp.hasNext(); list.add(tmp.next()));
        list2.add(c1);
        list2.add(c2);
        list2.add(c3);
        list2.add(c4);
        list2.add(c5);
        list2.add(c6);
        list2.add(c7);
        list2.add(p);
        assertTrue(list.toString().equalsIgnoreCase(list2.toString()));
	}
	
	@Test
	public void testSerialization() {
	    CompositePersonnels c7 = new CompositePersonnels();
	    List<Integer> numero = new ArrayList<Integer>();
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder(
            "hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        c7.add(p);
        AffichageParGroup apg = new AffichageParGroup();
        apg.parcoursLargeur(c7);
        apg.serialize("c7.ser");
        AffichageParGroup apg2 = AffichageParGroup.deserialize("c7.ser");
        File f = new File("c7.ser");
        f.delete();
        assertTrue(apg.toString().equals(apg2.toString()));
	}
	
	@Test
    public void testEchecDeserialize() {
		AffichageParGroup c = AffichageParGroup.deserialize("cc");
        assertNull(c);
    }
}
