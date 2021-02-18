package com.example.londonlandmarks;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLData {

    private Context context;
    private Landmark[] landmarks;

    public XMLData(Context c) {

        this.context = c;

        // Parse XML file
        InputStream stream = this.context.getResources().openRawResource(R.raw.data);
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);
        } catch (Exception e) {
        }

        //Get info for every tag
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList shortDescriptionList = xmlDoc.getElementsByTagName("shortDescription");
        NodeList longDescriptionList = xmlDoc.getElementsByTagName("longDescription");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList websiteList=xmlDoc.getElementsByTagName("website");
        NodeList locationList=xmlDoc.getElementsByTagName("location");


        // Extract info
        landmarks = new Landmark[nameList.getLength()];

        for (int i = 0; i < landmarks.length; i++) {

            String name = nameList.item(i).getFirstChild().getNodeValue();
            String shortDescription = shortDescriptionList.item(i).getFirstChild().getNodeValue();
            String longDescription = longDescriptionList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String website= websiteList.item(i).getFirstChild().getNodeValue();
            String location=locationList.item(i).getFirstChild().getNodeValue();

            landmarks[i] = new Landmark(name, shortDescription, longDescription, image, website,location);
        }

    }

    // Getters
    public int getLength() {
        return landmarks.length;
    }

    public Landmark getLendmark(int i) {
        return landmarks[i];
    }

    public String[] getLendmarkNames() {

        String names[] = new String[getLength()];

        for (int i = 0; i < names.length; i++) {
            names[i] = getLendmark(i).getName();
        }

        return names;
    }

    public String[] getLendmarkShortDesc() {

        String shDescription[] = new String[getLength()];

        for (int i = 0; i < shDescription.length; i++) {
            shDescription[i] = getLendmark(i).getShortDescription();
        }

        return shDescription;
    }

    public String[] getLendmarkLongDescription() {

        String longDescriptions[] = new String[getLength()];

        for (int i = 0; i < longDescriptions.length; i++) {
            longDescriptions[i] = getLendmark(i).getLongDescription();
        }

        return longDescriptions;
    }

    public String[] getLendmarksImages() {

        String images[] = new String[getLength()];

        for (int i = 0; i < images.length; i++) {
            images[i] = getLendmark(i).getImage();
        }

        return images;
    }

    public String[] getLandmarksWebsite(){
        String websites[] = new String[getLength()];

        for (int i = 0; i < websites.length; i++) {
            websites[i] = getLendmark(i).getWebsite();
        }
        return websites;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public int[] getImagesInt() {
        int[] images = new int[getLength()];

        for (int i = 0; i < getLength(); i++) {
            String imageName = getLendmark(i).getImage().substring(0, getLendmark(i).getImage().lastIndexOf('.'));
            images[i] = context.getResources().getIdentifier(imageName, "drawable", context.getOpPackageName());
        }
        return images;
    }

    public List<Landmark> getLendmarks(){
        return Arrays.asList(landmarks);
    }

    public String[] getLandmarksLocations(){
        String locations[] = new String[getLength()];

        for (int i = 0; i < locations.length; i++) {
            locations[i] = getLendmark(i).getWebsite();
        }
        return locations;
    }

}
