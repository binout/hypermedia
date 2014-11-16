package io.github.binout.hypermedia;

public class HyperLink {

    public static final String SELF = "self";
    public static final String ALTERNATE = "alternate";

    private String rel;
    private String href;

    protected HyperLink() {
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
