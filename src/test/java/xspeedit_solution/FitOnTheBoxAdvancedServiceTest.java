/**
 * 
 */
package xspeedit_solution;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsct.xspeedit.exceptions.XspeeditIllegalException;
import com.vsct.xspeedit.models.BoxPack;
import com.vsct.xspeedit.services.FitOnTheBoxAdvancedService;
import com.vsct.xspeedit.util.Config;

/**
 * @author sebarin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(
		  locations = "classpath:xspeedit-solution-test.properties")
public class FitOnTheBoxAdvancedServiceTest {
	
	@TestConfiguration
    static class FitOnTheBoxAdvancedServiceContextConfiguration {
  
        @Bean
        public FitOnTheBoxAdvancedService fitOnTheBoxAdvancedService() {
            return new FitOnTheBoxAdvancedService();
        }
        
        @Bean Config conf() {
        	return new Config();
        }
    }

	@Autowired
	private FitOnTheBoxAdvancedService fitOnTheBoxAdvanced;
	
	@Autowired
	private Config conf;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@Test(expected = XspeeditIllegalException.class)
	public void fitOnTheBoxTestNoArgs() throws XspeeditIllegalException{
		fitOnTheBoxAdvanced.fitOnTheBox(null, conf.CAPACITY);
	}
	
	@Test(expected = XspeeditIllegalException.class)
	public void fitOnTheBoxTestManyArgs() throws XspeeditIllegalException{
		String [] args = {"123456789", "987654321"};
		fitOnTheBoxAdvanced.fitOnTheBox(args, conf.CAPACITY);
	}

	@Test(expected = NumberFormatException.class)
	public void fitOnTheBoxTestArgsWrongType() throws NumberFormatException, XspeeditIllegalException{
		String [] args = {"ABCDEFGHI"};
		fitOnTheBoxAdvanced.fitOnTheBox(args, conf.CAPACITY);
	}
	
	@Test
	public void fitOnTheBox() throws NumberFormatException, XspeeditIllegalException {
		String [] args = {"163841689525773"};
		BoxPack boxPack = fitOnTheBoxAdvanced.fitOnTheBox(args, conf.CAPACITY);
		assertTrue(boxPack.getBoxes().size() == 8);
	}
}
