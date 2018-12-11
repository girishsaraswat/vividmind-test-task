package com.vividmind.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividmind.db.model.Tour;
import com.vividmind.exceptions.UnrecoverableVividmindException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Girish Sarashwat
 */
public final class JsonUtil {

    private JsonUtil() {
    }

    public static String toJson(final Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UnrecoverableVividmindException(e);
        }
    }

    public static JsonNode getJsonNode(final String json) {
        final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            throw new UnrecoverableVividmindException(e);
        }
    }

    public static List<Tour> loadJsonNode(JsonNode toursNode){
        List<Tour> tourList = new ArrayList<>();
        Tour tour;
        Iterator<JsonNode> it = toursNode.iterator();
        while (it.hasNext()) {
            JsonNode node = it.next();
            tour = new Tour();
            tour.setId(Integer.parseInt(node.get("id").toString()));
            tour.setName(node.get("name").toString().replace("^\"|\"$", ""));
            tour.setLongDesc(node.get("longDesc").toString().replace("^\"|\"$", ""));
            tourList.add(tour);
        }
        return tourList;
    }

}
