package ch.valueminer.model.valueminer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 21.01.18.
 */
public class ValueMinerInput implements Serializable {

    private Long timestamp;
    private ValueMinerData data;
    private List<String> categories = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ValueMinerData getData() {
        return data;
    }

    public void setData(ValueMinerData data) {
        this.data = data;
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

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void addCategory(String category) {
        categories.add(category);
    }
}
