package fr.ird.dropper.ers.fra.config;

/*
 * Copyright (C) 2019 Ob7 - IRD
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import fr.ird.common.configuration.IRDProperties;
import fr.ird.common.log.LogService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The ERSProperties class represents a persistent set of properties. This
 * properties are stored in the file "ers-dropper-config.xml".
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 *
 */
public class ERSDropperProperties extends IRDProperties {

    private static final ERSDropperProperties service = new ERSDropperProperties();

    public static ERSDropperProperties getService() {
        return service;
    }

    private ERSDropperProperties() {
        PROJECT_NAME = "ers-dropper-fra";
        PROJECT_CONFIG_FILENAME = "ers-dropper-fra-config.xml";
        PROJECT_CONFIG_COMMENT = "ERS Dropper FRA Service configuration's properties";

    }
    /**
     * The XML key to access the value of JDBC username.
     */
    public static final String KEY_JDBC_USERNAME = "jdbc_username";
    /**
     * The XML key to access the value of JDBC password.
     */
    public static final String KEY_JDBC_PASSWORD = "jdbc_password";
    /**
     * The XML key to access the value of JDBC URL.
     */
    public static final String KEY_JDBC_URL = "jdbc_url";
    /**
     * The XML key to access the value of JDBC DRIVER CLASS.
     */
    public static final String KEY_JDBC_DRIVER_CLASS = "jdbc_driver";
    /**
     * The JDBC username to the database access.
     */
    public static String JDBC_USERNAME;
    /**
     * The JDBC password to the database access.
     */
    public static String JDBC_PASSWORD;
    /**
     * The JDBC url to locate the database.
     */
    public static String JDBC_URL;
    /**
     * The JDBC driver class to load the database.
     */
    public static String JDBC_DRIVER_CLASS;
    public static final String KEY_SEND_DIRECTORY = "repertoire_envoi";
    public static final String KEY_MESSAGE_DIRECTORY = "repertoire_depot";
    public static final String KEY_ERROR_DIRECTORY = "repertoire_erreur";
    public static final String KEY_PROCESSED_DIRECTORY = "repertoire_traites";
    public static final String KEY_FORMAT_XML_OPS = "formatage_xml_ops";
    public static final String KEY_FORMAT_XML_ERS = "formatage_xml_ers";
    public static final String KEY_FORMAT_XML_VALUE = "formatage_xml_valeurs";
    public static final String KEY_FORMAT_XML = "formatage_xml";
    public static final String KEY_EUROPEAN_FORMAT_XML = "formatageEuropeen_xml";
    public static String ERROR_DIRECTORY;
    public static String SEND_DIRECTORY;
    public static String MESSAGE_DIRECTORY;
    public static String MESSAGE_V1_DIRECTORY;
    public static String PROCESSED_DIRECTORY;
    public static String QUE_V1_DIRECTORY;
    public static String FORMAT_XML_OPS;
    public static String FORMAT_XML_ERS;
    public static String FORMAT_XML_VALUE;
    public static String FORMAT_XML;
    public static String EUROPEAN_FORMAT_XML;

    /**
     * Initialize the loading of properties.
     */
    public void init() {
        LogService.getService().logApplicationInfo("Initialisation du module de gestion des propriétés «ERS Dropper».");
        try {
            if (!configFileExist()) {
                createConfigFile();
            }
            Properties p = loadProperties();

            ERSDropperProperties.JDBC_USERNAME = p.getProperty(KEY_JDBC_USERNAME);
            ERSDropperProperties.JDBC_PASSWORD = p.getProperty(KEY_JDBC_PASSWORD);
            ERSDropperProperties.JDBC_URL = p.getProperty(KEY_JDBC_URL);
            ERSDropperProperties.JDBC_DRIVER_CLASS = p.getProperty(KEY_JDBC_DRIVER_CLASS);
            ERSDropperProperties.SEND_DIRECTORY = p.getProperty(KEY_SEND_DIRECTORY);
            ERSDropperProperties.ERROR_DIRECTORY = p.getProperty(KEY_ERROR_DIRECTORY);
            ERSDropperProperties.MESSAGE_DIRECTORY = p.getProperty(KEY_MESSAGE_DIRECTORY);
            ERSDropperProperties.PROCESSED_DIRECTORY = p.getProperty(KEY_PROCESSED_DIRECTORY);
            ERSDropperProperties.FORMAT_XML_OPS = p.getProperty(KEY_FORMAT_XML_OPS);
            ERSDropperProperties.FORMAT_XML_ERS = p.getProperty(KEY_FORMAT_XML_ERS);
            ERSDropperProperties.FORMAT_XML_VALUE = p.getProperty(KEY_FORMAT_XML_VALUE);
            ERSDropperProperties.FORMAT_XML = p.getProperty(KEY_FORMAT_XML);
            ERSDropperProperties.EUROPEAN_FORMAT_XML = p.getProperty(KEY_EUROPEAN_FORMAT_XML);

            if (ERSDropperProperties.JDBC_URL == null
                    || ERSDropperProperties.JDBC_DRIVER_CLASS == null) {
                throw new Exception("Le chargement du fichier de configuration «ers-dropper-config» a échoué.");
            }

        } catch (FileNotFoundException e) {
            LogService.getService().logApplicationError(e.getMessage());
        } catch (IOException e) {
            LogService.getService().logApplicationError(e.getMessage());

        } catch (Exception e) {
            LogService.getService().logApplicationError(e.getMessage());
        }
    }

    @Override
    public Properties createDefaultProperties() {
        Properties properties = new Properties();
        properties.setProperty(KEY_JDBC_URL, "");
        properties.setProperty(KEY_JDBC_DRIVER_CLASS, "");
        properties.setProperty(KEY_JDBC_USERNAME, "");
        properties.setProperty(KEY_JDBC_PASSWORD, "");
        properties.setProperty(KEY_SEND_DIRECTORY, "");
        properties.setProperty(KEY_ERROR_DIRECTORY, "");
        properties.setProperty(KEY_MESSAGE_DIRECTORY, "");
        properties.setProperty(KEY_PROCESSED_DIRECTORY, "");
        properties.setProperty(KEY_FORMAT_XML_OPS, "");
        properties.setProperty(KEY_FORMAT_XML_ERS, "");
        properties.setProperty(KEY_FORMAT_XML_VALUE, "");
        properties.setProperty(KEY_FORMAT_XML, "");
        properties.setProperty(KEY_EUROPEAN_FORMAT_XML, "");
        return properties;
    }

    @Override
    public void createDefaultDirectory() {
        super.createDefaultDirectory();

    }

    @Override
    public void copyDefaultFile() {

    }
}
