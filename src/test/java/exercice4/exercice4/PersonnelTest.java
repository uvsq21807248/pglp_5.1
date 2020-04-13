package exercice4.exercice4;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PersonnelTest {
	@Test
	
	public void test() {
		List<Integer>  numero= new ArrayList<Integer>()  ;
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        assertTrue(p.getNom().equals("hajar") && p.getPrenom() == "atmani" &&
                p.getDateNaissance().equals(LocalDate.of(1955, 05, 02)) );
	}

	@Test
	public void TestSerialize() {
		List<Integer>  numero= new ArrayList<Integer>()  ;
    	numero.add(18121595);
    	numero.add(2468516);
        Personnel p = new Personnel.Builder("hajar", "atmani", LocalDate.of(1955, 05, 02), numero).build();
        
        p.serialize("person.ser");
        Personnel p2 = Personnel.deserialize("person.ser");
        File f = new File("person.ser");
        f.delete();
        assertTrue(p.toString().equals(p2.toString()));
	}
	
	@Test
    public void testEchecDeserialize() {
	    Personnel c = Personnel.deserialize("cc");
        assertNull(c);
    }

	
}
