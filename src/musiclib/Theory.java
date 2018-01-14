package musiclib;

import music.Note;
import music.Scale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Theory {

    private static final Map<String, String[]> major = Map.ofEntries(

            entry("C#", new String[]{"C#", "D#", "E#", "F#", "G#", "A#", "B#", "C#"}), // 7 sharps
            entry("F#", new String[]{"F#", "G#", "A#", "B", "C#", "D#", "E#", "F#"}), // 6 sharps
            entry("B", new String[]{"B", "C#", "D#", "E", "F#", "G#", "A#", "B"}), // 5 sharps
            entry("E", new String[]{"E", "F#", "G#", "A", "B", "C#", "D#", "E"}), // 4 sharps
            entry("A", new String[]{"A", "B", "C#", "D", "E", "F#", "G#", "A"}), // 3 sharps
            entry("D", new String[]{"D", "E", "F#", "G", "A", "B", "C#", "D"}), // 2 sharps
            entry("G", new String[]{"G", "A", "B", "C", "D", "E", "F#", "G"}), // 1 sharp

            entry("C", new String[]{"C", "D", "E", "F", "G", "A", "B", "C"}), // 0 sharps / flats


            entry("F", new String[]{"F", "G", "A", "Bb", "C", "D", "E", "F"}), // 1 flat
            entry("Bb", new String[]{"Bb", "C", "D", "Eb", "F", "G", "A", "Bb"}), // 2 flats
            entry("Eb", new String[]{"Eb", "F", "G", "Ab", "Bb", "C", "D", "Eb"}), // 3 flats
            entry("Ab", new String[]{"Ab", "Bb", "C", "Db", "Eb", "F", "G", "Ab"}), // 4 flats
            entry("Db", new String[]{"Db", "Eb", "F", "Gb", "Ab", "Bb", "C", "Db"}), // 5 flats
            entry("Gb", new String[]{"Gb", "Ab", "Bb", "Cb", "Db", "Eb", "F", "Gb"}), // 6 flats
            entry("Cb", new String[]{"Cb", "Db", "Eb", "Fb", "Gb", "Ab", "Bb", "Cb"}) // 7 flats


            );

    public static Scale getScale(String note, String tonality) {
        switch (tonality) {
            case "Major":
                return new Scale(major.get(note));
            case "Minor":
                break;
            case "Melodic Minor":
                break;
            case "Harmonic Minor":
                break;
            default:
                return null;
        }
        return null;
    }
}
