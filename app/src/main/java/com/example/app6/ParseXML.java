package com.example.app6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class ParseXML extends AppCompatActivity {

    TextView tvCity, tvLatitude, tvLongitude, tvTemperature, tvHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parsexml);

        tvCity = findViewById(R.id.citynameval);
        tvLatitude = findViewById(R.id.latitudeval);
        tvLongitude = findViewById(R.id.longitudeval);
        tvTemperature = findViewById(R.id.temperatureval);
        tvHumidity = findViewById(R.id.humidityval);

        try {
            InputStream is = getAssets().open("city.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element rootTag = doc.getDocumentElement();
            rootTag.normalize();
            NodeList nodeList = doc.getElementsByTagName("citydetails");

            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element everyTagUnderRoot = (Element) node;
                tvCity.setText(getValue("cityname", everyTagUnderRoot));
                tvLatitude.setText(getValue("latitude", everyTagUnderRoot));
                tvLongitude.setText(getValue("longitude", everyTagUnderRoot));
                tvTemperature.setText(getValue("temperature", everyTagUnderRoot));
                tvHumidity.setText(getValue("humidity", everyTagUnderRoot));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}