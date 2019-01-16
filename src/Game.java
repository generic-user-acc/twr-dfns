import javax.swing.*;
import java.util.LinkedList;

/**
 * Game.java
 * This is the class that handles the game and its operations and stuff
 * @author Eric Ke
 * Created: 2019/1/16
 */
public class Game {

    private Map map;
    private LinkedList<Enemy> enemies;
    private Clock clock;
    private EnemySpawner spawner;
    private UpdaterThread t;

    /**
     * creates a new game
     * @param mapName name of the map
     */
    public Game(String mapName) {
        map = new Map(mapName);
        enemies = new LinkedList<>();
        clock = new Clock();
        spawner = new EnemySpawner(mapName);
        spawner.generateWave(0);
        t = new UpdaterThread(enemies, spawner);
        t.start();
        SwingUtilities.invokeLater(() -> {
            try {
                new GameFrame(enemies, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void updateClock() {
        clock.update();
    }

    public void spawnEnemy() {
        enemies.add(spawner.getNextEnemy(0));
    }
}
