 // Dylan Widecki
// Rom Wasserman
// Bryan Soto
// A monster battle class that initiates 2 options of monster battles based on the monster class.
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

	public class MonsterBattle 
	{
		
		 static Scanner myScanner = new Scanner(System.in);
		 // A loop to present the user of choosing the battle option again after he chose option 3 (creating his own monster)
		 static boolean battleFought = false;
		
		public static void main(String [] args)
		{
			System.out.println("Hello\nworld");
			while (battleFought == false) {
				// Asks the user which battle they would like to run
				System.out.println("Which battle would you like to run? press 1 for a default battle, press 2 for a custom battle, or press 3 to create your monster.");
				int answer = myScanner.nextInt();
				if (answer == 1)
				{
					// Default battle (Giant vs Ogre)
					Monster Giant = new Monster("Giant", 200.0, 25.0, 1);
					Monster Ogre = new Monster("Ogre", 100.0, 50.0, 3);
				// A loop to check if both monster are alive to continue the battle for another round
					while (Ogre.isAlive() && Giant.isAlive())
					{
						// situation where Giant attacks first
						if (Giant.getAttackPriority() > Ogre.getAttackPriority())
						{
							System.out.println("Giant will attack first.");
							// Variable to set the Giant's attack
							double gAttack = Giant.attack();
							// sets the Ogre's new health after taking damage
							Ogre.setHealth(Ogre.health - gAttack);
					
							System.out.println("Giant attacked Ogre for " + Math.round(gAttack) + " damage."); 
							// checks if the Ogre is alive. If it is alive it attacks the Giant
							if (Ogre.isAlive())
							{
								System.out.println("Ogre will attack Giant");
								double oAttack = Ogre.attack();
								 Giant.setHealth(Giant.health - oAttack);
								System.out.println("Ogre attacked Giant for " + Math.round(oAttack) + " damage.");
							}
							else 
							{
								// if the Ogre dies than the Giant won.
								System.out.println("Giant wins! The battle is over!");
								battleFought = true;

							}
						}
						// situation where Ogre attacks first
						else if (Ogre.getAttackPriority() > Giant.getAttackPriority())
						{
							System.out.print("Ogre will attack first.");
							// sets the Ogre's attack
							double oAttack = Ogre.attack();
							// sets the Giant's health after taking damage
							Giant.setHealth(Giant.health - oAttack);
							System.out.println("Ogre attacked Giant for " + Math.round(oAttack) + " damage."); 
							// checks if Giant survived the attack 
							if (Giant.isAlive())
							{
								System.out.println("Giant will attack Ogre.");
								// sets the Giant's attack
								double gAttack = Giant.attack();
								// sets  the Ogre's health after taking damage
								Ogre.setHealth(Ogre.getHealth() - gAttack);
								System.out.println("Giant attacked Ogre for " + Math.round(gAttack) + " damage.");
							}
							else 
							{
								// if the Giant dies than the Ogre won.
								System.out.println("Ogre wins! The battle is over!");
								battleFought = true;

							}
						}
						else 
						{
							// A situation where the Giant's speed and the Ogre's speed is equal. The user decides which monster to attack first
							System.out.println("There is a tie. Please choose which Monster attacks first! Press 1 for Giant, Press 2 for Ogre");
							int firstAttacker = myScanner.nextInt();
							// if the user chooses the Giant to attack first
							if (firstAttacker == 1)
							{
								System.out.println("Giant will attack first.");
								// sets the Giant's attack
								double gAttack = Giant.attack();
								// sets  the Ogre's health after taking damage
								Ogre.setHealth(Ogre.health - gAttack);
						
								System.out.println("Giant attacked Ogre for " + Math.round(gAttack) + " damage.");
								if (Ogre.isAlive())
								{
									System.out.println("Ogre will attack Giant");
									// sets the Ogre's attack
									double oAttack = Ogre.attack();
									// sets  the Giant's health after taking damage
									Giant.setHealth(Giant.health - oAttack);
									System.out.println("Ogre attacked Giant for " + Math.round(oAttack) + " damage.");
								}
								else 
								{
									// if the Ogre dies than the Giant won.
									System.out.println("Giant wins! The battle is over!");
									battleFought = true;									
								}
							}
							else
							{
								System.out.print("Ogre will attack first.");
								// sets the Ogre's attack
								double oAttack = Ogre.attack();
								// sets  the Giant's health after taking damage
								Giant.setHealth(Giant.health - oAttack);
								System.out.println("Ogre attacked Giant for " + Math.round(oAttack) + " damage."); 
								if (Giant.isAlive())
								{
									System.out.println("Giant will attack Ogre.");
									// sets the Giant's attack
									double gAttack = Giant.attack();
									// sets  the Ogre's health after taking damage
									Ogre.setHealth(Ogre.health - gAttack);
									System.out.println("Giant attacked Ogre for " + Math.round(gAttack) + " damage.");
								}
								else 
								{
									// if the Giant dies than the Ogre won.
									System.out.println("Ogre wins! The battle is over!");
									battleFought = true;
								}
							}
						}
					}
					// Prints each monsters' properties after the battle ends.
					System.out.println(Ogre.toString());
					System.out.println(Giant.toString());
				}
				else if (answer == 2)
				{
					// If the user chooses the custom battle
					// creates two new custom monster
					Monster monster1 = null;
					Monster monster2 = null;
					// checks if the file the user enter exists
					while (monster1 == null) {
						myScanner.nextLine();
						System.out.println("Please enter the name of the first monster file");
						String input1 = myScanner.nextLine();
						// calling the readMonster method on the first monster file
						monster1 = readMonster(input1);	
					}
					while (monster2 == null) {
						System.out.println("Please enter the name of the second monster file");
						String input2 = myScanner.nextLine();
						// calling the readMonster method on the second monster file
						monster2 = readMonster(input2);	
					}
					// A loop to check if both monster are alive to continue the battle for another round
					while (monster1.isAlive() && monster2.isAlive()) {						
						// A situation where monster1 attacks first
						if (monster1.getAttackPriority() > monster2.getAttackPriority())
						{
							System.out.println(monster1.name + " will attack first.");
							// sets the monster1's attack 
							double m1Attack = monster1.attack();
							// sets monster2's health after being attacked
							monster2.setHealth(monster2.health - m1Attack);
						
							System.out.println(monster1.name + " attacked " + monster2.name + " for " + Math.round(m1Attack) + " damage.");
							// checks if monster2 survived the attack
							if (monster2.isAlive())
							{
								System.out.println(monster2.name + " will attack " + monster1.name);
								// sets monster2's attack
								double m2Attack = monster2.attack();
								//sets monster1's health after taking damage
								 monster1.setHealth(monster1.health - m2Attack);
								System.out.println(monster2.name + " attacked " + monster1.name + " for " + Math.round(m2Attack) + " damage.");
							}
							else 
							{
								// if the monster2 dies than the other monster1 win.
								System.out.println(monster1.name + " wins! The battle is over!");
								battleFought = true;

							}
						}
						// A situation where monster2 attacks first
						else if (monster2.getAttackPriority() > monster1.getAttackPriority())
						{
							System.out.print( monster2.name + " will attack first.");
							// sets monster2's attack
							double m2Attack = monster2.attack();
							//sets monster1's health after taking damage
							 monster1.setHealth(monster1.health - m2Attack);
							System.out.println(monster2.name + " attacked " + monster1.name + " for " + Math.round(m2Attack) + " damage."); 
							// checks if monster1 survived the attack
							if (monster1.isAlive())
							{
								System.out.println(monster1.name + " will attack Ogre.");
								// sets the monster1's attack 
								double m1Attack = monster1.attack();
								// sets monster2's health after being attacked
								monster2.setHealth(monster2.health - m1Attack);
								System.out.println(monster1.name + " attacked " + monster2.name + " for " + Math.round(m1Attack) + " damage.");
							}
							else 
							{
								// if monster1 died monster2 won.
								System.out.println( monster2.name + " wins! The battle is over!");
								battleFought = true;

							}
						}
						else 
						{
							// A situation where the monster1's speed and the monster2's speed is equal. The user decides which monster to attack first
							System.out.println("There is a tie. Please choose which Monster attacks first! Press 1 for " + monster1.name + ", Press 2 for " + monster2.name);
							int firstAttacker = myScanner.nextInt();
							// If the user chooses monster1 to attack first
							if (firstAttacker == 1)
							{
								System.out.println(monster1.name + " will attack first.");
								// sets the monster1's attack 
								double m1Attack = monster1.attack();
								monster2.setHealth(monster2.health - m1Attack);	
								// sets monster2's health after being attacked
								System.out.println(monster1.name + " attacked " + monster2.name + " for " + Math.round(m1Attack) + " damage.");
								// checks if monster2 survived the attack
								if (monster2.isAlive())
								{
									System.out.println(monster2.name + " will attack " + monster1.name);
									// sets monster2's attack
									double m2Attack = monster2.attack();
									//sets monster1's health after taking damage
									 monster1.setHealth(monster1.health - m2Attack);
									System.out.println(monster2.name + " attacked " + monster1.name + " for " + Math.round(m2Attack) + " damage.");
								}
								else 
								{
									// if the monster2 dies than the other monster1 win.
									System.out.println(monster1.name + " wins! The battle is over!");
									battleFought = true;

								}
							}
							else
							{
								// If the user chooses monster2 to attack first
								System.out.print( monster2.name + " will attack first.");
								// sets monster2's attack
								double m2Attack = monster2.attack();
								//sets monster1's health after taking damage
								 monster1.setHealth(monster1.health - m2Attack);
								System.out.println(monster2.name + " attacked " + monster1.name + " for " + Math.round(m2Attack) + " damage."); 
								// checks if monster1 survived the attack
								if (monster1.isAlive())
								{
									System.out.println(monster1.name + " will attack " + monster2.name);
									// sets the monster1's attack 
									double m1Attack = monster1.attack();
									// sets monster2's health after being attacked
									monster2.setHealth(monster2.health - m1Attack);
									System.out.println(monster1.name + " attacked " + monster2.name + " for " + Math.round(m1Attack) + " damage.");
								}
								else 
								{
									// if monster1 died monster2 won.
									System.out.println( monster2.name + " wins! The battle is over!");
									battleFought = true;
									
								}
							}
						}
					}
					// Prints the custom monsters' properties after the battle is over
							System.out.println(monster1.toString());
							System.out.println(monster2.toString());
						}
					
						// if the user chooses option 3 (to create their monster)
						else  {
							 myScanner.nextLine();
							// reading the user input assigning the input to new monster variables
							System.out.println("Please enter the monster's name.");
							String newName = myScanner.nextLine();
							System.out.println("Please enter the monster's health.");
							Double newHealth = myScanner.nextDouble();
							System.out.println("Please enter the monster's strength.");
							Double newStrength = myScanner.nextDouble();
							System.out.println("Please enter the monster's speed.");
							int newSpeed = myScanner.nextInt();
							// creating the custom monster with the new variables
							Monster customMonster = new Monster(newName,newHealth,newStrength,newSpeed);
							try {
								// creating a file writer with the name of the custom monster
								FileWriter fileWriter = new FileWriter(customMonster.name);
								// creating the print writer to the new file created
								PrintWriter out = new PrintWriter(fileWriter);
								// writing the new file the custom monster properties
								out.println(customMonster.name);
								out.println(customMonster.health);
								out.println(customMonster.strength);
								out.println(customMonster.speed);	
								// closing the print writer and the filewriter
								out.close();
								fileWriter.close();
								// assigning battleFought to false to ask the user again what battle option to choose
								battleFought = false;
							}
							// exception
							catch (IOException e) {
								e.printStackTrace();
							}																				
						}		
					}
				
					
		}				
			
			
		public static Monster readMonster(String input)
		{
			// A try block to read the custom monster files 
			try  {
				// Assigning a file variable 
				File newFile = new File(input);
				// new scanner variable to read the files
				Scanner fileReader = new Scanner(newFile);
				// An indicator to assign the file's lines to new varaibles
				int i = 0;
				// Default monster properties
				String name = "";
				double health = 0.0;
				double strength = 0.0;
				int speed = 0;
				// A while loop to read the file's lines
				while (fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					// Assigning the first line to the monster's name
					if (i == 0) {
						name = line;	
					}
					// Assigning the second line to the monster's health. Converting the string to a double.
					if (i == 1) {
						health = Double.parseDouble(line);
					}
					// Assigning the third line to the monster's strength. Converting the string to a double.
					if (i == 2) {
						strength = Double.parseDouble(line);
					}
					// Assigning the fourth line to the monster's speed. Converting the string to an int.
					if (i == 3) {
						speed = Integer.parseInt(line);
					}
					// Incrementing i to read the next line
					i++;
				}
				// Assigning the properties of the text file to a new monster object
				Monster monster = new Monster(name, health, strength, speed);
				// closing the scanner
				fileReader.close();
				// returning monster output
				return monster;
			}
			// checking if the file does not exist
			catch (FileNotFoundException e) {
				return null;
			}
	}
}

