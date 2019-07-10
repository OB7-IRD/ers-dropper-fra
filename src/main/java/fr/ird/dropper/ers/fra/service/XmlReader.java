package fr.ird.dropper.ers.fra.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import fr.ird.common.log.LogService;
import fr.ird.dropper.ers.fra.business.*;

/**
 * Classe permettant de lire un fichier XML et de le transformer en Ops.
 *
 * @author christelle.jeanberne
 */
public class XmlReader {

    private static XStream xstream;

    public static void initXstreamParser() {

        StaxDriver staxDriver = new StaxDriver( /* qmap */);
        xstream = new XStream(staxDriver);

        xstream.processAnnotations(Bti.class);
        xstream.processAnnotations(Coe.class);
        xstream.processAnnotations(Cor.class);
        xstream.processAnnotations(Cox.class);
        xstream.processAnnotations(Cro.class);
        xstream.processAnnotations(Css.class);
        xstream.processAnnotations(Cst.class);
        xstream.processAnnotations(Cvo.class);
        xstream.processAnnotations(Cvt.class);
        xstream.processAnnotations(Dat.class);
        xstream.processAnnotations(Del.class);
        xstream.processAnnotations(Dep.class);
        xstream.processAnnotations(Dis.class);
        xstream.processAnnotations(Don.class);
        xstream.processAnnotations(Ecps.class);
        xstream.processAnnotations(Ecss.class);
        xstream.processAnnotations(Ecst.class);
        xstream.processAnnotations(Edci.class);
        xstream.processAnnotations(Edep.class);
        xstream.processAnnotations(Efad.class);
        xstream.processAnnotations(Efar.class);
        xstream.processAnnotations(Eger.class);
        xstream.processAnnotations(Elog.class);
        xstream.processAnnotations(Emav.class);
        xstream.processAnnotations(Eof.class);
        xstream.processAnnotations(Epfa.class);
        xstream.processAnnotations(Eras.class);
        xstream.processAnnotations(Ers.class);
        xstream.processAnnotations(Ertp.class);
        xstream.processAnnotations(Esal.class);
        xstream.processAnnotations(Esli.class);
        xstream.processAnnotations(Espe.class);
        xstream.processAnnotations(Etli.class);
        xstream.processAnnotations(Etrc.class);
        xstream.processAnnotations(Etrn.class);
        xstream.processAnnotations(Etts.class);
        xstream.processAnnotations(Evzo.class);
        xstream.processAnnotations(Far.class);
        xstream.processAnnotations(Gea.class);
        xstream.processAnnotations(Ger.class);
        xstream.processAnnotations(Ges.class);
        xstream.processAnnotations(Gil.class);
        xstream.processAnnotations(Gls.class);
        xstream.processAnnotations(Ins.class);
        xstream.processAnnotations(Jci.class);
        xstream.processAnnotations(Lan.class);
        xstream.processAnnotations(Log.class);
        xstream.processAnnotations(Ops.class);
        xstream.processAnnotations(Pfp.class);
        xstream.processAnnotations(Pno.class);
        xstream.processAnnotations(Pnt.class);
        xstream.processAnnotations(Pos.class);
        xstream.processAnnotations(Pro.class);
        xstream.processAnnotations(Que.class);
        xstream.processAnnotations(Ras.class);
        xstream.processAnnotations(Rec.class);
        xstream.processAnnotations(Ret.class);
        xstream.processAnnotations(Rlc.class);
        xstream.processAnnotations(Rsp.class);
        xstream.processAnnotations(Rtp.class);
        xstream.processAnnotations(Sal.class);
        xstream.processAnnotations(Siz.class);
        xstream.processAnnotations(Sli.class);
        xstream.processAnnotations(Spe.class);
        xstream.processAnnotations(Src.class);
        xstream.processAnnotations(Tli.class);
        xstream.processAnnotations(Tra.class);
        xstream.processAnnotations(Trn.class);
        xstream.processAnnotations(Trz.class);
    }

    /**
     * Lit un fichier XML et le transforme en Ops.
     *
     * @param fileName
     * @return Ops
     */
    public static Ops parse(InputStream fileStream) {
        UnicodeReader ins = null;

        ins = new UnicodeReader(fileStream, "UTF-8");

        return (Ops) xstream.fromXML(ins);
    }

    /**
     * Lit un fichier XML et le transforme en Ops.
     *
     * @param fileName
     * @return Ops
     */
    public static Ops parse(String fileName) {
        try {
            FileInputStream stream = new FileInputStream(new File(fileName));
            Ops ops = parse(stream);
            stream.close();
            return ops;
        } catch (FileNotFoundException e) {
            LogService.getService().logParseError(fileName, e.getMessage());
            return null;
        } catch (IOException e) {
            LogService.getService().logParseError(fileName, e.getMessage());
            return null;
        }
    }

    /**
     * Lit un fichier et le met dans une chaîne de caractères.
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static String readFile(String fileName) throws FileNotFoundException {
        String content = readFile(new FileInputStream(fileName));
        return content;
    }

    /**
     * Lit un flux et le met dans une chaîne de caractères.
     *
     * @param flux
     * @return
     */
    public static String readFile(InputStream flux) {
        StringBuffer fileContents = new StringBuffer();
        try {
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String line;
            while ((line = buff.readLine()) != null) {
                fileContents.append(line);
            }
            buff.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return fileContents.toString();
    }

    public static void main(String[] args) {
        InputStream is = new XmlReader().getClass().getResourceAsStream("/testAdrian.xml");

        XmlReader.initXstreamParser();

        UnicodeReader ins = null;

        ins = new UnicodeReader(is, "UTF-8");

        xstream.fromXML(ins);
    }
}
