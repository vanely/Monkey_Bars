import java.util.SplittableRandom;

public class Note {
    Pitch pitch;
    int octave;
    int midiNoteNumber;

    Note(int midiNoteNumber) {
        this.midiNoteNumber = midiNoteNumber;
        pitch = Pitch.midiNumberToPitch(midiNoteNumber);
        this.octave = midiNoteNumber / 12 - 1;

    }

    Note(String note) {

    }

    @Override
    public String toString() {
        return getNoteNameWithoutOctave();
    }

    public String getNoteNameWithOctave() {
        return String.format("%s%d", pitch, octave);
    }

    public String getNoteNameWithoutOctave() {
        return String.format("%s", pitch);
    }

    // TODO: Replace with correct name when Vanely gives me the correct term for the part of the note without the accidental.
    /*
    public String getRoot() {
        return
    }
    */
}
