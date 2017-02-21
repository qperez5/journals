import org.junit.Assert;
import org.junit.Test;

/**
 * Created by qperez on 3/02/17.
 */
public class RankingTest {


    /**
     * Test for scenario one
     */
    @Test
    public void testRankJournals(){

        Journal journalA = new Journal("Journal A", 5.6f);
        Journal journalB = new Journal("Journal B", 2.4f);
        Journal journalC = new Journal("Journal C", 3.1f);

        Ranking ranking = new Ranking(2015);
        ranking.addJournal(journalA);
        ranking.addJournal(journalB);
        ranking.addJournal(journalC);

        Journal journal1 = ranking.getJournalAt(1);
        Assert.assertEquals("Journal A", journal1.getName());
        Journal journal2 = ranking.getJournalAt(2);
        Assert.assertEquals("Journal C", journal2.getName());
        Journal journal3 = ranking.getJournalAt(3);
        Assert.assertEquals("Journal B", journal3.getName());

    }

    /**
     * Test for scenario two
     */
    @Test
    public void testSharedRank(){

        Journal journalA = new Journal("Journal A", 2.2f);
        Journal journalB = new Journal("Journal B", 6.2f);
        Journal journalC = new Journal("Journal C", 6.2f);

        Ranking ranking = new Ranking(2014);
        ranking.addJournal(journalA);
        ranking.addJournal(journalB);
        ranking.addJournal(journalC);

        Journal journal1 = ranking.getJournalAt(1);
        Assert.assertEquals("Journal B", journal1.getName());
        Journal journal2 = ranking.getJournalAt(2);
        Assert.assertEquals("Journal C", journal2.getName());
        Journal journal3 = ranking.getJournalAt(3);
        Assert.assertEquals("Journal A", journal3.getName());

    }

    /**
     * Test for scenario three.
     */
    @Test
    public void testExcludingReview(){

        Journal journalA = new Journal("Journal A", 5.6f);
        journalA.setReview(true);
        Journal journalB = new Journal("Journal B", 2.4f);
        Journal journalC = new Journal("Journal C", 3.1f);


        Ranking ranking = new Ranking(2013);
        ranking.addJournal(journalA);
        ranking.addJournal(journalB);
        ranking.addJournal(journalC);

        Journal journal1 = ranking.getJournalAt(1);
        Assert.assertEquals("Journal C", journal1.getName());
        Journal journal2 = ranking.getJournalAt(2);
        Assert.assertEquals("Journal B", journal2.getName());
        Journal journal3 = ranking.getJournalAt(3);
        Assert.assertNull(journal3);
        Assert.assertEquals(2,ranking.size());


    }

}