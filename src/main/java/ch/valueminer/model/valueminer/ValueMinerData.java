package ch.valueminer.model.valueminer;

import java.io.Serializable;

/**
 * Created by thomas on 21.01.18.
 */
public class ValueMinerData implements Serializable {

    private ValueMinerDataModel dataModel;
    private String json;

    public ValueMinerDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ValueMinerDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

}
