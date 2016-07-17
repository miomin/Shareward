package scu.miomin.com.shareward.activity.dataModel;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializer for a dummy object
 * <p/>
 * Convert a JsonObject into a Dummy object.
 */
public class DummyObjectDeserializer implements JsonDeserializer<DummyObject> {
    @Override
    public DummyObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final DummyObject dummyObject = new DummyObject();
        final JsonObject jsonObject = json.getAsJsonObject();

        dummyObject.setTitle(jsonObject.get("title").getAsString());
        dummyObject.setBody(jsonObject.get("body").getAsString());

        return dummyObject;
    }
}
