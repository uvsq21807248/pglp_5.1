package exercice4.exercice4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;

public class CompositePersonnelsTest {
	@Test

	public void testConstructeur() {
		CompositePersonnels cp = new CompositePersonnels();
		Iterator<InterfacePersonnel> ip = cp.iterator();
		assertFalse(ip.hasNext());
	}
	@Test
	
	public void testAjout() {
		CompositePersonnels cp = new CompositePersonnels();
		cp.add(new CompositePersonnels());
		Iterator<InterfacePersonnel> ip = cp.iterator();
		assertTrue(ip.hasNext());
	}
	@Test
	
	public void testSuppression() {
		CompositePersonnels cp = new CompositePersonnels();
		CompositePersonnels cp2 = new CompositePersonnels();
		InterfacePersonnel it = cp2;
		cp.add(cp2);
		cp.remove(it);
		Iterator<InterfacePersonnel> ip = cp.iterator();
		assertFalse(ip.hasNext());
	}
	
	@Test
	public void testSerialization() {
	    CompositePersonnels cp = new CompositePersonnels();
        CompositePersonnels cp2 = new CompositePersonnels();
        cp.add(cp2);
        
        cp.serialize("cp.ser");
        CompositePersonnels cp3 = CompositePersonnels.deserialize("cp.ser");
        File f = new File("cp.ser");
        f.delete();
        assertTrue(cp.toString().equals(cp3.toString()));
	}

    @Test
    public void testEchecDeserialize() {
        CompositePersonnels c = CompositePersonnels.deserialize("cc");
        assertNull(c);
    }
}
