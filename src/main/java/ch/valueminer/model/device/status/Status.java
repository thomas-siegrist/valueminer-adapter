package ch.valueminer.model.device.status;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by thomas on 14.01.18.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OskarStatus.class, name = "OskarStatus")
})
public class Status implements Serializable {


    public String type;
    public boolean power;
    public Long lastAccess;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

}
