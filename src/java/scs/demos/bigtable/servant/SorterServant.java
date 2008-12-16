package scs.demos.bigtable.servant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import org.omg.CORBA.Any;

import scs.demos.bigtable.AllEntriesHolder;
import scs.demos.bigtable.Entries;
import scs.demos.bigtable.EntriesHolder;
import scs.demos.bigtable.IteratorHolder;
import scs.demos.bigtable.KeysHolder;
import scs.demos.bigtable.SorterPOA;

/**
 * Armazena o hash com chave e par para cada entrada do big table
 * Oferece interface para entrada e saida de valores
 * @author hubert
 *
 */
public class SorterServant extends SorterPOA {

	private BigTableComponent component;
	private int numReducers;
	private int currentRequesterReducer = 0;
	
	boolean started = false;
	private HashMap<Integer, Integer> groups; // former int defines char, latter defines the group

	private HashMap<Any, ArrayList<Any>> rows = null;
	
	
	public SorterServant(BigTableComponent component) {
		this.component = component;
	}
	
	@Override
	public void get(Any key, IteratorHolder values) {
		ArrayList<Any> val = null;
		Set<Entry<Any,ArrayList<Any>>> keySet = rows.entrySet();
		Iterator<Entry<Any,ArrayList<Any>>> it = keySet.iterator();
		while (it.hasNext()) {
			Entry<Any,ArrayList<Any>> currEntry = it.next();
			if (currEntry.getKey().extract_string().equals(key.extract_string())) {
				val = currEntry.getValue();
				break;
			}
		}
		if (val != null)
			values.value = val.toArray(new Any[val.size()]);
		else
			values.value = new Any[0];
	}

	@Override
	public void put(Any key, Any value) {
		if (key != null && value != null) {
			boolean added = false;
			
			if (rows == null)
				rows = new HashMap<Any, ArrayList<Any>>();
			
			ArrayList<Any> val = null;
			Set<Entry<Any,ArrayList<Any>>> keySet = rows.entrySet();
			Iterator<Entry<Any,ArrayList<Any>>> it = keySet.iterator();
			while (it.hasNext()) {
				Entry<Any,ArrayList<Any>> currEntry = it.next();
				if (currEntry.getKey().extract_string().equals(key.extract_string())) {
					val = currEntry.getValue();
					val.add(value);
					rows.put(currEntry.getKey(), val);
					added = true;
					break;
				}
			}
			
			if (!added) {
				val = new ArrayList<Any>();
				val.add(value);
				rows.put(key, val);
			}
		}
	}

	@Override
	public void getEntriesOnRange(AllEntriesHolder allEntries) {
		if (rows != null) {
			Set<Entry<Any,ArrayList<Any>>> keySet = rows.entrySet();
			
			ArrayList<Entries> entriesArray = new ArrayList<Entries>();
			Iterator<Entry<Any,ArrayList<Any>>> it = keySet.iterator();
			while (it.hasNext()) {
				Entry<Any,ArrayList<Any>> entry = it.next();
				int j = 0;
				try {
					char ch = entry.getKey().extract_string().charAt(0);
					j = groups.get(new Integer(ch)).intValue();
				}
				catch (Exception e) {j = 0;}
				if (j == currentRequesterReducer) {
					Entries element = new Entries();
					element.key = entry.getKey();
					element.values = entry.getValue().toArray(new Any[entry.getValue().size()]);
					entriesArray.add(element);
				}
			}
			
			if (entriesArray != null && entriesArray.size() > 0) {
				allEntries.value = entriesArray.toArray(new Entries[entriesArray.size()]);
			}				
			else {
				allEntries.value = new Entries[0];
			}
		}
		
		currentRequesterReducer++;
	}

	@Override
	public void setNumberOfReducers(int numReducers) {
		this.numReducers = numReducers;
		
		String constellation = "abcdefghijklmnopqrstuvwxyz0123456789";
		int symbols = constellation.length();
		
		groups = new HashMap<Integer,Integer>();
		for (int i = 0; i < constellation.length(); i++) {
			groups.put(new Integer(constellation.charAt(i)), (symbols / ((i > 0)?i:1) ) % numReducers);
		}
	}

}
