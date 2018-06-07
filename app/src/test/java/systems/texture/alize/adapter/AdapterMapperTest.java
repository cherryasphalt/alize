package systems.texture.alize.adapter;

import com.google.common.collect.ImmutableList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(RobolectricTestRunner.class)
public class AdapterMapperTest {
    AdapterMapper adapterMapper;

    @Before
    public void setup() {
        adapterMapper = new AdapterMapper();
        adapterMapper.add(0, "0")
                .addList(1, ImmutableList.of("1", "2", "3", "4", "5"))
                .add(2, "6")
                .add(3, "7")
                .add(4, "8")
                .addList(5, ImmutableList.of("9", "10", "11"));
    }

    @Test
    public void testSize() {
        assertEquals(12, adapterMapper.size());
    }

    @Test
    public void testPositions() {
        assertEquals("0", adapterMapper.get(0));
        assertEquals("1", adapterMapper.get(1));
        assertEquals("2", adapterMapper.get(2));
        assertEquals("3", adapterMapper.get(3));
        assertEquals("4", adapterMapper.get(4));
        assertEquals("5", adapterMapper.get(5));
        assertEquals("6", adapterMapper.get(6));
        assertEquals("7", adapterMapper.get(7));
        assertEquals("8", adapterMapper.get(8));
        assertEquals("9", adapterMapper.get(9));
        assertEquals("10", adapterMapper.get(10));
        assertEquals("11", adapterMapper.get(11));
    }

    @Test
    public void testViewTypes() {
        assertEquals(0, adapterMapper.getViewType(0));
        assertEquals(1, adapterMapper.getViewType(1));
        assertEquals(1, adapterMapper.getViewType(2));
        assertEquals(1, adapterMapper.getViewType(3));
        assertEquals(1, adapterMapper.getViewType(4));
        assertEquals(1, adapterMapper.getViewType(5));
        assertEquals(2, adapterMapper.getViewType(6));
        assertEquals(3, adapterMapper.getViewType(7));
        assertEquals(4, adapterMapper.getViewType(8));
        assertEquals(5, adapterMapper.getViewType(9));
        assertEquals(5, adapterMapper.getViewType(10));
        assertEquals(5, adapterMapper.getViewType(11));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void negativePosition_shouldThrowIndexOutOfBoundsException() {
        adapterMapper.getViewType(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidPosition_shouldThrowIndexOutOfBoundsException() {
        adapterMapper.getViewType(13);
    }

    @Test
    public void testEmpty() {
        AdapterMapper emptyAdapterMapper = new AdapterMapper();
        assertTrue(emptyAdapterMapper.isEmpty());
    }

    @Test
    public void testHasViewType() {
        assertTrue(adapterMapper.hasViewType(0));
        assertTrue(adapterMapper.hasViewType(1));
        assertTrue(adapterMapper.hasViewType(2));
        assertTrue(adapterMapper.hasViewType(3));
        assertTrue(adapterMapper.hasViewType(4));
        assertTrue(adapterMapper.hasViewType(5));
        assertFalse(adapterMapper.hasViewType(6));
        assertFalse(adapterMapper.hasViewType(-1));
        assertFalse(adapterMapper.hasViewType(100));
    }

    @Test
    public void testFindFirstOfViewType() {
        assertEquals(1, adapterMapper.findFirstOfViewType(1));
        assertEquals(7, adapterMapper.findFirstOfViewType(3));
        assertEquals(9, adapterMapper.findFirstOfViewType(5));
        assertEquals(-1, adapterMapper.findFirstOfViewType(20));
    }

    @Test
    public void testGetListContainingIndex() {
        AdapterMapper tempAdapterMapper = new AdapterMapper();
        tempAdapterMapper.add(0, "0")
                .addList(1, ImmutableList.of("1", "2", "3", "4", "5"))
                .add(2, "6")
                .add(2, "7")
                .add(2, "8")
                .addList(3, ImmutableList.of("9", "10", "11"));
        assertEquals(ImmutableList.of("0"),
                tempAdapterMapper.getListContainingIndex(0));
        assertEquals(ImmutableList.of("1", "2", "3", "4", "5"),
                tempAdapterMapper.getListContainingIndex(3));
        assertEquals(ImmutableList.of("1", "2", "3", "4", "5"),
                tempAdapterMapper.getListContainingIndex(4));
        assertEquals(ImmutableList.of("6", "7", "8"),
                tempAdapterMapper.getListContainingIndex(7));
        assertEquals(ImmutableList.of("9", "10", "11"),
                tempAdapterMapper.getListContainingIndex(10));
    }

    @Test
    public void testRemoveListContainingIndex() {
        AdapterMapper tempAdapterMapper = new AdapterMapper();
        tempAdapterMapper.add(0, "0")
                .addList(1, ImmutableList.of("1", "2", "3", "4", "5"))
                .add(2, "6")
                .add(2, "7")
                .add(2, "8")
                .addList(3, ImmutableList.of("9", "10", "11"));
        tempAdapterMapper.removeListContainingIndex(7);
        assertEquals("10", tempAdapterMapper.get(7));
        tempAdapterMapper.removeListContainingIndex(1);
        assertEquals("9", tempAdapterMapper.get(1));
        tempAdapterMapper.removeListContainingIndex(0);
        tempAdapterMapper.removeListContainingIndex(0);
        assertTrue(tempAdapterMapper.isEmpty());
    }

    @Test
    public void testReplaceListContainingIndex() {
        AdapterMapper tempAdapterMapper = new AdapterMapper();
        tempAdapterMapper.add(0, "0")
                .addList(1, ImmutableList.of("1", "2", "3", "4", "5"))
                .add(2, "6")
                .add(2, "7")
                .add(2, "8")
                .addList(3, ImmutableList.of("9", "10"));
        tempAdapterMapper.replaceListContainingIndex(2, 4, ImmutableList.of("11", "12", "13", "14", "15"));
        assertEquals("12", tempAdapterMapper.get(2));
        tempAdapterMapper.replaceListContainingIndex(7, 4, ImmutableList.of("16", "17", "18"));
        assertEquals("17", tempAdapterMapper.get(7));
    }

    @Test
    public void testAddMultipleSingles() {
        AdapterMapper tempAdapterMapper = new AdapterMapper();
        tempAdapterMapper.add(1, "0")
                .add(1, "1")
                .add(1, "2");
        tempAdapterMapper.removeListContainingIndex(1);
        assertTrue(tempAdapterMapper.isEmpty());
    }
}