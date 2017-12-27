import java.util.ArrayList;
import java.util.List;

public class Scale extends ArrayList<Note> {
    Scale() {

    }

    Scale(List<Note> l) {
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
    public String toString() {
        return this.printWithOctaves(false);
    }
}
