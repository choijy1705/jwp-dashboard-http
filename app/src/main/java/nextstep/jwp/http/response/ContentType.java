package nextstep.jwp.http.response;


import java.util.Arrays;

public enum ContentType {

    HTML("html", "text/html;charset=utf-8"),
    ICO("ico", "image/x-icon"),
    CSS("css", "text/css"),
    JS("js", "application/javascript"),
    SVG("svg", "image/svg+xml");

    private static final int INDEX = 1;

    private final String suffix;
    private final String value;


    ContentType(String suffix, String value) {
        this.suffix = suffix;
        this.value = value;
    }

    public static ContentType findByUri(String uri) {
        String suffix = uri.split("\\.")[INDEX];

        return Arrays.stream(ContentType.values())
            .filter(contentType -> contentType.getSuffix().equals(suffix))
            .findAny().orElseThrow(IllegalAccessError::new);
    }

    public String getSuffix() {
        return suffix;
    }

    public String getValue() {
        return value;
    }
}
