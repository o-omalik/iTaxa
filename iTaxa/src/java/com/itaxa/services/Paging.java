/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author adnan
 */
public class Paging {
//properties
	List list;
	int offset;
	int maxentries = 10;
        int page = 1;
        boolean next;
        boolean prev;
        int listsize;
        
        
        public Paging(){}

        //get list by off and maxentries
	// returns a subset of the list, from off to off + maxentries
	public ArrayList getListByOffsetAndLength(){
		
		ArrayList arrayList = new ArrayList();
        try{
		int off = getOffset();
                int listSize = getListSize();
		//calc the to value
		int to = off + getMaxentries();
		//if off or lenght exceed set them to list.size
		if( off > listSize ) 
                    off = listSize;
		if(to > listSize)
                    to = listSize;
		//add the list items to the return collection 
		for(int i=off;i<to;i++){
			arrayList.add(list.get(i));
		}}catch(Exception e){}
		//return the collection
		return arrayList;
	}
     //get list site
    public int getListSize() {
        listsize =list.size();
        return listsize;
    }
   //get pages returns a list of Integer values, representing the pages
	public Collection getPages(){
		
		Collection collection = new ArrayList(); 
                int max = getMaxentries();
                int listSize = getListSize();
		//calc how many pages are there
		int pages = listSize / max ;
		if(listSize % max != 0)
			pages = pages + 1;
		
		//fill an collection with all pages
		for(int i=1;i<=pages;i++){
			collection.add(new Integer(i));
		}
		
		return collection;
	}
    
   

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

     public int getMaxentries() {
        return maxentries;
    }

    public void setMaxentries(int maxentries) {
        this.maxentries = maxentries;
    }
    
     public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    public int getOffset() {
        offset = getMaxentries() * (getPage() - 1);
        return offset;
    }
    
    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isNext() {
        if(getPages().size() > page)
            next = true;
        return next;
    }

    public boolean isPrev() {
        if(page > 1)
            prev = true;
        return prev;
    }

    
        
}
