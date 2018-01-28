package ch.valueminer.model.valueminer;

import java.io.Serializable;

/**
 * Created by thomas on 21.01.18.
 */
public class ValueMinerDataModel implements Serializable {

    private String id;
    private String name;
    private String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueMinerDataModel that = (ValueMinerDataModel) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
