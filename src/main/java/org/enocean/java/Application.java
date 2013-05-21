package org.enocean.java;

import org.enocean.java.common.ProtocolConnector;
import org.enocean.java.packets.BasicPacket;
import org.enocean.java.packets.RemoteCommand4BSTeachIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        logger.info("starting..");
        String port = args[0];
        ProtocolConnector connector = new EnoceanSerialConnector();
        connector.connect(port);
        ESP3Host esp3Host = new ESP3Host(connector);
        BasicPacket packet = new RemoteCommand4BSTeachIn();
        esp3Host.sendRadio(packet);
        esp3Host.receiveRadio();
    }
}