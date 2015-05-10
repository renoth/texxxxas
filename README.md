# texxxxas
A text-heavy 4X Roguelike

This is a very early prototype of a 4x game with roguelike elements.
Build with gradle it uses several submodules (common, generator, ui, main) and Jackson JSON (De-)serialization to save the gamestate.

Build a runnable jar with 
```
gradle clean :main:build :main:dist
```

You may edit options.json previous to running.
Run with 

```
java -jar build/dist/texxxxas-main-${version}.jar
```
