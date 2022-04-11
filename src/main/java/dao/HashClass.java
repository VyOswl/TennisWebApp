package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
*/

public class HashClass {
	//Map DB = new HashMap();
	private static final String salt = "Totoro&quot;";

	public HashClass() {
		
	}
	
	/*
	public static String sha1(String input) {
		String sha1 = null;
		try {
			MessageDigest msgD = MessageDigest.getInstance(sha1);
			msgD.update(input.getBytes("UTF-8"), 0, input.length());
			sha1 = DatatypeConverter.printHexBinary(msgD.digest());
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			Logger.getLogger(HashClass.class.getName()).log(Level.SEVERE, null, e);
		}
		return sha1;
	}
	*/
	
	// Add salt
	/*
    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
    */
	
	 
	 public static String getSalt() {
		return salt;
	}
	
	public static String get_SHA1(String input, String salt) {
		String encodedPwd = null;
		
		//byte[] encodedPwd = md.digest(input.getBytes());
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	            md.update(salt.getBytes());
	            byte[] bytes = md.digest(input.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bytes.length; i++) {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
	                        .substring(1));
	            }
	            encodedPwd = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        System.out.println(encodedPwd);
	        return encodedPwd;
	 }

	private static String get_SHA_256_SecurePassword(String passwordToHash, String salt) {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(salt.getBytes());
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bytes.length; i++) {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
	                        .substring(1));
	            }
	            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }

	 private static String get_SHA_384_SecurePassword(String passwordToHash, String salt) {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-384");
	            md.update(salt.getBytes());
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bytes.length; i++) {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
	                        .substring(1));
	            }
	            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }

	 private static String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            md.update(salt.getBytes());
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bytes.length; i++) {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
	                        .substring(1));
	            }
	            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }

}
