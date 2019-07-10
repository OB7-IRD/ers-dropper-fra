package fr.ird.dropper.ers.fra.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import fr.ird.dropper.ers.fra.business.*;


/**
 * Classe permettant d'écrire un fichier XML à partir d'un Ops.
 * 
 * @author christelle.jeanberne
 */
public class XmlWriter {

	/**
	 * Crée un fichier XML à partir de son nom et d'un Ops
	 * 
	 * @param ops
	 * @param fileName
	 */
	public void Writer(Ops ops, String fileName) {
		QNameMap qmap = new QNameMap();
		qmap.setDefaultNamespace(Constant.XMLNS);
		qmap.setDefaultPrefix( Constant.SENT_NAMESPACE );
		StaxDriver staxDriver = new StaxDriver(qmap);
			
		XStream xstream = new XStream( staxDriver );

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
		
		try {
			OutputStreamWriter bufferedWriter =
			   new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"); 

			// On détermine l'entête qui est éventuellement ajoutée au fichier
			String defaultHeader = "";
			String minimalXmlOutput = xstream.toXML(null);
			String namespace = "";
			if (!Constant.SENT_NAMESPACE.isEmpty()) {
				namespace = Constant.SENT_NAMESPACE + ":";
			}
			int pos=minimalXmlOutput.indexOf("<" + namespace + "null");
			if (pos >= 0) {
				defaultHeader = minimalXmlOutput.substring(0,pos);
			}
			
			String result = xstream.toXML(ops);
			
			// On écrit le fichier en précisant l'entête UTF-8
			StringBuilder sb = new StringBuilder(result.length());
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				sb.append(result.substring(defaultHeader.length()));
				bufferedWriter.append(sb.toString());
			
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}