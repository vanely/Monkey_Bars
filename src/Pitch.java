public enum Pitch {
    C(0, "C"),
    Bs(0, String.format("B%s", Music.SHARP)),
    Dbb(0, String.format("D%s", Music.DOUBLE_FLAT)),

    Cs(1, String.format("C%s", Music.SHARP)),
    Db(1, String.format("D%s", Music.FLAT)),
    Bss(1, String.format("B%s", Music.DOUBLE_SHARP)),

    D(2, "D"),
    Css(2, String.format("C%s", Music.DOUBLE_SHARP)),
    Ebb(2, String.format("E%s", Music.DOUBLE_FLAT)),

    Ds(3, String.format("D%s", Music.SHARP)),
    Eb(3, String.format("E%s", Music.FLAT)),
    Fbb(3, String.format("F%s", Music.DOUBLE_FLAT)),

    E(4, "E"),
    Fb(4, String.format("F%s", Music.FLAT)),
    Dss(4, String.format("D%s", Music.DOUBLE_SHARP)),

    F(5, "F"),
    Es(5, String.format("E%s", Music.SHARP)),
    Gbb(5, String.format("G%s", Music.DOUBLE_FLAT)),

    Fs(6, String.format("F%s", Music.SHARP)),
    Gb(6, String.format("G%s", Music.FLAT)),
    Ess(6, String.format("E%s", Music.DOUBLE_SHARP)),

    G(7, "G"),
    Fss(7, String.format("F%s", Music.DOUBLE_SHARP)),
    Abb(7, String.format("A%s", Music.DOUBLE_FLAT)),

    Gs(8, String.format("G%s", Music.SHARP)),
    Ab(8, String.format("A%s", Music.FLAT)),

    A(9, "A"),
    Gss(9, String.format("G%s", Music.DOUBLE_SHARP)),
    Bbb(9, String.format("B%s", Music.DOUBLE_FLAT)),

    As(10, String.format("A%s", Music.SHARP)),
    Bb(10, String.format("B%s", Music.FLAT)),
    Cbb(10, String.format("C%s", Music.DOUBLE_FLAT)),

    B(11, "B"),
    Cb(11, String.format("C%s", Music.FLAT)),
    Ass(11, String.format("A%s", Music.DOUBLE_SHARP)),

    PITCH_INVALID(-1, "");

    private final int baseMidiNumber;
    private final String name;

    public int getBaseMidiNumber() {
        return baseMidiNumber;
    }

    Pitch(int baseMidiNumber, String name) {
        this.baseMidiNumber = baseMidiNumber;
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }

    public static boolean pitchStringIsValid(String pitch) {
        if (pitch.length() > 3)
            return false;
        pitch = pitch.replace('#', 's');
        String first = pitch.toUpperCase();

        if (first.startsWith("A") || first.startsWith("B") || first.startsWith("C") || first.startsWith("D") ||
                first.startsWith("E") || first.startsWith("F") || first.startsWith("G")) {
            pitch = pitch.substring(1, pitch.length());

            return pitch.equals("") || pitch.equals("s") || pitch.equals("b") || pitch.equals("ss") || pitch.equals("bb");
        }
        return false;
    }

    public static Pitch pitchFromString(String pitch) {
        pitch = pitch.substring(0, 1).toUpperCase() + pitch.substring(1, pitch.length());
        pitch = pitch.replace('#', 's');

        switch (pitch) {
            case "C":
                return C;
            case "D":
                return D;
            case "E":
                return E;
            case "F":
                return F;
            case "G":
                return G;
            case "A":
                return A;
            case "B":
                return B;
            case "Cs":
                return Cs;
            case "Ds":
                return Ds;
            case "Es":
                return Es;
            case "Fs":
                return Fs;
            case "Gs":
                return Gs;
            case "As":
                return As;
            case "Bs":
                return Bs;
            case "Cb":
                return Cb;
            case "Db":
                return Db;
            case "Eb":
                return Eb;
            case "Fb":
                return Fb;
            case "Gb":
                return Gb;
            case "Ab":
                return Ab;
            case "Bb":
                return Bb;
            case "Css":
                return Css;
            case "Dss":
                return Dss;
            case "Ess":
                return Ess;
            case "Fss":
                return Fss;
            case "Gss":
                return Gss;
            case "Ass":
                return Ass;
            case "Bss":
                return Bss;
            case "Cbb":
                return Cbb;
            case "Dbb":
                return Dbb;
            case "Ebb":
                return Ebb;
            case "Fbb":
                return Fbb;
            case "Gbb":
                return Gbb;
            case "Abb":
                return Abb;
            case "Bbb":
                return Bbb;
            default:
                return PITCH_INVALID;
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
