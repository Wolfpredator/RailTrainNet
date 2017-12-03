package service;

import model.RailwayNetwork;
import model.Train;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TrainXmlParser {


    public void getTrain() {
        try {
            String from, to;

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/resources/Trains.xml");
            NodeList stationList = document.getElementsByTagName("Train");


            for (int i = 0; i < stationList.getLength(); i++) {
                Element trainXmlElement = (Element) stationList.item(i);

                from = trainXmlElement.getAttribute("from");
                to = trainXmlElement.getAttribute("to");

                new Train(from, to);

            }
            } catch(ParserConfigurationException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            } catch(SAXException e){
                e.printStackTrace();
            }
        }
    }
