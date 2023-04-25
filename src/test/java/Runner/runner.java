package Runner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class runner {
	@Test
    void testParallel() {

    	
    	Results results = Runner.path("classpath:testfetures/test.feature").parallel(1);
    			  			

    	System.out.println("Report Dir --- "+results.getReportDir());
 
    	generateReport(results.getReportDir());

  
    }
    
    public static void generateReport(String karateOutputPath)
    {
    	Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
		final List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		Configuration config = new Configuration(new File("target"), "Tardis_Testfeatures");
		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
		reportBuilder.generateReports();
    }

}
