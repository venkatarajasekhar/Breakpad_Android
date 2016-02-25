package com.gotye.thirdparty;

import java.io.File;

public class BreakpadUtil
{
	public static boolean registerBreakpad(String folder)
	{
		File f = new File(folder);
		return registerBreakpad(f);
	}
	
	public static boolean registerBreakpad(File paramFile)
	{  
		if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
			throw new IllegalArgumentException("dumpDir is illegal.");
		return nativeRegisterBreakpad(paramFile.getAbsolutePath());
	}

	private static native boolean nativeRegisterBreakpad(String dump_folder);
	
	public static native void nativeUnregisterBreakpad();
	
	public static native void nativeTest();

	static
	{
		System.loadLibrary("breakpad_util_jni");
	}
}