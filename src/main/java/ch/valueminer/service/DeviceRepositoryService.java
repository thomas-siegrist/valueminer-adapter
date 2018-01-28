package ch.valueminer.service;

import ch.valueminer.model.device.Device;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thomas on 28.01.18.
 */
@Component
@Scope("singleton")
public class DeviceRepositoryService {

    private final Map<String, Map<String, Device>> deviceMultiMap;

    public DeviceRepositoryService() {
        deviceMultiMap = new HashMap<>();
    }

    public synchronized Device put(Device device) {

        Map<String, Device> typedDeviceMap = deviceMultiMap.get(device.getDeviceType());
        if (typedDeviceMap == null)
            deviceMultiMap.put(device.getDeviceType(), new HashMap<>());
        deviceMultiMap.get(device.getDeviceType()).put(device.getDeviceId(), device);

        return device;
    }

    /**
     * @return never null
     */
    public synchronized Map<String, Device> getDevices(@NotNull String deviceType) {
        Map<String, Device> deviceMap = deviceMultiMap.get(deviceType);
        if (deviceMap == null) {
            deviceMultiMap.put(deviceType, new HashMap<>());
            return deviceMultiMap.get(deviceType);
        }
        return deviceMap;
    }

}
