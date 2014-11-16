package io.github.binout.hypermedia;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HyperEntityTest {

    private HyperLinkBuilder github = new HyperLinkBuilder("http://github.com");
    private HyperLinkBuilder twitter = new HyperLinkBuilder("http://twitter.com");

    private ObjectMapper objectMapper = new ObjectMapper();

    private Person me() {
        Person person = new Person();
        person.setName("binout");
        return person;
    }

    @Test
    public void jackson_serialization() throws IOException {
        Person person = me();
        person.addLink(github.link("github", "/binout"));

        String json = objectMapper.writeValueAsString(person);

        JSONObject jsonObject = new JSONObject(json);
        assertThat(jsonObject.get("name")).isEqualTo("binout");
        JSONArray links = jsonObject.getJSONArray("links");
        assertThat(links.length()).isEqualTo(1);
        assertThat(links.getJSONObject(0).get("rel")).isEqualTo("github");
        assertThat(links.getJSONObject(0).get("href")).isEqualTo("http://github.com/binout");
    }

    @Test
    public void should_retrieve_link_by_rel() throws IOException {
        Person person = me();
        person.addLink(github.link("github", "/binout"));
        person.addLink(twitter.link("twitter", "/binout"));

        HyperLink twitterLink = person.link("twitter");

        assertThat(twitterLink.getRel()).isEqualTo("twitter");
        assertThat(twitterLink.getHref()).isEqualTo("http://twitter.com/binout");
    }

    @Test
    public void should_retrieve_link_by_rel_even_it_doesnt_exists() throws IOException {
        Person person = me();
        person.addLink(github.link("github", "/binout"));
        person.addLink(twitter.link("twitter", "/binout"));

        HyperLink selfLink = person.link(HyperLink.SELF);

        assertThat(selfLink).isNull();
    }
}