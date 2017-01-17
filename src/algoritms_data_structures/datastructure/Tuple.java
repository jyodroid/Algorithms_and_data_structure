package algoritms_data_structures.datastructure;

/**
 * Created by jyodroid on 1/14/17.
 */
public class Tuple implements Comparable<Tuple> {

    private int x;
    private int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Tuple tuple) {
        if (tuple.getX() == this.getX() && tuple.getY() == this.y) return 0;
        else return (tuple.getX() - this.x);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Tuple)){
            return false;
        }

        return this.compareTo((Tuple) obj) == 0;
    }
}
