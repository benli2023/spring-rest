package com.github.springrest.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionCallback {

	public interface Callback<T> {
		public void with(T e);
	}
	
	public static <T> void forEach(Collection<T> collection,Callback<T> callback) {
		if (collection == null || collection.size() == 0)
			return;
		Iterator<T> it = collection.iterator();
		while (it.hasNext()) {
			T object = it.next();
			callback.with(object);
		}
	}

}
