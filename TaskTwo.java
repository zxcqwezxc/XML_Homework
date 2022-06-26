import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskTwo {


    public static void main(String[] args) {
        try {

            ArrayList<Element> arrayOfElements = new ArrayList<>();
            NodeList arrayOfNodes = null;
            Node node = null;

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XMLHandler handler = new XMLHandler();
            parser.parse("settings.xml", handler);

            File input = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(input);
            NodeList nodes = doc.getElementsByTagName(XMLHandler.getArrayName());

            for (int i = 0; i < nodes.getLength(); ++i) {
                node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    arrayOfNodes = element.getChildNodes();

                    for (int j = 0; j < arrayOfNodes.getLength(); ++j) {
                        if (arrayOfNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            arrayOfElements.add((Element) arrayOfNodes.item(j));
                        }
                    }

                    arrayOfElements.sort(Comparator.comparing((Node o) -> o.getAttributes().getNamedItem(XMLHandler.getAttributeName()).getTextContent()));
                    
                }
            }
            for (int k = 0; k < arrayOfElements.size(); ++k) {
                Node buffNodeOne = arrayOfNodes.item(k);
                Node buffNodeTwo = arrayOfElements.get(k);
                node.replaceChild(buffNodeTwo, buffNodeOne);

            }
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            FileOutputStream fOutputStream = new FileOutputStream("output.xml");
            StreamResult result = new StreamResult(fOutputStream);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(TaskTwo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
