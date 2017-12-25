import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Theory {
    private static final Map<String, int[]> scales = Map.ofEntries(
            entry("Major",          new int[]{ 0, 2, 4, 5, 7, 9, 11, 12}),
            entry("NaturalMinor",   new int[]{ 0, 2, 3, 5, 7, 8, 10, 12}),
            entry("HarmonicMinor",  new int[]{ 0, 2, 3, 5, 7, 8, 11, 12}),
            entry("MelodicMinor",  new int[]{ 0, 2, 3, 5, 7, 9, 11, 12})
    );

    private static final Map<String, String> scalesSpacing = Map.ofEntries(
            entry("Major",          "RWWHWWWH"),
            entry("NaturalMinor",   "RWHWWHWW"),
            entry("HarmonicMinor",  "RWHWWH3H"),
            entry("MelodicMinor",   "RWHWWWWH")

    );

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
