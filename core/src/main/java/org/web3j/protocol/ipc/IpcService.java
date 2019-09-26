package org.web3j.protocol.ipc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.web3j.protocol.Service;

/**
 * Ipc service implementation.
 */
public class IpcService extends Service {

    private static final Logger log = LoggerFactory.getLogger(IpcService.class);

    private final IOFacade ioFacade;

    @Deprecated
    public IpcService(IOFacade ioFacade, boolean includeRawResponses) {
        super(includeRawResponses);
        this.ioFacade = ioFacade;
    }

    @Deprecated
    public IpcService(IOFacade ioFacade) {
        this(ioFacade, false);
    }

    public IpcService(boolean includeRawResponses) {
        this(null, includeRawResponses);
    }

    public IpcService() {
        this(null, false);
    }

    protected IOFacade getIO() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    protected InputStream performIO(String payload) throws IOException {
        IOFacade io = getIoFacade();
        io.write(payload);
        log.debug(">> " + payload);

        String result = io.read();
        log.debug("<< " + result);
        if (io != ioFacade) {
            io.close();
        }

        // It's not ideal converting back into an inputStream, but we want
        // to be consistent with the HTTPService API.
        // UTF-8 (the default encoding for JSON) is explicitly used here.
        return new ByteArrayInputStream(result.getBytes("UTF-8"));
    }

    private IOFacade getIoFacade() {
        IOFacade io;
        if (ioFacade != null) {
            io = ioFacade;
        } else {
            io = getIO();
        }
        return io;
    }

    @Override
    public void close() throws IOException {
        IOFacade io = getIoFacade();

        if (io != null) {
            io.close();
        }
    }
}
