package org.elsys.mbenov.imageclient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

public class ImageData {
    public long width;
    public long height;
    public List data;
    public String name;

    public ImageData(long width, long height, List data, String name) {
        this.width = width;
        this.height = height;
        this.data = data;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImageData{" +
                "width=" + width +
                ", height=" + height +
                ", data=" + data +
                ", name='" + name + '\'' +
                '}';
    }

    public String toJSONString() {
        JSONObject json = new JSONObject();
        json.put("height", height);
        json.put("width", width);
        json.put("data", data);
        json.put("name", name);

        return json.toJSONString();
    }

    static ImageData fromJSONString(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(data.toString());

        return new ImageData(
                (long)obj.get("width"),
                (long)obj.get("height"),
                (JSONArray)obj.get("data"),
                (String)obj.get("name")
        );
    }
}
