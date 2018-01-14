package music;
import java.util.ArrayList;
import java.util.List;

public class Scale extends ArrayList<Note> {
    public Scale() {

    }

    public Scale(String[] l) {
        for (String note: l) {
            this.add(new Note(note));
        }
    }

    public Scale(List<Note> l) {
        this.addAll(l);
    }


    public String printWithOctaves(boolean withOctaves) {
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < this.size(); i++) {
            String noteName = String.format("%s",
                    withOctaves ? this.get(i).getNoteNameWithOctave() : this.get(i).getNoteNameWithoutOctave());
            if (i != size() - 1)
                string.append(String.format("%s ", noteName));
            else
                string.append(noteName);
        }
        string.append("]");

        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Scale))
            return false;

        Scale castedScale = (Scale) o;
        if (castedScale.size() != this.size())
            return false;

        for ( Note n: castedScale) {
            if (!this.hasEquivalentNote(n))
                return false;
        }

        return true;
    }

    public boolean hasEquivalentNote(Note n) {
        for (Note t: this) {
            if (t.getNoteNameWithoutOctave().equals(n.getNoteNameWithoutOctave()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.printWithOctaves(false);
    }
}
