package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the Gilded Rose inventory management system.
 * Ensures that the updateQuality method correctly updates items' sell-in and quality values.
 * Covers various item types and edge cases.
 *
 * @author Volodymyr Voroniuk
 * @project gilded-rose-adding-tests
 * @class GildedRoseTest
 * @version 1.0.0
 * @since 18.04.24 - 19.00
 */
public class GildedRoseTest {

    // Test that the quality and sell-in values of a standard item decrease by 1 each day
    @Test
    public void whenDayPasses_StandardItemQualityAndSellInDecrease() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn, "SellIn should decrease by 1 each day.");
        assertEquals(19, app.items[0].quality, "Quality should decrease by 1 each day.");
    }

    // Test that the quality of multiple items degrades at the end of each day
    @Test
    public void whenDayPasses_MultipleItemsQualityDegrade() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Elixir of the Mongoose", 5, 7)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertAll("Multiple items degrade",
                () -> assertEquals(19, app.items[0].quality, "+5 Dexterity Vest quality should decrease by 1."),
                () -> assertEquals(6, app.items[1].quality, "Elixir of the Mongoose quality should decrease by 1.")
        );
    }

    // Test that the quality of an item degrades twice as fast once the sell-in date has passed
    @Test
    public void whenSellInPasses_QualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality, "Quality should degrade twice as fast after the sell-in date.");
    }

    // Test that the quality of an item degrades by 1 when there is 1 day left on the sell-in
    @Test
    public void whenOneDayLeft_QualityDegradesByOne() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 1, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality, "Quality should degrade by 1 with 1 day left on sell-in.");
    }

    // Test that the quality of an item degrades down to 0
    @Test
    public void whenDayPasses_QualityDegradesDownToZero() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality, "Quality should degrade down to 0.");
    }

    // Test that the quality of an item is never negative
    @Test
    public void whenDayPasses_ItemQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= 0, "Item quality should never be negative.");
    }

    // Test that "Aged Brie" increases in quality over time
    @Test
    public void whenDayPasses_AgedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality, "Aged Brie should increase in quality as it ages.");
    }

    // Test that "Aged Brie" with a quality of 49 increases to a maximum of 50
    @Test
    public void whenDayPasses_AgedBrieQuality49IncreasesTo50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "Aged Brie should increase in quality up to a maximum of 50.");
    }

    // Test that the quality of an item is never more than 50
    @Test
    public void whenDayPasses_ItemQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "Item quality should never exceed 50.");
    }

    // Test that "Aged Brie" increases in quality twice as fast after the sell-in date
    @Test
    public void whenSellInPasses_AgedBrieIncreasesTwiceAsFast() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality, "Aged Brie should increase in quality twice as fast once sell-in date has passed.");
    }

    // Test that "Aged Brie" with a quality of 50 does not increase after the sell-in date
    @Test
    public void whenSellInPasses_AgedBrieQuality50DoesNotIncrease() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "Aged Brie with quality of 50 should not increase, even after sell-in date.");
    }

    // Test that legendary items never have to be sold
    @Test
    public void whenDayPasses_LegendaryItemsSellInRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn, "Legendary item 'Sulfuras' sell-in should remain unchanged.");
    }

    // Test that legendary items never decrease in quality
    @Test
    public void whenDayPasses_LegendaryItemsQualityRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality, "Legendary item 'Sulfuras' quality should remain unchanged.");
    }

    // Test that backstage passes increase in quality as the sell-in date approaches
    @Test
    public void whenDayPasses_BackstagePassesIncreaseInQualityAsSellInApproaches() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality, "Backstage passes should increase in quality as the sell-in date approaches.");
    }

    // Test that backstage passes increase in quality by 1 when there are more than 10 days
    @Test
    public void whenMoreThan10Days_BackstagePassesIncreaseInQualityBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality, "Backstage passes should increase in quality by 1 when there are more than 10 days.");
    }

    // Test that backstage passes increase in quality by 2 when there are 10 days or less
    @Test
    public void when10DaysOrLess_BackstagePassesIncreaseInQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality, "Backstage passes should increase in quality by 2 when there are 10 days or less.");
    }

    // Test that backstage passes with a quality of 49 increase up to 50 when there are 10 days or less
    @Test
    public void when10DaysOrLess_BackstagePassesQuality49IncreasesTo50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "Backstage passes with a quality of 49 should increase up to 50 when there are 10 days or less.");
    }

    // Test that backstage passes increase in quality by 2 when there are 6 days or less
    @Test
    public void when6DaysOrLess_BackstagePassesIncreaseInQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality, "Backstage passes should increase in quality by 2 when there are 6 days or less.");
    }

    // Test that backstage passes increase in quality by 3 when there are 5 days or less
    @Test
    public void when5DaysOrLess_BackstagePassesIncreaseInQualityBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality, "Backstage passes should increase in quality by 3 when there are 5 days or less.");
    }

    // Test that backstage passes with a quality of 47 increase up to 50 when there are 5 days or less
    @Test
    public void when5DaysOrLess_BackstagePassesQuality47IncreasesTo50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "Backstage passes with a quality of 47 should increase up to 50 when there are 5 days or less.");
    }

    // Test that backstage passes with a quality of 49 increase up to 50 when there are 5 days or less
    @Test
    public void when5DaysOrLess_BackstagePassesQuality49IncreasesTo50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality, "Backstage passes with a quality of 49 should increase up to 50 when there are 5 days or less.");
    }

    // Test that backstage passes quality drops to 0 after the concert
    @Test
    public void afterConcert_BackstagePassesQualityDropsToZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality, "Backstage passes should drop to a quality of 0 after the concert.");
    }

}
