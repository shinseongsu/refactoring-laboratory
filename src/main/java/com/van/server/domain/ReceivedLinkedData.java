package com.van.server.domain;

import java.util.LinkedHashMap;

public class ReceivedLinkedData {

    LinkedHashMap<String, String> receivedLinkedHashMap;

    public LinkedHashMap<String, String> getReceivedLinkedHashMap() {
        return receivedLinkedHashMap;
    }

    public void setReceivedLinkedHashMap(LinkedHashMap<String, String> receivedLinkedHashMap) {
        this.receivedLinkedHashMap = receivedLinkedHashMap;
    }

    @Override
    public String toString() {
        return "ReceivedLinkedData{" +
                "receivedLinkedHashMap=" + receivedLinkedHashMap +
                '}';
    }
}
