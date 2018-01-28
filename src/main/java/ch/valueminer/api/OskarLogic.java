package ch.valueminer.api;

import ch.valueminer.model.device.status.OskarStatus;
import ch.valueminer.model.device.status.Status;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thomas on 14.01.18.
 */
@RestController
public class OskarLogic {

    private Status getStatusFor(OskarStatus oskar) {

        int humidity = 45; // TODO read from room

        int level = calculateLevel(humidity);
        String power = calculatePower(level);

        return null;
        //return new Status(level, power);
    }

    private String calculatePower(int level) {
        return level < 40 ? "Off" : "On";
    }

    private static int calculateLevel(int humidity) {
        return (humidity - 100) * -1 / 10;
    }

}
