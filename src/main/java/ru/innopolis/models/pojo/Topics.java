package ru.innopolis.models.pojo;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 30.11.2016.
 */
public enum Topics {

    SPORT(1),
    EANGLISH(2),
    JAVA(3),
    CPP(4),
    BIZNES(5),
    FASHION(6),
    PHOTO(7);

    final private int value;
    final private static Map<Integer, Topics> r = new HashMap();

    static {
        for(Topics a: EnumSet.allOf(Topics.class)){
            r.put( a.value, a);
            }
    }
    static public Topics getByValue(int a){
        return r.get(a);
    }
        Topics(int a ) {
            value=a;
        }

    public int getValue() {
        return value;
    }
}
