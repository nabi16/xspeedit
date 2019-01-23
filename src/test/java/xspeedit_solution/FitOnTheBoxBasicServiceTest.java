/**
 * 
 */
package xspeedit_solution;

import static org.junit.Assert.*;

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
import com.vsct.xspeedit.services.FitOnTheBoxBasicService;
import com.vsct.xspeedit.util.Config;

/**
 * @author sebarin
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:xspeedit-solution-test.properties")
public class FitOnTheBoxBasicServiceTest {

	@TestConfiguration
	static class FitOnTheBoxBasicServiceContextConfiguration {

		@Bean
		public FitOnTheBoxBasicService fitOnTheBoxBasicService() {
			return new FitOnTheBoxBasicService();
		}

		@Bean
		Config conf() {
			return new Config();
		}
	}

	@Autowired
	private FitOnTheBoxBasicService fitOnTheBoxBasic;

	@Autowired
	private Config conf;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	@Test(expected = XspeeditIllegalException.class)
	public void fitOnTheBoxTestNoArgs() throws XspeeditIllegalException {
		fitOnTheBoxBasic.fitOnTheBox(null, conf.CAPACITY);
	}

	@Test(expected = XspeeditIllegalException.class)
	public void fitOnTheBoxTestManyArgs() throws XspeeditIllegalException {
		String[] args = { "123456789", "987654321" };
		fitOnTheBoxBasic.fitOnTheBox(args, conf.CAPACITY);
	}

	@Test(expected = NumberFormatException.class)
	public void fitOnTheBoxTestArgsWrongType() throws NumberFormatException, XspeeditIllegalException {
		String[] args = { "ABCDEFGHI" };
		fitOnTheBoxBasic.fitOnTheBox(args, conf.CAPACITY);
	}

	@Test
	public void fitOnTheBox() throws NumberFormatException, XspeeditIllegalException {
		String[] args = { "163841689525773" };
		BoxPack boxPack = fitOnTheBoxBasic.fitOnTheBox(args, conf.CAPACITY);
		assertTrue(boxPack.getBoxes().size() == 10);
	}
}
