import java.util.ArrayList;
import java.util.List;

public class Theory {
    public static List<Note> getMajorScale(int midiNoteNumber) {
        Scale majorScale = new Scale();

        int[] major = { 0, 2, 4, 5, 7, 9, 11, 12};

        for (int i = 0; i < major.length; i++) {
            majorScale.add(new Note(midiNoteNumber+major[i]));
        }

        return majorScale;
    }

    // TODO: create this method that will turn the scale generate into a scale with proper musical spelling.
    /*
    public static Scale normalizeScale(Scale original) {

    }
    */
}
