package exercise1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXML {
    String filePath = "student.xml";

    public void parseAndPrintStudentDetails(String filePath) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(filePath);
            document.normalizeDocument();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("student");

            // Iterate through each "student" element
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("\nStudent " + (i + 1) + ":");
                    // Extract data from the node
                    System.out.println("Name: " + extractNode(node, "name"));
                    System.out.println("Age: " + extractNode(node, "age"));
                    System.out.println("Subject: " + extractNode(node, "subject"));
                    System.out.println("Gender: " + extractNode(node, "gender"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractNode(Node parentNode, String tagName) {
        NodeList nodeList = parentNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(tagName)) {
                return node.getTextContent();
            }
        }
        return "Not Available";
    }

    public static void main(String[] args) {
        ReadXML readXML = new ReadXML();
        readXML.parseAndPrintStudentDetails("student.xml");
    }
}