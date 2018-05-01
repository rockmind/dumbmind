package pl.home.learning.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Matrix<T extends Number>  {
	private int i;
	private int j;
    private List<T> matrix;
	public Matrix(int i, int j, List<T> matrix) {
		super();
		this.i = i;
		this.j = j;
		this.matrix = matrix;
	}

	public Matrix(int i, int j) {
		super();
		this.i = i;
		this.j = j;
		List<Number> tmp = new ArrayList<>();
		for (int k = 0; k < i*j; k++) {
			tmp.add(0);
		}
	}
	T get(int i, int j) {
		return matrix.get(j%6 + i*6);
	}
	void set(int i, int j, T element) {
		matrix.set(j%6 + i*6, element);
	}
	int getDimN() {
		return i;
	}
	int getDimM() {
		return j;
	}
	Matrix dot(Matrix m2) {
		Matrix mTmp = new Matrix<>(j, m2.getDimM());
		double  tmp= 0.;
		for (int i = 0; i < this.i; i++) {
			for (int j = 0; j < m2.getDimM(); j++) {
				for (int k = 0; k < this.j; k++) {
					tmp+=(double) matrix.get(k%6 + i*6) * (double) m2.get(k, j);
				}
				mTmp.set(i, j, tmp);
				tmp = 0.;
				
			}
		}
		return mTmp;
	}
	@Override
	public String toString() {
		StringBuffer macierz = new StringBuffer("");
		macierz.append(matrix.get(0).toString());
		for (int j = 1; j < this.j; j++) {
			macierz.append(matrix.get(j%6 + i*6).toString());
		}
		for (int i = 1; i < this.i; i++) {
			macierz.append("\n");
			macierz.append(matrix.get(i*6).toString());
			for (int j = 1; j < this.j; j++) {
				macierz.append("\t");
				macierz.append(matrix.get(j%6 + i*6).toString());
			}
			
		}
		return macierz.toString();
	}
	public static void main(String[] args) {
		Matrix<Double> m1 = new Matrix<>(2, 2, Arrays.asList(1.,1.,1.,1.,1.,1.,1.,1.,1.));
		Matrix<Double> m2 = new Matrix<>(2, 2, Arrays.asList(1.,1.,1.,1.,1.,1.,1.,1.,1.));
		System.out.println(m1.toString());
			}
}
