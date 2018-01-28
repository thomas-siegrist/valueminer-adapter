package ch.valueminer.model;

import java.io.Serializable;

/**
 * Created by thomas on 21.01.18.
 */
public class FoobotData implements Serializable {

    private final String deviceId;
    private final Long timestamp;
    private final String json;

    public FoobotData(String deviceId, Long timestamp, String json) {
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.json = json;
    }

    public String getDeviceId() {
        return deviceId;
    }


    public Long getTimestamp() {
        return timestamp;
    }


    public String getJson() {
        return json;
    }


}
