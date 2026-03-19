package com.gildedrose;

class GildedRose {
	
    private static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void decreaseQuality(Item item, int fattore) {
 	   if (item.quality>=fattore) {
 		   item.quality = item.quality - fattore;
 	   }
    }
    
    public void increaseQuality(Item item, int fattore) {
 	   if (item.quality + fattore<=MAX_QUALITY) {
 		   item.quality = item.quality + fattore;
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
    
    public void updateQuality() {
    	
    	int fattore=1;
    	
        for (int i = 0; i < items.length; i++) {
        	
        	fattore = 1;
        	
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            
            if (items[i].sellIn < 0) {
            	fattore=2;
            }
            
            	if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    	if (!items[i].name.equals("Conjurados")) {
                    		decreaseQuality(items[i],fattore);
                    	}
                    	else {
                    		decreaseQuality(items[i],2*fattore);
                    	}
                    }
            	} else {
            		increaseQuality(items[i],fattore);
            		if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        updateQualityBackstage(items[i]);
            		}
                }
        }
    }
}
