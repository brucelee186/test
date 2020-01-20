package com.mtf.framework.model.common;

/**
 * 用于支持简单KeyValue的Json
 *
 * @author Wade.Zhu
 * @version 1.0	2013-9-16	Wade.Zhu		created.
 * @version <ver>
 */
public class Tetrad<F, S, T, U> {

	private F	first;
	private S	second;
	private T	third;
	private U	fourth;

	/**
	 * @return first
	 */
	public F getFirst() {
		return first;
	}

	/**
	 * @return second
	 */
	public S getSecond() {
		return second;
	}

	/**
	 * @return third
	 */
	public T getThird() {
		return third;
	}

	/**
	 * @return fourth
	 */
	public U getFourth() {
		return fourth;
	}

	/**
	 * @return first
	 */
	public void setFirst(F f) {
		this.first = f;
	}

	/**
	 * @return second
	 */
	public void setSecond(S s) {
		this.second = s;
	}

	/**
	 * @return third
	 */
	public void setThird(T t) {
		this.third = t;
	}

	/**
	 * @return fourth
	 */
	public void setFourth(U u) {
		this.fourth = u;
	}

	/***
	 * Constructor for a Tetrad. If either are null then equals() and hashCode()
	 * will throw a NullPointerException.
	 * 
	 * @param first
	 *            the first object in the Tetrad
	 * @param second
	 *            the second object in the Tetrad
	 * @param third
	 *            the third object in the Tetrad
	 * @param fourth
	 *            the fourth object in the Tetrad
	 */
	public Tetrad(F first, S second, T third, U fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public Tetrad() {

	}

	/***
	 * Checks the two objects for equality by delegating to their respective
	 * equals() methods.
	 * 
	 * @param o
	 *            the Tetrad to which this one is to be checked for equality
	 * @return true if the underlying objects of the Tetrad are both considered
	 *         equals()
	 */
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Tetrad)) return false;
		final Tetrad<F, S, T, U> other;
		try {
			other = (Tetrad<F, S, T, U>) o;
		} catch (ClassCastException e) {
			return false;
		}
		return first.equals(other.first) && second.equals(other.second);
	}

	/***
	 * Compute a hash code using the hash codes of the underlying objects
	 * 
	 * @return a hashcode of the Tetrad
	 */
	public int hashCode() {
		int result = 17;
		result = 31 * result + (first == null ? 11 : first.hashCode());
		result = 31 * result + (second == null ? 13 : second.hashCode());
		result = 31 * result + (third == null ? 17 : third.hashCode());
		result = 31 * result + (fourth == null ? 19 : fourth.hashCode());
		return result;
	}

	/***
	 * Convenience method for creating an appropriately typed Tetrad.
	 * 
	 * @param first
	 *            the first object in the Tetrad
	 * @param second
	 *            the second object in the Tetrad
	 * @param third
	 *            the third object in the Tetrad
	 * @param fourth
	 *            the fourth object in the Tetrad
	 * @return a Tetrad that is templatized with the types of a, b, c and d
	 */
	public static <F, S, T, U> Tetrad<F, S, T, U> create(F first, S second, T third, U fourth) {
		return new Tetrad<F, S, T, U>(first, second, third, fourth);
	}
}