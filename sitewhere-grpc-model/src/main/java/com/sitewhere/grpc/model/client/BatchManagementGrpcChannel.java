/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.grpc.model.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sitewhere.grpc.service.BatchManagementGrpc;
import com.sitewhere.grpc.service.BatchManagementGrpc.BatchManagementBlockingStub;
import com.sitewhere.grpc.service.BatchManagementGrpc.BatchManagementStub;
import com.sitewhere.spi.tracing.ITracerProvider;

/**
 * Channel that allows for communication with a remote batch management GRPC
 * server.
 * 
 * @author Derek
 */
public class BatchManagementGrpcChannel
	extends MultitenantGrpcChannel<BatchManagementBlockingStub, BatchManagementStub> {

    /** Static logger instance */
    private static Logger LOGGER = LogManager.getLogger();

    public BatchManagementGrpcChannel(ITracerProvider tracerProvider, String host, int port) {
	super(tracerProvider, host, port);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.grpc.model.client.GrpcChannel#createBlockingStub()
     */
    @Override
    public BatchManagementBlockingStub createBlockingStub() {
	return BatchManagementGrpc.newBlockingStub(getChannel());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.grpc.model.client.GrpcChannel#createAsyncStub()
     */
    @Override
    public BatchManagementStub createAsyncStub() {
	return BatchManagementGrpc.newStub(getChannel());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.server.lifecycle.ILifecycleComponent#getLogger()
     */
    @Override
    public Logger getLogger() {
	return LOGGER;
    }
}