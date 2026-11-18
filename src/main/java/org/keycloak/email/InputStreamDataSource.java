package org.keycloak.email;

import javax.activation.DataSource;
import javax.activation.MimetypesFileTypeMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;


public class InputStreamDataSource implements DataSource {
    private static final MimetypesFileTypeMap MIMETYPES = new MimetypesFileTypeMap();

    private Boolean fistRead;
    private final String name;
    private final InputStream inputStream1;
    private final InputStream inputStream2;

    public InputStreamDataSource(InputStream inputStream1, InputStream inputStream2, String name) {
        this.name = name;
        this.fistRead = true;
        this.inputStream1 = inputStream1;
        this.inputStream2 = inputStream2;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (this.fistRead) {
            this.fistRead = false;
            return this.inputStream1;
        }

        this.inputStream1.close();
        return this.inputStream2;
    }

    @Override
    public OutputStream getOutputStream() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String getContentType() {
        // The JDK's FileNameMap knows common types like application/pdf, which the
        // built-in MimetypesFileTypeMap table lacks. Fall back to the latter for
        // types the JDK doesn't know; it returns application/octet-stream if unknown.
        String contentType = URLConnection.guessContentTypeFromName(name);
        if (contentType == null) {
            contentType = MIMETYPES.getContentType(name);
        }
        return contentType;
    }

    @Override
    public String getName() {
        return name;
    }
}
