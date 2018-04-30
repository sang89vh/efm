package com.efm.filemanager.utils;

import java.util.Comparator;

/**
 * Created by Khanh Linh <nho89vh@gmail.com>  on 20-11-2015.
 */
public class BookSorter implements Comparator<String[]> {

    @Override
    public int compare(String[] lhs, String[] rhs) {
        int result = lhs[0].compareToIgnoreCase(rhs[0]);

        if (result == 0) {
            // the title is same, compare their paths
            result = lhs[1].compareToIgnoreCase(rhs[1]);
        }
        return result;
    }
}
