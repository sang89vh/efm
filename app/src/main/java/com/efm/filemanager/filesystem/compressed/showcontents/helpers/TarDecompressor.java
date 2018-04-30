package com.efm.filemanager.filesystem.compressed.showcontents.helpers;

import android.content.Context;

import com.efm.filemanager.adapters.data.CompressedObjectParcelable;
import com.efm.filemanager.asynchronous.asynctasks.compress.TarHelperTask;
import com.efm.filemanager.filesystem.compressed.showcontents.Decompressor;
import com.efm.filemanager.utils.OnAsyncTaskFinished;

import java.util.ArrayList;

/**
 * @author Khanh Linh <nho89vh@gmail.com>
 *         on 2/12/2017, at 00:36.
 */

public class TarDecompressor extends Decompressor {

    public TarDecompressor(Context context) {
        super(context);
    }

    @Override
    public TarHelperTask changePath(String path, boolean addGoBackItem, OnAsyncTaskFinished<ArrayList<CompressedObjectParcelable>> onFinish) {
        return new TarHelperTask(filePath, path, addGoBackItem, onFinish);
    }

}
