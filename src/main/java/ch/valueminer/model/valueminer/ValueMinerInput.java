package ch.valueminer.model.valueminer;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 21.01.18.
 */
public class ValueMinerInput implements Serializable {

    private Long timestamp;
    private DeviceIdentifier device;
    private String json;
    private List<String> categories;
    private List<String> tags;

    public void setDevice(DeviceIdentifier device) {
        this.device = device;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

    public DeviceIdentifier getDevice() {
        return this.device;
    }

    public void addCategory(String category) {
        if (categories == null)
            categories = new ArrayList<>();
        categories.add(category);
    }

    public void addTag(String tag) {
        if (tags == null)
            tags = new ArrayList<>();
        tags.add(tag);
    }

}
