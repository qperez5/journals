import java.util.*;

/**
 * Represents the ranking of Journals.
 * Can be viewed as a Collection.
 */
public class Ranking implements Iterable<Journal> {
    
    private int year;

    /**
     * Delegate the sorting tasks to the SortedSet collection.
     */
    private SortedSet<Journal> journals;

    private List<Journal> sortedJournalsList;
    
    public Ranking(int year) {
        this.year = year;
        journals = new TreeSet<Journal>();
    }

    /**
     * Add a journal to the ranking.  Upon adding the ranking gets sorted according to Journal's sorting.
     * Doesn allow review journals to be added to the Ranking.
     * @param journal journal to add to this Ranking
     * @see Journal#compareTo(Journal)
     */
    public void addJournal(Journal journal) {
        if(journal!=null && !journal.isReview()){
            boolean added = journals.add(journal);
            if(added){
                sortedJournalsList = new ArrayList<Journal>(journals);
            }
        }
    }

    /**
     * Get the journal at the specific rank in the Ranking according to ranking sorting rules.
     * @param rank rank position starting from 1 to Ranking size
     * @return the journal at the designated rank position
     */
    public Journal getJournalAt(int rank) {
        if(sortedJournalsList!=null && sortedJournalsList.size() >= rank && rank >= 1 ){
            return sortedJournalsList.get(rank-1);
        }
        return null;
    }

    /**
     * Ranking size
     * @return size
     */
    public int size() {
        return journals.size();
    }

    public int getYear() {
        return year;
    }

    /**
     * Allows ranking to be traversed in Ranking order.
     * @return
     */
    public Iterator<Journal> iterator() {
        return journals.iterator();
    }
}
