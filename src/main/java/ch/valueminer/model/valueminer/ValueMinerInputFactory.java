package ch.valueminer.model.valueminer;

import ch.valueminer.model.FoobotData;

/**
 * Created by thomas on 21.01.18.
 */
public class ValueMinerInputFactory {

    // ----------------------------------------------------------
    // Foobot
    // ----------------------------------------------------------

    // ----------------------------------------------------------
    // Foobot
    // ----------------------------------------------------------
    public static ValueMinerInput from(FoobotData foobotData) {
        if (foobotData == null)
            return null;
        ValueMinerInput valueMinerInput = new ValueMinerInput();
        valueMinerInput.setTimestamp(foobotData.getTimestamp());
        valueMinerInput.setData(toValueMinerData(foobotData));
        valueMinerInput.addCategory("AirQuality");
        valueMinerInput.addCategory("Indoor");
        valueMinerInput.addTag("Foobot");
        valueMinerInput.addTag(foobotData.getDeviceId());
        return valueMinerInput;
    }

    private static ValueMinerData toValueMinerData(FoobotData foobotData) {
        ValueMinerData valueMinerData = new ValueMinerData();
        valueMinerData.setDataModel(toValueMinerDataModel(foobotData));
        valueMinerData.setJson(foobotData.getJson());
        return valueMinerData;
    }

    private static ValueMinerDataModel toValueMinerDataModel(FoobotData foobotData) {
        ValueMinerDataModel valueMinerDataModel = new ValueMinerDataModel();
        valueMinerDataModel.setId("FOOBOT");
        valueMinerDataModel.setName(foobotData.getDeviceId());
        valueMinerDataModel.setVersion("1.0");
        return valueMinerDataModel;
    }

}
