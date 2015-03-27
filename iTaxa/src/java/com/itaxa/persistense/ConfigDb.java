/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.Reader;
import org.apache.log4j.Logger;



/**
 *
 * @author adnankaramat
 */
public class ConfigDb {

    private static ConfigDb instance = new ConfigDb();
    private static Logger log = Logger.getLogger(ConfigDb.class);
    protected static final SqlMapClient sqlMap;
    

    static {
        try {
            //  log.debug("Attempting to initialize SqlMap");
            String resource = "com/itaxa/ibatis/sqlMapConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
            log.debug("Initialized SqlMap");
        } catch (Exception e) {
            log.error("Error intializing ConfigDb ", e);
            e.printStackTrace();
            throw new RuntimeException("Error initializing ConfigDb class. Cause: " + e);
        }
    }

    protected ConfigDb() {
    }

    public static ConfigDb getInstance() {
        return instance;
    }
}
