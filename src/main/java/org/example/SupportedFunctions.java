package org.example;

import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.StringJoiner;

public class SupportedFunctions {
    private static final Logger logger = LoggerFactory.getLogger(SupportedFunctions.class);

    public static void main(String[] args) {
        String poiVersion = getPoiVersion();
        logger.info("Apache POI Version: {}", poiVersion);

        Collection<String> supportedFunctions = FunctionEval.getSupportedFunctionNames();
        StringJoiner supportedFunctionsLine = new StringJoiner(", ");
        for (String function : supportedFunctions) {
            supportedFunctionsLine.add(function);
        }
        logger.info("Supported Functions: {}", supportedFunctionsLine);

        Collection<String> notSupportedFunctions = FunctionEval.getNotSupportedFunctionNames();
        StringJoiner notSupportedFunctionsLine = new StringJoiner(", ");
        for (String function : notSupportedFunctions) {
            notSupportedFunctionsLine.add(function);
        }
        logger.info("Not Supported Functions: {}", notSupportedFunctionsLine);


        // Analysis ToolPak supported functions
        Collection<String> analysisToolPakFunctions = AnalysisToolPak.getSupportedFunctionNames();
        StringJoiner analysisToolPakFunctionsLine = new StringJoiner(", ");

        for (String function : analysisToolPakFunctions) {
            analysisToolPakFunctionsLine.add(function);
        }
        logger.info("Analysis ToolPak Functions: {}", analysisToolPakFunctionsLine);
    }

    private static String getPoiVersion() {
        Properties properties = new Properties();
        try (InputStream input = SupportedFunctions.class.getClassLoader().getResourceAsStream("version.properties")) {
            if (input == null) {
                logger.warn("version.properties file not found, returning Unknown.");
                return "Unknown";
            }
            properties.load(input);
            return properties.getProperty("poi.version");
        } catch (IOException ex) {
            logger.error("Failed to load POI version from properties file", ex);
            return "Unknown";
        }
    }
}



