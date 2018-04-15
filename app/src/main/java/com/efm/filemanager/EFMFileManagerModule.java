package com.efm.filemanager;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.efm.filemanager.adapters.glide.apkimage.ApkImageModelLoaderFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Ensures that Glide's generated API is created for the Gallery sample.
 */
@GlideModule
public class EFMFileManagerModule extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.prepend(String.class, Drawable.class, new ApkImageModelLoaderFactory(context.getPackageManager()));
    }
}
