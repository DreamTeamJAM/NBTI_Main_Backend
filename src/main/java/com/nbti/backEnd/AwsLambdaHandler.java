package com.nbti.backEnd;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class AwsLambdaHandler implements RequestStreamHandler {
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    
    static {
        try {
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(NbtiBackEndApplication.class);
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring framework", e);
        }
    }
    
//    public AwsLambdaHandler() throws ContainerInitializationException{
//		handler = new SpringBootProxyHandlerBuilder<AwsProxyRequest>()
//				.defaultProxy()
//				.asyncInit()
//				.springBootApplication(NbtiBackEndApplication.class)
//				.buildAndInitialize();
//	}

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
    	System.out.println("TEST TEST " + inputStream.toString() + " ;---; " + outputStream.toString());
    	  
    	  
        handler.proxyStream(inputStream, outputStream, context);
    }

}