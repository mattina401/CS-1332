/**
 * Implementation of Homework 2
 * 
 * @author Jongyeon Kim(jkim989)
 * GTID# 903018469
 */
public class PrimitiveMatrix implements Matrix {

	private int rows, cols;
	// Declaring index = row*cols + col
	private int index;
	// Declaring 1D matrix
	private double[] MatrixArray;
	
	/**
	 * @param rows
	 *            number of rows in matrix
	 * @param cols
	 *            number of cols in matrix
	 */
	public PrimitiveMatrix(final int rows, final int cols) {
		// TODO Auto-generated method stub
		this.rows = rows;
		this.cols = cols;
		MatrixArray = new double[rows*cols];
	}

	@Override
	public void put(final double value, final int row, final int col)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
		// Do not put value if index is not in range
		this.index = row*cols + col;
		if (MatrixArray.length < (index)) {
			throw new IndexOutOfBoundsException("index is out of range");
		} else if (MatrixArray.length > (index)) {
			MatrixArray[index] = value;
		} else if (MatrixArray.length == (index)) {
			MatrixArray[index] = value;
		}
	}

	@Override
	public double get(int row, int col) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		this.index = row*cols + col;
		while (MatrixArray.length < (index)) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		return MatrixArray[index];
	}

	@Override
	public Matrix add(final Matrix rhs) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Matrix result = new PrimitiveMatrix(rows, cols);
		int i = 0;
		
		// Check two matrices have same size
		if ((rows - rhs.getRowDimension() != 0) && (cols - rhs.getColumnDimension() != 0)) {
			throw new IllegalArgumentException("Matrices's size are different");
		}
		while(i < MatrixArray.length) {
			 double sum = MatrixArray[i] + rhs.get(0, i);
			 result.put(sum, 0, i);
			 i++;
		}
		return result;
	}

	@Override
	public Matrix sub(final Matrix rhs) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Matrix result = new PrimitiveMatrix(rows, cols);
		int i = 0;
		
		// Check two matrices have same size
		if ((rows - rhs.getRowDimension() != 0) && (cols - rhs.getColumnDimension() != 0)) {
			throw new IllegalArgumentException("Matrices's size are different");
		}
		while(i<MatrixArray.length) {
			 double sub = MatrixArray[i] - rhs.get(0, i);
			 result.put(sub, 0, i);
			 i++;
		}
		return result;
	}

	@Override
	public Matrix mult(final Matrix rhs) throws IllegalArgumentException {
	    // TODO Auto-generated method stub
		Matrix result = new PrimitiveMatrix(rows, rhs.getColumnDimension());
		
		// Check second matrix has same number of columns with number of rows of first matrix
		while(cols - rhs.getRowDimension() != 0) {
			throw new IllegalArgumentException("Cannot apply multiplication"); 
		}
		double value = 0;
		int c;
		for(int i = 0; i < rows; i++) {
			c = i*rows;
			for(int j = 0; j < rhs.getColumnDimension(); j++) {
				for(int k = 0; k < rhs.getRowDimension(); k++) {
					value = value + MatrixArray[c]*rhs.get(k, j);
					c++;
				}
			c = i*rows;
			result.put(value, i, j);
			value = 0;
			}	
		}
		return result;
	}

	@Override
	public int getRowDimension() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnDimension() {
		// TODO Auto-generated method stub
		return cols;
	}
}