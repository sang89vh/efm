package com.efm.filemanager.filesystem.compressed.showcontents.helpers;

import android.content.Context;

import com.efm.filemanager.adapters.data.CompressedObjectParcelable;
import com.efm.filemanager.asynchronous.asynctasks.compress.CompressedHelperTask;
import com.efm.filemanager.asynchronous.asynctasks.compress.GzipHelperTask;
import com.efm.filemanager.asynchronous.asynctasks.compress.TarHelperTask;
import com.efm.filemanager.filesystem.compressed.showcontents.Decompressor;
import com.efm.filemanager.utils.OnAsyncTaskFinished;

import java.util.ArrayList;

public class GzipDecompressor extends Decompressor {

    public GzipDecompressor(Context context) {
        super(context);
    }

    @Override
    public CompressedHelperTask changePath(String path, boolean addGoBackItem,
                                           OnAsyncTaskFinished<ArrayList<CompressedObjectParcelable>> onFinish) {
        return new GzipHelperTask(filePath, path, addGoBackItem, onFinish);
    }

}
