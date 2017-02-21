/**
 * Represents a single Journal.
 * Journal define its own sorting rules via Comparable interface.
 */
public class Journal implements Comparable<Journal> {

    private String name;

    private Float score;

    private boolean review;

    public Journal(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public Journal(String name, float score, boolean review) {
        this.name = name;
        this.score = score;
        this.review = review;
    }


    public String getName() {
        return name;
    }

    public Float getScore() {
        return score;
    }

    public boolean isReview() {
        return review;
    }

    public int compareTo(Journal other) {
        int compare = this.score.compareTo(other.score);

        if(compare == 0){
            return this.name.compareTo(other.name);
        }

        return compare * -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journal journal = (Journal) o;

        return name.equals(journal.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
