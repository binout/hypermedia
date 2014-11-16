package io.github.binout.hypermedia;

import java.util.*;

public class HyperEntity {

    private Map<String, HyperLink> links = new LinkedHashMap<>();

    public Collection<HyperLink> getLinks() {
        return links.values();
    }

    public HyperLink link(String rel) {
        return links.get(rel);
    }

    public void addLink(HyperLink link) {
        this.links.put(link.getRel(), link);
    }
}
