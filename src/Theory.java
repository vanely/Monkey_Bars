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



    public static String[] getOctaveBaseList(String base) {
        //A =65, G = 71
        int asciiCode = base.charAt(0);

        String baseList[] = new String[8];

        for (int i = asciiCode; i < asciiCode + baseList.length; i++) {
            Character character = (char) (65 + ((i-65) %7));
            baseList[i-asciiCode] = character.toString();
        }

        return baseList;
    }
    public static Scale getScale(Note note, String scaleName){
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
            scale.add(getBaseEquivalent(baseMidiNoteNumber+spacing[i],baseList[i]));
        }

        return scale;
    }

    public static Note getBaseEquivalent(int midiNoteNumber, String base) {
        List<String> eqList = equivalents.get(midiNoteNumber % 12);

        for (String note: eqList) {
            if (note.startsWith(base))
                return new Note(midiNoteNumber,note);
        }
        return null;
    }

    public static String getFlatEquivalent(int midiNoteNumber, String base) {
        List<String> equivalent = equivalents.get(midiNoteNumber % 12);

        for (String s : equivalent) {
            if (!s.contains("#") && s.startsWith(base))
                return s;
        }

        return "";
    }

    public static String getSharpEquivalent(int midiNoteNumber, String base) {
        List<String> equivalent = equivalents.get(midiNoteNumber % 12);

        for (String s : equivalent) {
            if (!s.contains("b") && s.startsWith(base))
                return s;
        }

        return "";
    }

    public static Scale getMajorScale(int midiNoteNumber) {
        Scale majorScale = new Scale();

        int[] major = scalesList.get("Major");

        for (int i = 0; i < major.length; i++) {
//            majorScale.add(new Note(midiNoteNumber + major[i]));
        }

        return majorScale;
    }

    public static Scale getNaturalMinorScale(int midiNoteNumber) {
        Scale naturalMinorScale = new Scale();

        int[] naturalMinor = scalesList.get("NaturalMinor");

        for (int i = 0; i < naturalMinor.length; i++) {
//            naturalMinorScale.add(new Note(midiNoteNumber + naturalMinor[i]));
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
