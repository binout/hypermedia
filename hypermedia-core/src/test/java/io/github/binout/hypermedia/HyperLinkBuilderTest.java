package io.github.binout.hypermedia;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HyperLinkBuilderTest {

    private final HyperLinkBuilder builder = new HyperLinkBuilder("http://google.com");

    @Test
    public void should_build_hyperlink() {
        HyperLink link = builder.link("mail", "/gmail");

        assertThat(link.getHref()).isEqualTo("http://google.com/gmail");
        assertThat(link.getRel()).isEqualTo("mail");
    }

    @Test
    public void should_build_self_hyperlink() {
        HyperLink link = builder.self("/persons/123");

        assertThat(link.getHref()).isEqualTo("http://google.com/persons/123");
        assertThat(link.getRel()).isEqualTo("self");
    }

    @Test
    public void should_build_alternate_hyperlink() {
        HyperLink link = builder.alternate("/images/123");

        assertThat(link.getHref()).isEqualTo("http://google.com/images/123");
        assertThat(link.getRel()).isEqualTo("alternate");
    }
}
