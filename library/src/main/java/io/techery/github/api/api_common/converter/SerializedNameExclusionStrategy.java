package io.techery.github.api.api_common.converter;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;

public class SerializedNameExclusionStrategy implements ExclusionStrategy {

    @Override public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(SerializedName.class) == null;
    }

    @Override public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
