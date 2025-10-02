package lab2;
import java.util.Scanner;

abstract class Monster {
    private String name;
    private int health;
    private int level;
    private static int count = 0;

    public Monster() {
        count++;
    }

    public Monster(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
        count++;
    }

    public abstract void attack();
    public abstract void specialAbility();
    
    public String getName() { return name; }
    public int getHealth() { return health; }
    public static int getCount() { return count; }

    public void displayInfo() {
        System.out.println(name + " - Здоровье: " + health + ", Уровень: " + level);
    }
}

class Goblin extends Monster {
    private String weapon;
    private int stealth;

    public Goblin() {
        super("Голбин", 80, 2);
        this.weapon = "Нож";
        this.stealth = 60;
    }

    @Override
    public void attack() {
        System.out.println("Гоблин атакует с помощью " + weapon);
    }

    @Override
    public void specialAbility() {
        System.out.println("Гоблин использует скрытность " + stealth);
    }
}

class Mermaid extends Monster {
    private String song;
    private int charm;

    public Mermaid() {
        super("Русалка", 100, 3);
        this.song = "Песня сирены";
        this.charm = 70;
    }

    @Override
    public void attack() {
        System.out.println("Русалка атакует с помощью " + song);
    }

    @Override
    public void specialAbility() {
        System.out.println("Русалка поет " + charm);
    }
}

class Dragon extends Monster {
    private String element;
    private int firePower;

    public Dragon() {
        super("Дракон", 150, 5);
        this.element = "Огонь";
        this.firePower = 85;
    }

    @Override
    public void attack() {
        System.out.println("Дракон атакует с помощью " + element);
    }

    @Override
    public void specialAbility() {
        System.out.println("Дракон использует огонь: " + firePower);
    }
}

public class MonsterLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Goblin goblin = new Goblin();
        Mermaid mermaid = new Mermaid();
        Dragon dragon = new Dragon();

        System.out.println("Создано монстров: " + Monster.getCount());
        Monster[] monsters = {goblin, mermaid, dragon};
        for (Monster m : monsters) {
            m.displayInfo();
            m.attack();
            m.specialAbility();
            System.out.println();
        }

        scanner.close();
    }
}