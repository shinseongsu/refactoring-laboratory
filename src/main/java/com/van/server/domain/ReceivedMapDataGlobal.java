package com.van.server.domain;

import java.util.HashMap;

public class ReceivedMapDataGlobal {

    public static HashMap<String, ReceivedLinkedData> receivedMapDataGlobal;

    public static HashMap<String, ReceivedLinkedData> getReceivedMapDataGlobal() {
        return receivedMapDataGlobal;
    }

    public static void setReceivedMapDataGlobal(HashMap<String, ReceivedLinkedData> receivedMapDataGlobal) {
        ReceivedMapDataGlobal.receivedMapDataGlobal = receivedMapDataGlobal;
    }
}
