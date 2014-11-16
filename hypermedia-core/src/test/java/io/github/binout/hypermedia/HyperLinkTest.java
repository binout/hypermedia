package io.github.binout.hypermedia;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HyperLinkTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void jackson_serialization() throws IOException {
        HyperLink hyperLink = new HyperLink();
        hyperLink.setHref("/somewhere/mars");
        hyperLink.setRel("place");

        String json = mapper.writeValueAsString(hyperLink);
        JSONObject jsonObject = new JSONObject(json);
        assertThat(jsonObject.get("rel")).isEqualTo("place");
        assertThat(jsonObject.get("href")).isEqualTo("/somewhere/mars");
    }
}
