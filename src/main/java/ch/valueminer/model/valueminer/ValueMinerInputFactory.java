package ch.valueminer.model.valueminer;

import ch.valueminer.model.FoobotData;
import ch.valueminer.model.device.Device;
import ch.valueminer.utils.JsonUtil;

/**
 * Created by thomas on 21.01.18.
 */
public class ValueMinerInputFactory {

    // ----------------------------------------------------------
    // Device
    // ----------------------------------------------------------
    public static ValueMinerInput from(Device device) {
        ValueMinerInput valueMinerInput = new ValueMinerInput();
        valueMinerInput.setTimestamp(System.currentTimeMillis());
        valueMinerInput.setDevice(deviceIdentifier(device.getDeviceId(), device.getDeviceType()));
        valueMinerInput.setJson(JsonUtil.toJson(device));
        valueMinerInput.addCategory("Device");
        return valueMinerInput;
    }

    private static DeviceIdentifier deviceIdentifier(String deviceId, String deviceType) {
        DeviceIdentifier deviceIdentifier = new DeviceIdentifier();
        deviceIdentifier.id = deviceId;
        deviceIdentifier.type = deviceType;
        return deviceIdentifier;
    }

    // ----------------------------------------------------------
    // Foobot
    // ----------------------------------------------------------
    public static ValueMinerInput from(FoobotData foobotData) {
        if (foobotData == null)
            return null;
        ValueMinerInput valueMinerInput = new ValueMinerInput();
        valueMinerInput.setTimestamp(foobotData.getTimestamp());
        valueMinerInput.setDevice(deviceIdentifier(foobotData.getDeviceId(), "Foobot"));
        valueMinerInput.setJson(foobotData.getJson());
        valueMinerInput.addCategory("AirQuality");
        valueMinerInput.addCategory("Indoor");
        return valueMinerInput;
    }

}
