package com.github.springrest.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class LogHelper {

	public static void debug(Class<?> type, String methodName, String message) {
		Log debugger = LogFactory.getLog("DEBUGGER." + type.getName());
		if (debugger.isDebugEnabled()) {
			StringBuilder builder = new StringBuilder();
			builder.append(message);
			debugger.debug(builder.toString());
		}
	}

	public static boolean isDebugEnable(Class<?> type) {
		Log debugger = LogFactory.getLog("DEBUGGER." + type.getName());
		return debugger.isDebugEnabled();

	}

}
