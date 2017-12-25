import java.util.ArrayList;
import java.util.List;

public class Scale extends ArrayList<Note> {
    Scale() {

    }

    Scale(List<Note> l) {
        this.addAll(l);
    }

    public String printWithOctaves() {
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < this.size(); i++) {
            if (i != size())
                string.append(String.format("%s ", this.get(i).getNoteNameWithOctave()));
            else
                string.append(this.get(i).getNoteNameWithOctave());
        }
        string.append("]");

        return string.toString();
    }
}
