# 🧙‍♂️ Dungeon Delvers

**Dungeon Delvers** is a Java-based console RPG game where players form a party of adventurers, battle monsters, collect loot, and descend through dungeon floors. The game showcases object-oriented programming concepts such as inheritance, polymorphism, and abstraction.

## 🗡️ Game Features

- 🎮 Console-based RPG gameplay
- 🧝 Create custom adventurers with randomized attributes
- ⚔️ Fight unique monsters like Goblins and Thieves
- 💰 Collect gold and weapons dropped by enemies
- 🛒 Purchase stronger weapons from the merchant
- 🧭 Descend through dungeon floors to face tougher enemies
- 🧠 Includes OOP concepts like abstract classes and inheritance

## 🛠️ How to Run

### Requirements:
- Java Development Kit (JDK) 8 or higher

### Steps:
1. Clone or download this repository.
2. Open a terminal in the project folder.
3. Compile all `.java` files:
   ```bash
   javac *.java
   ```
4. Run the main game:
   ```bash
   java DungeonDelvers
   ```
5. Enjoy your adventure!

## 📚 Concepts Demonstrated

- **Abstraction:** The `Monster` class is abstract, requiring subclasses to implement their unique attacks.
- **Inheritance:** `Goblin` and `Thief` inherit from the `Monster` class.
- **Encapsulation:** Attributes in classes are private with public getters/setters.
- **Polymorphism:** Monsters perform attacks using overridden methods based on their type.
- **Randomization:** Combat outcomes and adventurer stats involve randomness.

## 🧩 Future Improvements

- Add more monster types and adventurer classes
- Implement inventory and equipment management
- Introduce magic spells and skill trees
- Add save/load game functionality
- Create a graphical interface with JavaFX or Swing

## 👨‍💻 Author

Created by Cheah Wan Xin & Zoya Khan
for learning purposes and showcasing OOP principles in Java.

---

Feel free to fork and modify this game for your own RPG adventures!

