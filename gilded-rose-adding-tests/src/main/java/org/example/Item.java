package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents an item in the inventory of the Gilded Rose shop.
 * Each item has a name, a sell-in period, and a quality value.
 *
 * @author Volodymyr Voroniuk
 * @project gilded-rose-adding-tests
 * @class Item
 * @version 1.0.0
 * @since 18.04.24 - 19.00
 */
@Data
@AllArgsConstructor
public class Item {

    public String name;
    public int sellIn;
    public int quality;

}
