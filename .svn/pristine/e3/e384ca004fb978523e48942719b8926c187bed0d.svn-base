package com.mtf.framework.model.common;

/**
 * 用于支持简单KeyValue的Json
 *
 * @author Wade.Zhu
 * @version 1.0	2013-9-12	Wade.Zhu		created.
 * @version <ver>
 */
public class Triple<F, S, T> {

	private F	first;
	private S	second;
	private T	third;

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

	/***
	 * Constructor for a Triple. If either are null then equals() and hashCode()
	 * will throw a NullPointerException.
	 * 
	 * @param first
	 *            the first object in the Triple
	 * @param second
	 *            the second object in the Triple
	 * @param third
	 *            the third object in the Triple
	 */
	public Triple(F first, S second, T third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public Triple() {

	}

	/***
	 * Checks the two objects for equality by delegating to their respective
	 * equals() methods.
	 * 
	 * @param o
	 *            the Triple to which this one is to be checked for equality
	 * @return true if the underlying objects of the Triple are both considered
	 *         equals()
	 */
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Triple)) return false;
		final Triple<F, S, T> other;
		try {
			other = (Triple<F, S, T>) o;
		} catch (ClassCastException e) {
			return false;
		}
		return first.equals(other.first) && second.equals(other.second);
	}

	/***
	 * Compute a hash code using the hash codes of the underlying objects
	 * 
	 * @return a hashcode of the Triple
	 */
	public int hashCode() {
		int result = 17;
		result = 31 * result + (first == null ? 11 : first.hashCode());
		result = 31 * result + (second == null ? 13 : second.hashCode());
		result = 31 * result + (third == null ? 17 : third.hashCode());
		return result;
	}

	/***
	 * Convenience method for creating an appropriately typed Triple.
	 * 
	 * @param first
	 *            the first object in the Triple
	 * @param second
	 *            the second object in the Triple
	 * @param third
	 *            the third object in the Triple
	 * @return a Triple that is templatized with the types of a, b and c
	 */
	public static <F, S, T> Triple<F, S, T> create(F first, S second, T third) {
		return new Triple<F, S, T>(first, second, third);
	}
}