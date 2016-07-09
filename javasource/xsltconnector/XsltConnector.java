package xsltconnector;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by ako on 9-7-2016.
 */
public class XsltConnector {
    private static final ILogNode logger = Core.getLogger(XsltConnector.class.getName());

    public String transform(String xmlInput, String xsltTemplate) throws TransformerException {
        logger.info("transform");
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new StringReader(xsltTemplate));

        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(xmlInput));
        StringWriter out = new StringWriter();
        transformer.transform(text, new StreamResult(out));
        return out.toString();
    }
}
