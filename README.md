# GameOfRural
### *Mini game project on java about the life on a rural village.*

# Resume
Small project in Java as a first-year final project for the "DAM 1" module of my higher grade. The goal is to create an interactive town with different professions and actions. Each character has a profession and can interact in a specific way with the map and other characters.

The player can control any of the characters and move with them, perform actions, and view their status. Or you can generate random turns and have the characters move and interact on their own.

The aim of the project is not to create a complex game, but a functional one. It is intended to learn to handle the different aspects of Java as well as the creation of interfaces.

![](https://i.imgur.com/2kkJZa8.jpg)
> *Preview of the game.*

# Features
- Each time the game is started, a new map is generated at random.
- Different algorithms for generating forests, rivers and names.
- Possibility to control each citizen in a specific way and move them around the map using WASD or arrow keys.
- Possibility to generate random turns (between 1 and 9999) where all citizens will move and interact with each other automatically.
- Switch between different citizens using their IDs and see the current status (inventory, money etc) of the selected citizen.
- 10 different jobs to control and 2 administrators (Mayor and Marshal) to move around the map with.
- Every 200 turns the Mayor will collect taxes from citizens. In the following 200 turns the Marshal will distribute the collected money.
- 4 different types of land animals, 3 different types of fish and 5 different types of trees.

# Jobs
Each citizen will have a different job and based on that will act on the map in a unique way.

- <b>Farmer: </b>
The farmer starts the game with a semi-random amount of various items in his inventory (milk, eggs, cheese and potatoes). As he travels around the map he will meet other citizens and sell their products to them, generating an exchange of money between them.

- <b>Fishmonger: </b>
Similar to the farmer, the fishmonger starts with several objects (sushi, baked white fish, baked lemon garlic salmon and fish soup) and will try to sell them to the rest of the citizens he comes across on the map.

- <b>Lumberjack: </b>
The lumberjack will cut down the trees he finds and save the wood as a new resource called wood planks that he can deliver to the carpenter.
In addition, if the Lumberjack finds a piece of furniture on the map, he can dismantle it and recover the wood from which it was made.

- <b>Carpenter: </b>
If a carpenter comes across a lumberjack who has wood planks in his inventory he will take them and create furniture that he will leave on the map.

- <b>Miner: </b>
The miner scours the map in search of gold ores to be mined. If he finds one he will turn it into ground gold that he can later deliver to the blacksmith.

- <b>Blacksmith: </b>
If a blacksmith comes across a miner who has ground gold in his inventory he will take it and melt it into ruralcoins that he will keep in his inventory.

- <b>Shepherd: </b>
If the shepherd crosses his path with an animal (chicken, cow, pig or goat) he will feed it with grain. This will modify the amount of meat obtained by the butcher when he (sadly) comes across that animal.

- <b>Butcher: </b>
The butcher goes around the map happily but if he comes across an animal he will remember what his cruel job is and he will have to finish him off. This will result in obtaining raw meat, the amount obtained will depend on the type of animal and how much it has been fed by the shepherd.

- <b>Baker: </b>
The baker will look for grain on the map and transform it into bread. This grain has nothing to do with the grain used by the shepherd to feed the animals.

- <b>Fisherman: </b>
The fisherman is the only job that interacts with the river. If the fisherman is adjacent to a fish he will catch it and keep it in his inventory.

There are two other "jobs" but they don't do much *(as in real life)*. The mayor and the marshal. These two characters will be on the map walking around and greeting citizens. They will act every 200 turns.
- <b>Mayor: </b>
First the mayor will collect a tax from his citizens. He will keep 5% of the current ruralcoins of each citizen in a special bag and give it to the marshal.

- <b>Marshal: </b>
Since this is a game, some part of it has to be fantasy. When 200 turns have elapsed the Marshal will divide the ruralcoins collected equally among all the citizens. In addition, the marshal is the only character that moves two squares each turn. This is because he rides a horse.

# Images of the game
This montage was made using version 1.0 of the game and allowing 9999 turns to pass.

![](https://i.imgur.com/6Tei14G.png)
> *The town of Lääco before and after 9999 turns.*

In this first test we can see that both the lumberjack and the butcher have covered almost the entire map and have deforested the whole of Lääco. Hardly anything is left alive. In addition the lumberjack and the carpenter have met resulting in the creation of different furniture. A perfect example of modern capitalism. There is hardly any vegatation or animal life left, only human creations.

![](https://i.imgur.com/eKkOwn4.png)
> *The town of Bíëluxuz before and after 9999 turns.*

The town of Bíëluxuz, on the other hand, has had better luck. A gold ore has blocked the advance across the river. This prevented the lumberjack from crossing to the upper side or the butcher from descending to the lower side. Bíëluxuz is in a wilder state. After 9999 turns the original state has not been changed that much. Of course the player can now manually take control of the citizens and make the lumberjack cross the river, perhaps in another 9999 turns Bíëluxuz will be very different.

# Modifying the game

All Game of Rural files are public and can be modified. The aim of this project has been to create something with the knowledge acquired during the first year of study in the degree 'Development of multiplatform applications' ('Desarrollo de aplicaciones multiplataforma (DAM1)' in Spanish). I want to thank my teachers for their time and effort and I encourage anyone curious to import and modify the project to their liking.

All the files are documented and from the GraphicLauncher class and the initialize() method you can change factors to make, for example, a bigger map (50x100 maybe?) or add 3 characters of each profession. Any doubt or suggestion I will be glad to hear it.

# External links
Source for graphic resources:
- Medieval images: https://www.behance.net/pietrosmurra
- Background Song: https://www.youtube.com/watch?v=eZ_r1H9vHkI
- Fonts: https://github.com/tonsky/FiraCode
