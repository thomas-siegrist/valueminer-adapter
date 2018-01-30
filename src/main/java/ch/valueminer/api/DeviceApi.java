package ch.valueminer.api;

import ch.valueminer.model.device.Device;
import ch.valueminer.model.device.status.Status;
import ch.valueminer.model.valueminer.ValueMinerInputFactory;
import ch.valueminer.service.DataPublisherService;
import ch.valueminer.service.DeviceRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by thomas on 24.01.18.
 */
@RestController()
@RequestMapping("/api/devices")
public class DeviceApi {

    @Autowired
    private DeviceRepositoryService devices;

    @Autowired
    private DataPublisherService dataPublisherService;

    @RequestMapping(
            path = "{deviceType}",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public ResponseEntity<Collection<Device>> getDevices(
            @PathVariable(name = "deviceType") String deviceType) {
        return ResponseEntity.ok(devices.getDevices(deviceType).values());
    }

    @RequestMapping(
            path = "{deviceType}/{deviceId}",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public ResponseEntity<? extends Status> getStatus(
            @PathVariable(name = "deviceType") String deviceType,
            @PathVariable(name = "deviceId") String deviceId) {
        Device device = devices.getDevices(deviceType).get(deviceId);

        if (device == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(device.getStatus());
    }

    @RequestMapping(
            path = "{deviceType}/{deviceId}",
            produces = "application/json",
            method = RequestMethod.PUT
    )
    public ResponseEntity<? extends Status> setStatus(
            @PathVariable(name = "deviceType") String deviceType,
            @PathVariable(name = "deviceId") String deviceId,
            @RequestBody Status status) {
        Device device = new Device(deviceId, status, deviceType);

        devices.put(device);
        dataPublisherService.publish(ValueMinerInputFactory.from(device));

        return ResponseEntity.ok(status);
    }

}
