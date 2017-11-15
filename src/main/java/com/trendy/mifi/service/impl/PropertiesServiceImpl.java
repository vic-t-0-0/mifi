package com.trendy.mifi.service.impl;

import com.trendy.mifi.service.PropertiesService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by admin on 17/11/14.
 */
@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Override
    public void makePropertiesFile(Properties pdemo, String sfield, String tfields,
                                   String filePath, String prefix, String suffix) {
        try {
            for (String s : tfields.split(",")) {
                pdemo.setProperty(sfield, s);
                FileOutputStream fos = new FileOutputStream(
                        new File(filePath +
                                (prefix == null || prefix.equals("") ? "" : prefix) +
                                s.split("\\.")[0] +
                                (suffix == null || suffix.equals("") ? ".properties" : suffix)));
                pdemo.store(fos, "The New properties file");
                fos.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
