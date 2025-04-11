package io.cdap.wrangler.api.parser;

public class TimeDuration extends Token {
    private final long milliseconds;

    public TimeDuration(String value) {
        super("TIME_DURATION", value);
        this.milliseconds = parse(value);
    }

    private long parse(String input) {
        input = input.toLowerCase().trim();
        double number = Double.parseDouble(input.replaceAll("[^0-9.]", ""));
        if (input.endsWith("h")) return (long)(number * 3600 * 1000);
        if (input.endsWith("m")) return (long)(number * 60 * 1000);
        if (input.endsWith("s")) return (long)(number * 1000);
        return (long) number; // ms
    }

    public long getMilliseconds() {
        return milliseconds;
    }
}
