package Gen;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Gen {
	@Test
	public void  gen() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException{
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("gen.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	
	
	@Test
	public void  gen2() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException{
		  int cont = 5 , press = 5;
		  BigDecimal conts = new BigDecimal(cont);
		  BigDecimal pres = new BigDecimal(press);
		  System.out.println(conts.multiply(pres));
	}
}