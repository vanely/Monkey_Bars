import java.util.Scanner;


public class Note {
    Pitch pitch;
    int octave;
    int midiNoteNumber;

    Note(int midiNoteNumber, String pitch) {
        this.midiNoteNumber = midiNoteNumber;
        if (Pitch.pitchStringIsValid(pitch))
            this.pitch = Pitch.pitchFromString(pitch);
        else
            System.out.println("Pitch used to create note is invalid!");
        this.octave = midiNoteNumber / 12 - 1;

    }

    Note(String note) {
        if (Note.hasValidName(note)){
            String[] tokens = note.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            this.pitch = Pitch.pitchFromString(tokens[0]);
            this.octave = tokens.length == 2 ? Integer.parseInt(tokens[1]) : defaultOctave(pitch);
            this.midiNoteNumber = (this.octave + 1) *12 + this.pitch.getBaseMidiNumber();
        } else {
            System.out.println("Invalid string used to generate note.");
        }
    }

    @Override
    public String toString() {
        return getNoteNameWithoutOctave();
    }

    public static int defaultOctave(Pitch p) {
        switch (p) {
            case A:
            case Gss:
            case Bbb:
            case As:
            case Bb:
            case Cbb:
            case B:
            case Cb:
            case Ass:
                return 1;
            default:
                return 0;
        }
    }
    public String getNoteNameWithOctave() {
        return String.format("%s%d", pitch, octave);
    }

    public String getNoteNameWithoutOctave() {
        return String.format("%s", pitch);
    }

    public static boolean hasValidName(String name) {
        String[] tokens = name.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        if (tokens.length < 1 || tokens.length > 2)
            return false;
        if (tokens.length == 1)
            return Pitch.pitchStringIsValid(tokens[0]);

        Scanner scanner = new Scanner(String.format("%s %s", tokens[0], tokens[1]));
        String pitch = scanner.next();

        return Pitch.pitchStringIsValid(pitch) && scanner.hasNextInt();

    }
    // TODO: Replace with correct name when Vanely gives me the correct term for the part of the note without the accidental.
    /*
    public String getRoot() {
        return
    }
    */
}
