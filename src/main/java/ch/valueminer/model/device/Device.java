package ch.valueminer.model.device;

import ch.valueminer.model.device.status.Status;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by thomas on 28.01.18.
 */
public class Device implements Serializable {

    private final String deviceType;
    private final String deviceId; // unique
    private final Status status;

    public Device(String deviceId, Status status, String deviceType) {
        this.deviceId = deviceId;
        this.status = status;
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Status getStatus() {
        return status;
    }

    public String getDeviceType() {
        return deviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        return deviceId.equals(device.deviceId);

    }

    @Override
    public int hashCode() {
        return deviceId.hashCode();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}
