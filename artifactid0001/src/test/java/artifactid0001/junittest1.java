package artifactid0001;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.junit.After;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.Configuration;

public class junittest1 {

	public WebDriver driver;
	mainProgram m = new mainProgram();
	Logger logger = LogManager.getLogger(junittest1.class);

	
	@Before
	public void setUp() throws Exception {

		m.set(); 

	}

	@Test
	public void test() {

		String returnurl1 = m.login();
		try{
			assertEquals("https://www.gittigidiyor.com/",returnurl1);
			logger.info("Login ba�ar�l�.");
		}
		catch (Exception e){
			logger.error("Login ba�ar�s�z.");
			m.driver.quit();
		}
		String returnurl2 = m.searchandnavigate();
		try {
			assertEquals("https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2",returnurl2);		
			logger.info("Sayfa ikide.");
		}
		catch (Exception e) {
			logger.error("Sayfa ikide de�il.");
			m.driver.quit();
		}
		boolean ret = m.chooseItem();
		try {
			assertEquals(true,ret);
			logger.info("Fiyatlar ayn�.");
		}
		catch(Exception e) {
			logger.error("Fiyatlar farkl�.");
			m.driver.quit();

		}
		String returnvalue = m.count();
		try {
			assertEquals("2",returnvalue);
			logger.info("�ki �r�n se�ildi");
		}
		catch(Exception e) {
			logger.error("�ki �r�n se�ilemedi.");
			m.driver.quit();

		}
		int emptied = m.empty();
		try {
			assertEquals(0,emptied);
			logger.info("�r�n silindi.");
		}
		catch(Exception e) {
			logger.error("�r�n silinemedi.");
			m.driver.quit();

		}
	}
	/*
	@After
	
	
	    public void endTest() {
	        driver.quit();
	        
	    }
	 */
}
