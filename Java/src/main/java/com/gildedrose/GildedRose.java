package com.gildedrose;

class GildedRose {
	
    private static final int MAX_VAL_QUALITY = 50;
    private static final int MIN_VAL_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void decreaseQuality(Item item, int fattore) {
 	   if (item.quality>=fattore) {
 		   item.quality = item.quality - fattore;
 	   }
 	   else {
 		  item.quality = MIN_VAL_QUALITY;
 	   }
    }
    
    public void increaseQuality(Item item, int fattore) {
 	   if (item.quality + fattore<=MAX_VAL_QUALITY) {
 		   item.quality = item.quality + fattore;
 	   }
 	   else {
 		  item.quality = MAX_VAL_QUALITY;
 	   }
    }
    
    public void updateQualityBackstage(Item item) {
    	
    	int fattore = 0;
    	
    	if (item.sellIn < 6 && item.sellIn >= 0) {
    		fattore = fattore + 1;
        }
		if (item.sellIn < 11 && item.sellIn >= 0) {
			fattore = fattore + 1;
        }
		if (item.sellIn < 0) {
			decreaseQuality(item,1);
    	}
		increaseQuality(item,fattore);
    }
    
    public void updateQualityCondizionale(Item item) {
	if (!item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            	if (!item.name.equals("Conjurados")) {
            		decreaseQuality(item,1);
            	}
            	else {
            		decreaseQuality(item,2);
            	}
            }
    	} else {
    		increaseQuality(item,1);
    		if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateQualityBackstage(item);
    		}
        }
	}
    
    public void updateQuality() {
    	
        for (int i = 0; i < items.length; i++) {
        
            
            updateQualityCondizionale(items[i]);
            
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            
            if (items[i].sellIn < 0) {
            	updateQualityCondizionale(items[i]);
            }
        }
    }
}
