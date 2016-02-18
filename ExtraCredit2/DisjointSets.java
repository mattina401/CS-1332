import java.util.LinkedHashMap;
import java.util.Set;

//name : Jongyeon Kim
//GTID : jkim989
public class DisjointSets<T> {
	
	private final LinkedHashMap<T, e> nodes = new LinkedHashMap<>();

	/**
	 * @param setItems
	 *            the initial items (sameSet and merge will never be called with
	 *            items not in this set, this set will never contain null
	 *            elements)
	 */
	public DisjointSets(Set<T> setItems) {
		// TODO
		
		for (T obj : setItems) {
			nodes.put(obj, new e(null, 0));
		}	
	}

	/**
	 * @param u
	 * @param v
	 * @return true if the items given are in the same set, false otherwise
	 */
	public boolean sameSet(T u, T v) {
		// TODO
		
		T paru, parv;
		paru = search(u);
		parv = search(v);
		return paru.equals(parv);
	}

	/**
	 * merges the sets u and v are in, do nothing if they are in the same set
	 * You are required to implement the following in this method:
	 * 	Path compression: every node points to its root
	 *  Merge by rank: Let the rank (estimate tree depth) of each set initially be 0. 
	 *  When merging to set with different ranks, make the smaller ranked root point to the larger root.
	 *  If the two ranks are the same, choose one to point to the other, and increment the rank of the new set
	 *
	 * @param u
	 * @param v
	 */
	public void merge(T u, T v) {
		// TODO
		
		T paru, parv;
		paru = search(u);
		parv = search(v);
		e ndu = nodes.get(paru);
		e ndv = nodes.get(parv);
		
		if (paru.equals(parv)) {
			return;
		}
		
		if (ndu.r >= ndv.r) {
			ndv.par = paru;
			if (ndu.r == ndv.r) {
				ndu.r++;
			}
		} else {
			ndu.par = parv;
		}
	}
	
	private class e {
		T par;
		int r;
		e(T par, int r) {
			this.par = par;
			this.r = r;
		}
	}
	
	private T search(T obj) {
		e nd = nodes.get(obj);
		if (nd.par != null) {
			nd.par = search(nd.par);
			return nd.par;
		} else {
			return obj;
		}
	}
}