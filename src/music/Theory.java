package music;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Theory {
    private static final Map<Integer, List<String>> equivalents = Map.ofEntries(
            entry(0, Arrays.asList("C", "B#", "Dbb")),
            entry(1, Arrays.asList("C#", "B##", "Db")),
            entry(2, Arrays.asList("D", "C##", "Ebb")),
            entry(3, Arrays.asList("D#", "Eb", "Fbb")),
            entry(4, Arrays.asList("E", "D##", "Fb")),
            entry(5, Arrays.asList("F", "E#", "Gbb")),
            entry(6, Arrays.asList("F#", "E##", "Gb")),
            entry(7, Arrays.asList("G", "F##", "Abb")),
            entry(8, Arrays.asList("G#", "Ab")),
            entry(9, Arrays.asList("A", "G##", "Bbb")),
            entry(10, Arrays.asList("A#", "Bb", "Cbb")),
            entry(11, Arrays.asList("B", "A##", "Cb"))
    );

    private static final LinkedHashMap<String, int[]> scalesList = createScalesList();

    private static final LinkedHashMap<String, String> scalesSpacingList = createScalesSpacingList();

    public static LinkedHashMap<String, int[]> createScalesList() {
        LinkedHashMap<String, int[]> scalesList = new LinkedHashMap<>();


        scalesList.put("Major", new int[]{0, 2, 4, 5, 7, 9, 11, 12});
        scalesList.put("Natural Minor", new int[]{0, 2, 3, 5, 7, 8, 10, 12});
        scalesList.put("Harmonic Minor", new int[]{0, 2, 3, 5, 7, 8, 11, 12});
        scalesList.put("Melodic Minor", new int[]{0, 2, 3, 5, 7, 9, 11, 12});

        return scalesList;
    }

    public static LinkedHashMap<String, String> createScalesSpacingList() {
        LinkedHashMap<String, String> scalesSpacingList = new LinkedHashMap<>();


        scalesSpacingList.put("Major", "RWWHWWWH");
        scalesSpacingList.put("Natural Minor", "RWHWWHWW");
        scalesSpacingList.put("Harmonic Minor", "RWHWWH3H");
        scalesSpacingList.put("Melodic Minor", "RWHWWWWH");

        return scalesSpacingList;
    }

    public static LinkedHashMap<String, Integer> createModesList() {
        LinkedHashMap<String, Integer> scalesList = new LinkedHashMap<>();


        scalesList.put("Ionian", 1);
        scalesList.put("Dorian", 2);
        scalesList.put("Phrygian", 3);
        scalesList.put("Lydian", 4);
        scalesList.put("Mixolydian", 5);
        scalesList.put("Aeolian", 6);
        scalesList.put("Locrian", 7);

        return scalesList;
    }

    public static String getRomanNumeral(int number) {
        StringBuilder romanNumeral = new StringBuilder();
//        , "\u203E"+"X"
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M", "M\u0305V", "\u0305V",
                "M\u0305X", "\u0305X", "\u0305X\u0305L", "\u0305L", "\u0305X\u0305C", "\u0305C", "\u0305C\u0305D",
                "\u0305D", "\u0305C\u0305M", "\u0305M"};
        int[] decimal = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 4000, 5000, 9000, 10000, 40000, 50000,
                90000, 100000, 400000, 500000, 900000, 1000000};
        int i = roman.length - 1;
        while (number > 0) {
            if (decimal[i] <= number) {
                romanNumeral.append(roman[i]);
                number -= decimal[i];
            } else {
                i--;
            }

        }
        return romanNumeral.toString();
    }

    public static String[] getOctaveBaseList(String base) {
        //A =65, G = 71
        int asciiCode = base.charAt(0);

        String baseList[] = new String[8];

        for (int i = asciiCode; i < asciiCode + baseList.length; i++) {
            Character character = (char) (65 + ((i - 65) % 7));
            baseList[i - asciiCode] = character.toString();
        }

        return baseList;
    }

    public static Scale getScale(Note note, String scaleName) {
        return null;
    }

    public static Scale getScale(String root, String scaleName) {
        if (!Pitch.pitchStringIsValid(root)) {
            System.out.println("Invalid pitch!");
            return null;
        }

        Scale scale = new Scale();

        int[] spacing = scalesList.get(scaleName);
        String[] baseList = getOctaveBaseList(getBase(root));

        int baseMidiNoteNumber = Pitch.pitchFromString(root).getBaseMidiNumber();
        for (int i = 0; i < spacing.length; i++) {
            scale.add(getBaseEquivalent(baseMidiNoteNumber + spacing[i], baseList[i]));
        }

        return scale;
    }

    public static Note getBaseEquivalent(int midiNoteNumber, String base) {
        List<String> eqList = equivalents.get(midiNoteNumber % 12);

        for (String note : eqList) {
            if (note.startsWith(base))
                return new Note(midiNoteNumber, note);
        }

        return null;
    }

    public static Note getSingleFlatEquivalent(int midiNoteNumber) {
        List<String> equivalent = equivalents.get(midiNoteNumber % 12);

        Note eq = null;
        for (String s : equivalent) {
            if (!s.contains("#") && !s.contains("bb"))
                eq = new Note(midiNoteNumber, s);
        }

        return eq;
    }

    public static Note getFlatishEquivalent(int midiNoteNumber) {
        List<String> equivalent = equivalents.get(midiNoteNumber % 12);

        for (String s : equivalent) {
            if (!s.contains("#"))
                return new Note(midiNoteNumber, s);
        }

        return null;
    }

    public static Note getSingleSharpEquivalent(int midiNoteNumber) {
        List<String> equivalent = equivalents.get(midiNoteNumber % 12);

        for (String s : equivalent) {
            if (!s.contains("b") && !s.contains("##"))
                return new Note(midiNoteNumber, s);
        }

        return null;
    }

    public static Note getSharpishEquivalent(int midiNoteNumber) {
        List<String> equivalent = equivalents.get(midiNoteNumber % 12);

        for (String s : equivalent) {
            if (!s.contains("b"))
                return new Note(midiNoteNumber, s);
        }

        return null;
    }

    public static String getCircleLabel(int midiNoteNumber) {
        if (Math.abs(12 / 2 - midiNoteNumber / 7) <= 1)
            return String.format("%s/%s", getSingleSharpEquivalent(midiNoteNumber), getSingleFlatEquivalent(midiNoteNumber));
        else if (12 / 2 - midiNoteNumber / 7 < 0)
            return String.format("%s", getSingleFlatEquivalent(midiNoteNumber));
        else
            return String.format("%s", getSingleSharpEquivalent(midiNoteNumber));
    }

    public static Scale getMajorScale(int midiNoteNumber) {
        Scale majorScale = new Scale();

        int[] major = scalesList.get("Major");

        for (int i = 0; i < major.length; i++) {
//            majorScale.add(new music.Note(midiNoteNumber + major[i]));
        }

        return majorScale;
    }

    public static Scale getNaturalMinorScale(int midiNoteNumber) {
        Scale naturalMinorScale = new Scale();

        int[] naturalMinor = scalesList.get("NaturalMinor");

        for (int i = 0; i < naturalMinor.length; i++) {
//            naturalMinorScale.add(new music.Note(midiNoteNumber + naturalMinor[i]));
        }

        return naturalMinorScale;
    }

    public static String getBase(String note) {
        return note.substring(0, 1).toUpperCase();
    }
    // TODO: create this method that will turn the scale generate into a scale with proper musical spelling.

    public static Scale normalizeScale(int[] spacing, String accidental) {
        return null;
    }

}
