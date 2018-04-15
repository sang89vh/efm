package com.efm.filemanager.filesystem.compressed.showcontents.helpers;

import android.content.Context;

import com.efm.filemanager.adapters.data.CompressedObjectParcelable;
import com.efm.filemanager.asynchronous.asynctasks.compress.ZipHelperTask;
import java.util.ArrayList;

import com.efm.filemanager.filesystem.compressed.showcontents.Decompressor;
import com.efm.filemanager.utils.OnAsyncTaskFinished;

/**
 * @author Emmanuel
 *         on 20/11/2017, at 17:19.
 */

public class ZipDecompressor extends Decompressor {

    public ZipDecompressor(Context context) {
        super(context);
    }

    @Override
    public ZipHelperTask changePath(String path, boolean addGoBackItem,
                           OnAsyncTaskFinished<ArrayList<CompressedObjectParcelable>> onFinish) {
        return new ZipHelperTask(context, filePath, path, addGoBackItem, onFinish);
    }

}
