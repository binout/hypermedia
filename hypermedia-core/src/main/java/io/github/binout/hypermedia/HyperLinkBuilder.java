package io.github.binout.hypermedia;

import static io.github.binout.hypermedia.HyperLink.ALTERNATE;
import static io.github.binout.hypermedia.HyperLink.SELF;

public class HyperLinkBuilder {

    private String baseUrl;

    public HyperLinkBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public HyperLink link(String rel, String uri) {
        HyperLink hyperLink = new HyperLink();
        hyperLink.setRel(rel);
        hyperLink.setHref(baseUrl + uri);
        return hyperLink;
    }

    public HyperLink self(String uri) {
        return link(SELF, uri);
    }

    public HyperLink alternate(String uri) {
        return link(ALTERNATE, uri);
    }
}
