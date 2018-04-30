package com.efm.filemanager.utils;

/**
 * Created by Khanh Linh <nho89vh@gmail.com>  on 21/12/15 edited by Khanh Linh <nho89vh@gmail.com>
 * A helper class which provides data structure of key/value pair
 *
 * typedef ImmutableEntry<ImmutableEntry<Integer, Integer>, Integer> MapEntry
 */
public class MapEntry extends ImmutableEntry<ImmutableEntry<Integer, Integer>, Integer> {

    /**
     * Constructor to provide values to the pair
     * @param key object of {@link ImmutableEntry} which is another key/value pair
     * @param value integer object in the pair
     */
    public MapEntry(ImmutableEntry<Integer, Integer> key, Integer value) {
        super(key, value);
    }
}
