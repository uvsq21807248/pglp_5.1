package exercice4.exercice4;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
  
    public void testApp()
    {
		Personnel p1;
		Personnel p2;
		Personnel p3;
		Personnel p4;
		CompositePersonnels composite_1;
		InterfacePersonnel intr ;
		p1= new Personnel.Builder(0, "aa", "jj",LocalDate.parse("1996-20-03",DateTimeFormatter.ISO_DATE)).build();
		p2= new Personnel.Builder(0, "bb", "kk",LocalDate.parse("1999-08-29",DateTimeFormatter.ISO_DATE)).build();
		p3= new Personnel.Builder(0, "cc", "ll",LocalDate.parse("1991-31-05",DateTimeFormatter.ISO_DATE)).build();
		p4= new Personnel.Builder(0, "dd", "nn",LocalDate.parse("2004-03-01",DateTimeFormatter.ISO_DATE)).build();
				 
			
    	
    }
}
