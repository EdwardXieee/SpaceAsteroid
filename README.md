### Code refactor
1. Separate application concerns into MVC patterns. For effective development and maintainability.
2. All the game objects such as asteroids, shuttles, bullets, etc. are extended abstract `GameObjects`, in which all game objects can be unified and all the data and logic of each game object can be defined in its own specified models, that only need to be stored and created logically in `GameStageModel`, and paint on the canvas in the `GameStageView` as game objects without considering each object differently. Better for the practice of MVC pattern implementation and this clear logic can make it easier for code maintenance and extensions.
3. Using design patterns and design principles to refactor the code (specified below).

### Design patterns
1. Template Method Pattern: `AbstractShuttle` has two abstract method `upgrade1` and `upgrade2`. Its subclasses can override the method to implement vrious upgrade, but the calls will be made in the way defined in the abstract class.
2. Abstract Factory Pattern: Use `FactoryProducer` to get `AbstractFactory` and to get objects of entity classes by passing type information. As long as knowing the name, the associated factory can be called to create various bullets or shuttles. High extensibility.
3. State Pattern: `Director` as a state class, separate state logic, and concrete implementation. There are many states in the projects, and they must be switched alongside the system status when running. This made update stages easier when using and maintaining.
4. Strategy Pattern: Implement in `ShuttleFire` for different types and upgrade forms of the shuttle. Encapsulation algorithm, the strategies can be easily reused and not influence behavior that already exists.
5. Singleton Pattern: Used in classes `Director`, `GameStageModel`, and `GameStageView`, all those objects need one and only one instance.

### Design principles
1. Single Responsibility Principles: Applied in all classes. One class is only responsible for one task. The code is more understandable, easy to reuse, and has less possibility to edit.
2. Open-Closed Principle: For example, the `ShuttleFire` strategy can be extended without edit exist behavior; Game objects extend `GameObjects`, `Role`, bullets and shuttles extend `AbstractShuttle` and `AbstractBullet`, encapsulate algorithm that does not change. 
3. Law of Demeter: System has good encapsulation; one module has little knowledge of other modules.

### Additional Game Features
1. Mute Function.
2. Pause Function.
3. Multiple Shuttle Choices with features and upgradeability.
4. Random Name generation.
5. Asteroids blood point.
6. Adding the display of level, shuttle health point, highest score, and congratulation scene.
7. Others: Option, info, ranking (achieved by SQL) features as required. UI design and sound effects for improving the game experience and suit the extensions.

### Team statement 
We make good use of git to achieve efficient teamwork.
Yuening Xie: Responsible for the first part of code refactoring; Feature extensions; Class diagrams; Test.
Jiafang Sun: Responsible for the second part of code refactoring; Feature extensions: Readme file; Video description.
