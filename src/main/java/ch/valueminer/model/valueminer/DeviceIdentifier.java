package ch.valueminer.model.valueminer;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by thomas on 09.02.18.
 */
public class DeviceIdentifier implements Serializable {

    public String id;
    public String type;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}
