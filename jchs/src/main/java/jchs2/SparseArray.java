package jchs2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SparseArray {
	/** The number of rows and columns in the sparse array. */
	private int numRows = 0;
	private int numCols = 0;

	/**
	 * The list of entries representing the non-zero elements of the sparse
	 * array. Entries are stored in the list in no particular order. Each
	 * non-zero element is represented by exactly one entry in the list.
	 */
	private List<SparseArrayEntry> entries;

	/** Constructs an empty SparseArray. */
	public SparseArray() {
		entries = new ArrayList<SparseArrayEntry>();
	}

	/**
	 * Construct a SparseArray given a List of sparse entries (SN)
	 * 
	 * @param sparseEntries
	 */
	public SparseArray(final List<SparseArrayEntry> sparseEntries) {
		this.entries = sparseEntries;
		// set internal rows, cols based on maximum from sparse entries (zero
		// based)
		for (SparseArrayEntry entry : sparseEntries) {
			if (entry.getRow() >= numRows)
				numRows = entry.getRow() + 1;
			if (entry.getCol() >= numCols)
				numCols = entry.getCol() + 1;
		}
	}

	/** Returns the number of rows in the sparse array. */
	public int getNumRows() {
		return numRows;
	}

	/** Returns the number of columns in the sparse array. */
	public int getNumCols() {
		return numCols;
	}

	/**
	 * Returns the value of the element at row index row and column index col in
	 * the sparse array. Precondition: 0 row < getNumRows() 0 col < getNumCols()
	 */
	public int getValueAt(int row, int col) {
		int val = 0;
		if (0 <= row && row < getNumRows() && 0 <= col && col < getNumCols()) {

			for (SparseArrayEntry entry : entries) {
				if (entry.getCol() == col && entry.getRow() == row) {
					val = entry.getValue();
					break;
				}
			}
		}
		return val;
	}

	/**
	 * Removes the column col from the sparse array. Precondition: 0 col <
	 * getNumCols()
	 */
	public void removeColumn(int col) {
		if (col >= 0 && col < getNumCols()) {
			int ix = 0;
			Iterator<SparseArrayEntry> i = entries.iterator();
			while (i.hasNext()) {
				SparseArrayEntry entry = i.next();
				if (entry.getCol() == col) {
					i.remove();
					continue;
				} else if (entry.getCol() > col) {
					entries.set(ix, new SparseArrayEntry(entry.getRow(), entry.getCol() - 1, entry.getValue()));
				}
				ix++;
			}
			numCols--;
		}
	}

}
