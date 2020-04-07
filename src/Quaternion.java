
/**
 * Allows user to construct quaternion objects and perform basic operations.
 * 
 * @author Jiaxuan Wang
 */
public class Quaternion {

	private final double a;
	private final double b;
	private final double c;
	private final double d;

	/**
	 * Creates a new quaternion from its components.
	 * 
	 * @param a scalar component
	 * @param b first vector component
	 * @param c second vector component
	 * @param d third vector component
	 */
	public Quaternion(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * Creates a new quaternion from an array containing its components.
	 * 
	 * @param q array of components
	 */
	public Quaternion(double[] q) {
		a = q[0];
		b = q[1];
		c = q[2];
		d = q[3];
	}

	/**
	 * Returns the sum of this quaternion and the specified quaternion.
	 * 
	 * @param q the quaternion to be added
	 * @return the quaternion whose value is {@code (this + q)}
	 */
	public Quaternion add(Quaternion q) {
		return new Quaternion(a + q.getA(), b + q.getB(), c + q.getC(), d + q.getD());
	}

	/**
	 * Returns the difference of this quaternion and the specified quaternion.
	 * 
	 * @param q quaternion to be subtracted
	 * @return quaternion whose value is {@code (this - q)}
	 */
	public Quaternion subtract(Quaternion q) {
		return new Quaternion(a - q.getA(), b - q.getB(), c - q.getC(), d - q.getD());
	}

	/**
	 * Returns this quaternion multiplied by a scalar.
	 * 
	 * @param scalar the scalar to multiply the quaternion by
	 * @return the quaternion whose value is {@code (this * scalar)}
	 */
	public Quaternion multiply(double scalar) {
		return new Quaternion(a * scalar, b * scalar, c * scalar, d * scalar);
	}

	/**
	 * Returns the product of this quaternion and the specified quaternion.
	 * 
	 * @param q the quaternion to multiply by
	 * @return the quaternion whose value is {@code (this * q)}
	 */
	public Quaternion multiply(Quaternion q) {
		return new Quaternion(a * q.getA() - b * q.getB() - c * q.getC() - d * q.getD(),
							a * q.getB() + b * q.getA() + c * q.getD() - d * q.getC(),
							a * q.getC() - b * q.getD() + c * q.getA() + d * q.getB(),
							a * q.getD() + b * q.getC() - c * q.getB() + d * q.getA());
	}

	/**
	 * Returns this quaternion divided by a scalar.
	 * 
	 * @param scalar the scalar to divide the quaternion by
	 * @return the quaternion whose value is {@code (this / scalar)}
	 */
	public Quaternion divide(double scalar) {
		return new Quaternion(a / scalar, b / scalar, c / scalar, d / scalar);
	}

	/**
	 * Returns the quotient of this quaternion and the specified quaternion.
	 * 
	 * @param q the quaternion to divide by
	 * @return the quaternion whose value is {@code (this / q)}
	 */
	public Quaternion divide(Quaternion q) {
		return multiply(q.getInverse());
	}

	/**
	 * Returns the conjugate quaternion of this quaternion.
	 * 
	 * @return the conjugate quaternion
	 */
	public Quaternion getConjugate() {
		return new Quaternion(a, -b, -c, -d);
	}

	/**
	 * Returns the norm of this quaternion.
	 * 
	 * @return the norm
	 */
	public double getNorm() {
		return Math.sqrt(a * a + b * b + c * c + d * d);
	}

	/**
	 * Returns the inverse of this quaternion.
	 * 
	 * @return the inverse quaternion
	 */
	public Quaternion getInverse() {
		return getConjugate().divide(getNorm() * getNorm());
	}

	/**
	 * Determines whether this quaternion is equal to the specified quaternion.
	 * 
	 * @param q the quaternion to compare
	 * @return {@code true} if the specified quaternion has the same components;
	 *         {@code false} otherwise
	 */
	public boolean equals(Quaternion q) {
		return (a == q.getA()) && (b == q.getB()) && (c == q.getC()) && (d == q.getD());
	}

	/**
	 * Returns the scalar component of this quaternion.
	 * 
	 * @return the scalar component
	 */
	public double getA() {
		return a;
	}

	/**
	 * Returns the first vector component of this quaternion.
	 * 
	 * @return the first vector component
	 */
	public double getB() {
		return b;
	}

	/**
	 * Returns the second vector component of this quaternion.
	 * 
	 * @return the second component
	 */
	public double getC() {
		return c;
	}

	/**
	 * Returns the third vector component of this quaternion.
	 * 
	 * @return the third vector component
	 */
	public double getD() {
		return d;
	}

	/**
	 * Returns a string representation of this quaternion and its components.
	 * 
	 * @return a string representation of this quaternion
	 */
	@Override
	public String toString() {
		return "[" + a + ", " + b + ", " + c + ", " + d + "]";
	}

}
