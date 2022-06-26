import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class XMLHandler extends DefaultHandler {

    private static final String ARRAYREGEX = "array";
    private static final String ATTRIBUTENAMEREGEX = "attributeName";
    private static String arrayName = "";
    private static String attributeName = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(ARRAYREGEX)) {
            arrayName = attributes.getValue("name");
        }
        if (qName.equals(ATTRIBUTENAMEREGEX)) {
            attributeName = attributes.getValue("value");
        }
    }

    public static String getArrayName() {
        return arrayName;
    }

    public static String getAttributeName() {
        return attributeName;
    }
}
