package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * FileUtil is the class used to copy text file to other text file. It can copy
 * one by one byte, copy by input value byte(s), and copy by BufferedReader &
 * PrintWriter.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.03.30
 */
public class FileUtil {
	/**
	 * Copy the InputStream to the OutputStream one byte at a time.
	 * 
	 * @param in
	 *            is the InputStream file to copy.
	 * @param out
	 *            is the OutputStream file to copy to.
	 * @throws RuntimeException
	 *             when it catch an IOException.
	 */
	static void copy(InputStream in, OutputStream out) {
		int count;
		try {
			while ((count = in.read()) != -1) {
				out.write(count);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// ignore it
			}
		}

	}

	/**
	 * Copy the InputStream to the OutputStream using a byte array of size
	 * blocksize.
	 * 
	 * @param in
	 *            is the InputStream file to copy.
	 * @param out
	 *            is the OutputStream file to copy to.
	 * @param blocksize
	 *            is the size of the file to be copied per time.
	 * @throws RuntimeException
	 *             when it catch an IOException.
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		byte[] buffer = new byte[blocksize];
		int count;
		try {
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// ignore it
			}
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using a BufferedReader to read
	 * the InputStream and PrintWriter to write the OutputStream. Read and write
	 * one line at a time.
	 * 
	 * @param in
	 *            is the InputStream file to copy.
	 * @param out
	 *            is the OutputStream file to copy to.
	 * @throws RuntimeException
	 *             when it catch an IOException.
	 */
	static void bcopy(InputStream in, OutputStream out) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);
		String s;
		try {
			while ((s = buffer.readLine()) != null) {
				writer.write(s + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		writer.close();
		try {
			buffer.close();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using a BufferedReader to read
	 * the InputStream and BufferedWriter to write the OutputStream with an
	 * array of char. Read and write one char at a time.
	 * 
	 * @param in
	 *            is the InputStream file to copy.
	 * @param out
	 *            is the OutputStream file to copy to.
	 * @throws RuntimeException
	 *             when it catch an IOException.
	 */
	static void bcopyCharArray(InputStream in, OutputStream out) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		char[] c = new char[70];
		int length;
		try {
			while ((length = buffer.read(c)) != -1) {
				writer.write(c, 0, length);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		try {
			writer.close();
			buffer.close();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
