
package com.company.productapp.microstream;

import one.microstream.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;


public final class MicroStream
{
	public static DataRoot               root           = new DataRoot();
	public static EmbeddedStorageManager storageManager = EmbeddedStorageConfiguration.Builder()
		.setStorageDirectoryInUserHome("microstream-data/ProductApp")
		.createEmbeddedStorageFoundation()
		.createEmbeddedStorageManager(MicroStream.root)
		.start();
	// public static DataRoot root()
	// {
	// return MicroStream.root;
	// }
	//
	// public static EmbeddedStorageManager storageManager()
	// {
	// return MicroStream.storageManager;
	// }
	//
	// private MicroStream()
	// {
	// }
}
