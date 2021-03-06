package music;

import javax.sound.midi.*;
import java.util.Map;
import java.util.Scanner;

public class Music {

    //    public static final int INSTRUMENT = 69;
    public static final String QUARTER_NOTE = String.valueOf(Character.toChars(0x2669));
    public static final String QUARTER_NOTE2 = String.valueOf(Character.toChars(0x1D15F));

    public static final String EIGHTH_NOTE = String.valueOf(Character.toChars(0x266A));
    public static final String BEAMED_EIGHTH_NOTES = String.valueOf(Character.toChars(0x266B));
    public static final String BEAMED_SIXTEENTH_NOTES = String.valueOf(Character.toChars(0x266C));

    public static final String WHOLE_REST = String.valueOf(Character.toChars(0x1D13B));

    public static final String TREBLE_CLEF = String.valueOf(Character.toChars(0x1D11E));
    public static final String BASS_CLEF = String.valueOf(Character.toChars(0x1D122));
    public static final String ALTO_CLEF = String.valueOf(Character.toChars(0x1D121));
    public static final String LEFT_REPEAT = String.valueOf(Character.toChars(0x1D106));
    public static final String RIGHT_REPEAT = String.valueOf(Character.toChars(0x1D107));
    public static final String FERMATA = String.valueOf(Character.toChars(0x1D110));
    public static final String CRESCENDO = String.valueOf(Character.toChars(0x1D192));


    public static final String SHARP = String.valueOf(Character.toChars(0x266F));
    public static final String FLAT = String.valueOf(Character.toChars(0x266D));
    public static final String NATURAL = String.valueOf(Character.toChars(0x266E));
    public static final String DOUBLE_FLAT = String.valueOf(Character.toChars(0x1D12B));
    public static final String DOUBLE_SHARP = String.valueOf(Character.toChars(0x1D12A));

//    public static final String DOUBLE_FLAT = String.format("%s%s", FLAT, FLAT);
//    public static final String DOUBLE_SHARP = String.format("%s%s", SHARP, SHARP);


    public static void main(String[] args) {
/*
        Synthesizer synth = null;
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        }
        catch (Exception e) {
            System.out.println(e);
        }


        MidiChannel channel = synth.getChannels()[0];
        channel.programChange(INSTRUMENT - 1);
        channel.setChannelPressure(5);  // optional vibrato


        Sequence sequence = new Sequence(Sequence.PPQ, 1);

        Track track = sequence.createTrack();


        ShortMessage sm = new ShortMessage( );
        sm.setMessage(ShortMessage.PROGRAM_CHANGE, 9, INSTRUMENT, 0); //9 ==> is the channel 10.
        track.add(new MidiEvent(sm, 0));
*/
/*
        System.out.println("FLAT = " + FLAT);
        System.out.println("SHARP = " + SHARP);
        System.out.println("NATURAL = " + NATURAL);
        System.out.println("DOUBLE_FLAT = " + DOUBLE_FLAT);
        System.out.println("DOUBLE_SHARP = " + DOUBLE_SHARP);

        System.out.println("WHOLE_REST = " + WHOLE_REST);

        System.out.println("QUARTER_NOTE = " + QUARTER_NOTE);
        System.out.println("EIGHTH_NOTE = " + EIGHTH_NOTE);
        System.out.println("BEAMED_EIGHTH_NOTES = " + BEAMED_EIGHTH_NOTES);
        System.out.println("BEAMED_SIXTEENTH_NOTES = " + BEAMED_SIXTEENTH_NOTES);

        System.out.println("TREBLE_CLEF = " + TREBLE_CLEF);
        System.out.println("BASS_CLEF = " + BASS_CLEF);
        System.out.println("ALTO_CLEF = " + ALTO_CLEF);

        System.out.println("LEFT_REPEAT = " + LEFT_REPEAT);
        System.out.println("RIGHT_REPEAT = " + RIGHT_REPEAT);

        System.out.println("FERMATA = " + FERMATA);
        System.out.println("CRESCENDO = " + CRESCENDO);

        System.out.println("QUARTER_NOTE2 = " + QUARTER_NOTE2);

*/
        Scanner input = new Scanner(System.in);
        String response;
        int decimal;


        do {
            System.out.print("Please enter an integer between 1 and 3,999,999 (without the commas), or type '0' to" +
                    " move on to the next test: ");
            decimal = input.nextInt();
            if (decimal != 0) {
                if (decimal >= 1 && decimal <= 3999999)
                    System.out.println(Theory.getRomanNumeral(decimal));
                else {
                    System.out.println("Learn to read, dickweed.  Try again!");
                }
            }
        } while (decimal != 0);

        System.out.print("Please enter a pitch to validate, or type 'Q' to quit: ");
        int cof = input.nextInt();

        for (int i = 0; i < 12; i++) {
            System.out.println(Theory.getCircleLabel(7*i));
        }

        do {
            System.out.print("Please enter a pitch to validate, or type 'Q' to quit: ");
            response = input.next();
            if (!response.equals("Q")) {
                if (Pitch.pitchStringIsValid(response))
                    System.out.printf("music.Pitch entered is valid and recognized as %s!\n\n", Pitch.pitchFromString(response));
                else {
                    System.out.println("music.Pitch entered is not valid and cannot be recognized. Use the letters A-G with b, bb, # or ##!");
                    System.out.println("e.g. Ab, C#, Fbb, D##, C");
                }
            }
        } while (!response.equals("Q"));

        do {
            System.out.print("Please enter a note to validate, or type 'Q' to quit: ");
            response = input.next();
            if (!response.equals("Q")) {
                if (Note.hasValidName(response))
                    System.out.printf("music.Note entered is valid and recognized as %s!\n\n", new Note(response));
                else {
                    System.out.println("music.Note entered is not valid and cannot be recognized. Use the letters A-G with b, bb, # or ## and a number if desired!");
                    System.out.println("e.g. Ab3, C#5, Fbb8, D##2, C, G9");
                }
            }
        } while (!response.equals("Q"));
/*

        System.out.print("Please enter a midi note number: ");


        int midiNoteNumber = input.nextInt();
*/

//        music.Pitch pitch = music.Pitch.C;
//        System.out.println(music.Pitch.valueOf("Cs"));

//        channel.noteOn(midiNoteNumber, 127);

        Map<String, int[]> scales = Theory.createScalesList();

        do {
            System.out.print("Please enter a pitch to generate scales for, or type 'Q' to quit: ");
            response = input.next();
            if (!Pitch.pitchStringIsValid(response))
                System.out.println("Invalid pitch, asshole... Please enter a valid pitch (e.g. C#, A, Db, etc.)\n");
            else {
                for (String s : scales.keySet()) {
                    System.out.printf("%s: %s\n", s, Theory.getScale(response, s));
                }
                System.out.println();
            }
        } while (!response.equals("Q"));


    }

    public static void play(MidiChannel channel, Note note) {
    }

    public void silence(MidiChannel channel) {
        channel.allNotesOff();
    }
}
