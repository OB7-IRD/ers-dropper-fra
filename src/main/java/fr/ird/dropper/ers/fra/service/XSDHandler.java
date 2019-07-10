package fr.ird.dropper.ers.fra.service;

import fr.ird.common.log.LogService;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author christelle.jeanberne
 *
 */
public class XSDHandler extends DefaultHandler {
    
    OpsFileValidatorReport opsFileValidatorReport = new OpsFileValidatorReport();
    
    public XSDHandler(OpsFileValidatorReport opsFileValidatorReport) {
        this.opsFileValidatorReport = opsFileValidatorReport;
    }
    
    public void fatalError(SAXParseException e) {
        String message = buildMessage(e);
        LogService.getService(this.getClass()).logApplicationError("Erreur fatale :" + message);
        opsFileValidatorReport.addEntree(message);
    }
    
    public void error(SAXParseException e) {
        String message = buildMessage(e);
        LogService.getService(this.getClass()).logApplicationError("Erreur :" + message);
        opsFileValidatorReport.addEntree(message);
    }
    
    public void warning(SAXParseException e) {
        String message = buildMessage(e);
        LogService.getService(this.getClass()).logApplicationWarn("Warning :" + message);
        opsFileValidatorReport.addEntree(message);
    }
    
    private String buildMessage(SAXParseException e) {
        return "Line: " + e.getLineNumber() + " Column: " + e.getColumnNumber() + " Error: " + e.getMessage();
    }

    /**
     * Doit etre surchargee dans le cas de l'inclusion des fichiers XSD pour
     * résoudre correctement le chemin des XSD dans le workspace
     */
    @Override
    public InputSource resolveEntity(String arg0, String arg1)
            throws IOException, SAXException {
        File tmp = new File(arg1);
        InputSource is = null;
        try {
            LogService.getService(this.getClass()).logApplicationDebug("" + getClass().getResource("/v3/" + tmp.getName()).toURI());
            is = new InputSource(new FileInputStream(new File(getClass().getResource("/v3/" + tmp.getName()).toURI())));
        } catch (URISyntaxException e) {
        }
        return is;
    }
}
