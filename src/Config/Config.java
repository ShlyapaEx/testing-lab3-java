package Config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Config {
    public static Set<String> allowed_formats = new HashSet<String> (Arrays.asList("epub", "mobi", "azw", "azw3", "iba", "pdf"));
}
