import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Theory {
    private static final Map<String, int[]> scales = Map.ofEntries(
            entry("Major",          new int[]{ 0, 2, 4, 5, 7, 9, 11, 12}),
            entry("Natural Minor",   new int[]{ 0, 2, 3, 5, 7, 8, 10, 12}),
            entry("Harmonic Minor",  new int[]{ 0, 2, 3, 5, 7, 8, 11, 12}),
            entry("Melodic Minor",  new int[]{ 0, 2, 3, 5, 7, 9, 11, 12})
    );

    private static final Map<String, String> scalesSpacing = Map.ofEntries(
            entry("Major",          "RWWHWWWH"),
            entry("Natural Minor",   "RWHWWHWW"),
            entry("Harmonic Minor",  "RWHWWH3H"),
            entry("Melodic Minor",   "RWHWWWWH")

    );

    public static Map<String, int[]> getScales() {
        return scales;
    }

    public static Scale getScale(int midiNoteNumber, String scaleName) {
        Scale scale = new Scale();

        int[] spacing = scales.get(scaleName);

        for (int i = 0; i < spacing.length; i++) {
            scale.add(new Note(midiNoteNumber+spacing[i]));
        }

        return scale;
    }

    public static Scale getMajorScale(int midiNoteNumber) {
        Scale majorScale = new Scale();

        int[] major = scales.get("Major");

        for (int i = 0; i < major.length; i++) {
            majorScale.add(new Note(midiNoteNumber+major[i]));
        }

        return majorScale;
    }

    public static Scale getNaturalMinorScale(int midiNoteNumber) {
        Scale naturalMinorScale = new Scale();

        int[] naturalMinor = scales.get("NaturalMinor");

        for (int i = 0; i < naturalMinor.length; i++) {
            naturalMinorScale.add(new Note(midiNoteNumber+naturalMinor[i]));
        }

        return naturalMinorScale;
    }

    // TODO: create this method that will turn the scale generate into a scale with proper musical spelling.
    /*
    public static Scale normalizeScale(Scale original) {

    }
    */
}
