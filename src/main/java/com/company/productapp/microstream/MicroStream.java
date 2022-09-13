
package com.company.productapp.microstream;

import one.microstream.enterprise.afs.aws.s3.types.S3Connector;
import one.microstream.enterprise.afs.blobstore.types.BlobStoreFileSystem;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;


public final class MicroStream
{
	public static EmbeddedStorageManager	storageManager;
	public final static DataRoot			root	= new DataRoot();
	
	static
	{
		//Set AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY as environment variables
		EnvironmentVariableCredentialsProvider credentialsProvider = EnvironmentVariableCredentialsProvider.create();

        Region region = Region.EU_CENTRAL_1;
        S3Client s3 = S3Client.builder()
            .region(region)
            .credentialsProvider(credentialsProvider)
            .build();
		
//		Just to check if nativ AWS connection is working
//        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
//        ListBucketsResponse listBucketsResponse = s3.listBuckets(listBucketsRequest);
//        listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));
                
        BlobStoreFileSystem fileSystem = BlobStoreFileSystem.New(
        	S3Connector.Caching(s3)
        );
        
        //Set BUCKET_NAME as environment variable
        String S3bucketname = System.getenv("BUCKET_NAME");
        storageManager = EmbeddedStorage.start(root, fileSystem.ensureDirectoryPath(S3bucketname));
	}
}
