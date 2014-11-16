package io.github.binout.hypermedia.jaxrs;

import org.testng.annotations.Test;

import javax.ws.rs.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class HyperLinkJaxrsBuilderTest {

    @Path("/resources")
    private static class Resource {
    }

    @Test
    public void getPath_should_return_path() {
        assertThat(HyperLinkJaxrsBuilder.getPath(Resource.class)).isEqualTo("/resources");
    }
}