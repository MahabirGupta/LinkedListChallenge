public class Town {
    private String field;
    private int distance;

    public Town(String field, int distance) {
        this.field = field;
        this.distance = distance;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return  field + " " +
                " distance = " + distance ;
    }
}
