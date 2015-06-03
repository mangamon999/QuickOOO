package inpheller.com.quickooo;

import junit.framework.TestCase;

import inpheller.com.quickooo.model.TimeOption;

/**
 * Created by brunopinheiro on 6/2/15.
 */
public class TimeOptionTest extends TestCase{

    private TimeOption timeOption;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        String title = "title";
        String description = "description";
        String message = "message";

        timeOption = new TimeOption(title, description, message);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        timeOption = null;
    }

    public void testCreate() {
        String title = "title";
        String description = "description";
        String message = "message";

        TimeOption timeOption = new TimeOption(title, description, message);

        assertEquals("Title should match the one passes as param", timeOption.getTitle(), title);
        assertEquals("Message should match the one passes as param", timeOption.getMessage(), message);
        assertEquals("Description should match the one passes as param", timeOption.getDescription(), description);
    }

    public void testAddSubOption() {
        TimeOption subOption = new TimeOption();
        timeOption.addSubOption(subOption);

        assertNotNull("SubOptions list should not be null", timeOption.getSubOptions());
        assertFalse("SubOptions list should not be empty", timeOption.getSubOptions().isEmpty());
        assertTrue("SubOptions list should contain the inserted sub option", timeOption.getSubOptions().contains(subOption));
    }

    public void testRemoveSubOption() {
        TimeOption subOption = new TimeOption();
        timeOption.addSubOption(subOption);

        timeOption.removeSubOption(subOption);

        assertNotNull("Suboptions should not be null", timeOption.getSubOptions());
        assertTrue("Suboptions should be empty", timeOption.getSubOptions().isEmpty());
    }

    public void testRemoveSupOptionNotThereShouldNotBreak() {
        timeOption.removeSubOption(new TimeOption());
    }

    public void testRemoveSupOptionNullShouldNotBreak() {
        timeOption.removeSubOption(null);
    }

    public void testWhenNoSubOptionIsFinal() {
        assertTrue("TimeOption with no sub options should return true for .isFinal()", timeOption.isFinal());
    }

    public void testWhenOneSubOptionsIsNotFinal() {
        timeOption.addSubOption(new TimeOption());
        assertFalse("TimeOption with one sub options should return false for .isFinal()", timeOption.isFinal());
    }

    public  void testWhenMultipleSubOptionsIsNotFinal() {
        timeOption.addSubOption(new TimeOption());
        timeOption.addSubOption(new TimeOption());
        timeOption.addSubOption(new TimeOption());
        assertFalse("TimeOption with multiple sub options should return false for .isFinal()", timeOption.isFinal());
    }

    public void testWhenAllSubOptionsRemovedIsFinal() {
        TimeOption option = new TimeOption();
        timeOption.addSubOption(option);
        timeOption.removeSubOption(option);

        assertTrue("TimeOption with no sub options should return true for .isFinal()", timeOption.isFinal());
    }
}
