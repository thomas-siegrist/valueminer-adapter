package ch.valueminer.utils;

import ch.valueminer.model.valueminer.ValueMinerInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * Created by thomas on 21.01.18.
 */
public class JsonUtil {

    public static <T extends Serializable> String toJson(T value) {
        if (value == null)
            return null;
        try {
            return new ObjectMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing Object as String: " + value, e);
        }
    }

}
