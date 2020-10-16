
//Programmer: Neel Joshi 
public class CryptoManager 
{
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	//Programmer: Neel Joshi 
	//This class makes sure the strings are in the bounds of the ASCII value.
	public static boolean stringInBounds (String plainText) 
	{
		boolean bounds = true;
		//For loop to go through each character
		for(int i = 0; i < plainText.length(); i++)
		{
			//Checks if it's in the "range" and if it's not i
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
					{
					bounds = false;
					}
		}
					return bounds;
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	//Programmer: Neel Joshi 
	//This class encypts the string into a Cesear Cipher
	public static String encryptCaesar(String plainText, int key) 
	{
		// offset = degrees away from character 
		String encryptC = "";
		char ch = 0;
		int encryption;
		int eachChar = 0;
			while(eachChar < plainText.length())
		{
			if(stringInBounds(plainText) || plainText.charAt(ch) == eachChar)
			{
				 ch = plainText.charAt(eachChar);
				 //adds key to character length which equals the total string length
				 encryption = ch + key;
				while(encryption > UPPER_BOUND)
				{
					// subtracts range if encrpytion > upper bound to keep in the range of the upper and lower bound
					encryption -= RANGE;
				}
				//change back to char if not then because if you don't cast char it'll just print the #s not the characters
				encryptC += (char) encryption;
				//this makes sure that it goes through each character of the string
				eachChar++;
			}
		}
				return encryptC;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	//Programmer: Neel Joshi 
	//This class encrypts the string into a Bellaso Cipher
	public static String encryptBellaso(String plainText, String bellasoStr) 
	{
		//Variables 
		
		String encryptedB = "";
		char ch = 0; 
		int bCrypt;
		int x = bellasoStr.length(); 
		int eachChar = 0;
		//Checks each character
		while(eachChar < plainText.length())
		{
			//Call stringInBounds in order to make sure that each string/character is in the range
			if(stringInBounds(plainText) || plainText.charAt(ch) == eachChar)
			{
				ch = plainText.charAt(eachChar);
				bCrypt = (int) ch + (int) bellasoStr.charAt(eachChar % x);
					while(bCrypt > UPPER_BOUND)
					{
						bCrypt -= RANGE;
					}
				encryptedB += (char) bCrypt;
				eachChar++;
			}
		}
					return encryptedB;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	//Programmer: Neel Joshi 
	// This class decrypts the encryptCaesar method. It is the inverse of it.
	public static String decryptCaesar(String encryptedText, int key) 
	{
		//Inverse of encryptCaesar
		String decryptC = "";
		char ch = 0;
		int encryption;
		int eachChar = 0;
			while(eachChar < encryptedText.length())
		{
			if(stringInBounds(encryptedText) || encryptedText.charAt(ch) == eachChar)
			{
				 ch = encryptedText.charAt(eachChar);
				 encryption = ch - key;
				while(encryption < LOWER_BOUND)
				{
					encryption += RANGE;
				}
				decryptC += (char) encryption;
				eachChar++;
			}
		}
				return decryptC;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	//Programmer: Neel Joshi 
	// This class decrypts the encryptBellaso method. It is the inverse of it.
	public static String decryptBellaso(String encryptedText, String bellasoStr)
	{
		//Inverse of encryptBellaso
		String decryptedB = "";
		char ch = 0; 
		int bCrypt;
		int x = bellasoStr.length(); 
		int eachChar = 0;
		
		while(eachChar < encryptedText.length())
		{
			if(stringInBounds(encryptedText) || encryptedText.charAt(ch) == eachChar)
			{
				ch = encryptedText.charAt(eachChar);
				//Subtracting to get the original character's ASCII value
				// eachChar % x makes sure that the length of the string is equal to the encrypted string of the origianl
				bCrypt = (int) ch - (int)bellasoStr.charAt(eachChar % x);
					while(bCrypt < LOWER_BOUND)
					{
						bCrypt += RANGE;
					}
				decryptedB += (char) bCrypt;
				eachChar++;
			}
		}
					return decryptedB;
		
	}
}