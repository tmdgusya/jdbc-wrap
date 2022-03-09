package reader;

import configure.Configure;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXmlConfigure implements ReadConfiguration {

    private final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder documentBuilder;

    public ReadXmlConfigure() {
        setUpDocumentBuilder();
    }

    @Override
    public Configure read(String filePath) {
        File configurationFile = new File(filePath);
        Document document = configFileToDocuments(configurationFile);
        document.getDocumentElement().normalize();

        Element documentElement = document.getDocumentElement();

        System.out.printf(documentElement.toString());

        String url = getTagValue("url", documentElement);
        String user = getTagValue("user", documentElement);
        String password = getTagValue("password", documentElement);
        String database = getTagValue("database", documentElement);

        return new Configure(url, database, user, password);
    }

    private Document configFileToDocuments(File configurationFile) {
        try {
            return this.documentBuilder.parse(configurationFile);
        } catch (SAXException e) {
            throw new IllegalArgumentException("Check Your File Path Or The File Extension is xml");
        } catch (IOException e) {
            throw new RuntimeException("Occur Exception during read xml file");
        }
    }

    private void setUpDocumentBuilder() {
        try {
            this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalArgumentException("Occur Exception Create Document Builder");
        }
    }

    private String getTagValue(String sTag, Element eElement) {
        NodeList list = eElement.getElementsByTagName(sTag);
        Element elem = (Element) list.item(0);
        Node ele = elem.getFirstChild();
        System.out.println("name    : " + ele.getNodeValue());

        return ele.getNodeValue();
    }
}
