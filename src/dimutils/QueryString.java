/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dimutils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This is class representing the QueryString.
 * I just extracted it from 'static' class to separate classfile.
 * @author Ernesto Guevara
 */
public  class QueryString 
{

            private String query = "";

            public QueryString(String name, String value) {
                encode(name, value);
            }

            public void add(String name, String value) {
                query += "&";
                encode(name, value);
            }

            private void encode(String name, String value) {
                try {
                query +=URLEncoder.encode(name, "UTF-8");
                query += "=";
                query += URLEncoder.encode(value, "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException("Broken VM does not support UTF-8");
                }
            }

            public String getQuery() {
                return query;
            }

            public String toString() {
                return getQuery();
            }

    } // QueryString class    