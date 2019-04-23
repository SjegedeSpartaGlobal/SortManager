package com.sparta.sj.starter;

import com.sparta.sj.sorters.BubbleSorter;
import com.sparta.sj.sorters.MergeSorter;
import com.sparta.sj.sorters.Sorter;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class SortFactory {

    private static Logger logger = Logger.getLogger(SortFactory.class.getName());

    enum sortTypes{
        BUBBLE("bubble"),
        MERGE("merge");

        private String type;

        sortTypes(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }
    }



    private SortFactory(){

    }

    //Gets the sorter instance from the properties file
    public static Sorter getInstance() {

        try {
            Properties properties = new Properties();
            properties.load(new FileReader("resources/factory.properties"));
            String sorter = properties.getProperty("sortType");
            Object selectedSorter = Class.forName((sorter));
            int[] a = {9,7,2,5};
            final Object sorter_obj = ((Class) selectedSorter).newInstance();
            logger.info("sorter: "+sorter);
            return (Sorter) sorter_obj;

        } catch (IOException e) {
            logger.error("file reader not found");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("sorter class not found");
            e.printStackTrace();
        } catch( IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return new BubbleSorter();
    }




}
