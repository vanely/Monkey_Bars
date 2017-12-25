import javax.sound.midi.*;
import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Music {

    public static final int INSTRUMENT = 69;


    public static void main(String[] args) throws InvalidMidiDataException {

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


        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a midi note number: ");
        int midiNoteNumber = input.nextInt();

        Pitch pitch = Pitch.C;
        System.out.println(Pitch.valueOf("Cs"));

        channel.noteOn(midiNoteNumber, 127);

        System.out.printf("Major: %s\n", Theory.getMajorScale(midiNoteNumber));
        System.out.printf("Natural Minor: %s", Theory.getNaturalMinorScale(midiNoteNumber));


    }

    public static void play(MidiChannel channel, Note note) {
    }

    public void silence(MidiChannel channel) {
        channel.allNotesOff();
    }
}
