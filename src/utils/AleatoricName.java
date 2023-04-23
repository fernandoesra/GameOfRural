package utils;

/**
 * This class generate aleatoric names between different ranges for the min and
 * max lenght.<br>
 * The generated names are 'alien' or 'esoteric' like. Not real names.<br>
 * Using the toString() method its possible to obtain the generated name.
 * 
 * @author Fernando Tarriño del Pozo (FernandoEsra)
 *
 */

public class AleatoricName {
	
	String name;
	
	/**
	 * Generate a random name with length between 3 and 12.
	 */
	public AleatoricName() {
		this.name = this.generateAleatoricName();	
		;
	}
	
	/**
	 * Generate a random name with personalized lengths.<br>
	 * The values includes the possible appaerance of spaces.
	 * 
	 * @param min The min value for the lenght.
	 * @param max The max value for the lenght.
	 */
	public AleatoricName(int min, int max) {
		this.name = this.generateAleatoricName(min, max);	
		;
	}
	
	/**
	 * Create a new String with a AleatoricName with length between 3 and 12.<br>
	 * This a algorithm use 4 methods to generate new letters:<br>
	 * <b>- </b> generateConsonantUpper()<br>
	 * <b>- </b> generateConsonantLower()<br>
	 * <b>- </b> generateVowelUpper()<br>
	 * <b>- </b> generateVowelLower()
	 * 
	 * <p>
	 * Each method return just one character, vowel or consonant. The algorithm
	 * first determies the lenght of the name and create an char array of that
	 * dimenison.<br>
	 * Then, starting on the first index there are a 85% of probability to generate
	 * a mayus consonant and a 15% of probability to generate a mayus vowel to fill
	 * the beginning of the name.<br>
	 * 
	 * The continues generatin new characters following just one rule. For every
	 * vowel generated one internal counter add one. At the beginning the
	 * probability of generate a vowel for the actual letter is 85 of. But if the
	 * generated vowel counter are 2 or greater that probability lowers to 15%.
	 * If a consonant is generated subtract one to the vowel counter.
	 * 
	 * @return A string with the aleatoric name.
	 */
	public String generateAleatoricName() {
		String newName = "";
		
		int min = 3;
		int max = 12;
		int random = (int) ((Math.random() * (max - min)) + min);
		int vowels = 0;
		
		char nameChars[] = new char[random];
		for (int i = 0; i < nameChars.length; i++) {
			min = 0;
			max = 100;
			random = (int) ((Math.random() * (max - min)) + min);
			
			if (random >= 0 && random <= 85 && i == 0) {
				nameChars[i] = this.generateConsonantUpper();
			} else if (i == 0) {
				nameChars[i] = this.generateVowelUpper();
				vowels++;
			}
			
			if (i > 0) {
				
				if (vowels >= 2) {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 85) {
						nameChars[i] = this.generateConsonantLower();
						vowels--;
					} else {
						nameChars[i] = this.generateVowelLower();
						vowels++;
					}
					
				} else {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 90) {
						nameChars[i] = this.generateVowelLower();
						vowels++;
					} else {
						nameChars[i] = this.generateConsonantLower();
						vowels--;
					}
				}
				
			}

		}
		
		for (int i = 0; i < nameChars.length; i++) {
			newName += nameChars[i];
		}
		
		return newName;
	}
	
	/**
	 * Create a new String with a AleatoricName with length between a defined
	 * range.<br>
	 * This a algorithm use 4 methods to generate new letters:<br>
	 * <b>- </b> generateConsonantUpper()<br>
	 * <b>- </b> generateConsonantLower()<br>
	 * <b>- </b> generateVowelUpper()<br>
	 * <b>- </b> generateVowelLower()
	 * 
	 * <p>
	 * Each method return just one character, vowel or consonant. The algorithm
	 * first determies the lenght of the name and create an char array of that
	 * dimenison.<br>
	 * Then, starting on the first index there are a 85% of probability to generate
	 * a mayus consonant and a 15% of probability to generate a mayus vowel to fill
	 * the beginning of the name.<br>
	 * 
	 * The continues generatin new characters following just one rule. For every
	 * vowel generated one internal counter add one. At the beginning the
	 * probability of generate a vowel for the actual letter is 85 of. But if the
	 * generated vowel counter are 2 or greater that probability lowers to 15%. If a
	 * consonant is generated subtract one to the vowel counter.
	 * 
	 * @param min Minimum number of characters accepted for the lenght of the name.
	 * @param max Maximum number of characters accepted for the lenght of the name.
	 * @return A string with the aleatoric name.
	 */
	public String generateAleatoricName(int min, int max) {
		String newName = "";
		int random = (int) ((Math.random() * (max - min)) + min);
		int vowels = 0;
		
		char nameChars[] = new char[random];
		
		for (int i = 0; i < nameChars.length; i++) {
			min = 0;
			max = 100;
			random = (int) ((Math.random() * (max - min)) + min);
			
			if (random >= 0 && random <= 85 && i == 0) {
				nameChars[i] = this.generateConsonantUpper();
			} else if (i == 0) {
				nameChars[i] = this.generateVowelUpper();
				vowels++;
			}
			
			if (i > 0) {
				
				if (vowels >= 2) {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 85) {
						nameChars[i] = this.generateConsonantLower();
						vowels--;
					} else {
						nameChars[i] = this.generateVowelLower();
						vowels++;
					}
					
				} else {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 90) {
						nameChars[i] = this.generateVowelLower();
						vowels++;
					} else {
						nameChars[i] = this.generateConsonantLower();
						vowels--;
					}
				}
				
			}

		}
		
		for (int i = 0; i < nameChars.length; i++) {
			newName += nameChars[i];
			
			if (i >= 6) {
				random = (int) ((Math.random() * (100 - 1)) + 1);
				if (random >= 1 && random <= 10) {
					newName += " ";
				}
			}
			
		}
		
		return newName;
	}
	
	/**
	 * That method generated a lowercase vowel. First generate a 'a', 'e', 'i', 'o'
	 * or 'u'. Then for each of that characters are a 5% of proability to add a
	 * umlaut symbol. If not, there are a 10% of probability to add a acent.
	 * 
	 * @return A character that will be, exclusively, a lowercase vowel.
	 */
	public char generateVowelLower() {
		int random = (int) (Math.random() * 6 + 1);
		char vowel = 'a';
		switch (random) {
		case 1:
			vowel = 'a';
			break;
		case 2:
			vowel = 'e';
			break;
		case 3:
			vowel = 'i';
			break;
		case 4:
			vowel = 'o';
			break;
		case 5:
			vowel = 'u';
			break;
		default:
			break;
		}
		
		if (vowel == 'a') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)225;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)228;
			}
		}
		
		if (vowel == 'e') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)233;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)235;
			}
		}
		
		if (vowel == 'i') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)237;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)239;
			}
		}
		
		if (vowel == 'o') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)243;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)256;
			}
		}
		
		if (vowel == 'u') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)250;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)252;
			}
		}
		
		return vowel;
	}
	
	/**
	 * That method generated a uppercase vowel. First generate a 'A', 'E', 'I', 'O'
	 * or 'U'. Then for each of that characters are a 5% of proability to add a
	 * umlaut symbol. If not, there are a 10% of probability to add a acent.
	 * 
	 * @return A character that will be, exclusively, a uppercase vowel.
	 */
	public char generateVowelUpper() {
		int random = (int) (Math.random() * 6 + 1);
		char vowel = 'A';
		switch (random) {
		case 1:
			vowel = 'A';
			break;
		case 2:
			vowel = 'E';
			break;
		case 3:
			vowel = 'I';
			break;
		case 4:
			vowel = 'O';
			break;
		case 5:
			vowel = 'U';
			break;
		default:
			break;
		}
		
		if (vowel == 'A') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)193;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)196;
			}
		}
		
		if (vowel == 'E') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)201;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)203;
			}
		}
		
		if (vowel == 'I') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)205;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)207;
			}
		}
		
		if (vowel == 'O') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)211;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)214;
			}
		}
		
		if (vowel == 'U') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = (char)218;
			}
			
			if (random >= 10 && random <= 15) {
				vowel = (char)220;
			}
		}
		
		return vowel;
	}
	
	/**
	 * That method generated a random number between 97 and 121 excluding the
	 * corresponding to a vowel letter. Then cast that number to a char and return
	 * it.
	 * 
	 * @return A character that will be, exclusively, a lowercase consonant.
	 */
	public char generateConsonantLower() {
		int random = 0;
		int min = 97;
		int max = 123;
		do {
			random = (int) ((Math.random() * (max - min)) + min);
		} while (random == 97 || random == 101 || random == 105 || random == 111 || random == 117);
		
		return (char)random;
	}
	
	/**
	 * That method generated a random number between 65 and 90 excluding the
	 * corresponding to a vowel letter. Then cast that number to a char and return
	 * it.
	 * 
	 * @return A character that will be, exclusively, a uppercase consonant.
	 */
	public char generateConsonantUpper() {
		int random = 0;
		int min = 65;
		int max = 91;
		do {
			random = (int) ((Math.random() * (max - min)) + min);
		} while (random == 65 || random == 69 || random == 73 || random == 79 || random == 85);
		
		return (char)random;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/*
	 * Mayus: 65 (A), 69 (E), 73 (I), 79 (O), 85 (U) - 90 (Z)
	 * Minus: 97 (a), 101 (e), 105 (i), 111 (o), 117 (u) - 122 (z)
	 */

}
