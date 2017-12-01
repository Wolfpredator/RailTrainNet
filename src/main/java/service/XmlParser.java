package service;

import model.ParseStationNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {

    private Map<String, ArrayList<ParseStationNode>> relations;
    private ArrayList<ParseStationNode> listStationNode;

    private String stationName;
    private String relationStation;
    private int distance;


    public Map<String, ArrayList<ParseStationNode>> getData() {
        parse();
        return relations;
    }

    private void parse() {
        try {
            relations = new HashMap<>();
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/resources/Station.xml");
            NodeList stationList = document.getElementsByTagName("Station");

            for (int i = 0; i < stationList.getLength(); i++) {
                listStationNode = new ArrayList<>();
                Element element = (Element) stationList.item(i);
                NodeList relationList = element.getElementsByTagName("RelationStation");

                stationName = element.getAttribute("name");

                for (int j = 0; j < relationList.getLength(); j++) {
                    listStationNode.add(getParseStationNode((Element) relationList.item(j)));
                }
                relations.put(stationName, listStationNode);
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Файл не найден");
        }
    }

    private ParseStationNode getParseStationNode(Element elementRelation) {
        relationStation = elementRelation.getAttribute("name");
        distance = Integer.parseInt(elementRelation.getAttribute("distance"));
        return new ParseStationNode(relationStation, distance);
    }

}