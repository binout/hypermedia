package io.github.binout.hypermedia.jaxrs;

import io.github.binout.hypermedia.HyperLink;
import io.github.binout.hypermedia.HyperLinkBuilder;

import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;
import java.net.MalformedURLException;

/**
 * LECTRA
 *
 * @author b.prioux
 */
public class HyperLinkJaxrsBuilder extends HyperLinkBuilder {

    public HyperLinkJaxrsBuilder(String baseUrl) {
        super(baseUrl);
    }

    public HyperLinkJaxrsBuilder(UriInfo uriInfo) throws MalformedURLException {
        super(uriInfo.getAbsolutePath().toURL().toString());
    }

    static String getPath(Class<?> resourceClass) {
        Path annotation = resourceClass.getAnnotation(Path.class);
        return annotation.value();
    }

    public HyperLink link(String rel, Class<?> resourceClass) {
        return super.link(rel, getPath(resourceClass));
    }

    public HyperLink self(Class<?> resourceClass) {
        return super.self(getPath(resourceClass));
    }

    public HyperLink alternate(Class<?> resourceClass) {
        return super.alternate(getPath(resourceClass));
    }
}
