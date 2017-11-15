package com.trendy.mifi.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.trendy.mifi.service.JsonService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by admin on 17/11/14.
 */
@Service
public class JsonServiceImpl implements JsonService {
    @Override
    public void makeJsonFiles(String jsonDemo, String sfield, String tfields,
                              String filePath, String prefix, String suffix) {
        try {
            Gson gson = new Gson();
            Map<Object, Object> jsonMaps = gson.fromJson(jsonDemo, Map.class);
            String[] sfs = sfield.split("\\.");
            String[] tfs = tfields.split(",");

            if (sfs == null || sfs.equals("") || tfs == null || tfs.equals("")) {
                System.out.println("input source|target fields is null");
                return;
            }

            // get source field
            Map<Object, Object> m = null;
            if (sfs.length > 1)
                for (int i = 0; i < sfs.length - 1; i++)
                    m = (Map<Object, Object>) jsonMaps.get(sfs[i]);
            else m = jsonMaps;

            // make files
            for (String s : tfs) {
                m.put(sfs[sfs.length - 1], s);
                FileUtils.writeStringToFile(
                        new File(filePath + File.separator +
                                (prefix == null || prefix.equals("") ? "" : prefix) +
                                s.split("\\.")[0] +
                                (suffix == null || suffix.equals("") ? ".json" : suffix)),
                        gson.toJson(jsonMaps), "utf-8");
            }
        } catch (JsonSyntaxException e) {
            System.out.println("json not right");
        } catch (IOException e) {
            System.out.println("fileName not right");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
