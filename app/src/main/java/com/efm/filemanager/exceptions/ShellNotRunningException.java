package com.efm.filemanager.exceptions;

/**
 * Created by Khanh Linh <nho89vh@gmail.com>  on 24/12/16.
 * Exception thrown when root is
 */

public class ShellNotRunningException extends Exception {
    public ShellNotRunningException() {
        super("Shell stopped running!");
    }
}
