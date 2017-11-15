package com.trendy.mifi.service;

import java.util.List;

/**
 * Created by admin on 17/11/14.
 */
public interface JsonService {


    /**
     * generate json files including jsonTemplate
     *
     * @param jsonDemo jsonTemplate .e.g. = {"person":{"id":"1","name":"qq"}}
     * @param sfield   source field .e.g. = person.id
     * @param tfields  target fields split by ',' .e.g. = "tom,mike"
     * @param filePath
     * @param prefix
     * @param suffix
     * @output : files {"person":{"id":"1","name":"tom"}} & {"person":{"id":"1","name":"mike"}}
     */
    void makeJsonFiles(String jsonDemo, String sfield, String tfields,
                       String filePath, String prefix, String suffix);
}
