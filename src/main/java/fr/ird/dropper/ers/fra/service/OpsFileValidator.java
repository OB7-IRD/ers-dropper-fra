package fr.ird.dropper.ers.fra.service;

import fr.ird.common.log.LogService;
import org.xml.sax.SAXException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class OpsFileValidator {

    private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private String fichierXml = "formatage.xml";

    private final File opsFile;

    public OpsFileValidator(File opsFile) {
        this.opsFile = opsFile;
    }

    /**
     * Retourne le nom du fichier XML à utiliser pour valider le fichier.
     *
     * @return le nom du fichier XML
     */
    public String getFichierXml() {
        return fichierXml;
    }

    /**
     * Affecte le nom du fichier XML à utiliser pour valider le fichier.
     *
     * @param fichierXml le nom du fichier XML
     */
    public void setFichierXml(String fichierXml) {
        this.fichierXml = fichierXml;
    }

    /**
     * Vérification conformité du fichier reçu par rapport aux XSD.
     *
     * @param xsdFilepath
     * @return
     */
//    public OpsFileValidatorReport validate(String xsdFilepath) {
//        LogService.getService(OpsFileValidator.class)
//                .logApplicationDebug("validate");
//        OpsFileValidatorReport opsFileValidatorReport = new OpsFileValidatorReport();
//        XSDHandler handler = new XSDHandler(opsFileValidatorReport);
//        LogService.getService(OpsFileValidator.class)
//                .logApplicationDebug("validate - 1");
//        try {
//            SAXParserFactory spf = SAXParserFactory.newInstance();
//            spf.setNamespaceAware(true);
//            spf.setValidating(true);
//            LogService.getService(OpsFileValidator.class)
//                    .logApplicationDebug("validate - 2");
//            SAXParser sp = spf.newSAXParser();
//
//            sp.getParser().setLocale(Locale.ENGLISH);
//
//            sp.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
//            LogService.getService(OpsFileValidator.class)
//                    .logApplicationDebug("validate - 3");
//            List<String> xsds = new ArrayList<>();
//            xsds.add(xsdFilepath);
//            LogService.getService(OpsFileValidator.class)
//                    .logApplicationDebug("validate - 4");
//            for (String xsd : xsds) {
//                InputStream schemaIs = getClass().getResourceAsStream(xsd);
//                sp.setProperty(JAXP_SCHEMA_SOURCE, schemaIs);
//                sp.parse(opsFile, handler);
//            }
//            LogService.getService(OpsFileValidator.class)
//                    .logApplicationDebug("validate - 5");
//
//        } catch (FactoryConfigurationError e) {
//            LogService.getService(this.getClass()).logApplicationError(e.getMessage());
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            LogService.getService(this.getClass()).logApplicationError(e.getMessage());
//        }
//        return opsFileValidatorReport;
//    }
}
