package com.epam.task4.builder;

import com.epam.task4.parsing.DeviceHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class DeviceSaxBuilder extends AbstractDeviceBuilder {
    private DeviceHandler deviceHandler;
    private XMLReader xmlReader;
    private static final Logger LOGGER = LogManager.getLogger(DeviceSaxBuilder.class);

    public DeviceSaxBuilder(){
        deviceHandler = new DeviceHandler();

        try{
            xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xmlReader.setContentHandler(deviceHandler);
        } catch (SAXException | ParserConfigurationException e) {
            LOGGER.fatal("Exception while creating xml reader.",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void buildDeviceSet(String fileName) {
        LOGGER.debug("Building device set.");

        try{
            xmlReader.parse(fileName);
        } catch (SAXException | IOException e) {
            LOGGER.fatal("Exception while parsing devices.",e);
            throw new RuntimeException(e);
        }
        pcComponentSet = deviceHandler.getPcComponentSet();
        phoneSet = deviceHandler.getPhoneSet();
    }
}
