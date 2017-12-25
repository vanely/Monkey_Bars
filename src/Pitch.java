public enum Pitch {
    C(0),
    Cs(1),
    D(2),
    Ds(3),
    E(4),
    F(5),
    Fs(6),
    G(7),
    Gs(8),
    A(9),
    As(10),
    B(11);

    private final int midiNumber;


    Pitch(int midiNumber) {
        this.midiNumber = midiNumber;
    }


    @Override
    public String toString() {
        return pitchToString(this.midiNumber);
    }

    public String pitchToString(int midiNumber) {
        int baseValue = midiNumber % 12;

        switch (baseValue) {
            case 0:
                return "C";
            case 1:
                return "C#";
            case 2:
                return "D";
            case 3:
                return "D#";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "F#";
            case 7:
                return "G";
            case 8:
                return "G#";
            case 9:
                return "A";
            case 10:
                return "A#";
            case 11:
                return "B";
            default:
                return "";
        }
    }

    public static Pitch midiNumberToPitch(int midiNumber) {
        int baseValue = midiNumber % 12;

        switch (baseValue) {
            case 0:
                return Pitch.C;
            case 1:
                return Pitch.Cs;
            case 2:
                return Pitch.D;
            case 3:
                return Pitch.Ds;
            case 4:
                return Pitch.E;
            case 5:
                return Pitch.F;
            case 6:
                return Pitch.Fs;
            case 7:
                return Pitch.G;
            case 8:
                return Pitch.Gs;
            case 9:
                return Pitch.A;
            case 10:
                return Pitch.As;
            case 11:
                return Pitch.B;
            default:
                return Pitch.C;
        }
    }
}
