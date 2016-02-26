package jchs2;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {
	/** The number of rows and columns in the sparse array. */
	private int numRows;
	private int numCols;
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
	
	public SparseArray(final List<SparseArrayEntry> entries){
		this.entries = entries;
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
		//part a
		return val;
	}

	/**
	 * Removes the column col from the sparse array. Precondition: 0 col <
	 * getNumCols()
	 */
	public void removeColumn(int col) {
		//part b
	}

}
