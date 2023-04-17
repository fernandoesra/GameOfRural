package utils;

public class AleatoricName {
	
	String name;
	
	public AleatoricName() {
		this.name = this.generateAleatoricName();	
		;
	}
	
	public AleatoricName(int min, int max) {
		this.name = this.generateAleatoricName(min, max);	
		;
	}
	
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
				nameChars[i] = this.generateConsonantMayus();
			} else if (i == 0) {
				nameChars[i] = this.generateVowelMayus();
				vowels++;
			}
			
			if (i > 0) {
				
				if (vowels >= 2) {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 85) {
						nameChars[i] = this.generateConsonantMinus();
						vowels--;
					} else {
						nameChars[i] = this.generateVowelMinus();
						vowels++;
					}
					
				} else {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 90) {
						nameChars[i] = this.generateVowelMinus();
						vowels++;
					} else {
						nameChars[i] = this.generateConsonantMinus();
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
				nameChars[i] = this.generateConsonantMayus();
			} else if (i == 0) {
				nameChars[i] = this.generateVowelMayus();
				vowels++;
			}
			
			if (i > 0) {
				
				if (vowels >= 2) {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 85) {
						nameChars[i] = this.generateConsonantMinus();
						vowels--;
					} else {
						nameChars[i] = this.generateVowelMinus();
						vowels++;
					}
					
				} else {
					
					random = (int) ((Math.random() * (max - min)) + min);
					if (random >= 0 && random <= 90) {
						nameChars[i] = this.generateVowelMinus();
						vowels++;
					} else {
						nameChars[i] = this.generateConsonantMinus();
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
	
	public char generateVowelMinus() {
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
				vowel = 'ä';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'á';
			}
		}
		
		if (vowel == 'e') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'ë';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'é';
			}
		}
		
		if (vowel == 'i') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'ï';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'í';
			}
		}
		
		if (vowel == 'o') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'ö';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'ó';
			}
		}
		
		if (vowel == 'u') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'ü';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'ú';
			}
		}
		
		return vowel;
	}
	
	public char generateVowelMayus() {
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
				vowel = 'Ä';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'Á';
			}
		}
		
		if (vowel == 'E') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'Ë';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'É';
			}
		}
		
		if (vowel == 'I') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'Ï';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'Í';
			}
		}
		
		if (vowel == 'O') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'Ö';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'Ó';
			}
		}
		
		if (vowel == 'U') {
			random = (int) ((Math.random() * (100 - 0)) + 0);
			
			if (random >= 0 && random <= 5) {
				vowel = 'Ü';
			}
			
			if (random >= 10 && random <= 15) {
				vowel = 'Ú';
			}
		}
		
		return vowel;
	}

	public char generateConsonantMinus() {
		int random = 0;
		int min = 97;
		int max = 122;
		do {
			random = (int) ((Math.random() * (max - min)) + min);
		} while (random == 97 || random == 101 || random == 105 || random == 111 || random == 117);
		
		return (char)random;
	}
	
	public char generateConsonantMayus() {
		int random = 0;
		int min = 65;
		int max = 90;
		do {
			random = (int) ((Math.random() * (max - min)) + min);
		} while (random == 65 || random == 69 || random == 73 || random == 79 || random == 85);
		
		return (char)random;
	}
	
	public String toString() {
		return name;
	}
	
	/*
	 * Mayus: 65 (A), 69 (E), 73 (I), 79 (O), 85 (U) - 90 (Z)
	 * Minus: 97 (a), 101 (e), 105 (i), 111 (o), 117 (u) - 122 (z)
	 */

}
